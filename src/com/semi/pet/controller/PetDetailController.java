package com.semi.pet.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.pet.model.service.*;
import com.semi.pet.model.vo.*;


/**
 * Servlet implementation class PetDetailController
 */
@WebServlet("/detail.p")
public class PetDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PetDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String petNo = request.getParameter("petNo");
		String petName = request.getParameter("petName");
		int petAge = Integer.parseInt(request.getParameter("petAge"));
		String petGender = request.getParameter("petGender");
		
		Pet p = new Pet(petNo, petName, petAge, petGender);
		
		request.setAttribute("p", p);
		
		ArrayList<Pet> list = new PetService().selectPetList();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("views/7H_The_Town/getThePet/AdminPagePetControll.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
