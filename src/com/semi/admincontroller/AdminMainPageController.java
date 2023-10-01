package com.semi.admincontroller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.client.model.service.FaqService;
import com.semi.client.model.service.ReportService;
import com.semi.client.model.vo.Faq;
import com.semi.board.model.service.BoardService;
import com.semi.board.model.vo.Report;
import com.semi.common.model.vo.PageInfo;

/**
 * Servlet implementation class AdminMainPageController
 */
@WebServlet("/main.ad")
public class AdminMainPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMainPageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int listCount; // 현재 총 게시글 갯수(1000개)
		int currentPage; // 현재 페이지(즉, 사용자가 요청한 페이지)
		int pageLimit; // 페이지 하단에 보여질 페이징바의 페이지 최대 갯수(10개씩 할예정)
		int boardLimit; // 한 페이지에 보여질 게시글의 최대 갯수(10개씩 할예정)

		int maxPage; // 가장 마지막 페이지가 몇번째 페이지인지(총 페이지 개수)
		int startPage; // 페이지 하단에 보여질 페이징바의 시작수
		int endPage; // 페이지 하단에 보여질 페이징바의 끝수
		listCount = new ReportService().selectListCount();

		currentPage = Integer
				.parseInt(request.getParameter("currentPage") == null ? "1" : request.getParameter("currentPage"));

		pageLimit = 1;

		boardLimit = 5;

		maxPage = (int) Math.ceil((double) listCount / boardLimit);

		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;

		endPage = startPage + pageLimit - 1;
		if (endPage > maxPage) {
			endPage = maxPage;
		}

		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);

		request.setAttribute("pi", pi);
		
		ArrayList<Report> rList = new BoardService().reportList(pi);
		ArrayList<Faq> fList = new FaqService().faqList(pi);

		request.setAttribute("rList", rList);
		request.setAttribute("fList", fList);

		
		request.getRequestDispatcher("/views/7H_The_Town/adminPage/AdminPageMain.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
