package com.lishichang.gui.listener;

import com.lishichang.gui.panel.NewProPanel;
import com.lishichang.gui.panel.ProblemPanel;
import com.lishichang.mubanentity.Host;
import com.lishichang.mubanentity.NewPro;
import com.lishichang.mubanentity.ScanHost;
import com.lishichang.service.*;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NewProListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        NewProPanel p = NewProPanel.instance;
        //拉回按钮比对看用户按了哪个
        JButton b = (JButton) e.getSource();
        // 导出按钮
        if (p.bExportDoc == b) {
            String oraName = p.oraName.getText();
            String proName = p.proName.getText();
            if(oraName.isEmpty() || proName.isEmpty()){
               JOptionPane.showMessageDialog(p, "\r\n输入不全\r\n");
               return;
            }
            try {
                ExportNewPro.ExportNewPro(oraName,proName);
                JOptionPane.showMessageDialog(p, "导出完成");
            } catch (IOException ioException) {
                ioException.printStackTrace();
                JOptionPane.showMessageDialog(p, "导出失败\r\n,错误:\r\n" + ioException.getMessage());
            }


        }

        // 更新数据
//        if (p.bRefreshData == b) {
//            String soureexcel = "template/等保2安全问题汇总.xlsx";
//            if (JOptionPane.showConfirmDialog(p,"确定要更新吗？历史源数据将丢失","更新提示",1) == 0){
//                try {
//                    new ReadProblemSourcetoDB().ReadProblemSourcetoDB(soureexcel);
//                    JOptionPane.showMessageDialog(p,"更新完成！","提示",JOptionPane.PLAIN_MESSAGE);
//                } catch (IOException ioException) {
//                    ioException.printStackTrace();
//                }
//            }
//
//        }

        p.updateData();
    }

}
