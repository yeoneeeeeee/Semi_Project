package com.semi.pet.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.pet.model.service.PetService;

/**
 * Servlet implementation class PetDeleteController
 */
@WebServlet("/delete.p")
public class PetDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PetDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();

		//System.out.println(request.getParameterValues("petNo"));
			
		String petNo = request.getParameter("petNo");
		
		String[] petNoList = petNo.split(",");
		
		for(int i = 0; i < petNoList.length; i++) {
			
		}
				
		int result = new PetService().deletePet(petNo);
		
		if(result > 0)	{ // 성공시
			session.setAttribute("alertMsg","성공적으로 pet list가 삭제되었습니다.");
			response.sendRedirect(request.getContextPath()+"/list.p");
		} else { // 실패시
			request.setAttribute("alertMsg", "pet list 삭제 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
			
		String petNo = request.getParameter("petNo");
		
		String[] petNoList = petNo.split(",");
		
		System.out.println(Arrays.toString(petNoList));
		
		int result = 0;
		
		for(int i = 0; i < petNoList.length; i++) {
			
			result = new PetService().deletePet(petNoList[i]);
			
		}
		
		if(result > 0)	{ // 성공시
			session.setAttribute("alertMsg","성공적으로 pet list가 삭제되었습니다.");
			response.sendRedirect(request.getContextPath()+"/list.p");
		} else { // 실패시
			request.setAttribute("alertMsg", "pet list 삭제 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
	}

}
