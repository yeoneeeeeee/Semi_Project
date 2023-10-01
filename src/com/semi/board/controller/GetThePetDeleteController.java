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
import com.semi.board.model.vo.GetThePet;

/**
 * Servlet implementation class GetThePetDeleteController
 */
@WebServlet("/delete.get")
public class GetThePetDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetThePetDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		GetThePetService gService = new GetThePetService();
		
		String boardNo = request.getParameter("bno");
		
		GetThePet g = gService.selectGetThePet(boardNo);
		
		ArrayList<Attachment> at = gService.selectAttachmentList(boardNo);
		
		request.setAttribute("b", g);
		request.setAttribute("at", at);
		
		int result = gService.deleteGetThePet(g, at);
		
		
		if(result > 0) {
			
			request.getSession().setAttribute("alertMsg", "성공적으로 게시글이 삭제되었습니다.");
			response.sendRedirect(request.getContextPath()+"/list.get");
			
		} else {
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
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