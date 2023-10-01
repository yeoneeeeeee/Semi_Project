package com.semi.board.controller;

import java.io.IOException;
import java.util.ArrayList;

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

/**
 * Servlet implementation class PostingPostUpdate
 */
@WebServlet("/FaqUpdate.bo")
public class FaqPostUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaqPostUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardService bService = new BoardService();

		String faqNo = request.getParameter("bno");

		

		FAQ b = bService.selectFaq(faqNo);

//		Attachment at = bService.selectAttachment(boardNo);

		
		request.setAttribute("b", b);
//		request.setAttribute("at", at);
		request.getRequestDispatcher("views/7H_The_Town/FAQ/FAQ_Post_Update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(ServletFileUpload.isMultipartContent(request)) {
	        
	         int maxSize = 10 * 1024 * 1024;
	         
	         
	         String savePath =  request.getSession().getServletContext().getRealPath("/resources/board_upfiles/");
	         
	         
	           MultipartRequest multi = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
	           
		   
	           String boardNo = multi.getParameter("bno");
	           String category = multi.getParameter("category");
	           String boardTitle = multi.getParameter("title");
	           String boardContent = multi.getParameter("text");
	           
	           FAQ b = new FAQ();
	           b.setFaqNo(boardNo);
	           b.setCategory(category);
	           b.setFaqTitle(boardTitle);
	           b.setFaqContent(boardContent);

		
		/*Attachment at = null;
		
		if(multi.getOriginalFileName("reUpfile")!=null) {
			
			at = new Attachment();
			at.setOriginName(multi.getOriginalFileName("reUpfile"));
			at.setChangeName(multi.getFilesystemName("reUpfile"));
			at.setFilePath("resources/board_upfiles/");
			
			
			if(multi.getParameter("originFileNo")!=null) {
				
				at.setFileNo(Integer.parseInt(multi.getParameter("originFileNo")));
				
				
				new File(savePath+multi.getParameter("originFileName")).delete();
			}else {
				//
				
				at.setRefNo(boardNo);
			}
		}*/
	
	
		int result = new BoardService().updateFaq(b);
		
		
		if(result > 0 ) {//수정 성공 => 상세조회 페이지 재요청
			request.getSession().setAttribute("alertMsg", "성공적으로 수정되었습니다.");
			response.sendRedirect(request.getContextPath()+"/faqDetail.bo?bno="+boardNo);
		}else { //에러페이지로 포워딩
			request.setAttribute("errorMsg", "게시글 수정에 실패했습니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
		}
	}
}
