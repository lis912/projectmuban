package com.lishichang.gui.panel;

import com.lishichang.dao.PlatInfOneDAO;
import com.lishichang.gui.listener.ArchiveCheckBoxListener;
import com.lishichang.gui.listener.ArchiveListener;
import com.lishichang.gui.listener.ProblemListener;
import com.lishichang.gui.util.ColorUtil;
import com.lishichang.gui.util.GUIUtil;
import com.lishichang.service.GlobalVar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * 界面类 SummaryinfoPanel 问题汇总导出页
 */
public class SummaryinfoPanel extends JPanel {
    public static SummaryinfoPanel instance = new SummaryinfoPanel();
    private JLabel showText = new JLabel("当前导入信息");
    private JLabel organName = new JLabel("单位名称:");
    private JLabel platName = new JLabel("系统名称:");
    private JLabel vorganName = new JLabel();
    private JLabel vplatName = new JLabel();

    public SummaryinfoPanel() {
        // 设置各JLabel标签的字体颜色
        GUIUtil.setColor(ColorUtil.blackColor, showText,organName, platName);

        // 设置字体 字号
        showText.setFont(new Font("微软雅黑", Font.BOLD, 24));
        vorganName.setFont(new Font("微软雅黑", Font.BOLD, 18));
        vplatName.setFont(new Font("微软雅黑", Font.BOLD, 18));

        JPanel SysinfoPanel = new JPanel();
        SysinfoPanel.setLayout(new GridLayout(8, 2));
        SysinfoPanel.add(organName);
        SysinfoPanel.add(vorganName);
        SysinfoPanel.add(platName);
        SysinfoPanel.add(vplatName);

        this.add(showText,BorderLayout.NORTH);
        this.add(SysinfoPanel,BorderLayout.CENTER);
        updateData();
        addListener();

    }
    // 更新数据:
    public void updateData(){
        PlatInfOneDAO platInfOneDAO = new PlatInfOneDAO();
        if(platInfOneDAO.get() != null){
            GUIUtil.setColor(ColorUtil.blueColor, vorganName, vplatName);
            vorganName.setText(platInfOneDAO.get().getOrganName());
            vplatName.setText(platInfOneDAO.get().getPlatName());
        }else{
            GUIUtil.setColor(ColorUtil.warningColor, vorganName, vplatName);
            vorganName.setText("未导入表1");
            vplatName.setText("未导入表1");
        }

    }
    public void addListener(){

    }

}