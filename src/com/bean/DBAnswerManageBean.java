package com.bean;

import java.util.ArrayList;
import java.util.List;

public class DBAnswerManageBean {
	
	 private List<String > userAnswer= new ArrayList<String>();
	 private List<String> currectAnswer=new ArrayList<String>();
	 private String  currectAns;
	 
	 
	public String getCurrectAns() {
		return currectAns;
	}
	public void setCurrectAns(String currectAns) {
		this.currectAns = currectAns;
	}
	public List<String> getCurrectAnswer() {
		return currectAnswer;
	}
	public void setCurrectAnswer(List<String> currectAnswer) {
		this.currectAnswer = currectAnswer;
	}
	public void  AddUserAnswer( String UserAns)
	{
		this.userAnswer.add(UserAns);
	}
	public List<String> getUserAnswer()
	{
		return userAnswer;
	}
}
