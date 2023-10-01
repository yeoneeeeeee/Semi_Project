package com.semi.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.board.model.service.BoardService;
import com.semi.board.model.vo.Reply;
import com.semi.member.model.vo.Member;

/**
 * Servlet implementation class ReplyInsertController
 */
@WebServlet("/rinsert.bo")
public class ReplyInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String replyContent = request.getParameter("replyContent");
		String boardNo = request.getParameter("bno");
		
		if(request.getSession().getAttribute("loginUser") != null) {
		
			if(replyContent == null || replyContent.equals("")) {
				String result = "none";
				response.getWriter().print(result);
			}else {
				String userNo = ((Member)request.getSession().getAttribute("loginUser")).getUserNo();
				
				Reply r = new Reply();
				r.setReplyContent(replyContent);
				r.setBoardNo(boardNo);
				r.setUserName(userNo+"");
				
				int result = new BoardService().insertReply(r);
				
				response.getWriter().print(result);
			}
		
		}else {
			String result = "login";
			response.getWriter().print(result);
		}
	}

}
