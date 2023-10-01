package com.semi.admincontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.member.model.service.MemberService;

/**
 * Servlet implementation class AdminDeleteMemberController
 */
@WebServlet("/delete.ad")
public class AdminDeleteMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDeleteMemberController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String mem = request.getParameter("mno");
		
		
		String[] mList = mem.split(",");
		
		int result = 0;
		
		for(int i = 0; i < mList.length; i++) {
		}
		if(result > 0) {
		
			request.getSession().setAttribute("alertMsg", "성공적으로 회원이 삭제되었습니다.");
			
			response.sendRedirect(request.getContextPath() + "/edit.ad");
			
		} else {
			
			request.getSession().setAttribute("alertMsg", "회원 삭제에 실패하였습니다.");
			
			response.sendRedirect(request.getContextPath() + "/edit.ad");
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mem = request.getParameter("mno");
		
		
		String[] mList = mem.split(",");
		
		int result = 0;
		
		for(int i = 0; i < mList.length; i++) {
			
			result = new MemberService().deleteMember(mList[i]);
			
		}
		if(result > 0) {
		
			request.getSession().setAttribute("alertMsg", "성공적으로 회원이 삭제되었습니다.");
			
			response.sendRedirect(request.getContextPath() + "/edit.ad");
			
		} else {
			
			request.getSession().setAttribute("alertMsg", "회원 삭제에 실패하였습니다.");
			
			response.sendRedirect(request.getContextPath() + "/edit.ad");
			
		}
		
		
		
	}

}
