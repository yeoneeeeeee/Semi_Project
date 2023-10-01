package com.semi.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.board.model.service.GetThePetService;
import com.semi.pet.model.vo.Pet;

/**
 * Servlet implementation class MemberIdCheckController
 */
@WebServlet("/petNoCheck.get")
public class GetThePetNoCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetThePetNoCheckController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String petNo = request.getParameter("petNo");

		int result = new GetThePetService().checkPetNo(petNo);
		
		response.getWriter().print(result);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String petNo = request.getParameter("petNo");
		
		Pet p = new GetThePetService().getPetInfo(petNo);
		
		String petNumber = "";
		if(p != null) {
			petNumber = p.getPetNo();
		}
		
		response.getWriter().print(petNumber);
		
	}

}
