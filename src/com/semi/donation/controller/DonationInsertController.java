package com.semi.donation.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.member.model.vo.Member;
import com.semi.donation.model.service.DonationService;
import com.semi.donation.model.vo.Donation;

/**
 * Servlet implementation class DonationInsertController
 */
@WebServlet("/donation.po")
public class DonationInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DonationInsertController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("loginUser") != null) {
			request.getRequestDispatcher("views/7H_The_Town/donation/DonationInfo.jsp").forward(request, response);
		} else {
			request.getSession().setAttribute("alertMsg", "로그인 후 다시 시도해주세요.");
			response.sendRedirect(request.getContextPath() + "/main");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

//		  String donationNo = request.getParameter("donationNo");
//		  int donaPrice = request.getParameter("donaPrice");
//		  String donaKind = request.getParameter("donaKind");
//		  Date donaDate = (String)request.getParameter("donaDate");
//		  String userNo = request.getParameter("userNo");
//		  
//		  
//		 Donation d = new Donation(donationNo, donaPrice, donaKind, donaDate, userNo);
		String checkPrice = "직접입력";
		int donaPrice = 0;

		String donaKind = request.getParameter("donationKind2");

		String donaPrice22 = request.getParameter("donaPrice");

		String userNo = request.getParameter("userNo");

		if (checkPrice.equals(donaPrice22)) {
			donaPrice = Integer.parseInt(request.getParameter("donaPrice1"));
		} else {
			donaPrice = Integer.parseInt(donaPrice22);
		}

		Donation d = new Donation(donaPrice, donaKind, userNo);

		int result = new DonationService().insertDonation(d);

		if (result > 0) {
			request.getRequestDispatcher("views/7H_The_Town/donation/DonationComplete.jsp").forward(request, response);
		} else {
			request.getSession().setAttribute("alertMsg", "후원에 실패했습니다 다시 입력해주세요");
			response.sendRedirect(request.getContextPath() + "/donation.do");
		}

	}

}
