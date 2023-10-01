package com.semi.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.board.model.service.BoardService;
import com.semi.board.model.vo.Attachment;
import com.semi.board.model.vo.Board;

/**
 * Servlet implementation class PostingContentController
 */
@WebServlet("/detail.bo")
public class PostingContentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostingContentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardNo = request.getParameter("bno");

		BoardService bService = new BoardService();

		
		int result = bService.increaseCount(boardNo);

		if (result > 0) {
			Board b = bService.selectBoard2(boardNo);
			ArrayList<Attachment> list = bService.selectAttachmentBoardList(boardNo);
			
			request.setAttribute("b", b);
			request.setAttribute("list", list);

			request.getRequestDispatcher("views/7H_The_Town/board/PostionPage_Content.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMsg", "상세조회에 실패했습니다.");
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
