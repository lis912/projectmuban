package com.lishichang.gui.listener;

import com.lishichang.gui.panel.ArchivedPanel;
import com.lishichang.gui.panel.ProblemPanel;
import com.lishichang.service.*;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;


/**
 *  ProblemListener  ： 问题汇总输出 pannel页面 Listener
 */
public class ProblemListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        ProblemPanel p = ProblemPanel.instance;
        // 获取勾选状态设置全局变量关于调研表各个表是否勾选来决定是否导入
        SetGlobalVarState(p);
        //拉回按钮比对看用户按了哪个
        JButton b = (JButton) e.getSource();
        // 导入测评项目问题
        if (p.bInconformity == b) {
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
            if (returnVal == JFileChooser.APPROVE_OPTION){
                try {
                    new ReadTmpProblemSourcetoDB().ReadTmpProblemSourcetoDB(file.getAbsolutePath());
                    JOptionPane.showMessageDialog(p, "导入成功");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                    JOptionPane.showMessageDialog(p, "导入失败\r\n,错误:\r\n" + ioException.getMessage());
                }

            }

        }

        // 导出按钮
        if (p.bExportDoc == b) {
            if(GlobalVar.isNoSelectProblemExport()){
                JOptionPane.showMessageDialog(p, "\r\n请至少选择1种输出文档\r\n");
                return;
            }
            try {
                if(GlobalVar.PROBLEMGENERAL || GlobalVar.PROBLEMNONETWORK){
                    ExportSummaryProblem.ExportSummaryProblem();
                }
                if(GlobalVar.PROBLEMDEVIP){
                    System.out.println("导出问题汇总关联设备清单");
                }
                if(GlobalVar.ASSOCIATEDHSLIST){
                    System.out.println("导出问题汇总关联安全设备清单");
                }
                if(GlobalVar.RECTIFICATIONSCHEME){
                    System.out.println("整改建议书");
                }
                ExportSummaryProblem.ExportSummaryProblem();
                JOptionPane.showMessageDialog(p, "导出完成");
            } catch (IOException ioException) {
                ioException.printStackTrace();
                JOptionPane.showMessageDialog(p, "导出失败\r\n,错误:\r\n" + ioException.getMessage());
            }
        }

        // 更新主机问题汇总数据
        if (p.bRefreshData == b) {
            String soureexcel = "template/等保2安全问题汇总.xlsx";
            if (JOptionPane.showConfirmDialog(p,"确定要更新吗？历史源数据将丢失","更新提示",1) == 0){
                try {
                    new ReadProblemSourcetoDB().ReadProblemSourcetoDBForHost(soureexcel);
                    JOptionPane.showMessageDialog(p,"更新完成！","提示",JOptionPane.PLAIN_MESSAGE);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }

        // 更新网络层面数据
//        if (p.bRefreshDataForNet == b) {
//            String soureexcel = "template/等保2安全问题汇总-网络层面.xlsx";
//            if (JOptionPane.showConfirmDialog(p,"确定要更新吗？历史源数据将丢失","更新提示",1) == 0){
//                try {
//                    new ReadProblemSourcetoDB().ReadProblemSourcetoDBForNet(soureexcel);
//                    JOptionPane.showMessageDialog(p,"更新完成！","提示",JOptionPane.PLAIN_MESSAGE);
//                } catch (IOException ioException) {
//                    ioException.printStackTrace();
//                }
//            }
//        }

        p.updateData();
    }

    private void SetGlobalVarState(ProblemPanel p){
        // 文档输出勾选状态获取
        GlobalVar.PROBLEMGENERAL = p.checkBoxHAN.isSelected();
        GlobalVar.PROBLEMNONETWORK = p.checkBoxNON.isSelected();
        GlobalVar.PROBLEMDEVIP = p.checkBoxProblemDevIp.isSelected();
        GlobalVar.ASSOCIATEDHSLIST = p.checkBoxAssociatedHSlist.isSelected();
        GlobalVar.RECTIFICATIONSCHEME = p.checkBoxRectificationScheme.isSelected();
    }

}