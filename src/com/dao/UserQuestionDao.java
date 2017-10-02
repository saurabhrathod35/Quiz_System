package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.QuestionBean;
import com.util.DBConnection;

public class UserQuestionDao {

	static Connection conn = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;

	public static List<QuestionBean>  listquestion(int quizid) {
		 
		 List<QuestionBean> list=new ArrayList<QuestionBean>();
		conn = DBConnection.getConnection();
		if (conn != null) {
			
			String select = "select * from question where quizid=?";
			try {
				pstmt = conn.prepareStatement(select);
				pstmt.setInt(1,quizid);
				rs = pstmt.executeQuery();
				 while (rs.next()) {
					 QuestionBean questionBean=new QuestionBean();
					questionBean.setQuestion_id(rs.getInt("q_id"));
					questionBean.setQuestion(rs.getString("questions"));
					questionBean.setOption1(rs.getString("option1"));
					questionBean.setOption2(rs.getString("option2"));
					questionBean.setOption3(rs.getString("option3"));
					questionBean.setAnswer(rs.getString("answer"));
					questionBean.setQuizid(rs.getInt("quizid"));
					list.add(questionBean);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
}
