package com.sunbeam.teaster;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import com.sunbeam.utils.UIStyle;

import com.sunbeam.Daoimpl.QuizDaoimpl;

public class DeleteQuizFrame extends JFrame {                                                        

    private JLabel idLabel;
    private JTextField idText;

    private JButton deleteButton;
    private JButton backButton;
    private JLabel headingLabel;
    public DeleteQuizFrame() {
    	
    	getContentPane().setBackground(new Color(245,245,245));

    	UIStyle style = new UIStyle();
        this.setTitle("Delete Quiz");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        
        
        headingLabel = new JLabel("DELETE QUIZ", JLabel.CENTER);
        headingLabel.setFont(new Font("Segoe UI", Font.BOLD, 26));
        headingLabel.setBounds(0,30,700,40);
        this.add(headingLabel);
        
        
        idLabel = new JLabel("Quiz ID");
        idLabel.setBounds(170,150,100,30);
        style.styleLabel(idLabel);
        this.add(idLabel);

        idText = new JTextField();
        idText.setBounds(270,145,250,35);
        style.styleTextField(idText);
        this.add(idText);

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(220,260,120,40);
        style.styleButton(deleteButton);
        this.add(deleteButton);

        backButton = new JButton("Back");
        backButton.setBounds(380,260,120,40);
        style.styleButton(backButton);
        this.add(backButton);

        deleteButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    int id = Integer.parseInt(idText.getText());

                    QuizDaoimpl qdao = new QuizDaoimpl();

                    qdao.deleteQuiz(id);

                    JOptionPane.showMessageDialog(null,
                            "Quiz Deleted Successfully");

                }
                catch(Exception e1) {

                    JOptionPane.showMessageDialog(null,
                            e1.getMessage());

                }

            }
        });

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