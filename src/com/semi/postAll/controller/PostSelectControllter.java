package com.semi.postAll.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.postAll.model.service.PostAllService;
import com.semi.postAll.model.vo.PostAll;

/**
 * Servlet implementation class PostSelectControllter
 */
@WebServlet("/select.do")
public class PostSelectControllter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostSelectControllter() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<PostAll> list = new PostAllService().PostSelect();

		if (!(list == null)) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("views/7H_The_Town/board/selectPost.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("views/7H_The_Town/common/errorPage.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
