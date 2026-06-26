package com.sunbeam.utils;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class UIStyle {

	public void styleButton(JButton button) {
		
		button.setBackground(new Color(52,152,219));
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Segoe UI",Font.BOLD,16));
		
		button.setFocusPainted(false);
		button.setBorder(BorderFactory.createEmptyBorder());
	}
	
	public void styleLabel(JLabel label) {
		label.setFont(new Font("Segoe UI",Font.BOLD,16));
		
	}
	public void styleTextField(JTextField textfield) {
		textfield.setFont(new Font("Segoe UI",Font.PLAIN,15));
	}
}
