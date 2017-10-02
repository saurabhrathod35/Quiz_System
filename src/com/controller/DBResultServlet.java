package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ResultBean;
import com.dao.ResultDAO;

public class DBResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DBResultServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		ResultBean resultBean=new ResultBean();
		List<ResultBean> list=ResultDAO.DBQuizResultList();
		if(list!=null)
		{
			request.setAttribute("resultlist", list);
			request.getRequestDispatcher("Result.jsp").forward(request, response);
		}
			
	}

}
