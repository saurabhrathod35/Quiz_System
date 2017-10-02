package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.QuizDao;

/**
 * Servlet implementation class QuizInVisibleServlet
 */
public class QuizInVisibleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		String quizid=request.getParameter("quiz");
		int qId=Integer.parseInt(quizid);
		if(QuizDao.QuizInVisible(qId))
		{
			response.sendRedirect("QuizListServlet");
		}
	}

}
