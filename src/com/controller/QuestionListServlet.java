package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.QuestionBean;
import com.dao.QuestionDAO;

/**
 * Servlet implementation class QuestionListServlet
 */
public class QuestionListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("username") == null) {
			request.getRequestDispatcher("adminLoginPage.jsp").forward(request,
					response);
		}
		else
		{
 		List<QuestionBean> listQuestion=QuestionDAO.listQuestion();
		if (listQuestion != null) {
			request.setAttribute("listQuestion", listQuestion);
		}
		request.getRequestDispatcher("listQuestion.jsp").forward(request, response);
 		
		// TODO Auto-generated method stub
	}}

}
