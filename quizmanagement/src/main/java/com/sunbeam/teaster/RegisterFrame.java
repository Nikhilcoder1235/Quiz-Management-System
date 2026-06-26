package com.sunbeam.teaster;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import com.sunbeam.dao.*;
import com.sunbeam.Daoimpl.*;

import com.sunbeam.entity.Role;
import com.sunbeam.entity.User;
import com.sunbeam.utils.UIStyle;

public class RegisterFrame extends JFrame{
   private JLabel titleLabel;
   private JLabel nameLabel;
   private JLabel emailLabel;
   private JLabel passwordLabel;
   
   private JTextField nameText;
   private JTextField emailText;
   private JPasswordField passwordText;
   
   private JButton registerButton;
   private JButton backButton;
   
	
	
	public RegisterFrame() {
		this.setTitle("Student Register");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		
		
		this.setSize(700,500);
		this.setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(245,245,245));
		this.setVisible(true);
		//add components
		
		UIStyle style = new UIStyle();
		
		 titleLabel = new JLabel("STUDENT REGISTRATION");
		  titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 26));
		  titleLabel.setBounds(180,30,350,40);
		  this.add(titleLabel);
		  
		  nameLabel = new JLabel("Name");
		  nameLabel.setBounds(170,110,100,30);
		  style.styleLabel(nameLabel);
		  this.add(nameLabel);

		  nameText = new JTextField();
		  nameText.setBounds(270,110,250,35);
		  style.styleTextField(nameText);
		  this.add(nameText);
	  
		  emailLabel = new JLabel("Email");
		  emailLabel.setBounds(170,170,100,30);
		  style.styleLabel(emailLabel);
		  this.add(emailLabel);

		  emailText = new JTextField();
		  emailText.setBounds(270,170,250,35);
		  style.styleTextField(emailText);
		  this.add(emailText);
	  
		  passwordLabel = new JLabel("Password");
		  passwordLabel.setBounds(170,230,100,30);
		  style.styleLabel(passwordLabel);
		  this.add(passwordLabel);

		  passwordText = new JPasswordField();
		  passwordText.setBounds(270,230,250,35);
		  style.styleTextField(passwordText);
		  this.add(passwordText);
	  
		  registerButton = new JButton("Register");
		  registerButton.setBounds(220,320,120,40);
		  style.styleButton(registerButton);
		  this.add(registerButton);

		  backButton = new JButton("Back");
		  backButton.setBounds(380,320,120,40);
		  style.styleButton(backButton);
		  this.add(backButton);
	  
	  
	  registerButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			User u = new User();
			u.setName(nameText.getText());
			u.setEmail(emailText.getText());
			u.setPassword(String.valueOf(passwordText.getPassword()));
			u.setRole(Role.STUDENT);
			
			try {
			    userDao dao = new userDaoimpl();

			    if(dao.save(u) == 1)
			        JOptionPane.showMessageDialog(null,
			                "Registration Successful");
			   
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
			new HomeFrame();
			dispose();
			
		}
	});
	}
//	public static void main(String[] args) {
//		
//
//		
//		RegisterFrame h = new RegisterFrame();
//		h.setSize(600,400);
//		h.setVisible(true);
//		h.setLocationRelativeTo(null);
//		
//		
//	}

}
