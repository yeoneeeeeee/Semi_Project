package com.semi.admincontroller;

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
 * Servlet implementation class AdminInsertPetController
 */
@WebServlet("/insertpet.ad")
public class AdminInsertPetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminInsertPetController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/views/7H_The_Town/adminPage/AdminPageInsertPet.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String petName = request.getParameter("petName");
		String petKind = request.getParameter("petKind");
		int petAge = Integer.parseInt(request.getParameter("petAge"));
		String petGender = request.getParameter("petGender");
		int petPrice = Integer.parseInt(request.getParameter("petPrice"));
		String rescue = request.getParameter("petRescue");
		
		Date petRescue = null;
		
		if(!(rescue.equals("") || rescue == null)) {
			petRescue = Date.valueOf(rescue);
			
		} else {
			
			petRescue = new Date(System.currentTimeMillis());
			
		}
		
		Pet p = new Pet(petName, petKind, petAge, petGender, petPrice, petRescue);
		
		int result = new PetService().insertPet(p);
		
		if(result > 0) {
			
			request.getSession().setAttribute("alertMsg", "성공적으로 등록하였습니다.");
			
			response.sendRedirect(request.getContextPath() + "/pet.ad");
			
		} else {
			
			request.getSession().setAttribute("alertMsg", "등록에 실패하였습니다.");
			
			response.sendRedirect(request.getContextPath() + "/pet.ad");
			
			
		}
		
		
		
	}

}
