package io.github.thishkt;


import com.github.houbb.opencc4j.util.ZhConverterUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChineseConvert {
    private JPanel panelMain;
    private JButton btnCToT;
    private JButton btnTToC;
    private JTextArea textArea;
    private JButton btnCopy;

    public ChineseConvert() {
        //設定按鈕大小
        btnCToT.setPreferredSize(new Dimension(100, 100));
        btnTToC.setPreferredSize(new Dimension(100, 100));
        btnCopy.setPreferredSize(new Dimension(100, 100));

        //簡體轉繁體
        btnCToT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String res = ZhConverterUtil.convertToTraditional(textArea.getText());
                textArea.setText(res);
            }
        });

        //繁體轉簡體
        btnTToC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String res = ZhConverterUtil.convertToSimple(textArea.getText());
                textArea.setText(res);


            }
        });

        //複製文字框內所有文字
        btnCopy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.selectAll();
                textArea.copy();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("HKT線上教室-繁簡轉換小工具");
        frame.setContentPane(new ChineseConvert().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
