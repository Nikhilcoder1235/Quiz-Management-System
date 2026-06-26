package com.sunbeam.teaster;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.sunbeam.entity.User;
import com.sunbeam.utils.UIStyle;

public class StudentDashboard extends JFrame {

    private JLabel titleLabel;

    private JButton viewQuizButton;
    private JButton takeQuizButton;
    private JButton viewScoreButton;
    private JButton logoutButton;
    private User u;
    

    public StudentDashboard(User u) {
        this.u = u;
        getContentPane().setBackground(new Color(245,245,245));

        UIStyle style = new UIStyle();
        this.setTitle("Student Dashboard");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);

        titleLabel = new JLabel("STUDENT DASHBOARD");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 26));
        titleLabel.setBounds(0,30,700,40);
        this.add(titleLabel);
        
        
        viewQuizButton = new JButton("View Quizzes");
        viewQuizButton.setBounds(260,100,180,40);
        style.styleButton(viewQuizButton);
        this.add(viewQuizButton);

        takeQuizButton = new JButton("Take Quiz");
        takeQuizButton.setBounds(260,160,180,40);
        style.styleButton(takeQuizButton);
        this.add(takeQuizButton);

        viewScoreButton = new JButton("View Scores");
        viewScoreButton.setBounds(260,220,180,40);
        style.styleButton(viewScoreButton);
        this.add(viewScoreButton);

        logoutButton = new JButton("Logout");
        logoutButton.setBounds(260,280,180,40);

        logoutButton.setBackground(new Color(231,76,60));
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setFont(new Font("Segoe UI", Font.BOLD,16));
        logoutButton.setFocusPainted(false);

        this.add(logoutButton);

        
        viewQuizButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                new ViewQuizFrame(u);
                dispose();

            }
        });
        
        takeQuizButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new TakeQuizFrame(u);
				dispose();
				
			}
		});
        
        viewScoreButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ViewScoreFrame(u);
				dispose();
			}
		});
        logoutButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                new HomeFrame();
                dispose();

            }
        });

        this.setSize(700,500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}