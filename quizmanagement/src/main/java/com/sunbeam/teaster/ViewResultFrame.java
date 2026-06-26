package com.sunbeam.teaster;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.sunbeam.Daoimpl.QuizDaoimpl;
import com.sunbeam.entity.Result;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import com.sunbeam.utils.UIStyle;

public class ViewResultFrame extends JFrame {

    private JTextArea area;
    private JScrollPane scroll;
    private JButton backButton;
    private JLabel headingLabel;
    public ViewResultFrame() {
    
    	getContentPane().setBackground(new Color(245,245,245));

    	UIStyle style = new UIStyle();
        this.setTitle("View Results");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);

        
        headingLabel = new JLabel("QUIZ RESULTS", JLabel.CENTER);
        headingLabel.setFont(new Font("Segoe UI", Font.BOLD,28));
        headingLabel.setForeground(new Color(44,62,80));
        headingLabel.setBounds(0,20,700,40);
        this.add(headingLabel);
        
        
        area = new JTextArea();
        area.setEditable(false);

        scroll = new JScrollPane(area);
        area.setFont(new Font("Segoe UI", Font.PLAIN,15));
        scroll.setBounds(80,80,540,250);
        this.add(scroll);

        backButton = new JButton("Back");
        backButton.setBounds(290,350,120,40);
        style.styleButton(backButton);
        this.add(backButton);

        try {

            QuizDaoimpl qdao = new QuizDaoimpl();

            List<Result> results = qdao.viewResults();

//System.out.println("Total Results : " + results.size());
            for (Result r : results) {
                area.append(r.toString() + "\n");
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null,
                    e.getMessage());

        }

        backButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                new AdminDashboard();
                dispose();

            }
        });

        this.setSize(700,500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}