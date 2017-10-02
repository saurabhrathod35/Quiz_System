package com.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserBean;
import com.dao.LoginDao;
import com.util.ValidationUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/checkLogin")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 @Override
	 protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
	}
 	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

 		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean flag = false;
		if (ValidationUtil.isEmpty(username)) {
			flag = true;
			request.setAttribute("msgUserName", "* UserName is Required");
		}

		if (ValidationUtil.isEmpty(password)) {
			flag = true;
			request.setAttribute("msgpassWord", "* Password is Required");
		}
		if (flag) {

			request.setAttribute("userName", username);
			request.setAttribute("password", password);
			request.getRequestDispatcher("loginPage.jsp")
					.forward(request, response);

		} else {

			UserBean userBean = new UserBean();

			userBean = new LoginDao().LoginDetails(username, password);
			if (userBean != null && userBean.getUsername() != null) {

				int que = 0;
				int totalMarks = 0;
				int timerMini=29;
				int timerSecond =59;
				int notAttemplted = 0;
				int attemplted = 0;
				int qcnt=1;
				
				HttpSession loginSession = request.getSession();
				loginSession.setAttribute("loginName", username);
				
				
				loginSession.setAttribute("que", que);
				loginSession.setAttribute("attemplted", attemplted);
				
				loginSession.setAttribute("totalMarks", totalMarks);
				loginSession.setAttribute("userBean", userBean);
				loginSession.setAttribute("timerMini", timerMini);
				loginSession.setAttribute("qcnt", qcnt);
				loginSession.setAttribute("timerSecond", timerSecond);
				loginSession.setAttribute("notAttemplted", notAttemplted);
				Date starttime=new Date();
				String stime= 	starttime.getHours()+":"+starttime.getMinutes()+":"+starttime.getSeconds();
				loginSession.setAttribute("startTime",stime);
				
				request.getRequestDispatcher("DatabaseQuizServlet").forward(request, response);
			} else {
				request.setAttribute("msgLogin",
						" *Username and Password is incorrect");
				request.getRequestDispatcher("loginPage.jsp").forward(request,
						response);
			}
		}

		// TODO Auto-generated method stub
	}

}
