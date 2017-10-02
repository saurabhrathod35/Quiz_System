package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.QuestionBean;
import com.dao.QuestionDAO;
import com.util.ValidationUtil;

/**
 * Servlet implementation class QuestionServlet
 */
public class QuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QuestionServlet() {
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

		String question = request.getParameter("question");
		String answer = request.getParameter("answer");
		String option1 = request.getParameter("option1");
		String option2 = request.getParameter("option2");
		String option3 = request.getParameter("option3");
		String quizid = request.getParameter("quizid");

		System.out.println("question" + question);
		System.out.println("question" + answer);
		System.out.println("question" + option1);
		System.out.println("question" + option2);
		System.out.println("question" + option3);
		System.out.println("question=====" + quizid);

		boolean error = false;
		QuestionBean bean = new QuestionBean();
		bean.setQuizid(Integer.parseInt(quizid));
		if (ValidationUtil.isEmpty(question)) {
			error = true;
			request.setAttribute(question, "plz Enter quiz");
		} else {
			bean.setQuestion(question);

		}

		if (ValidationUtil.isEmpty(answer)) {
			error = true;
			request.setAttribute(answer, "plz Enter Answer");
		} else {
			bean.setAnswer(answer);

		}

		if (ValidationUtil.isEmpty(option1)) {
			error = true;
			request.setAttribute(option1, "plz Enter option1");
		} else {
			bean.setOption1(option1);

		}

		if (ValidationUtil.isEmpty(option2)) {
			error = true;
			request.setAttribute(option2, "plz Enter option2");
		} else {
			bean.setOption2(option2);

		}

		if (ValidationUtil.isEmpty(option3)) {
			error = true;
			request.setAttribute(option3, "plz Enter option3");
		} else {
			bean.setOption3(option3);

		}

		if (error) {
			request.getRequestDispatcher("addQuestion.jsp").forward(request,
					response);
		} else {
			if (QuestionDAO.addQuestion(bean)) {
				//response.sendRedirect("QuestionListServlet");
				response.sendRedirect("addQuestions.jsp");
			} else {
				response.sendRedirect("addQuestions.jsp");
			}
		}

		// TODO Auto-generated method stub
	}

}
