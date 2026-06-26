package com.sunbeam.teaster;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.sunbeam.Daoimpl.QuizDaoimpl;

import java.awt.Color;
import java.awt.Font;
import com.sunbeam.utils.UIStyle;

public class CreateQuizFrame extends JFrame {

    private JLabel titleLabel;
    private JLabel pathLabel;

    private JTextField titleText;
    private JTextField pathText;

    private JButton createButton;
    private JButton backButton;
    private JLabel headingLabel;

    public CreateQuizFrame() {
    	getContentPane().setBackground(new Color(245,245,245));

    	UIStyle style = new UIStyle();
        this.setTitle("Create Quiz");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);

        // Components
        headingLabel = new JLabel("CREATE QUIZ", JLabel.CENTER);
        headingLabel.setFont(new Font("Segoe UI", Font.BOLD, 26));
        headingLabel.setBounds(0,30,700,40);
        this.add(headingLabel);
        
        titleLabel = new JLabel("Quiz Title");
        titleLabel.setBounds(170,140,100,30);
        style.styleLabel(titleLabel);
        this.add(titleLabel);
        
        
        titleText = new JTextField();
        titleText.setBounds(270,140,250,35);
        style.styleTextField(titleText);
         this.add(titleText);
         
        pathLabel = new JLabel("CSV File Path");
        pathLabel.setBounds(170,200,120,30);
        style.styleLabel(pathLabel);
         this.add(pathLabel);
         
        pathText = new JTextField();
        pathText.setBounds(270,200,250,35);
        style.styleTextField(pathText);
            this.add(pathText);
            
        createButton = new JButton("Create Quiz");
        createButton.setBounds(220,300,120,40);
        style.styleButton(createButton);
           this.add(createButton);
           
        backButton = new JButton("Back");
        backButton.setBounds(380,300,120,40);
        style.styleButton(backButton);
        this.add(backButton);

        // Create Button

        createButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    String title = titleText.getText();
                    String path = pathText.getText();

                    QuizDaoimpl qdao = new QuizDaoimpl();

                    qdao.createQuiz(title, path);

                    JOptionPane.showMessageDialog(null,
                            "Quiz Created Successfully");

                }
                catch (Exception e1) {

                    JOptionPane.showMessageDialog(null,
                            e1.getMessage());

                }

            }
        });

        // Back Button

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