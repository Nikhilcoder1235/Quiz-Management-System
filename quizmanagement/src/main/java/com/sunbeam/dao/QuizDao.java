package com.sunbeam.dao;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.sunbeam.entity.Question;
import com.sunbeam.entity.Quiz;
import com.sunbeam.entity.Result;

public interface QuizDao  extends AutoCloseable{
	
	 public void createQuiz(String title, String path) throws Exception;
	 
	 
   public Set<Quiz> listquiz() throws Exception;
  
  public List<Result> viewResults() throws Exception;
  public void deleteQuiz(int id) throws Exception;
  
  public void TakeQuiz(int std_id,int quiz_id) throws Exception;
  public List<Result> viewScore(int studentId) throws Exception;
} 
