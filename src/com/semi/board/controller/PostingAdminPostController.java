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
 * Servlet implementation class PostingPostController
 */
@WebServlet("/Adminpost.bo")
public class PostingAdminPostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostingAdminPostController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("views/7H_The_Town/board/AdminPostionPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(ServletFileUpload.isMultipartContent(request)) {
			
			int maxSize = 10*1024*1024; 
			
			String savePath = request.getSession().getServletContext().getRealPath("/resources/board_upfiles/");
			
			MultipartRequest multi = new MultipartRequest(request,savePath,maxSize,"UTF-8",new MyFileRenamePolicy());
			
			
			String category = multi.getParameter("category");
			String boardTitle = multi.getParameter("title");
			String boardContent = multi.getParameter("text");
	        //boardContent = boardContent.replace("\r\n","<br>");
			String boardWriter = multi.getParameter("userNo");
			
			Board b = new Board();
			b.setBoardCategory(category);
			b.setBoardTitle(boardTitle);
			b.setBoardContent(boardContent);
			b.setWriteNo(boardWriter);
			
			ArrayList<Attachment> list = new ArrayList(); 
			
			for(int i = 1; i<=3; i++) {
				String key = "file"+i;
			if(multi.getOriginalFileName(key)!=null) {
				Attachment at = new Attachment();
				at.setOriginName(multi.getOriginalFileName(key));
				at.setChangeName(multi.getFilesystemName(key));
				at.setCategoryNo(multi.getParameter("category"));
				at.setFilePath("resources/board_upfiles/");
				list.add(at);
			}
			}

			
			
			int result = new BoardService().insertBoard(b,list);
			
			if(result >0) { //성공시 = list.bo url재요청 보내기
				request.getSession().setAttribute("alertMsg", "게시글 작성 성공");
				response.sendRedirect(request.getContextPath()+"/list.bo");
			}else { 
				
				request.setAttribute("alertMsg", "게시글 작성 실패");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			}
		}else {
			request.setAttribute("alertMsg", "전송방식이 잘못되었습니다.");
			request.getRequestDispatcher("/views/common/errorPage.jsp").forward(request, response);
		}
	}

}
