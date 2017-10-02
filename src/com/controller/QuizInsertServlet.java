package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.QuizBean;
import com.dao.QuizDao;
import com.util.ValidationUtil;

/**
 * Servlet implementation class QuizInsertServlet
 */
public class QuizInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuizInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);	// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in servlet");
		// TODO Auto-generated method stub
		String quizName = request.getParameter("quizname");
		System.out.println("quizname"+quizName);
		boolean error = false;
		QuizBean quizBean = new QuizBean();

		if (ValidationUtil.isEmpty(quizName)) {
			error = true;
			request.setAttribute("quizName", "* Plz Enter Quiz Name");

		} else {

			quizBean.setQuizName(quizName);
			error = false;
		}
		if (error) {
			request.getRequestDispatcher("addQuiz.jsp").forward(request,
					response);
		} else {
			
			if(QuizDao.addQuizName(quizBean))
			{
				response.sendRedirect("QuizListServlet");
			}
			else
			{
				response.sendRedirect("addQuiz.jsp");
			}
			}

		// TODO Auto-generated method stub
	}

}
