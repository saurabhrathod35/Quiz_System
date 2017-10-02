package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.QuizBean;
import com.util.DBConnection;

public class QuizDao {
	static Connection con = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;

	public static boolean addQuizName(QuizBean quizBean) {
		boolean flag = false;
		con = DBConnection.getConnection();
		if (con != null) {
			String insert = "insert into quiz(quizName) values(?)";
			try {
				pstmt = con.prepareStatement(insert);
				pstmt.setString(1, quizBean.getQuizName());
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

	public static List<QuizBean> ListQuizName() {

		List<QuizBean> listquiz = new ArrayList<QuizBean>();
		con = DBConnection.getConnection();
		if (con != null) {
			String select = "select * from quiz";
			try {
				pstmt = con.prepareStatement(select);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					QuizBean quizBean = new QuizBean();
					quizBean.setQuizId(rs.getInt("quizId"));
					quizBean.setQuizName(rs.getString("quizName"));
					quizBean.setVisible(rs.getBoolean("visible"));
					listquiz.add(quizBean);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listquiz;
	}

	public static boolean  QuizVisible(int quizid)
	{
		boolean flag=false;
		con=DBConnection.getConnection();
		if(con!=null)
		{
			String update="update  quiz set visible=1 where quizid=?";
			try {
				pstmt=con.prepareStatement(update);
				pstmt.setInt(1, quizid);
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
	
	public static boolean  QuizInVisible(int quizid)
	{
		boolean flag=false;
		con=DBConnection.getConnection();
		if(con!=null)
		{
			String update="update quiz set visible=0 where quizid=?";
			try {
				pstmt=con.prepareStatement(update);
				pstmt.setInt(1, quizid);
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
}
