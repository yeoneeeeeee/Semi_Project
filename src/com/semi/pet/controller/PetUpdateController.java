package com.semi.pet.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.pet.model.service.PetService;
import com.semi.pet.model.vo.Pet;

/**
 * Servlet implementation class PetUpdateController
 */
@WebServlet("/update.p")
public class PetUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PetUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String petNo = request.getParameter("");
		
		Pet p = new PetService().selectPet(petNo); 
		
		request.setAttribute("p", p);
		request.getRequestDispatcher("views/pet/.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String petNo = request.getParameter("");
		String petName = request.getParameter("petName");
		String petKind = request.getParameter("petKind");
		int petAge = Integer.parseInt(request.getParameter("petAge"));
		String petGender = request.getParameter("Gender");
		int petPrice = Integer.parseInt(request.getParameter("petPrice"));
		String petStatus = request.getParameter("status");

		Pet p = new Pet();
		p.setPetNo(petNo);
		p.setPetName(petName);
		p.setPetKind(petKind);
		p.setPetAge(petAge);
		p.setPetGender(petGender);
		p.setPetPrice(petPrice);
		p.setStatus(petStatus);
		
		int result = new PetService().updatePet(p);
		
		if(result > 0) { 
			request.getSession().setAttribute("alertMsg", "성공적으로 pet list가 수정되었습니다.");
			response.sendRedirect( request.getContextPath()+"/"+petNo);
		}else {
			request.setAttribute("errorMsg", "pet list 수정 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}

	}

}