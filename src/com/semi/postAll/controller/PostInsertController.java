package com.semi.postAll.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.common.model.vo.PageInfo;
import com.semi.donation.model.service.DonationService;
import com.semi.donation.model.vo.Donation;
import com.semi.postAll.model.dao.PostAllDao;
import com.semi.postAll.model.service.*;
import com.semi.postAll.model.vo.PostAll;
import com.semi.member.model.vo.*;

/**
 * Servlet implementation class PostInsertController
 */
@WebServlet("/AllPost.do")
public class PostInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostInsertController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String receiverName = request.getParameter("memberName");

		String receiverNo = new PostAllService().searchReceiverNo(receiverName);

		if (receiverNo != null && receiverNo != "") {
			response.getWriter().print(receiverNo);
		} else {
			receiverNo = "";
			response.getWriter().print(receiverNo);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String postTitle = request.getParameter("title");
		String postContent = request.getParameter("content");
		String callerNo = ((Member) (request.getSession().getAttribute("loginUser"))).getUserNo();
		String receiverNo = request.getParameter("memberName");

		PostAll p = new PostAll(postTitle, postContent, receiverNo, callerNo);

		int result = new PostAllService().insertPostAll(p);

		if (result > 0) {
			response.sendRedirect(request.getContextPath() + "/message.me");
		} else {
			request.getSession().setAttribute("alertMsg", "쪽지보내기 실패");
			response.sendRedirect(request.getContextPath() + "/AllPost.bo");
		}

	}
}
