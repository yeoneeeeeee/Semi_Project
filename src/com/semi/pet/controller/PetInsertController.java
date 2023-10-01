package com.semi.pet.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.common.model.vo.PageInfo;
import com.semi.pet.model.service.PetService;
import com.semi.pet.model.vo.Pet;

/**
 * Servlet implementation class PetInsertController
 */
@WebServlet("/insert.p")
public class PetInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PetInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<Pet> list = new PetService().selectPetList();
		
		request.setAttribute("list", list);
	
		request.getRequestDispatcher("views/7H_The_Town/adminPage/AdminPagePetInsertControll.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// pet 내용 입력 받기 //
		request.setCharacterEncoding("UTF-8");
		String petName = request.getParameter("petName");
		String petKind = request.getParameter("petKind");
		int petAge = Integer.parseInt(request.getParameter("petAge"));
		String petGender = request.getParameter("petGender");
		int petPrice =  Integer.parseInt(request.getParameter("petPrice"));
		
		Pet p = new Pet();
		p.setPetName(petName);
		p.setPetKind(petKind);
		p.setPetAge(petAge);
		p.setPetGender(petGender);
		p.setPetPrice(petPrice);
		
		int result = new PetService().insertPet(p);

		if (result > 0) { 
			request.getSession().setAttribute("alertMsg", "성공적으로 pet list 정보가 추가되었습니다.");
			response.sendRedirect(request.getContextPath() + "/list.p");
		} else {
			request.setAttribute("errorMsg", "pet list 정보 등록 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
	 
	}
}


