package com.semi.admincontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.member.model.vo.Member;
import com.semi.reply.model.service.ReplyService;

/**
 * Servlet implementation class AdminReplyController
 */
@WebServlet("/reply.ad")
public class AdminReplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminReplyController() {
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
		
		Member loginUser = (Member) request.getSession().getAttribute("loginUser");
		
		String receiver = request.getParameter("receiver");
		
		String post = request.getParameter("ad-reply");
		
		int result = new ReplyService().replyAd(loginUser.getUserNo(), receiver, post);
		
		if(result > 0) {
			
			request.getSession().setAttribute("alertMsg", "답변을 성공적으로 작성했습니다.");
			
			response.sendRedirect(request.getContextPath() + "/client.ad");
			
		} else {
			
			request.getSession().setAttribute("alertMsg", "답변을 실패하였습니다.");
			
			response.sendRedirect(request.getContextPath() + "/client.ad");
			
		}
		
	}

}
