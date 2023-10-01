package com.semi.delivery.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.delivery.model.service.DeliveryService;
import com.semi.pet.model.service.PetService;

/**
 * Servlet implementation class DeliveryDeleteController
 */
@WebServlet("/delete.d")
public class DeliveryDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeliveryDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();

		String delNo = request.getParameter("delNo");
		
		String[] delNoList = delNo.split(",");
		
		for(int i = 0; i < delNoList.length; i++) {

		}

		int result = new DeliveryService().deleteDelivery(delNo);
		
		if(result > 0)	{ // 성공시
			session.setAttribute("alertMsg","성공적으로 배송정보가 삭제되었습니다.");
			response.sendRedirect(request.getContextPath()+"/delete.d");
		} else { // 실패시
			request.setAttribute("alertMsg", "배송정보 삭제 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
			
		String delNo = request.getParameter("delNo");
		
		String[] delNoList = delNo.split(",");
		
		int result = 0;
		
		for(int i = 0; i < delNoList.length; i++) {
			
			result = new DeliveryService().deleteDelivery(delNoList[i]);
			
		}
		
		if(result > 0)	{ // 성공시
			session.setAttribute("alertMsg","성공적으로 배송정보가 삭제되었습니다.");
			response.sendRedirect(request.getContextPath()+"/deliver.ad");
		} else { // 실패시
			request.setAttribute("alertMsg", "배송정보 삭제 실패");
			response.sendRedirect(request.getContextPath()+"/deliver.ad");
		}
	}

}
