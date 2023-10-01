package com.semi.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.common.model.vo.PageInfo;
import com.semi.delivery.model.service.DeliveryService;
import com.semi.delivery.model.vo.Delivery;
import com.semi.member.model.vo.Member;
import com.semi.pet.model.service.PetService;

/**
 * Servlet implementation class MemberMainPageController
 */
@WebServlet("/main.me")
public class MemberMainPageController extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberMainPageController() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
	  Member loginUser = (Member)request.getSession().getAttribute("loginUser");
	  
	  if(loginUser != null) {         
	  
	      int listCount; // 현재 총 게시글 갯수(1000개)
	      int currentPage; // 현재 페이지(즉, 사용자가 요청한 페이지)
	      int pageLimit; // 페이지 하단에 보여질 페이징바의 페이지 최대 갯수 (10개씩 할예정)
	      int boardLimit; // 한 페이지에 보여질 게시글의 최대 갯수 (10개씩 할예정)
	      int maxPage; // 가장 마지막 페이지가 몇번째 페이지인지(총 페이지 개수)
	      int startPage; // 페이지 하단에 보여질 페이징바의 시작수
	      int endPage; // 페이지 하단에 보여질 페이징바의 끝수
	
	      listCount = new PetService().selectListCount();
	            
	      currentPage = Integer.parseInt(request.getParameter("currentPage") == null ? "1" : request.getParameter("currentPage"));
	            
	      pageLimit = 5;
	
	      boardLimit = 6;
	            
	      maxPage = (int) Math.ceil((double)listCount / boardLimit); 
	            
	      startPage = (currentPage -1) / pageLimit * pageLimit +1;
	
	      endPage = startPage + pageLimit -1;
	   
	      if(endPage > maxPage) {
	         endPage = maxPage;
	      }
	         
	      PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
	            
	      request.setAttribute("pi", pi);
	      
	      
	      
	      ArrayList<Delivery> dList = new DeliveryService().selectDeliveryList(pi);
	      
	      request.setAttribute("dList", dList);
      
	      request.getRequestDispatcher("/views/7H_The_Town/mypage/MyPageMain.jsp").forward(request, response);
      } else {
         request.getSession().setAttribute("alertMsg", "로그인 후 다시 시도해주세요.");
         response.sendRedirect(request.getContextPath()+"/main");
      }
      
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      String delNo = request.getParameter("delNo");
            
      Delivery list = new DeliveryService().selectDelivery(delNo);
      
      request.setAttribute("list", list);
      
      doGet(request, response);
   }

}