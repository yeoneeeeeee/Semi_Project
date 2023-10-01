package com.semi.delivery.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.delivery.model.service.DeliveryService;
import com.semi.delivery.model.vo.Delivery;
import com.semi.member.model.vo.Member;

/**
 * Servlet implementation class DeliveryInsertController
 */
@WebServlet("/insert.d")
public class DeliveryInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeliveryInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("views/7H_The_Town/Main_Page.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		Member loginUser = (Member) request.getSession().getAttribute("loginUser");
		if(loginUser != null) {
			
			String userNo = loginUser.getUserNo();
			String petNo = request.getParameter("petNo");
	
			String mainAddress = request.getParameter("mainAddress");
			String detailAddress = request.getParameter("detailAddress");
			
			String curSpot = mainAddress+" "+ detailAddress;
			
			Delivery d = new Delivery();
			
			d.setCurSpot(curSpot);
			d.setPetNo(petNo);
			d.setUserNo(userNo);
	
			int result = new DeliveryService().insertDelivery(d);
	
			if (result > 0) { 
				request.getSession().setAttribute("alertMsg", "성공적으로 결제가 완료되었습니다.");
				request.getRequestDispatcher("views/7H_The_Town/getThePet/PayComplete.jsp").forward(request, response);
			} else {
				request.setAttribute("alertMsg", "결제실패 처음부터 다시 시도해주세요");
				response.sendRedirect(request.getContextPath()+"/list.get");
			}
	
		} else {
			request.getSession().setAttribute("alertMsg", "로그인 후 다시 시도해주세요.");
			response.sendRedirect(request.getContextPath()+"/list.get");
		}
	}

}
