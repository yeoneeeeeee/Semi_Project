package com.semi.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.board.model.service.GetThePetService;
import com.semi.board.model.vo.GetThePet;
import com.semi.pet.model.vo.Pet;

/**
 * Servlet implementation class GetThePetAdoptController
 */
@WebServlet("/adoptTerms.get")
public class GetThePetAdoptController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetThePetAdoptController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String boardNo = request.getParameter("bno");
		
		GetThePet g = new GetThePetService().selectGetThePet(boardNo);
		
		request.setAttribute("g", g);
		
		request.getRequestDispatcher("views/7H_The_Town/getThePet/PayTermsOfUse.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
