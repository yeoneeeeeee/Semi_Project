package com.semi.admincontroller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.common.model.vo.PageInfo;
import com.semi.donation.model.service.DonationService;
import com.semi.donation.model.vo.Donation;
import com.semi.member.model.vo.Member;
import com.semi.postAll.model.service.PostAllService;

/**
 * Servlet implementation class AdminDonationPageController
 */
@WebServlet("/donation.ad")
public class AdminDonationPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDonationPageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member loginUser = (Member)request.getSession().getAttribute("loginUser");
		
		if(loginUser != null) {		
			
			int listCount; 
			int currentPage; 
			int pageLimit; 
			int boardLimit;
			int maxPage;
			int startPage; 
			int endPage; 
			
		
			listCount = new PostAllService().PselectListCount();
			
			
			currentPage = Integer.parseInt(request.getParameter("currentPage") == null ? "1" : request.getParameter("currentPage"));
			
			
			pageLimit = 5;
			
			
			boardLimit = 6;
			
			maxPage = (int)Math.ceil((double)listCount/ boardLimit);
			 startPage = (currentPage -1 )/pageLimit * pageLimit +1 ; 
			
			
			endPage = startPage + pageLimit -1;
			if(endPage > maxPage) {
				endPage = maxPage;
			}
			PageInfo pi = new PageInfo(listCount, currentPage, pageLimit,boardLimit, maxPage, startPage,endPage);
			
			request.setAttribute("pi", pi);
			
			ArrayList<Donation> list = new DonationService().ASelectDonation(pi);
			
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("views/7H_The_Town/adminPage/AdminPageDonation.jsp").forward(request, response);	
			
		} else {
			request.getSession().setAttribute("alertMsg", "로그인 후 다시 시도해주세요.");
			response.sendRedirect(request.getContextPath()+"/main");
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
