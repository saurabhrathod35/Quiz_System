package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.UserBean;
import com.util.DBConnection;

public class LoginDao {

	static Connection connection = null;
	static PreparedStatement psmt = null;
	static ResultSet rs = null;

	public static UserBean LoginDetails(String userName, String password)
	{
		UserBean bean=new UserBean();
		connection=DBConnection.getConnection();
		if(connection!=null)
		{

			String select="select * from user u,quiz q where u.user_name=? and u.password=? and u.quizid=q.quizid and q.visible=1";
			try {
				psmt=connection.prepareStatement(select);
				
				psmt.setString(1,userName);
				psmt.setString(2,password);
				rs=psmt.executeQuery();
				if(rs.next())
				{
					bean.setUserid(rs.getInt("user_id"));
					bean.setUsername(rs.getString("user_name"));
					bean.setPassword(rs.getString("password"));
					bean.setQuizid(rs.getInt("quizid"));
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return bean; 
	}
}
