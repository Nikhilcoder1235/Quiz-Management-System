package com.sunbeam.teaster;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.sunbeam.Daoimpl.QuizDaoimpl;
import com.sunbeam.entity.User;
import com.sunbeam.utils.UIStyle;

public class TakeQuizFrame extends JFrame {

    private JLabel quizIdLabel;
    private JTextField quizIdText;

    private JButton startButton;
    private JButton backButton;
    private JLabel headingLabel;
    private User u;

    public TakeQuizFrame(User u) {
    	getContentPane().setBackground(new Color(245,245,245));

    	UIStyle style = new UIStyle();
    	
        this.u = u;

        this.setTitle("Take Quiz");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        
        headingLabel = new JLabel("TAKE QUIZ", JLabel.CENTER);
        headingLabel.setFont(new Font("Segoe UI", Font.BOLD,28));
        headingLabel.setForeground(new Color(44,62,80));
        headingLabel.setBounds(0,25,700,40);
        this.add(headingLabel);
        
        quizIdLabel = new JLabel("Quiz ID");
        quizIdLabel.setBounds(170,150,100,30);
        style.styleLabel(quizIdLabel);
        this.add(quizIdLabel);

        quizIdText = new JTextField();
        quizIdText.setBounds(270,145,250,35);
        style.styleTextField(quizIdText);
        this.add(quizIdText);

        startButton = new JButton("Start Quiz");
        startButton.setBounds(220,260,120,40);
        style.styleButton(startButton);
        this.add(startButton);

        backButton = new JButton("Back");
        backButton.setBounds(380,260,120,40);
        style.styleButton(backButton);
        this.add(backButton);

        startButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                  

                    int quizId = Integer.parseInt(quizIdText.getText());

                    new QuizQuestionFrame(u, quizId);

                    dispose();

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

                new StudentDashboard(u);
                dispose();

            }
        });

        this.setSize(700,500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}