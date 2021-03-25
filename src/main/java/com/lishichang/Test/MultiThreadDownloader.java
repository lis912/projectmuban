package com.lishichang.Test;

/*
 * @Author : @李若龙 2018171028 @SZU @CSSE
 */
import java.net.*;
import java.util.*;
import java.util.concurrent.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.html.*;

class DownloadThread extends Thread {

    URLConnection con;
    RandomAccessFile rf;

    public static volatile long allcur = 0;
    public static boolean isReady = false;

    public DownloadThread() {

    }

    public DownloadThread(URLConnection con, RandomAccessFile rf) {
        this.con = con;
        this.rf = rf;
    }

    public void run() {
        try {
            // 获取输入输出流
            InputStream is = con.getInputStream();
            //System.out.printf("线程 获取文件成功\n");

            // 输入流内容写入输出流
            byte[] buf = new byte[1024];
            int len = -1;

            while((len=is.read(buf)) != -1) {
                rf.write(buf, 0, len);
                synchronized(new Object()) {
                    allcur += (long)len;
                }
                // System.out.printf("%d / %d \n", allcur, 29210163);
            }
            rf.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

public class MultiThreadDownloader {

    String url;				// 目标url
    String savePath;		// 本地保存路径
    String fileName;		// 文件名
    int tnum = 5;			// 默认线程数目
    long totalLength;		// 总大小
    DownloadThread dth;		// 一个下载线程，用于查看下载进度
    JLabel  urlInputText;	// 文字：目标对象url
    JTextField urlInput;	// url输入框
    JLabel  pathInputText;	// 文字：本地保存路径
    JTextField pathInput;	// 保存路径输入框
    JLabel  nameInputText;	// 文字：文件名
    JTextField nameInput;	// 文件名输入框
    JLabel  barTex;			// 文字：进度条
    JProgressBar bar;		// 进度条
    JButton startBtn;		// 开始下载按钮
    ExecutorService pool = Executors.newCachedThreadPool();	// 线程池

    MultiThreadDownloader() {

    }

    MultiThreadDownloader(String url, String savePath, String fileName, int tnum) {
        this.url = url;
        this.tnum = tnum;
        this.savePath = savePath;
        this.fileName = fileName;
    }

    public void download() throws Exception {

        // 初始化组件，利用默认内容
        // url输入
        urlInputText = new JLabel ("目标对象URL");
        urlInput = new JTextField(url);
        // 路径输入
        pathInputText = new JLabel ("本地保存路径");
        pathInput = new JTextField(savePath);
        // 文件名输入
        nameInputText = new JLabel ("文件名");
        nameInput = new JTextField(fileName);
        // 进度条
        JLabel  barText = new JLabel ("进度条");
        bar = new JProgressBar(0, 100);

        // 开始下载按钮 注册事件 点击的时候创建新下载线程
        startBtn = new JButton("开始下载");
        startBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startBtn.setEnabled(false);	// 按钮禁用
                // 获得用户实际输入的内容
                savePath = pathInput.getText();
                fileName = nameInput.getText();
                url = urlInput.getText();
                try {
                    totalLength = new URL(url).openConnection().getContentLength();
                    bar.setMaximum((int)totalLength);
                    long eachLength = totalLength / tnum;
                    // 拓展名
                    String ext = url.substring(url.lastIndexOf("."));
                    // 创建下载线程
                    for(int i=0; i<tnum; i++) {
                        long st = eachLength * i;
                        long ed = eachLength * (i+1);
                        if(i == tnum-1) {
                            ed=Math.max(ed, totalLength);
                        }
                        // 建立URL连接
                        URLConnection con = new URL(url).openConnection();
                        con.setRequestProperty("Range", "bytes="+String.valueOf(st)+"-"+String.valueOf(ed));
                        con.connect();
                        // 打开文件流
                        RandomAccessFile rf = new RandomAccessFile(savePath+fileName+ext, "rw");
                        rf.seek(st);	// 文件流跳转到对应位置
                        // 创建下载线程
                        DownloadThread d =new DownloadThread(con, rf);
                        pool.submit(d);
                        if(i==tnum-1) {
                            dth = d;
                        }
                    }
                    // 创建一个每500ms更新进度条的线程
                    pool.submit(new Thread() {
                        public void run() {
                            while(true) {
                                //System.out.printf("%d / %d \n", dth.allcur, totalLength);
                                bar.setValue((int)dth.allcur);
                                if(dth.allcur >= totalLength) {
                                    startBtn.setText("下载完成");
                                    break;
                                }
                                try {
                                    this.sleep(500);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    });
                    // 关闭线程池
                    pool.shutdown();
                } catch(Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        // 开始下载按钮 注册事件 点击的时候创建新下载线程 -- 结束

        // 主窗体
        JFrame jf = new JFrame("下载器");
        jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jf.setSize(512, 321);
        jf.setLayout(new GridLayout(9, 1));
        jf.add(urlInputText);
        jf.add(urlInput);
        jf.add(pathInputText);
        jf.add(pathInput);
        jf.add(nameInputText);
        jf.add(nameInput);
        jf.add(barText);
        jf.add(bar);
        jf.add(startBtn);
        jf.show();

    }

    public static void main(String[] args) throws Exception {
        MultiThreadDownloader dl = new MultiThreadDownloader(
                "http://www.szulrl.cn/browserTest/PDFFILE.zip",
                "E:/MyEclipse/WorkSpace/Hello/src/homework/",
                "下载",
                3);
        dl.download();
    }
}
