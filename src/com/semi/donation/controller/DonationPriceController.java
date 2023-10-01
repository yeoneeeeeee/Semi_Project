package com.semi.donation.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.donation.model.service.DonationService;
import com.semi.donation.model.vo.Donation;

/**
 * Servlet implementation class DonationPriceController
 */
@WebServlet("/donation.do")
public class DonationPriceController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DonationPriceController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Donation> list = new DonationService().donaCount();

		if (!(list == null)) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("views/7H_The_Town/donation/DonationMain.jsp").forward(request, response);
		} else {
			request.getSession().setAttribute("alertMsg", "사진게시판 업로드 실패");
			response.sendRedirect(request.getContextPath() + "/donation.do");
		}
	}

	private Date String(String parameter) {
		// TODO Auto-generated method stub
		return null;
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
