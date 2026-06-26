package com.sunbeam.teaster;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import com.sunbeam.Daoimpl.QuizDaoimpl;
import com.sunbeam.entity.Question;
import com.sunbeam.entity.User;
import com.sunbeam.utils.UIStyle;

public class QuizQuestionFrame extends JFrame {

	private JLabel questionLabel;
	private JRadioButton optionA;
	private JRadioButton optionB;
	private JRadioButton optionC;
	private JRadioButton optionD;
	
	private ButtonGroup group;
	
	private JButton nextButton;
	private JButton submitButton;
	
	private List<Question> questionList;
	
	private User user;
	private int quizId;
	private int currentQuestion = 0;
	private int score = 0;
	
	private JLabel headingLabel;
	
	
	public QuizQuestionFrame(User user,int quizId) {
		
		getContentPane().setBackground(new Color(245,245,245));

		UIStyle style = new UIStyle();
		this.user = user;
		this.quizId = quizId;

		this.setTitle("Take Quiz");
		this.setLayout(null);
		this.setSize(700,500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		headingLabel = new JLabel("QUIZ EXAM", JLabel.CENTER);
		headingLabel.setFont(new Font("Segoe UI", Font.BOLD,28));
		headingLabel.setForeground(new Color(44,62,80));
		headingLabel.setBounds(0,20,700,40);

		this.add(headingLabel);
		
		questionLabel = new JLabel();
		questionLabel.setBounds(50,120,600,50);
		questionLabel.setFont(new Font("Segoe UI",Font.BOLD,18));
		this.add(questionLabel);
		
		optionA = new JRadioButton();
		optionA.setBounds(80,190,400,30);
		this.add(optionA);

		optionB = new JRadioButton();
		optionB.setBounds(80,230,400,30);
		this.add(optionB);

		optionC = new JRadioButton();
		optionC.setBounds(80,270,400,30);
		this.add(optionC);

		optionD = new JRadioButton();
		optionD.setBounds(80,310,400,30);
		this.add(optionD);
		
		optionA.setFont(new Font("Segoe UI",Font.PLAIN,16));
		optionB.setFont(new Font("Segoe UI",Font.PLAIN,16));
		optionC.setFont(new Font("Segoe UI",Font.PLAIN,16));
		optionD.setFont(new Font("Segoe UI",Font.PLAIN,16));
		
		group = new ButtonGroup();

		group.add(optionA);
		group.add(optionB);
		group.add(optionC);
		group.add(optionD);
		
		
		nextButton = new JButton("Next");
		nextButton.setBounds(220,390,120,40);
		style.styleButton(nextButton);
		this.add(nextButton);
		
		submitButton = new JButton("Submit");
		submitButton.setBounds(380,390,120,40);
		style.styleButton(submitButton);
		submitButton.setEnabled(false);

		this.add(submitButton);
		
		nextButton.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {

		        checkAnswer();

		        currentQuestion++;

		        if(currentQuestion < questionList.size()) {

		            loadQuestion();

		            if(currentQuestion == questionList.size()-1) {

		                nextButton.setEnabled(false);
		                submitButton.setEnabled(true);

		            }

		        }

		    }
		});
		
		submitButton.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {

		        try {

		            checkAnswer();

		            QuizDaoimpl dao = new QuizDaoimpl();

		            dao.saveScore(user.getId(), quizId, score);

		            JOptionPane.showMessageDialog(null,
		                    "Quiz Submitted\nScore : "
		                    + score + "/" + questionList.size());

		            new StudentDashboard(user);

		            dispose();

		        }
		        catch(Exception ex) {

		            JOptionPane.showMessageDialog(null,
		                    ex.getMessage());

		        }

		    }
		});
		
		try {

		    QuizDaoimpl dao = new QuizDaoimpl();

		    questionList = dao.getQuestions(quizId);

		    loadQuestion();
		    

		}
		catch(Exception e) {

		    JOptionPane.showMessageDialog(null,
		            e.getMessage());

		}
		this.setVisible(true);
	}
	private void loadQuestion() {

	    Question q = questionList.get(currentQuestion);

	    questionLabel.setText(q.getQuestion());

	    optionA.setText(q.getOptionA());

	    optionB.setText(q.getOptionB());

	    optionC.setText(q.getOptionC());

	    optionD.setText(q.getOptionD());

	    group.clearSelection();
	    
	    
	}
	
	private void checkAnswer() {

	    Question q = questionList.get(currentQuestion);

	    String correctAnswer = q.getAnswer().trim();

	    String userAnswer = "";

	    if(optionA.isSelected())
	        userAnswer = "A";

	    else if(optionB.isSelected())
	        userAnswer = "B";

	    else if(optionC.isSelected())
	        userAnswer = "C";

	    else if(optionD.isSelected())
	        userAnswer = "D";

	    if(userAnswer.equalsIgnoreCase(correctAnswer)) {
	        score++;
	    }
	}
}
