package com.semi.board.controller;

import java.io.File;
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
import com.semi.board.model.vo.Attachment;
import com.semi.board.model.vo.Board;
import com.semi.common.MyFileRenamePolicy;

/**
 * Servlet implementation class PostingPostUpdate
 */
@WebServlet("/postUpdate.bo")
public class PostingPostUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostingPostUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardService bService = new BoardService();

		String boardNo = request.getParameter("bno");

		

		Board b = bService.selectBoard2(boardNo);

//		Attachment at = bService.selectAttachment(boardNo);

		
		request.setAttribute("b", b);
//		request.setAttribute("at", at);

		request.getRequestDispatcher("views/7H_The_Town/board/PostionUpdatePage.jsp").forward(request, response);
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
	           //String boardWriter = multi.getParameter("userNo");
	           
	           Board b = new Board();
	           b.setBoardNo(boardNo);
	           b.setBoardCategory(category);
	           b.setBoardTitle(boardTitle);
	           b.setBoardContent(boardContent);
	           //b.setWriteNo(boardWriter);

		
	           ArrayList<Attachment> list = new ArrayList(); 
				
				for(int i = 1; i<=3; i++) {
					String key = "reUpfile"+i;
				if(multi.getOriginalFileName(key)!=null) {
					Attachment at = new Attachment();
					at.setOriginName(multi.getOriginalFileName(key));
					at.setChangeName(multi.getFilesystemName(key));
					at.setCategoryNo(multi.getParameter("category"));
					at.setFilePath("resources/board_upfiles/");
					at.setBoardNo(boardNo);
					list.add(at);
				}else {
					Attachment at = new Attachment();
					at.setOriginName(multi.getOriginalFileName(key));
					at.setChangeName(multi.getFilesystemName(key));
					at.setCategoryNo(multi.getParameter("category"));
					at.setFilePath("resources/board_upfiles/");
					at.setBoardNo(boardNo);
					list.add(at);
				}
				}
				int result = new BoardService().updateBoard(b,list);
				
				if(result > 0 ) {
					request.getSession().setAttribute("alertMsg", "성공적으로 수정되었습니다.");
					response.sendRedirect(request.getContextPath()+"/detail.bo?bno="+boardNo);
				}else { //에러페이지로 포워딩
					request.setAttribute("errorMsg", "게시글 수정에 실패했습니다.");
					request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
				}
		}
	}
}
