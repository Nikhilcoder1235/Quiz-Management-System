package com.sunbeam.teaster;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.sunbeam.Daoimpl.userDaoimpl;
import com.sunbeam.entity.Role;
import com.sunbeam.entity.User;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import com.sunbeam.utils.UIStyle;
public class LoginFrame extends JFrame {
	   private JLabel emailLabel;
	   private JLabel passwordLabel;
	   private Role role;
	   private JTextField emailText;
	   private JPasswordField passwordText;
	   private JLabel titleLabel;
	   private JLabel loginLabel;
	   private JButton LoginButton;
	   private JButton backButton;
	   private JLabel imageLabel;
	   
	public LoginFrame(Role role) {
		this.role = role;
		this.setTitle("Student Login");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		getContentPane().setBackground(new Color(245,245,245));

		UIStyle style = new UIStyle();
		
		this.setSize(700,500);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		//add components
		
		ImageIcon icon = new ImageIcon(getClass().getResource("/images/admin.png"));

		Image img = icon.getImage();
		Image newImg = img.getScaledInstance(120, 120, Image.SCALE_SMOOTH);

		imageLabel = new JLabel(new ImageIcon(newImg));
		imageLabel.setBounds(290, 20, 120, 120);

		this.add(imageLabel);
		
		loginLabel = new JLabel();
       
		if(role == Role.ADMIN)
		    loginLabel.setText("ADMIN LOGIN");
		else
		    loginLabel.setText("STUDENT LOGIN");

		loginLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
		loginLabel.setBounds(260,210,180,30);
		this.add(loginLabel);
		
		
		emailLabel = new JLabel("Email");
		emailLabel.setBounds(170,260,100,30);
		style.styleLabel(emailLabel);
		  this.add(emailLabel);

		  emailText = new JTextField();
		  emailText.setBounds(270,255,250,35);

		  style.styleTextField(emailText);
		  this.add(emailText);
		  
		  passwordLabel = new JLabel("Password");
		  passwordLabel.setBounds(170,320,100,30);
		  style.styleLabel(passwordLabel);
		  this.add(passwordLabel);
		  
		  passwordText = new JPasswordField();
		  passwordText.setBounds(270,315,250,35);

		  style.styleTextField(passwordText);
		  this.add(passwordText);
		  
		  LoginButton = new JButton("Login");
		  LoginButton.setBounds(220,390,120,40);
		  style.styleButton(LoginButton);
		  this.add(LoginButton);

		  backButton = new JButton("Back");
		  backButton.setBounds(380,390,120,40);
		  style.styleButton(backButton);
		  this.add(backButton);
		
		  
		  LoginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					userDaoimpl dao= new userDaoimpl();
					User u=new User();
					String email=emailText.getText();
					String Pass=new String (passwordText.getPassword());
					u=dao.login(email,Pass );
					
					if(u.getRole() == role)
					{
					    if(role == Role.ADMIN)
					    {
					        JOptionPane.showMessageDialog(null,
					                "Admin Login Successful");

					        new AdminDashboard();
					        dispose();
					    }
					    else
					    {
					        JOptionPane.showMessageDialog(null,
					                "Student Login Successful");
                           new StudentDashboard(u);
                           dispose();
					       
					    }
					}
					else
					{
					    JOptionPane.showMessageDialog(null,
					            "Invalid Login");
					}
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
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
//		LoginFrame l = new LoginFrame();
//		l.setSize(600,400);
//		l.setVisible(true);
//	}

}
