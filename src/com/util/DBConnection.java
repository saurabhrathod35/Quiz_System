package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static String user="root";
	private static String password="root";
	private static String driver="com.mysql.jdbc.Driver";
	private static String connectionURL="jdbc:mysql://localhost:3306/quiz";
	
	public static Connection getConnection() {
		Connection conn=null;
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(connectionURL,user,password);
			System.out.println("connection done.....");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void connectionClose(Connection conn) {
		try {
		if(!conn.isClosed())
		{	
			conn.close();
			}} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public static void main(String[] args) {
			new DBConnection().getConnection();
		}
}
	

