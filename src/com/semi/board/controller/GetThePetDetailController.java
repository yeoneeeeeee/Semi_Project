package com.semi.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.board.model.service.GetThePetService;
import com.semi.board.model.vo.Attachment;
import com.semi.board.model.vo.Favorite;
import com.semi.board.model.vo.GetThePet;
import com.semi.member.model.vo.Member;
import com.semi.pet.model.vo.Pet;

/**
 * Servlet implementation class GetThePetDetailController
 */
@WebServlet("/detail.get")
public class GetThePetDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetThePetDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String boardNo = request.getParameter("bno");
		String userNo = "";

		GetThePet g = new GetThePetService().selectGetThePet(boardNo);
		
		if(g != null) {
			
			Pet p = new GetThePetService().selectGetThePetInfo(boardNo);
			
			ArrayList<Attachment> aList = new GetThePetService().selectAttachmentList(boardNo);
			
			if(request.getSession().getAttribute("loginUser") != null) {
				userNo = ((Member)(request.getSession().getAttribute("loginUser"))).getUserNo();
				Favorite red = new GetThePetService().checkFavorite(userNo,boardNo);
				request.setAttribute("red", red);
			}
			
			request.setAttribute("p",p);
			request.setAttribute("g",g);
			request.setAttribute("aList", aList);
			
			request.getRequestDispatcher("views/7H_The_Town/getThePet/PetDetail.jsp").forward(request, response);
		} else {
			request.setAttribute("alertMsg", "펫 상세글 조회 실패");
			request.getRequestDispatcher("views/7H_The_Town/getThePet/PetList.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


}
