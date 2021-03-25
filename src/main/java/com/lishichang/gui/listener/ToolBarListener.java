package com.lishichang.gui.listener;

import com.lishichang.gui.panel.ArchivedPanel;
import com.lishichang.gui.panel.MainPanel;
import com.lishichang.gui.panel.NewProPanel;
import com.lishichang.gui.panel.ProblemPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * MainPanel 的监听器，监听 Toolbar 的按钮操作并切换面板
 * workingPanel有方法 .show(WorkingPanel p) 可以居中显示子面板 并 更新数据
 * @see MainPanel
 */

public class ToolBarListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        // 不知道为什么多处要初始化MainPanel.instance
        MainPanel p = MainPanel.instance;
        // 框架代码 获取信号源
        JButton b = (JButton) e.getSource();
        // 判断鼠标出发的是哪个
        if (b == p.bArchived) {
           p.workingPanel.show(ArchivedPanel.instance);
        }
        if (b == p.bStartPro) {
           p.workingPanel.show(ProblemPanel.instance);
        }
        if (b == p.bNewPro) {
            p.workingPanel.show(NewProPanel.instance);
        }
    }
}
