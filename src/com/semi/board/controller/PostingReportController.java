package com.semi.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.board.model.service.BoardService;
import com.semi.board.model.vo.Board;
import com.semi.board.model.vo.Report;
import com.semi.member.model.vo.Member;

/**
 * Servlet implementation class PostingBoardController
 */
@WebServlet("/report.bo")
public class PostingReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostingReportController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member loginUser = (Member)request.getSession().getAttribute("loginUser");
		if(loginUser != null) {
			
		String boardNo = request.getParameter("bno");
		
		Board b = new BoardService().selectBoard2(boardNo);
		request.setAttribute("b", b);
		
		
		request.getRequestDispatcher("views/7H_The_Town/board/PostionPage_Report.jsp").forward(request, response);
		}else {
			request.getSession().setAttribute("alertMsg", "로그인 후 다시 시도해주세요.");
			response.sendRedirect(request.getContextPath()+"/list.bo");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardContent = request.getParameter("text");
		String boardNo = request.getParameter("bno");
		
		Report r = new Report();
		r.setBoardNo(boardNo);
		r.setReportContent(boardContent);
		
		int result = new BoardService().insertReport(r);
		
		if(result >0) { //성공시 = list.bo url재요청 보내기
			request.getSession().setAttribute("alertMsg", "신고되었습니다.");
			response.sendRedirect(request.getContextPath()+"/list.bo");
		}else { 
			
			request.setAttribute("alertMsg", "신고 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
		
		
	}

}
