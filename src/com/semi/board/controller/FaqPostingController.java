package com.semi.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.semi.board.model.service.BoardService;
import com.semi.board.model.vo.Board;
import com.semi.board.model.vo.FAQ;
import com.semi.common.MyFileRenamePolicy;
import com.semi.member.model.vo.Member;

/**
 * Servlet implementation class PostingPostController
 */
@WebServlet("/faqpost.bo")
public class FaqPostingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaqPostingController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Member loginUser = (Member) request.getSession().getAttribute("loginUser");

		if (loginUser != null) {
			request.getRequestDispatcher("views/7H_The_Town/FAQ/FAQ_PostingPage.jsp").forward(request, response);

		} else {
			request.getSession().setAttribute("alertMsg", "로그인 후 다시 시도해주세요");
			response.sendRedirect(request.getContextPath()+"/main");
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Member loginUser = (Member)request.getSession().getAttribute("loginUser");
		
		if(loginUser != null) {
			
			if(ServletFileUpload.isMultipartContent(request)) {
				
				int maxSize = 10*1024*1024; 
				
				String savePath = request.getSession().getServletContext().getRealPath("/resources/board_upfiles/");
				System.out.println(savePath);
				
				MultipartRequest multi = new MultipartRequest(request,savePath,maxSize,"UTF-8",new MyFileRenamePolicy());
				
				
				String category = multi.getParameter("category");
				String faqTitle = multi.getParameter("title");
				String faqContent = multi.getParameter("text");
				String boardWriter = multi.getParameter("userNo");
				
				FAQ f = new FAQ();
				f.setCategory(category);
				f.setFaqContent(faqContent);
				f.setFaqTitle(faqTitle);
				f.setUserNo(boardWriter);
				
				//Attachment at = null; 
				
				
				
				/*
				 * if(multi.getOriginalFileName("upfile") != null) { at = new Attachment();
				 * at.setOriginName(multi.getOriginalFileName("upfile")); //원본명
				 * at.setChangeName(multi.getFilesystemName("upfile")); //수정명(실제 서버에 업로드되어있는
				 * 파일명) at.setFilePath("resources/board_upfiles/"); }
				 */
				
				
				int result = new BoardService().insertFaq(f);
				
				if(result >0) { //성공시 = list.bo url재요청 보내기
					request.getSession().setAttribute("alertMsg", "게시글 작성 성공");
					response.sendRedirect(request.getContextPath()+"/faqPetList.bo");
				}else { //실패시 => 업로드 하고자하는 첨부파일이 있었을 경우, db에 저장실패시 굳이 서버에 보관할 필요가 없다.
					/*
					 * if(at != null){ //삭제하고자 하는 파일 삭제 후 delete메소드 호출하기 new
					 * File(savePath+at.getChangeName()).delete(); }
					 */
					request.setAttribute("alertMsg", "게시글 작성 실패");
					request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
				}
			}else {
				request.setAttribute("alertMsg", "전송방식이 잘못되었습니다.");
				request.getRequestDispatcher("/views/common/errorPage.jsp").forward(request, response);
			}
		
		} else {
			request.getSession().setAttribute("alertMsg", "로그인 후 다시 시도해주세요");
			request.getRequestDispatcher(request.getContextPath()+"/main").forward(request, response);;
		}
	}

}
