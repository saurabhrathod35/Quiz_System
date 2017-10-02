package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserBean;
import com.dao.LoginDao;
import com.util.ValidationUtil;

@WebServlet("/Login")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
			request.getRequestDispatcher("adminLoginPage.jsp").forward(request,
					response);

		} else {
			UserBean userBean = new UserBean();
			/*
			 * new LoginDao(); userBean = LoginDao.LoginDetails(username,
			 * password); if (userBean != null && userBean.getUsername() !=
			 * null) { HttpSession loginSession = request.getSession();
			 * loginSession.setAttribute("userBean", userBean);
			 * response.sendRedirect("AdminHeader.jsp");
			 */

			if (username.equals("admin") && password.equals("admin123")) {
				HttpSession loginSession = request.getSession();
				loginSession.setAttribute("username", username);
				response.sendRedirect("AdminHeader.jsp");
			} else {
				request.setAttribute("msgLogin",
						" *Username and Password is incorrect");
				request.getRequestDispatcher("adminLoginPage.jsp").forward(
						request, response);
			}
		}

	}

}
