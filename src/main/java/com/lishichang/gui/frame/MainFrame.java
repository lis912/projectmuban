package com.lishichang.gui.frame;

import com.lishichang.gui.panel.MainPanel;

import javax.swing.*;

/**
 * 程序主窗体
 * 设置了程序窗体的长宽标题和退出操作等
 * 继承和重新封装了JFrame类 JFrame就是整个图形化程序的界面
 */

public class MainFrame extends JFrame {
//    static {
//        GUIUtil.useLNF();
//    }

    // 类的静态变量=该类的构造方法 ，可以直接调用
    public static MainFrame instance = new MainFrame();
    private MainFrame() {
        // 设置窗口大小 这里操作的是父类JFrame
        this.setSize(720, 580);
        // 名称
        this.setTitle("测评项目文档生成工具");
        // 添加MainPanel 主面板 才能添加按钮等组件
        this.setContentPane(MainPanel.instance);
        // 设置窗口相对于指定组件的位置。 为 null，则此窗口将置于屏幕的中央。
        this.setLocationRelativeTo(null);
        // 设置框架是否可由用户调整大小。
        this.setResizable(true);
        // 点击关闭后程序的操作 默认传入的是常量3 就是彻底关闭进程
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // 显示或者隐藏窗口 当然是显示了 ，main应该是作为调试使用，在启动代码中已经设置了一次，看来每个类中都可有main方法
//    public static void main(String[] args) {
//        instance.setVisible(true);
//    }
}