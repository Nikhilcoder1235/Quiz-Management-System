package com.sunbeam.teaster;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import com.sunbeam.utils.UIStyle;

public class AdminDashboard extends JFrame {

    private JLabel titleLabel;

    private JButton createQuizButton;
    private JButton listQuizButton;
    private JButton viewResultButton;
    private JButton deleteQuizButton;
    private JButton logoutButton;

    public AdminDashboard() {
    	getContentPane().setBackground(new Color(245,245,245));

    	UIStyle style = new UIStyle();
        this.setTitle("Admin Dashboard");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);

        titleLabel = new JLabel("ADMIN DASHBOARD", JLabel.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 26));
        titleLabel.setBounds(0,30,700,40);
        this.add(titleLabel);
        
        
        createQuizButton = new JButton("Create Quiz");
        createQuizButton.setBounds(260,100,180,40);
        style.styleButton(createQuizButton);
        this.add(createQuizButton);

        listQuizButton = new JButton("List Quiz");
        listQuizButton.setBounds(260,160,180,40);
        style.styleButton(listQuizButton);
        this.add(listQuizButton);
        
        viewResultButton = new JButton("View Results");
        viewResultButton.setBounds(260,220,180,40);
        style.styleButton(viewResultButton);
        this.add(viewResultButton);

        deleteQuizButton = new JButton("Delete Quiz");
        deleteQuizButton.setBounds(260,280,180,40);
        style.styleButton(deleteQuizButton);
        this.add(deleteQuizButton);

        logoutButton = new JButton("Logout");
        logoutButton.setBounds(260,340,180,40);

        logoutButton.setBackground(new Color(231,76,60));
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setFont(new Font("Segoe UI", Font.BOLD,16));
        logoutButton.setFocusPainted(false);
        logoutButton.setBorder(BorderFactory.createEmptyBorder());

        this.add(logoutButton);
        
        createQuizButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                new CreateQuizFrame();
                dispose();

            }
        });
        
        listQuizButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ListQuizFrame();
				dispose();
				
			}
		});

        viewResultButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ViewResultFrame();
				dispose();
				
			}
		});
        
        deleteQuizButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new DeleteQuizFrame();
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