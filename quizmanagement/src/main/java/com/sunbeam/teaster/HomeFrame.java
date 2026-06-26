//package com.sunbeam.teaster;
//
//import java.awt.event.ActionEvent;
//
//import com.sunbeam.entity.Role;
//import java.awt.event.ActionListener;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import java.awt.Color;
//import java.awt.Font;
//import javax.swing.BorderFactory;
//import com.sunbeam.utils.UIStyle;
//
//
//public class HomeFrame extends JFrame {
//	 
//	private JLabel titlelabel;
//	private JButton adminButton;
//	private JButton registerButton;
//	private JButton studentButton;
//	private JButton exitButton;
//public HomeFrame() {
//	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//	this.setTitle("Quiz App");
//	this.setLayout(null);
//	getContentPane().setBackground(new Color(245,245,245));
//	
//	UIStyle style = new UIStyle();
//	
//	//add components
//	
//	titlelabel = new JLabel("QUIZ MANAGEMENT SYSTEM");
//	titlelabel.setFont(new Font("Segoe UI",Font.BOLD,24));
//	titlelabel.setBounds(130,30,400,40);
//	
//	this.add(titlelabel);
//	
//	
//	adminButton = new JButton("Admin Login");
//	adminButton.setBounds(200,90,180,40);
//	style.styleButton(adminButton);
//	this.add(adminButton);
//	
//	registerButton = new JButton("Student Register");
//	registerButton.setBounds(200,145,180,40);
//	style.styleButton(registerButton);
//	this.add(registerButton);
//	
//	studentButton = new JButton("Student Login");
//	studentButton.setBounds(200,200,180,40);
//	style.styleButton(studentButton);
//	this.add(studentButton);
//	
//	exitButton = new JButton("Exit");
//	exitButton.setBounds(200,255,180,40);
//	exitButton.setBackground(new Color(231,76,60));
//	exitButton.setForeground(Color.WHITE);
//	exitButton.setFont(new Font("Segoe UI",Font.BOLD, 16));
//	exitButton.setFocusPainted(false);
//	exitButton.setBorder(BorderFactory.createEmptyBorder());
//	this.add(exitButton);
//	
//	registerButton.addActionListener(new ActionListener() {
//		
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			new RegisterFrame();
//			dispose();
//			
//		}
//	});
//	
//	exitButton.addActionListener(new ActionListener() {
//		
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			System.exit(0);
//			
//		}
//	});
//	adminButton.addActionListener(new ActionListener() {
//		
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			new LoginFrame(Role.ADMIN);
//			dispose();
//			
//			
//		}
//	});
//	
//	studentButton.addActionListener(new ActionListener() {
//		
//		@Override
//		public void actionPerformed(ActionEvent e) {             
//			new LoginFrame(Role.STUDENT);
//			dispose();
//			
//			
//		}
//	});
//	
//	
//	this.setSize(700,500);
//	this.setLocationRelativeTo(null);
//	this.setVisible(true);
//}
//
//
////private void styleButton(JButton button) {
////	button.setBackground(new Color(52,152,219));
////	button.setForeground(Color.WHITE);
////	button.setFont(new Font("Segoe UI",Font.BOLD,16));
////	button.setFocusPainted(false);
////	button.setBorder(BorderFactory.createEmptyBorder());
////}
//	
//	public static void main(String[] args)
//	{
//		HomeFrame h = new HomeFrame();
//		h.setSize(700,500);
//		h.setVisible(true);
//	}
//}

package com.sunbeam.teaster;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.sunbeam.entity.Role;
import com.sunbeam.utils.UIStyle;

public class HomeFrame extends JFrame {

	private JLabel titlelabel;
	private JLabel subTitle;

	private JButton adminButton;
	private JButton registerButton;
	private JButton studentButton;
	private JButton exitButton;

	public HomeFrame() {

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Quiz Management System");
		this.setLayout(null);
		this.getContentPane().setBackground(new Color(235, 245, 255));

		UIStyle style = new UIStyle();

		titlelabel = new JLabel("QUIZ MANAGEMENT SYSTEM");
		titlelabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
		titlelabel.setForeground(new Color(44, 62, 80));
		titlelabel.setBounds(120, 30, 470, 40);
		this.add(titlelabel);

		subTitle = new JLabel("Learn  |  Practice  |  Achieve");
		subTitle.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		subTitle.setForeground(Color.GRAY);
		subTitle.setBounds(235, 70, 260, 30);
		this.add(subTitle);

		adminButton = new JButton("Admin Login");
		adminButton.setBounds(220, 140, 220, 45);
		style.styleButton(adminButton);
		adminButton.setBackground(new Color(52, 152, 219));
		this.add(adminButton);

		registerButton = new JButton("Student Register");
		registerButton.setBounds(220, 200, 220, 45);
		style.styleButton(registerButton);
		registerButton.setBackground(new Color(46, 204, 113));
		this.add(registerButton);

		studentButton = new JButton("Student Login");
		studentButton.setBounds(220, 260, 220, 45);
		style.styleButton(studentButton);
		studentButton.setBackground(new Color(155, 89, 182));
		this.add(studentButton);

		exitButton = new JButton("Exit");
		exitButton.setBounds(220, 320, 220, 45);
		exitButton.setBackground(new Color(231, 76, 60));
		exitButton.setForeground(Color.WHITE);
		exitButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
		exitButton.setFocusPainted(false);
		exitButton.setBorder(BorderFactory.createEmptyBorder());
		this.add(exitButton);

		JLabel footer = new JLabel("Welcome To Online Quiz Portal");
		footer.setBounds(240, 400, 250, 20);
		footer.setForeground(Color.DARK_GRAY);
		footer.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		this.add(footer);

		registerButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new RegisterFrame();
				dispose();

			}
		});

		adminButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new LoginFrame(Role.ADMIN);
				dispose();

			}
		});

		studentButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new LoginFrame(Role.STUDENT);
				dispose();

			}
		});

		exitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				System.exit(0);

			}
		});

		this.setSize(700, 500);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public static void main(String[] args) {

		new HomeFrame();

	}
}
