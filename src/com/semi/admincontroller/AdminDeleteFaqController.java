package com.semi.admincontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.client.model.service.FaqService;

/**
 * Servlet implementation class AdminDeleteFaqController
 */
@WebServlet("/deletefaq.ad")
public class AdminDeleteFaqController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDeleteFaqController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fno = request.getParameter("fno");
		
		String[] fList = fno.split(",");
		
		int result = 0;
		
		if(result > 0) {
			
			request.getSession().setAttribute("alertMsg", "성공적으로 문의내역이 삭제되었습니다.");
			
			response.sendRedirect(request.getContextPath() + "/client.ad");
			
			
		} else {
			
			request.getSession().setAttribute("alertMsg", "성공적으로 문의내역이 삭제되었습니다.");
			
			response.sendRedirect(request.getContextPath() + "/client.ad");
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fno = request.getParameter("fno");
		
		String[] fList = fno.split(",");
		
		int result = 0;
		
		for(int i = 0; i < fList.length; i++) {
			
			result = new FaqService().deleteFaq(fList[i]);
			
		}
		if(result > 0) {
			
			request.getSession().setAttribute("alertMsg", "성공적으로 문의내역이 삭제되었습니다.");
			
			response.sendRedirect(request.getContextPath() + "/client.ad");
			
			
		} else {
			
			request.getSession().setAttribute("alertMsg", "문의내역 삭제에 실패하였습니다.");
			
			response.sendRedirect(request.getContextPath() + "/client.ad");
			
		}
				
		
	}

}
