package com.sunbeam.entity;

import java.util.Objects;

public class Attempt {

	private int attemptId;
	private int studentId;
	private int quizid;
	private int score;
	
	public Attempt () {
		
	}
	
	public Attempt( int studentId, int quizid, int score) {
		
		this.studentId = studentId;
		this.quizid = quizid;
		this.score = score;
	}

	public int getAttemptId() {
		return attemptId;
	}

	public void setAttemptId(int attemptId) {
		this.attemptId = attemptId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getQuizid() {
		return quizid;
	}

	public void setQuizid(int quizid) {
		this.quizid = quizid;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Attempt [attemptId=" + attemptId + ", studentId=" + studentId + ", quizid=" + quizid + ", score="
				+ score + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(attemptId, quizid, score, studentId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Attempt other = (Attempt) obj;
		return attemptId == other.attemptId && quizid == other.quizid && score == other.score
				&& studentId == other.studentId;
	}
	
	
	
	
}

