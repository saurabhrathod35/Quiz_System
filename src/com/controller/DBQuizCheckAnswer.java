package com.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;

import com.bean.DBAnswerManageBean;
import com.bean.UserBean;
import com.dao.QuizAnwerDao;
import com.dao.ResultDAO;

/**
 * Servlet implementation class DBQuizCheckAnswer
 */
public class DBQuizCheckAnswer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DBQuizCheckAnswer() {
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
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession httpSession = request.getSession();
		UserBean bean = new UserBean();
		bean = (UserBean) httpSession.getAttribute("userBean");

//		List<String> userans = DBAnswerManageBean.getUserAnswer();
		Date endTime = new Date();
		String etime = endTime.getHours() + ":" + endTime.getMinutes() + ":"
				+ endTime.getSeconds();
		String startTime = (String) httpSession.getAttribute("startTime");
		if (bean.getQuizid() == 1) {

//			List<String> currectAnswer = QuizAnwerDao.QuizAnswerCheck(bean
//					.getQuizid());
//	
			Integer totalMarks = Integer.parseInt(httpSession.getAttribute("totalMarks").toString());
			
//			int attempQue = 0;
//			for (int i = 0; i < userans.size(); i++) {
///*				System.out.println(userans.get(i) + "===="
//						+ currectAnswer.get(i));
//*/				
//				
//				if (userans.get(i).equals(currectAnswer.get(i))) {
//					totalMarks++;
//
//				}
//				if (!userans.get(i).equalsIgnoreCase("abcd")) {
//					attempQue++;
//				}
//
//			}
			Integer attempted =   Integer.parseInt( httpSession.getAttribute("attemplted").toString());

			Integer notAttempted =   Integer.parseInt( httpSession.getAttribute("notAttemplted").toString());

			request.setAttribute("attempQue", attempted);

			request.setAttribute("notAttempQue", notAttempted);

			if (ResultDAO.insertMarksDBQuiz(bean, totalMarks, startTime, etime)) {

//				userans.clear();
				request.getRequestDispatcher("userResult.jsp").forward(request,
						response);

			}
		}
		if (bean.getQuizid() == 4) {
//			List<String> currectAnswer = QuizAnwerDao.QuizAnswerCheck(bean
//					.getQuizid());
//			int totalMarks = 0;
//			int attempQue = 0;
//			for (int i = 0; i < userans.size(); i++) {
///*				System.out.println(userans.get(i) + "===="
//						+ currectAnswer.get(i));
//*/				if (userans.get(i).equals(currectAnswer.get(i))) {
//					totalMarks++;
//
//				}
//				if (!userans.get(i).equals("abcd")) {
//					attempQue++;
//				}
//
//			}
			Integer totalMarks = Integer.parseInt(httpSession.getAttribute("totalMarks").toString());
			Integer attempted =   Integer.parseInt( httpSession.getAttribute("attemplted").toString());

			Integer notAttempted =   Integer.parseInt( httpSession.getAttribute("notAttemplted").toString());

			request.setAttribute("attempQue", attempted);

			request.setAttribute("notAttempQue", notAttempted);
			if (ResultDAO.insertMarksCodeQuiz(bean, totalMarks, startTime,
					etime)) {
//				userans.clear();
				request.getRequestDispatcher("userResult.jsp").forward(request,
						response);
			}
		}
		if (bean.getQuizid() == 2) {
//			List<String> currectAnswer = QuizAnwerDao.QuizAnswerCheck(bean
//					.getQuizid());
//			int totalMarks = 0;
//			int attempQue = 0;
//			for (int i = 0; i < userans.size(); i++) {
///*				System.out.println(userans.get(i) + "===="
//						+ currectAnswer.get(i));
//*/				if (userans.get(i).equals(currectAnswer.get(i))) {
//					totalMarks++;
//
//				}
//				if (!userans.get(i).equals("abcd")) {
//					attempQue++;
//				}
//
//			}
//			request.setAttribute("attempQue", attempQue);
			Integer totalMarks = Integer.parseInt(httpSession.getAttribute("totalMarks").toString());
			Integer attempted =   Integer.parseInt( httpSession.getAttribute("attemplted").toString());

			Integer notAttempted =   Integer.parseInt( httpSession.getAttribute("notAttemplted").toString());

			request.setAttribute("attempQue", attempted);

			request.setAttribute("notAttempQue", notAttempted);
			if (ResultDAO.insertMarksDebugQuiz(bean, totalMarks, startTime, etime)) {
//				userans.clear();
				request.getRequestDispatcher("userResult.jsp").forward(request,
						response);
			}
		}

		if (bean.getQuizid() == 3) {
//			List<String> currectAnswer = QuizAnwerDao.QuizAnswerCheck(bean
//					.getQuizid());
//			int totalMarks = 0;
//			int attempQue = 0;
//			for (int i = 0; i < userans.size(); i++) {
///*				System.out.println(userans.get(i) + "===="
//						+ currectAnswer.get(i));
//*/				if (userans.get(i).equals(currectAnswer.get(i))) {
//					totalMarks++;
//
//				}
//				if (!userans.get(i).equalsIgnoreCase("abcd")) {
//					attempQue++;
//				}
//
//			}
			
			 			

//			request.setAttribute("attempQue", attempQue);
			Integer totalMarks = Integer.parseInt(httpSession.getAttribute("totalMarks").toString());
			Integer attempted =   Integer.parseInt( httpSession.getAttribute("attemplted").toString());

			Integer notAttempted =   Integer.parseInt( httpSession.getAttribute("notAttemplted").toString());

			request.setAttribute("attempQue", attempted);

			request.setAttribute("notAttempQue", notAttempted);
			if (ResultDAO.insertMarksTechnicalQuiz(bean, totalMarks, startTime, etime)) {
//				userans.clear();
				request.getRequestDispatcher("userResult.jsp").forward(request,
						response);
			}
		}
	}
}
