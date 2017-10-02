package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.QuestionBean;
import com.bean.UserBean;
import com.dao.UserQuestionDao;

/**
 * Servlet implementation class DatabaseQuizServlet
 */
public class DatabaseQuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DatabaseQuizServlet() {
		super();
		// TODO Auto-generated constructor stub
	
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session=request.getSession();
		UserBean bean=(UserBean) session.getAttribute("userBean");
		
		
		System.out.println("Quiz ID ==="+bean.getQuizid());
		List<QuestionBean> beans = UserQuestionDao.listquestion(bean.getQuizid());
			request.setAttribute("questionList", beans);
			session.setAttribute("beans",beans);
			
		request.getRequestDispatcher("Quiz.jsp").include(request,
				response);

	}

}
