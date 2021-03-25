package com.lishichang.gui.panel;

import com.lishichang.dao.PlatInfOneDAO;
import com.lishichang.gui.listener.NewProListener;
import com.lishichang.gui.listener.ProblemListener;
import com.lishichang.gui.util.ColorUtil;
import com.lishichang.gui.util.GUIUtil;
import com.lishichang.service.GlobalVar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class NewProPanel extends WorkingPanel{
    public static NewProPanel instance = new NewProPanel();
    private JLabel organName = new JLabel("单位名称:  ");
    private JLabel platName = new JLabel("系统名称:  ");
    public JTextField oraName = new JTextField();
    public JTextArea proName= new JTextArea(100, 80);
    JScrollPane SproName = new JScrollPane(proName);
    public JButton bExportDoc = new JButton("导出文档");

    public NewProPanel(){
        Box namebox = Box.createHorizontalBox();
        namebox.add(organName);
        namebox.add(oraName);

        Box pronamebox = Box.createHorizontalBox();
        pronamebox.add(platName);
        pronamebox.add(SproName);

        Box nullbox = Box.createHorizontalBox();

        Box topright = Box.createVerticalBox();
        topright.add(namebox);
        topright.add(nullbox);
        topright.add(pronamebox);

        Box box = Box.createVerticalBox();
        box.add(Box.createVerticalStrut(400));

        Box boxh = Box.createHorizontalBox();
        boxh.add(Box.createHorizontalStrut(20));
        boxh.add(bExportDoc);
        box.add(boxh);


        this.setLayout(new BorderLayout());
        this.add(topright,BorderLayout.CENTER);
        this.add(box,BorderLayout.EAST);

        addListener();
    }

    public void addListener(){
        NewProListener newProListener = new NewProListener();
        bExportDoc.addActionListener(newProListener);
    }
    public void updateData(){


    }
}
