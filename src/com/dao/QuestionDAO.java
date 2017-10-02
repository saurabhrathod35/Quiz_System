package com.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.QuestionBean;
import com.util.DBConnection;

public class QuestionDAO {

	static Connection con = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;

	public static boolean deleteQuestion(String questionId)
	{
		boolean flag=false;
		con=DBConnection.getConnection();
		if(con!=null)
		{
			String delete=" delete from question where q_id=?";
			
			try {
				pstmt=con.prepareStatement(delete);
				pstmt.setString(1,questionId);
				if(pstmt.executeUpdate()>0)
				{
					flag=true;
				}
			} catch (SQLException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return flag;
	}
	public static boolean addQuestion(QuestionBean bean) {
		boolean flag = false;
		con = DBConnection.getConnection();
		if (con != null) {
			String insert = "insert into question(questions,answer,option1,option2,option3,quizid) values(?,?,?,?,?,?)";
			try {
				pstmt = con.prepareStatement(insert);
				pstmt.setString(1, bean.getQuestion());
				pstmt.setString(2, bean.getAnswer());
				pstmt.setString(3,bean.getOption1());
				pstmt.setString(4,bean.getOption2());
				pstmt.setString(5,bean.getOption3());
				pstmt.setInt(6, bean.getQuizid());
				
				System.out.println("answer::::"+bean.getAnswer());
				
				int cnt = pstmt.executeUpdate();

				if (cnt > 0) {
					flag = true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return flag;
	}
	public static List<QuestionBean> listQuestion()
	{
		List<QuestionBean> listQuestion=new ArrayList<QuestionBean>();
		con=DBConnection.getConnection();
		if(con!=null)
		{
			String select =" select qu.*,q.quizname from  question qu,quiz q where qu.quizid=q.quizid";
			try {
				pstmt = con.prepareStatement(select);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					QuestionBean bean=new QuestionBean();
					bean.setQuestion_id(rs.getInt("q_id"));
					bean.setQuestion(rs.getString("questions"));
					bean.setAnswer(rs.getString("answer"));
					bean.setOption1(rs.getString("option1"));
					bean.setOption2(rs.getString("option2"));
					bean.setOption3(rs.getString("option3"));
					bean.setQuizid(rs.getInt("quizid"));
					bean.setQuizName(rs.getString("quizName"));
					listQuestion.add(bean);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listQuestion;
	}
	 
}
