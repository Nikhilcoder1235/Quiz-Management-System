package com.sunbeam.entity;

public class Result {
private int resultid;
private int studentId;
private int quizId;
private int score;

public Result() {
	
}

public Result(int resultid, int studentId, int quizId, int score) {
	this.resultid = resultid;
	this.studentId = studentId;
	this.quizId = quizId;
	this.score = score;
	
}

public int getResultid() {
	return resultid;
}

public void setResultid(int resultid) {
	this.resultid = resultid;
}

public int getStudentId() {
	return studentId;
}

public void setStudentId(int studentId) {
	this.studentId = studentId;
}

public int getQuizId() {
	return quizId;
}

public void setQuizId(int quizId) {
	this.quizId = quizId;
}

public int getScore() {
	return score;
}

public void setScore(int score) {
	this.score = score;
}

@Override
public String toString() {
	return "Result [resultid=" + resultid + ", studentId=" + studentId + ", quizId=" + quizId + ", score=" + score
			+ "]";
}


}
