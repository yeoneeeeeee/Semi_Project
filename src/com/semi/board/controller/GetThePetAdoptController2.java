package com.semi.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.board.model.service.GetThePetService;
import com.semi.board.model.vo.GetThePet;
import com.semi.delivery.model.service.DeliveryService;
import com.semi.pet.model.vo.Pet;

/**
 * Servlet implementation class GetThePetAdoptController
 */
@WebServlet("/adopt.get")
public class GetThePetAdoptController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetThePetAdoptController2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String boardNo = request.getParameter("bno");
		
		Pet p = new GetThePetService().selectGetThePetInfo(boardNo);
		GetThePet g = new GetThePetService().selectGetThePet(boardNo);
		
		request.setAttribute("g", g);
		request.setAttribute("p", p);
		
		request.getRequestDispatcher("views/7H_The_Town/getThePet/PetPayment.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		request.setCharacterEncoding("UTF-8");
//		
//		String petNo = request.getParameter("petNo");
//		String loginUser = request.getParameter("loginUser");
//		String userNo = new Memberservice().selectMember(loginUser);
//		
//		int result = new DeliveryService().insertDelivery(petNo, userNo);
//		
//		if(result > 0) {
//			request.getRequestDispatcher("views/7H_The_Town/getThePet/PayComplete.jsp").forward(request, response);
//		} else {
//			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
//		}
		
	}

}
