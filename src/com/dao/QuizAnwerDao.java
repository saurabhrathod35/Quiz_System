package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.DBAnswerManageBean;
import com.bean.UserBean;
import com.util.DBConnection;

public class QuizAnwerDao {
	static Connection con = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;

	public static List<String> QuizAnswerCheck(int quizid) {

		List<String> answerList=new ArrayList<String>();	
		con = DBConnection.getConnection();
		if (con != null) {
			String select = "select answer from question where quizid=?";
			try {
				pstmt = con.prepareStatement(select);
				pstmt.setInt(1, quizid);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					answerList.add(rs.getString("answer"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return answerList;
	}

	public static boolean setTotalDBQuizMarks(int totalmarks, UserBean bean) {
		con = DBConnection.getConnection();
		boolean flag = false;
		if (con != null) {
			String insert = "insert into db_quiz(user_id,quizid,total) values(?,?,?)";
			try {
				pstmt = con.prepareStatement(insert);
				pstmt.setInt(1, bean.getUserid());
				pstmt.setInt(2, bean.getQuizid());
				pstmt.setInt(3, totalmarks);

				int cnt = pstmt.executeUpdate();
				if (cnt > 0) {
					flag = true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return flag;
	}
}
