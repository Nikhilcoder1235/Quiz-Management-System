package com.sunbeam.Daoimpl;

import java.io.BufferedReader;
import com.sunbeam.entity.Question;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.sunbeam.entity.Attempt;
import com.sunbeam.entity.Quiz;
import com.sunbeam.entity.Result;
import com.sunbeam.entity.User;
import com.sunbeam.exception.NoQuestionsFoundException;
import com.sunbeam.exception.NoQuizFoundException;
import com.sunbeam.exception.QuizAlreadyAttemptedException;
import com.sunbeam.utils.DbUtil;

public class QuizDaoimpl {

	Connection con;
	Scanner sc = new Scanner(System.in);

	public QuizDaoimpl() throws Exception {
		con = DbUtil.getConnection();
	}

	public void createQuiz(String title, String path) throws Exception, NoQuestionsFoundException {
		String Query = "Insert into quiz (title) values(?)";

		PreparedStatement stmt = con.prepareStatement(Query, PreparedStatement.RETURN_GENERATED_KEYS);

		stmt.setString(1, title);
		stmt.executeUpdate();
		ResultSet rs = stmt.getGeneratedKeys();
		int id = 0;
		if (rs.next()) {
			id = rs.getInt(1);

		}

		System.out.println("generated key " + id);

		BufferedReader br = new BufferedReader(new FileReader(path));
		String Question;
		boolean Qfound = false;
		while ((Question = br.readLine()) != null) {

			if (Question.trim().isEmpty())
				continue;
			Qfound = true;
			String op_1 = br.readLine();
			String op_2 = br.readLine();
			String op_3 = br.readLine();
			String op_4 = br.readLine();
			String cor_op = br.readLine();

			String Query1 = "insert into question (quizId,question,optionA,optionB,optionC,optionD,answer) values(?,?,?,?,?,?,?)";

			PreparedStatement stmt1 = con.prepareStatement(Query1);

			stmt1.setInt(1, id);
			stmt1.setString(2, Question);
			stmt1.setString(3, op_1);
			stmt1.setString(4, op_2);
			stmt1.setString(5, op_3);
			stmt1.setString(6, op_4);
			stmt1.setString(7, cor_op);
			stmt1.executeUpdate();

			if (!Qfound) {
				throw new NoQuestionsFoundException(path);
			}
			System.out.println("quiz is created");
		}
	}

	public Set<Quiz> listquiz() throws Exception, NoQuizFoundException {
		Set<Quiz> quizes = new LinkedHashSet<>();
		String sql = "Select * from quiz";
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Quiz q = new Quiz();
			q.setId(rs.getInt("id"));
			q.setTitle(rs.getString("title"));
			quizes.add(q);
		}
		
		if(quizes.isEmpty()) {
		    throw new NoQuizFoundException("No Quiz Available");
		}
		return quizes;

	}

	public List<Result> viewResults() throws Exception, NoQuizFoundException {
		List<Result> results = new LinkedList<>();
		String sql = "Select * from attempt";

		PreparedStatement stmt = con.prepareStatement(sql);

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Result r = new Result();

			
			r.setStudentId(rs.getInt("studentId"));
			r.setQuizId(rs.getInt("quizId"));
			r.setScore(rs.getInt("score"));

			results.add(r);

		}
		return results;
	}

	public void deleteQuiz(int id) throws Exception, NoQuizFoundException {
		String sql = " DELETE quiz ,question FROM quiz  INNER JOIN question on   quiz.id=question.quizId where quiz.id=?";

		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);
		int rs = stmt.executeUpdate();
		if (rs > 0) {
			System.out.println("quiz is deleted");
		}

	}

public void TakeQuiz(int std_id,int quiz_id) throws Exception,QuizAlreadyAttemptedException{
	String checkQuery =
			"select * from attempt where studentId=? and quizid=?";

			PreparedStatement stmtCheck =
			        con.prepareStatement(checkQuery);

			stmtCheck.setInt(1, std_id);
			stmtCheck.setInt(2, quiz_id);

			ResultSet rsCheck =
			        stmtCheck.executeQuery();

			if(rsCheck.next()) {
			    throw new QuizAlreadyAttemptedException(
			            "Quiz already attempted");
			}
	int score=0;
	String query="Select * from question where quizId=?";
	PreparedStatement stmt= con.prepareStatement(query);
	stmt.setInt(1, quiz_id);
	
	ResultSet rs=stmt.executeQuery();
	
	while(rs.next()) {
		String que=rs.getString("question");
		if(que==null) {
			break;
		}
		System.out.println(que);
		System.out.println(rs.getString("optionA"));
		System.out.println(rs.getString("optionB"));
		System.out.println(rs.getString("optionC"));
		System.out.println(rs.getString("optionD"));
		
		System.out.println("enter your ans ");
		String userAns=sc.next().trim().toUpperCase();
		String correct_opt=rs.getString("answer").trim();
		if(correct_opt.contains(":")) {
			correct_opt=correct_opt.split(":")[1].trim();
		}
		
		
		if(userAns.equalsIgnoreCase(correct_opt)) {
			System.out.println("correct ans ");
			score++;
		}
	}
	
	Attempt atmt=new Attempt(std_id,quiz_id,score);// constructor
	
	User u=new User();
	u.getAttemptmap().put(quiz_id, atmt);
	
	String Query="insert into attempt(studentId,quizid,score) values(?,?,?)";
	PreparedStatement stmt3 = con.prepareStatement(Query);
	
	stmt3.setInt(1, std_id);
	stmt3.setInt(2, quiz_id);
	stmt3.setInt(3, score);
	stmt3.executeUpdate();
	
	System.out.println("Quiz is submitted");
	System.out.println("score "+score);

	
	
	
	  
 }

public List<Result> viewScore(int studentId) throws Exception,NoQuizFoundException {

    List<Result> scores = new LinkedList<>();

    String sql =
    "select * from attempt where studentId=?";

    PreparedStatement stmt =
            con.prepareStatement(sql);

    stmt.setInt(1, studentId);

    ResultSet rs = stmt.executeQuery();

    while(rs.next()) {

        Result r = new Result();

        r.setStudentId(
                rs.getInt("studentId"));

        r.setQuizId(
                rs.getInt("quizId"));

        r.setScore(
                rs.getInt("score"));

        scores.add(r);
    }

    if(scores.isEmpty()) {
        throw new NoQuizFoundException(
                "No Scores Found");
    }

    return scores;
}
public List<Question> getQuestions(int quizId) throws Exception {

    List<Question> questions = new LinkedList<>();

    String sql = "select * from question where quizId=?";

    PreparedStatement stmt = con.prepareStatement(sql);

    stmt.setInt(1, quizId);

    ResultSet rs = stmt.executeQuery();

    while(rs.next()) {

        Question q = new Question();

        q.setQuestionId(rs.getInt("questionId"));
        q.setQuestion(rs.getString("question"));
        q.setOptionA(rs.getString("optionA"));
        q.setOptionB(rs.getString("optionB"));
        q.setOptionC(rs.getString("optionC"));
        q.setOptionD(rs.getString("optionD"));
        q.setAnswer(rs.getString("answer"));

        questions.add(q);
    }

    return questions;
}

public void saveScore(int studentId, int quizId, int score) throws Exception {

    String sql = "insert into attempt(studentId,quizId,score) values(?,?,?)";

    PreparedStatement stmt = con.prepareStatement(sql);

    stmt.setInt(1, studentId);
    stmt.setInt(2, quizId);
    stmt.setInt(3, score);

    stmt.executeUpdate();
}
}
