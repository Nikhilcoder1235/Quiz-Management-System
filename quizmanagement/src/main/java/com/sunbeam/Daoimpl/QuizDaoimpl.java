package com.sunbeam.Daoimpl;
import java.io.BufferedReader;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.sunbeam.entity.Quiz;
import com.sunbeam.entity.Result;
import com.sunbeam.exception.NoQuestionsFoundException;
import com.sunbeam.exception.NoQuizFoundException;
import com.sunbeam.utils.DbUtil;
public class QuizDaoimpl {
 
 Connection con;
 
 public QuizDaoimpl() throws Exception {
	 con = DbUtil.getConnection();
 }
 

 public void createQuiz(String title,String path) throws Exception,NoQuestionsFoundException{
	 String Query = "Insert into quiz (title) values(?)";
	 
	 PreparedStatement stmt = con.prepareStatement(Query,PreparedStatement.RETURN_GENERATED_KEYS);
	 
	 stmt.setString(1, title);
	 stmt.executeUpdate();
	 ResultSet rs = stmt.getGeneratedKeys();
	 int id = 0;
	 if(rs.next()) {
		 id = rs.getInt(1);
		 
	 }
	 
	 System.out.println("generated key " +id);
	 
	 BufferedReader br = new BufferedReader(new FileReader(path));
	 String Question;
	 boolean Qfound = false;
	 while((Question = br.readLine())!= null) {
		
		 if(Question.trim().isEmpty())
		 continue;
	 Qfound = true;
	 String op_1 = br.readLine();
	 String op_2 = br.readLine();
	 String op_3 = br.readLine();
	 String op_4 = br.readLine();
	 String cor_op = br.readLine();
	 
	 String Query1 = "insert into question (quizId,question,optionA,optionB,optionC,optionD,answer) values(?,?,?,?,?,?,?)";
	 
	 PreparedStatement stmt1 = con.prepareStatement(Query1);
	 
	 stmt1.setInt(1,id);
	 stmt1.setString(2,Question);
	 stmt1.setString(3,op_1);
	 stmt1.setString(4, op_2);
	 stmt1.setString(5, op_3);
	 stmt1.setString(6, op_4);
	 stmt1.setString(7, cor_op);
	 stmt1.executeUpdate();
	 
	 if(!Qfound) {
		 throw new NoQuestionsFoundException(path);
	 }
	 System.out.println("quiz is created");
 }
 }
 
 
 public Set<Quiz> listquiz() throws Exception,NoQuizFoundException{
	 Set<Quiz> quizes = new LinkedHashSet<>();
	 String sql = "Select * from quiz";
	 PreparedStatement stmt = con.prepareStatement(sql);
	 ResultSet rs = stmt.executeQuery();
	 
	 while(rs.next()) {
		 Quiz q = new Quiz();
		 q.setId(rs.getInt("id"));
		 q.setTitle(rs.getString("title"));
		 quizes.add(q);
	 }
	return quizes;
			 
			 
	 
 }
 public  List<Result> viewResults() throws Exception,NoQuizFoundException{
	 List<Result> results = new LinkedList<>();
	 String sql = "Select * from result";
	 
	 PreparedStatement stmt = con.prepareStatement(sql);
	 
	 ResultSet rs = stmt.executeQuery();
	 
	 while(rs.next()) {
		 Result r = new Result();
		 
		 r.setResultid(rs.getInt("resultid"));
		 r.setStudentId(rs.getInt("studentId"));
		 r.setQuizId(rs.getInt("quizId"));
		 r.setScore(rs.getInt("Score"));
		 
		 results.add(r);
		 
		 
	 }
	 return results;
 }
 
public void deleteQuiz(int id) throws Exception,NoQuizFoundException{
 String sql =  " DELETE quiz ,question FROM quiz  INNER JOIN question on   quiz.id=question.quizId where quiz.id=?";
 
 PreparedStatement stmt = con.prepareStatement(sql);
 stmt.setInt(1, id);
int rs= stmt.executeUpdate();
if(rs>0) {
System.out.println("quiz is deleted");
}

}
 
 
}
