package com.semi.admincontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.client.model.service.ReportService;

/**
 * Servlet implementation class AdminDeleteReportController
 */
@WebServlet("/deletereport.ad")
public class AdminDeleteReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDeleteReportController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String rno = request.getParameter("rno");
		
		String[] rList = rno.split(",");
		
		int result = 0;
		
		if(result > 0) {
			
			request.getSession().setAttribute("alertMsg", "성공적으로 신고내역이 삭제되었습니다.");
			
			response.sendRedirect(request.getContextPath() + "/report.ad");
			
			
		} else {
			
			request.getSession().setAttribute("alertMsg", "신고내역 삭제에 실패하였습니다.");
			
			response.sendRedirect(request.getContextPath() + "/report.ad");
			
		}
				
		
	
	}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String rno = request.getParameter("rno");
		
		String[] rList = rno.split(",");
		
		int result = 0;
		
		for(int i = 0; i < rList.length; i++) {
			
			result = new ReportService().deleteReport(rList[i]);
			
		}
		if(result > 0) {
			
			request.getSession().setAttribute("alertMsg", "성공적으로 신고내역이 삭제되었습니다.");
			
			response.sendRedirect(request.getContextPath() + "/report.ad");
			
			
		} else {
			
			request.getSession().setAttribute("alertMsg", "신고내역 삭제에 실패하였습니다.");
			
			response.sendRedirect(request.getContextPath() + "/report.ad");
			
		}
				
		
	
	}

}
