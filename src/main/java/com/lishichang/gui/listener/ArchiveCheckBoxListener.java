package com.lishichang.gui.listener;

import com.lishichang.gui.panel.ArchivedPanel;
import com.lishichang.service.GlobalVar;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


/**
 *  ArchiveListener  ： 项目流程资料pannel页面 各勾选框 Listener
 */
public class ArchiveCheckBoxListener implements ItemListener {
    @Override
    public void itemStateChanged(ItemEvent e) {
        ArchivedPanel p = ArchivedPanel.instance;
        JCheckBox b = (JCheckBox) e.getSource();

        // 判断鼠标出发的是哪个
        if (b == p.BoxCleanAll) {
            if(p.BoxCleanAll.isSelected()){
                // 清空勾选
                p.BoxOnePlat.setSelected(false);
                p.BoxTwoPhy.setSelected(false);
                p.BoxThrNet.setSelected(false);
                p.BoxFourSec.setSelected(false);

                p.BoxFiveCip.setSelected(false);
                p.BoxSixHost.setSelected(false);
                p.BoxSevTerm.setSelected(false);
                p.BoxEigTerm.setSelected(false);

                p.BoxNineApp.setSelected(false);
                p.BoxTenData.setSelected(false);
                p.BoxElePer.setSelected(false);
                p.BoxTweDoc.setSelected(false);
                p.BoxThirTopology.setSelected(false);
                p.BoxFoteCloud.setSelected(false);

                p.BoxCleanAll.setSelected(true);

            }else {
                // 恢复默认勾选
                p.BoxOnePlat.setSelected(true);
                p.BoxTwoPhy.setSelected(true);
                p.BoxThrNet.setSelected(true);
                p.BoxFourSec.setSelected(true);

                p.BoxFiveCip.setSelected(false);
                p.BoxSixHost.setSelected(true);
                p.BoxSevTerm.setSelected(true);
                p.BoxEigTerm.setSelected(false);

                p.BoxNineApp.setSelected(true);
                p.BoxTenData.setSelected(false);
                p.BoxElePer.setSelected(true);
                p.BoxTweDoc.setSelected(true);
                p.BoxThirTopology.setSelected(true);
                p.BoxFoteCloud.setSelected(false);

            }
        }

    }
}


