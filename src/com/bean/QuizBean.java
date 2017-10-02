package com.bean;

public class QuizBean {

	private int  QuizId;
	private String QuizName;
	private boolean visible;
	
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	public int getQuizId() {
		return QuizId;
	}
	public void setQuizId(int quizId) {
		QuizId = quizId;
	}
	public String getQuizName() {
		return QuizName;
	}
	public void setQuizName(String quizName) {
		QuizName = quizName;
	}
	
	
}
