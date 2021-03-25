package com.lishichang;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JCheckBoxExample {
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;

    public JCheckBoxExample() {
        prepareGUI();
    }

    public static void main(String[] args) {
        JCheckBoxExample swingControlDemo = new JCheckBoxExample();
        swingControlDemo.showCheckBoxDemo();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("Java Swing JCheckBox示例");
        mainFrame.setSize(400, 400);
        mainFrame.setLayout(new GridLayout(3, 1));

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        headerLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("", JLabel.CENTER);
        statusLabel.setSize(350, 100);

        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }

    private void showCheckBoxDemo() {
        headerLabel.setText("Control in action: CheckBox");

        final JCheckBox chkApple = new JCheckBox("Java/Swing");
        final JCheckBox chkMango = new JCheckBox("Python");
        final JCheckBox chkPeer = new JCheckBox("MySQL");

//        chkApple.setMnemonic(KeyEvent.VK_C);
//        chkMango.setMnemonic(KeyEvent.VK_M);
//        chkPeer.setMnemonic(KeyEvent.VK_P);

        chkApple.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                statusLabel.setText("Java/Swing Checkbox: " + (e.getStateChange() == 1 ? "checked" : "unchecked"));
            }
        });
        chkMango.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                statusLabel.setText("Python Checkbox: " + (e.getStateChange() == 1 ? "checked" : "unchecked"));
            }
        });
        chkPeer.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                statusLabel.setText("MySQL Checkbox: " + (e.getStateChange() == 1 ? "checked" : "unchecked"));
            }
        });
        controlPanel.add(chkApple);
        controlPanel.add(chkMango);
        controlPanel.add(chkPeer);

        mainFrame.setVisible(true);
    }
}


