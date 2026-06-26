package com.sunbeam.teaster;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.sunbeam.Daoimpl.QuizDaoimpl;
import com.sunbeam.entity.Quiz;
import com.sunbeam.entity.User;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

import com.sunbeam.utils.UIStyle;

public class ViewQuizFrame extends JFrame {
    private User u;
    private JTextArea area;
    private JScrollPane scroll;
    private JButton backButton;
    private JLabel headingLabel;
    
    
    public ViewQuizFrame(User u) {
    	
    	getContentPane().setBackground(new Color(245,245,245));

    	UIStyle style = new UIStyle();
    	
        this.u = u;
        this.setTitle("View Quizzes");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);

        
        headingLabel = new JLabel("AVAILABLE QUIZZES", JLabel.CENTER);
        headingLabel.setFont(new Font("Segoe UI", Font.BOLD,26));
        headingLabel.setForeground(new Color(44,62,80));
        headingLabel.setBounds(0,20,700,40);
        this.add(headingLabel);
        
        
        area = new JTextArea();
        area.setEditable(false);
        area.setFont(new Font("Segoe UI", Font.PLAIN,15));
        area.setBackground(Color.WHITE);

        scroll = new JScrollPane(area);
        scroll.setBounds(80,80,540,270);
        scroll.setBorder(BorderFactory.createLineBorder(new Color(52,152,219),2));

        this.add(scroll);

        backButton = new JButton("Back");
        backButton.setBounds(290,380,120,40);

        style.styleButton(backButton);
        this.add(backButton);

        try {

            QuizDaoimpl qdao = new QuizDaoimpl();

            Set<Quiz> quizzes = qdao.listquiz();

            area.append("===== AVAILABLE QUIZZES =====\n\n");

            for (Quiz q : quizzes) {
                area.append(q.toString() + "\n");
            }

        } 
        catch (Exception e) {

            JOptionPane.showMessageDialog(null,
                    e.getMessage());

        }

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