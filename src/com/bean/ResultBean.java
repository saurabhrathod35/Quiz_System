package com.bean;

public class ResultBean {

	
	private String user_id;
	private String quizId;
	private String total;
	private String userName;
	private String quizname;
	private String startTime;
	private String endTime;
	private String complitionTime;

	
	public String getStartTime() {
		return startTime;
	}
	public String getComplitionTime() {
		return complitionTime;
	}
	public void setComplitionTime(String complitionTime) {
		this.complitionTime = complitionTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getQuizname() {
		return quizname;
	}
	public void setQuizname(String quizname) {
		this.quizname = quizname;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getQuizId() {
		return quizId;
	}
	public void setQuizId(String quizId) {
		this.quizId = quizId;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}

}
