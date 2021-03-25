package com.lishichang.gui.listener;


import com.lishichang.dao.HostInfSixDAO;
import com.lishichang.entity.HostInfSix;
import com.lishichang.gui.panel.ArchivedPanel;
import com.lishichang.service.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 *  ArchiveListener  ： 项目流程资料pannel页面 Listener
 */
public class ArchiveListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        ArchivedPanel p = ArchivedPanel.instance;

        // 获取勾选状态设置全局变量关于调研表各个表是否勾选来决定是否导入
        SetGlobalVarState(p);

        //拉回按钮比对看用户按了哪个
        JButton b = (JButton) e.getSource();
        if (p.bImportExcel == b) {
            // 判断是否为清空状态下导入
            if (GlobalVar.isNoSelectImport()){
                JOptionPane.showMessageDialog(p, "错误：！！！\r\n请至少选择1个工作簿\r\n");
                return;
            }

            // new一个文件选择器 JFileChooser(File currentDirectory) MyWorkPath
            JFileChooser fc = new JFileChooser(GlobalVar.MyWorkPath);
            fc.setFileFilter(new FileFilter() {
                @Override
                public String getDescription() {
                    return ".xlsx";
                }
                @Override
                public boolean accept(File f) {
                    return f.getName().toLowerCase().endsWith(".xlsx");
                }
            });

            // 对话框
            int returnVal = fc.showOpenDialog(p);
            File file = fc.getSelectedFile();
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                try {
                    ReadExceltoDB read = new ReadExceltoDB();
                    read.ReadExceltoDB(file.getAbsolutePath());
                    JOptionPane.showMessageDialog(p, "调研表导入成功");
                } catch (Exception e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(p, "导入调研表失败\r\n,错误:\r\n" + e1.getMessage());
                }
            }
        }
        if (p.bExportWord == b) {
            if(GlobalVar.isNoSelectExport()){
                JOptionPane.showMessageDialog(p, "\r\n请至少选择1种输出文档\r\n");
                return;
            }
            try {
                if(GlobalVar.GENERAL || GlobalVar.NONETWORK){
                    ExportFangAn.ExportFangAn();
                }
                if(GlobalVar.SCANHOSTS){
                   System.out.println("SCANHOSTS");
                   ExportToolTestHost.ExportToolTestHost();
                }
                if(GlobalVar.SCANWEB){
                    System.out.println("SCANWEB");
                    ExportToolTestWeb.ExportToolTestWeb();
                }
                if(GlobalVar.WORDCHANGE){
                    System.out.println("WORDCHANGE");
                    ExportWordChange.ExportWordChange();
                }
                if(GlobalVar.PROJECTPLAN){
                    System.out.println("PROJECTPLAN");
                    ExportProjectPlan.ExportProjectPlan();
                }
                if(GlobalVar.SIGN){
                    System.out.println("SIGN ExportSignDevIP ");
                    ExportSignOff.ExportSignOff();
                }
                JOptionPane.showMessageDialog(p, "导出完成");
            } catch (IOException ioException) {
                ioException.printStackTrace();
                JOptionPane.showMessageDialog(p, "导出失败\r\n,错误:\r\n" + ioException.getMessage());
            }
        }
        p.updateData();
    }


    private void SetGlobalVarState(ArchivedPanel p){
        // 调研表输出勾选状态获取
        GlobalVar.BoxOnePlat = p.BoxOnePlat.isSelected();
        GlobalVar.BoxTwoPhy = p.BoxTwoPhy.isSelected();
        GlobalVar.BoxThrNet = p.BoxThrNet.isSelected();
        GlobalVar.BoxFourSec = p.BoxFourSec.isSelected();
        GlobalVar.BoxFiveCip = p.BoxFiveCip.isSelected();
        GlobalVar.BoxSixHost = p.BoxSixHost.isSelected();
        GlobalVar.BoxSevTerm = p.BoxSevTerm.isSelected();
        GlobalVar.BoxEigTerm = p.BoxEigTerm.isSelected();
        GlobalVar.BoxNineApp = p.BoxNineApp.isSelected();
        GlobalVar.BoxTenData = p.BoxTenData.isSelected();
        GlobalVar.BoxElePer = p.BoxElePer.isSelected();
        GlobalVar.BoxTweDoc = p.BoxTweDoc.isSelected();
        GlobalVar.BoxThirTopology = p.BoxThirTopology.isSelected();
        GlobalVar.BoxFoteCloud = p.BoxFoteCloud.isSelected();

        // 文档输出勾选状态获取
        GlobalVar.GENERAL = p.checkBoxHAN.isSelected();
        GlobalVar.NONETWORK = p.checkBoxNON.isSelected();
        GlobalVar.SCANHOSTS = p.checkBoxScanHosts.isSelected();
        GlobalVar.SCANWEB = p.checkBoxScanWeb.isSelected();
        GlobalVar.WORDCHANGE = p.checkBoxWordChange.isSelected();
        GlobalVar.PROJECTPLAN = p.checkBoxProjectPlan.isSelected();
        GlobalVar.SIGN = p.checkBoxSIGN.isSelected();

    }

}