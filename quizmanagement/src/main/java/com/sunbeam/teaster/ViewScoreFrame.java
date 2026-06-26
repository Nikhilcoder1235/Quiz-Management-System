package com.sunbeam.teaster;

import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

import com.sunbeam.utils.UIStyle;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.sunbeam.Daoimpl.QuizDaoimpl;
import com.sunbeam.entity.Result;
import com.sunbeam.entity.User;

public class ViewScoreFrame extends JFrame {

    private JTextArea area;
    private JScrollPane scroll;
    private JButton backButton;

    private User u;
    private JLabel headingLabel;
    
    public ViewScoreFrame(User u) {
    	
    	getContentPane().setBackground(new Color(245,245,245));

    	UIStyle style = new UIStyle();
        this.u = u;

        this.setTitle("View Scores");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        
        headingLabel = new JLabel("MY SCORES", JLabel.CENTER);
        headingLabel.setFont(new Font("Segoe UI", Font.BOLD,28));
        headingLabel.setForeground(new Color(44,62,80));
        headingLabel.setBounds(0,20,700,40);

        this.add(headingLabel);

        area = new JTextArea();
        area.setEditable(false);
        area.setFont(new Font("Segoe UI", Font.PLAIN,15));
        area.setBackground(Color.WHITE);

        scroll = new JScrollPane(area);
        scroll.setBounds(80,80,540,270);

        scroll.setBorder(
        BorderFactory.createLineBorder(
        new Color(52,152,219),2));

        this.add(scroll);
        
        backButton = new JButton("Back");
        backButton.setBounds(290,380,120,40);
        style.styleButton(backButton);
        this.add(backButton);

        try {

            QuizDaoimpl dao = new QuizDaoimpl();

            List<Result> scores = dao.viewScore(u.getId());

           
            area.append("=========== MY SCORES ===========\n\n");

            for(Result r : scores)
            {
                area.append("Quiz ID : " + r.getQuizId() + "\n");
                area.append("Score   : " + r.getScore() + "\n");
                area.append("------------------------------------\n");
            }

        }
        catch(Exception e) {

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