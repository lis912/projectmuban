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
 * 界面类 ProblemPanel 问题汇总导出页
 */

public class ProblemPanel extends WorkingPanel {
    public static ProblemPanel instance = new ProblemPanel();
    public JButton bRefreshData  = new JButton("更新源数据");
//    public JButton bRefreshDataForNet  = new JButton("更新网络源数据");
    public JButton bInconformity = new JButton("导入不符合项");

    private JLabel showText = new JLabel("当前导入信息");
    private JLabel organName = new JLabel("单位名称:");
    private JLabel platName = new JLabel("系统名称:");
    private JLabel vorganName = new JLabel();
    private JLabel vplatName = new JLabel();

    public JCheckBox checkBoxHAN = new JCheckBox("问题汇总",true);
    public JCheckBox checkBoxNON = new JCheckBox("问题汇总(无网络)",false);
    public JCheckBox checkBoxProblemDevIp = new JCheckBox("问题汇总关联设备清单",false);
    public JCheckBox checkBoxAssociatedHSlist = new JCheckBox("关联安全设备清单",false);
    public JCheckBox checkBoxRectificationScheme = new JCheckBox("整改建议书",false);

    public JButton bExportDoc = new JButton("导出文档");

    public ProblemPanel() {
        GUIUtil.setColor(ColorUtil.blueColor,bRefreshData,bInconformity,bExportDoc);

        // 导入调研表选择框
        Box tleft = Box.createVerticalBox();
        tleft.add(bRefreshData);
//        tleft.add(bRefreshDataForNet);

        JPanel LeftPanelImport  = new JPanel();
        LeftPanelImport.setLayout(new BorderLayout());
        LeftPanelImport.add(tleft,BorderLayout.CENTER);
        LeftPanelImport.add(bInconformity,BorderLayout.SOUTH);
        //LeftPanelImport.add(bImportExcel,BorderLayout.SOUTH);

        // 设置各JLabel标签的字体颜色
        GUIUtil.setColor(ColorUtil.blackColor, showText,organName, platName);

        // 设置字体 字号
        showText.setFont(new Font("微软雅黑", Font.BOLD, 24));
        vorganName.setFont(new Font("微软雅黑", Font.BOLD, 18));
        vplatName.setFont(new Font("微软雅黑", Font.BOLD, 18));

        // 1.系统摘要信息  滚动栏居中  导入按钮底部 SummaryinfoPanel
        JPanel CenterPanelSummaryinfo = new JPanel();
        CenterPanelSummaryinfo.setLayout(new BorderLayout());



        JPanel SysinfoPanel = new JPanel();
        SysinfoPanel.setLayout(new GridLayout(8, 2));
        SysinfoPanel.add(organName);
        SysinfoPanel.add(vorganName);
        SysinfoPanel.add(platName);
        SysinfoPanel.add(vplatName);



        CenterPanelSummaryinfo.add(showText,BorderLayout.NORTH);
        CenterPanelSummaryinfo.add(SysinfoPanel,BorderLayout.CENTER);

        // 2.选择栏和导出按钮组合  选择栏垂直box居中，    导出按钮底部
        JPanel RightPanelExport = new JPanel();
        RightPanelExport.setLayout(new BorderLayout());
        Box topright = Box.createVerticalBox();
        topright.add(checkBoxHAN);
        topright.add(checkBoxNON);
        topright.add(checkBoxProblemDevIp);
        topright.add(checkBoxAssociatedHSlist);
        topright.add(checkBoxRectificationScheme);
        RightPanelExport.add(topright,BorderLayout.CENTER);
        RightPanelExport.add(bExportDoc,BorderLayout.SOUTH);


        this.setLayout(new BorderLayout());
        this.add(LeftPanelImport,BorderLayout.WEST);
        this.add(CenterPanelSummaryinfo,BorderLayout.CENTER);
        this.add(RightPanelExport,BorderLayout.EAST);

        addListener();
    }

    public void addListener(){
        ProblemListener problemListener = new ProblemListener();

//        bRefreshDataForNet.addActionListener(problemListener);
        bRefreshData.addActionListener(problemListener);
        bInconformity.addActionListener(problemListener);
        bExportDoc.addActionListener(problemListener);

        // 监听勾选状态 应该是独立封装到监听器里 后期解决吧  并且改变其他复选框的状态 手工实现了单选的效果
        checkBoxHAN.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == 1){
                    GlobalVar.GENERAL=true;
                    checkBoxNON.setSelected(false);
                }else {
                    GlobalVar.GENERAL=false;
                }
            }
        });
        checkBoxNON.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == 1){
                    GlobalVar.NONETWORK=true;
                    checkBoxHAN.setSelected(false);
                }else {
                    GlobalVar.NONETWORK=false;
                }
            }
        });

    }
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
}
