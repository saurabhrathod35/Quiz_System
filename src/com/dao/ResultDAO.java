package com.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import java.text.SimpleDateFormat;

import com.bean.QuestionBean;
import com.bean.ResultBean;
import com.bean.UserBean;
import com.util.DBConnection;

public class ResultDAO {

	static Connection con = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;

	public static List<ResultBean> DBQuizResultList() {
		List<ResultBean> listQuestion = new ArrayList<ResultBean>();
		con = DBConnection.getConnection();
		if (con != null) {
			String select = "select user_name,quizname,total,start_time,end_time,comp_time from db_view d,quiz q,user u where d.user_id=u.user_id and d.quizid=q.quizid order by total desc";
			try {
				pstmt = con.prepareStatement(select);
				rs = pstmt.executeQuery();

				while (rs.next()) {

					ResultBean bean = new ResultBean();

					bean.setUserName(rs.getString("user_name"));
					bean.setQuizname(rs.getString("quizname"));
					bean.setTotal(rs.getString("total"));
					bean.setStartTime(rs.getString("start_time"));
					bean.setEndTime(rs.getString("end_time"));
					bean.setComplitionTime(rs.getString("comp_time"));
					listQuestion.add(bean);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listQuestion;
	}

	public static List<ResultBean> DebugQuizResultList() {
		List<ResultBean> listQuestion = new ArrayList<ResultBean>();
		con = DBConnection.getConnection();
		if (con != null) {
			String select = "select user_name,quizname,total,start_time,end_time,comp_time from  debug_view  d,quiz q,user u where d.user_id=u.user_id and d.quizid=q.quizid order by total desc";
			try {
				pstmt = con.prepareStatement(select);
				rs = pstmt.executeQuery();

				while (rs.next()) {

					ResultBean bean = new ResultBean();

					bean.setUserName(rs.getString("user_name"));
					bean.setQuizname(rs.getString("quizname"));
					bean.setTotal(rs.getString("total"));
					bean.setStartTime(rs.getString("start_time"));
					bean.setEndTime(rs.getString("end_time"));
					bean.setComplitionTime(rs.getString("comp_time"));
					listQuestion.add(bean);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listQuestion;
	}

	public static List<ResultBean> CodeQuizResultList() {
		List<ResultBean> listQuestion = new ArrayList<ResultBean>();
		con = DBConnection.getConnection();
		if (con != null) {
			String select = "select user_name,quizname,total,start_time,end_time,comp_time from code_view d,quiz q,user u where d.user_id=u.user_id and d.quizid=q.quizid order by total desc";
			try {
				pstmt = con.prepareStatement(select);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					ResultBean bean = new ResultBean();
					bean.setUserName(rs.getString("user_name"));
					bean.setQuizname(rs.getString("quizname"));
					bean.setTotal(rs.getString("total"));
					bean.setStartTime(rs.getString("start_time"));
					bean.setEndTime(rs.getString("end_time"));
					bean.setComplitionTime(rs.getString("comp_time"));
					listQuestion.add(bean);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listQuestion;
	}
	
	
	public static List<ResultBean> TechnicalQuizResultList() {
		List<ResultBean> listQuestion = new ArrayList<ResultBean>();
		con = DBConnection.getConnection();
		if (con != null) {
			String select = "select user_name,quizname,total,start_time,end_time,comp_time from tech_view d,quiz q,user u where d.user_id=u.user_id and d.quizid=q.quizid order by total desc";
			try {
				pstmt = con.prepareStatement(select);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					ResultBean bean = new ResultBean();
					bean.setUserName(rs.getString("user_name"));
					bean.setQuizname(rs.getString("quizname"));
					bean.setTotal(rs.getString("total"));
					bean.setStartTime(rs.getString("start_time"));
					bean.setEndTime(rs.getString("end_time"));
					bean.setComplitionTime(rs.getString("comp_time"));
					listQuestion.add(bean);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listQuestion;
	}
	
	public static boolean insertMarksDBQuiz(UserBean bean, int totalMarks,
			String startTime, String endTime) {
		boolean ins = false;
		String comTime=ResultDAO.timeDiff(endTime,startTime);
		con = DBConnection.getConnection();
		if (con != null) {
			
			String insert = "insert into db_quiz(user_id,quizid,total,start_time,end_time,comp_time) value(?,?,?,?,?,?)";
			try {
				pstmt = con.prepareStatement(insert);
				pstmt.setInt(1, bean.getUserid());
				pstmt.setInt(2, bean.getQuizid());
				pstmt.setInt(3, totalMarks);
				pstmt.setString(4, startTime);
				pstmt.setString(5, endTime);
				pstmt.setString(6,comTime);
				if (pstmt.executeUpdate() > 0) {
					ins = true;
				
					
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return ins;
	}

 public static String timeDiff(String eTime,String stime)
 {
	 String timediff=null;
	 con=DBConnection.getConnection();
	 if(con!=null)
	 {
		 String diff="select timediff(?,?) as comp_time";
		 
		 try {
			pstmt=con.prepareStatement(diff);
			 pstmt.setString(1,eTime);
			 pstmt.setString(2, stime);
			 rs=pstmt.executeQuery();
			 if(rs.next())
			 {
			
				 timediff=rs.getString("comp_time");
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	 }
	return timediff;
	  }
	
	public static boolean insertMarksCodeQuiz(UserBean bean, int totalMarks,
			String startTime, String endTime) {
		boolean ins = false;
		String comTime=ResultDAO.timeDiff(endTime,startTime);
		con = DBConnection.getConnection();
		if (con != null) {
			String insert = "insert into code_quiz(user_id,quizid,total,start_time,end_time,comp_time) value(?,?,?,?,?,?)";
			try {
				pstmt = con.prepareStatement(insert);
				pstmt.setInt(1, bean.getUserid());
				pstmt.setInt(2, bean.getQuizid());
				pstmt.setInt(3, totalMarks);
				pstmt.setString(4, startTime);
				pstmt.setString(5, endTime);
				pstmt.setString(6,comTime);
				if (pstmt.executeUpdate() > 0) {
					ins = true;
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return ins;
	}

	public static boolean insertMarksDebugQuiz(UserBean bean, int totalMarks,
			String startTime, String endTime) {
		boolean ins = false;
		String comTime=ResultDAO.timeDiff(endTime,startTime);
		con = DBConnection.getConnection();
		if (con != null) {
			String insert = "insert into debug_quiz(user_id,quizid,total,start_time,end_time,comp_time) value(?,?,?,?,?,?)";
			try {
				pstmt = con.prepareStatement(insert);
				pstmt.setInt(1, bean.getUserid());
				pstmt.setInt(2, bean.getQuizid());
				pstmt.setInt(3, totalMarks);
				pstmt.setString(4, startTime);
				pstmt.setString(5, endTime);
				pstmt.setString(6,comTime);
				if (pstmt.executeUpdate() > 0) {
					ins = true;
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return ins;
	}

	public static boolean insertMarksTechnicalQuiz(UserBean bean, int totalMarks,
			String startTime, String endTime) {
		boolean ins = false;
		String comTime=ResultDAO.timeDiff(endTime,startTime);
		con = DBConnection.getConnection();
		if (con != null) {
			String insert = "insert into  tech_quiz(user_id,quizid,total,start_time,end_time,comp_time) value(?,?,?,?,?,?)";
			try {
				pstmt = con.prepareStatement(insert);
				pstmt.setInt(1, bean.getUserid());
				pstmt.setInt(2, bean.getQuizid());
				pstmt.setInt(3, totalMarks);
				pstmt.setString(4, startTime);
				pstmt.setString(5, endTime);
				pstmt.setString(6,comTime);
				if (pstmt.executeUpdate() > 0) {
					ins = true;
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return ins;
	}

	public String timeCalculator(String startTime, String endTime) {

		String stime = startTime;
		String etime = endTime;
		Date d1 = null;
		Date d2 = null;
		SimpleDateFormat format=new SimpleDateFormat("MM/DD/YYYY HH:MM:SS");
		try {
			
			d1 = format.parse(stime);
			d2=format.parse(etime);
			
			long diff=d2.getTime()-d1.getTime();

			long diffsecond=diff/1000%60;
	System.out.println("....."+diff);
			
			long diffmini=diff/(60*1000)%60;
			
			long diffhr=diff/(60*60*1000)%24;
			
			System.out.println(diffhr+":"+diffmini+":"+diffsecond);
		} catch (Exception e) {
			// TODO: handle exception
		}

		/*
		 * String[] startArry = startTime.split(":"); String[] endArry =
		 * endTime.split(":"); String st=""; String et="";
		 *//*
			 * for (int i = 0; i < startArry.length; i++) { st+=startArry[i]; }
			 * for (int i = 0; i < endArry.length; i++) { et+=endArry[i]; }
			 * 
			 * int finalStartTime=Integer.parseInt(st); int
			 * finalEndTime=Integer.parseInt(et); int
			 * cal=finalEndTime-finalStartTime;
			 * System.out.println("start time>"+finalStartTime);
			 * System.out.println("endtime>"+finalEndTime);
			 * System.out.println("diff > > "+cal);
			 */

		/*
		 * int shr= Integer.parseInt( startArry[0]); /// hr int
		 * smin=Integer.parseInt( startArry[1]); // min int
		 * ssecond=Integer.parseInt( startArry[2]); // second
		 * 
		 * 
		 * int ehr=Integer.parseInt( endArry[0]);
		 * 
		 * int emin= Integer.parseInt( endArry[1]);
		 * 
		 * int esecond=Integer.parseInt( endArry[2]);
		 */

		return null;
	}

	public static void main(String[] args) {
		String a = new ResultDAO().timeCalculator("01/19/2017 09:31:00", "01/19/2017 11:00:00");
 
	}

}
