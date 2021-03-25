package com.lishichang.startup;


import com.lishichang.gui.frame.MainFrame;
import com.lishichang.gui.panel.ArchivedPanel;
import com.lishichang.gui.panel.MainPanel;

import javax.swing.*;

/**
 * 启动类 Bootstrap
 * main为本程序的总入口
 * 会加载一个 MainFrame 程序窗体 和 一个 MainPanel 程序 主面板 ，并且初始化 MainPanel 中的 workingPanel
 * workingPanel有方法 .show(WorkingPanel p) 可以居中显示子面板 并 更新数据
 * 使用swing的阻塞机制，优先加载整个启动窗口
 *
 * @see MainFrame
 * @see MainPanel
 */
public class Bootstrap {
    public static void main(String[] args) throws Exception {
        // useLNF是个静态方法，所以可以通过类名直接调用 定义GUI风格
       // GUIUtil.useLNF();
        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                // 程序主窗体
                MainFrame.instance.setVisible(true);
                // 居中显示子面板 并 更新数据
               MainPanel.instance.workingPanel.show(ArchivedPanel.instance);
            }
        });
    }
}
