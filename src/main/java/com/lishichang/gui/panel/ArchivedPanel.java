package com.lishichang.gui.panel;

import com.lishichang.dao.PlatInfOneDAO;
import com.lishichang.entity.Archived;
import com.lishichang.entity.PlatInfOne;
import com.lishichang.gui.listener.ArchiveCheckBoxListener;
import com.lishichang.gui.listener.ArchiveListener;
import com.lishichang.gui.util.ColorUtil;
import com.lishichang.gui.util.GUIUtil;
import com.lishichang.service.GlobalVar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


/**
 * 界面类 ArchivedPanel 项目调研表导入 和 文档导出页面
 */

public class ArchivedPanel extends WorkingPanel{
    public static ArchivedPanel instance = new ArchivedPanel();

    // 下方的三个按钮
    public JButton bImportExcel  = new JButton("导入调研表");
    public JButton bExportWord = new JButton("导出文档");

    public JCheckBox checkBoxHAN = new JCheckBox("测评方案(主机+网络)");
    public JCheckBox checkBoxNON = new JCheckBox("测评方案(无网络)");
    public JCheckBox checkBoxScanHosts = new JCheckBox("漏洞扫描主机列表");
    public JCheckBox checkBoxScanWeb = new JCheckBox("WEB漏扫指导书");
    public JCheckBox checkBoxWordChange = new JCheckBox("文档交接单");
    public JCheckBox checkBoxProjectPlan = new JCheckBox("项目计划书");
    public JCheckBox checkBoxSIGN = new JCheckBox("离场确认单");

    // 导入表选择框
    public JCheckBox BoxOnePlat = new JCheckBox("表1(系统信息)",true);
    public JCheckBox BoxTwoPhy = new JCheckBox("表2(物理机房)",true);
    public JCheckBox BoxThrNet = new JCheckBox("表3(网络设备)",true);
    public JCheckBox BoxFourSec = new JCheckBox("表4(安全设备)",true);
    public JCheckBox BoxFiveCip = new JCheckBox("表5(密码产品)",false);
    public JCheckBox BoxSixHost = new JCheckBox("表6(主机信息)",true);
    public JCheckBox BoxSevTerm = new JCheckBox("表7(终端信息)",true);
    public JCheckBox BoxEigTerm = new JCheckBox("表8(管理软件)",false);
    public JCheckBox BoxNineApp = new JCheckBox("表9(应用系统)",true);
    public JCheckBox BoxTenData = new JCheckBox("表10(关键数据)",false);
    public JCheckBox BoxElePer = new JCheckBox("表11(安全人员)",true);
    public JCheckBox BoxTweDoc = new JCheckBox("表12(管理文档)",true);
    public JCheckBox BoxThirTopology = new JCheckBox("表13(网络拓扑图)",true);
    public JCheckBox BoxFoteCloud = new JCheckBox("表14(云平台)",false);
    public JCheckBox BoxCleanAll = new JCheckBox("清空或恢复默认勾选",false);

    private JLabel showText = new JLabel("当前导入信息");
    private JLabel organName = new JLabel("单位名称:");
    private JLabel platName = new JLabel("系统名称:");
    private JLabel vorganName = new JLabel();
    private JLabel vplatName = new JLabel();

    public ArchivedPanel() {
        GUIUtil.setColor(ColorUtil.blueColor,bImportExcel,bExportWord);

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
        // JPanel默认采用流式布局，边界布局这玩意会如果没有添加各个方向的组件，唯一的组件就会自动全部填充！！！！


        // 2.选择栏和导出按钮组合  选择栏垂直box居中，    导出按钮底部
        JPanel RightPanelExport = new JPanel();
        RightPanelExport.setLayout(new BorderLayout());

        Box topright = Box.createVerticalBox();
        topright.add(checkBoxHAN);
        topright.add(checkBoxNON);
        topright.add(checkBoxScanHosts);
        topright.add(checkBoxScanWeb);
        topright.add(checkBoxWordChange);
        topright.add(checkBoxProjectPlan);
        topright.add(checkBoxSIGN);


        RightPanelExport.add(topright,BorderLayout.CENTER);
        RightPanelExport.add(bExportWord,BorderLayout.SOUTH);

        // 导入调研表选择框
        Box tleft = Box.createVerticalBox();
        tleft.add(BoxOnePlat);
        tleft.add(BoxTwoPhy);
        tleft.add(BoxThrNet);
        tleft.add(BoxFourSec);
        tleft.add(BoxFiveCip);
        tleft.add(BoxSixHost);
        tleft.add(BoxSevTerm);
        tleft.add(BoxEigTerm);
        tleft.add(BoxNineApp);
        tleft.add(BoxTenData);
        tleft.add(BoxElePer);
        tleft.add(BoxTweDoc);
        tleft.add(BoxThirTopology);
        tleft.add(BoxFoteCloud);
        tleft.add(BoxCleanAll);

        JPanel LeftPanelImport  = new JPanel();
        LeftPanelImport.setLayout(new BorderLayout());
        LeftPanelImport.add(tleft,BorderLayout.CENTER);
        LeftPanelImport.add(bImportExcel,BorderLayout.SOUTH);

        // 3.以上1在西边  2在东
        // 布局：设置为边界布局模式 导入选择在左侧  系统摘要信息居中  选择栏和导出按钮在右侧
        this.setLayout(new BorderLayout());
        this.add(LeftPanelImport,BorderLayout.WEST);
        this.add(CenterPanelSummaryinfo,BorderLayout.CENTER);
        this.add(RightPanelExport,BorderLayout.EAST);
        this.addListener();
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(ArchivedPanel.instance);
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
        ArchiveListener archiveListener = new ArchiveListener();
        ArchiveCheckBoxListener archiveCheckBoxListener = new ArchiveCheckBoxListener();
        bImportExcel.addActionListener(archiveListener);
        bExportWord.addActionListener(archiveListener);
        BoxCleanAll.addItemListener(archiveCheckBoxListener);

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
}