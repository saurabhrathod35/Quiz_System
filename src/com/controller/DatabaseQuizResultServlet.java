package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.DBAnswerManageBean;
import com.bean.UserBean;
import com.dao.QuizAnwerDao;

/**
 * Servlet implementation class DatabaseQuizResultServlet
 */
@WebServlet("/checkResult")
public class DatabaseQuizResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DatabaseQuizResultServlet() {
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
		int count = Integer.parseInt(request.getParameter("count"));
		System.out.println(count);
		HttpSession session = request.getSession();
		session.setAttribute("que", ++count);
		
		int cnt1=Integer.parseInt(session.getAttribute("qcnt").toString());
		
		cnt1++;
		
		session.setAttribute("qcnt", cnt1);
		
		
		
		String ans = request.getParameter("answer");
		String correctAnswer = request.getParameter("correctAnswer");
		String min = request.getParameter("min");
		String sec = request.getParameter("sec");
		
		System.out.println("min >>>>>>>>>>>>>>>>>"+min);
		System.out.println("sec >>>>>>>>>>>>>>>>>"+sec);
		
		session.setAttribute("timerMini", min);
		session.setAttribute("timerSecond", sec);

		
		if(ans==null)
		{
			Integer notAttemplted = Integer.parseInt(session.getAttribute("notAttemplted").toString());
			session.setAttribute("notAttemplted", ++notAttemplted);
			System.out.println("total marks is :: "+notAttemplted);

//		DBAnswerManageBean.AddUserAnswer("abcd");
		}
		else
		{
			if(ans.trim().equals(correctAnswer.trim())){
				Integer total = Integer.parseInt(session.getAttribute("totalMarks").toString());
				session.setAttribute("totalMarks", ++total);
				System.out.println("total marks is :: "+total);
				
			}
			Integer attemplted = Integer.parseInt(session.getAttribute("attemplted").toString());
			session.setAttribute("attemplted", ++attemplted);
			System.out.println("total marks is :: "+attemplted);

//			DBAnswerManageBean.AddUserAnswer(ans);
		}
		request.getRequestDispatcher("Quiz.jsp").forward(request, response);

	}

}
