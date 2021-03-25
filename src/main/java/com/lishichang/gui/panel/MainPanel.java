package com.lishichang.gui.panel;

import com.lishichang.gui.listener.ToolBarListener;
import com.lishichang.gui.util.CenterPanel;

import javax.swing.*;
import java.awt.*;

/**
 * 界面类 MainPanel 主界面
 * 主要有一个 Toolbar 的工具栏 和 一个  workingPanel 的 CenterPanel 的 工作区
 * workingPanel工作区内为本包中的各个页面，它们都是抽象类 WorkingPanel 的 子类
 * 各个页面有它们独自的监听器负责用户操作的监听
 *
 * @see CenterPanel
 */

public class MainPanel extends JPanel {
    public static MainPanel instance = new MainPanel();
    // 创建工具栏对象tb
    private JToolBar tb = new JToolBar();
    // 创建按钮8个
    public JButton bArchived = new JButton("项目流程资料");
    public JButton bStartPro = new JButton("问题汇总生成");
    public JButton bNewPro = new JButton("项目启动资料");

    // 中心容器
    public CenterPanel workingPanel;
    // 构造方法
    private MainPanel() {
        tb.add(bArchived);
        tb.add(bStartPro);
        tb.add(bNewPro);
        // 工具栏是否可以移动
        tb.setFloatable(false);
        // 初始化工作面板 rate貌似设置的是缩进率
       workingPanel = new CenterPanel(0.85);

        this.setLayout(new BorderLayout());
        // 添加工具栏到主MainPanel  workingPanel
        this.add(tb, BorderLayout.NORTH);
        // 添加工作面板 布局模式为边界模式
        this.add(workingPanel, BorderLayout.CENTER);

        addListeners();
    }

    private void addListeners() {
        ToolBarListener l = new ToolBarListener();
        bArchived.addActionListener(l);
        bStartPro.addActionListener(l);
        bNewPro.addActionListener(l);
    }

}
