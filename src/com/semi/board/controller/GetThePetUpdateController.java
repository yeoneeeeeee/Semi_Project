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
import com.semi.board.model.service.GetThePetService;
import com.semi.board.model.vo.Attachment;
import com.semi.board.model.vo.FileCategory;
import com.semi.board.model.vo.GetThePet;
import com.semi.common.MyFileRenamePolicy;

/**
 * Servlet implementation class GetThePetUpdateController
 */
@WebServlet("/update.get")
public class GetThePetUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetThePetUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GetThePetService gService = new GetThePetService();
		
		String boardNo = request.getParameter("bno");
		
		ArrayList<FileCategory> fList = gService.selectCategoryList();
		
		GetThePet g = gService.selectGetThePet(boardNo);
		
		ArrayList<Attachment> atList = gService.selectAttachmentList(boardNo);
		
		request.setAttribute("fList", fList);
		request.setAttribute("g", g);
		request.setAttribute("atList", atList);
		
		request.getRequestDispatcher("views/7H_The_Town/getThePet/GetThePetUpdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		if(ServletFileUpload.isMultipartContent(request)) {
			int maxSize = 100 * 1024 * 1024;
			
			String savePath = request.getSession().getServletContext().getRealPath("/resources/board_upfiles/");
			
			MultipartRequest multi = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			String boardNo = multi.getParameter("bno");
			String getContent = multi.getParameter("getContent");
//			getContent = getContent.replace("\r\n","<br>");
			String petNo = multi.getParameter("petNo");
			
			GetThePet g = new GetThePet();
			g.setGetNo(boardNo);
			g.setGetContent(getContent);
			g.setPetNo(petNo);

			ArrayList<Attachment> originList = new GetThePetService().selectAttachmentList(boardNo);
			ArrayList<Attachment> reUpList = new ArrayList<Attachment>();
			Attachment at = null;
			
			for(int i = 0; i < 5; i++) {
				
				String reUpFile = "reUpFile"+i;
				String categoryNo = "categoryNo"+i;
				
				if(multi.getOriginalFileName(reUpFile) != null) {
					
					at = new Attachment();
					at.setOriginName(multi.getOriginalFileName(reUpFile));
					at.setChangeName(multi.getFilesystemName(reUpFile));
					at.setFilePath("resources/board_upfiles/");
					at.setCategoryNo(multi.getParameter(categoryNo));
					at.setBoardNo(boardNo);
					
					reUpList.add(at);
					
				}
			}
			
			int result1 = 1;
			
			if(multi.getOriginalFileName("reUpFile1") != null) {
			
				if(originList != null) {
					
					for(int i = 0; i < originList.size(); i++) {
						at= new Attachment();
						
						at.setFileNo(originList.get(i).getFileNo());
						
						new File(savePath+originList.get(i).getChangeName()).delete();
					}
					
					result1 = new GetThePetService().deleteAttachment(g, originList);
					
				} else {
					originList = null;
				}
			} else {
				reUpList = null;
			}
			
			int result2 = new GetThePetService().updateGetThePet(g, reUpList);
			
			if(result1*result2 > 0) {
				request.getSession().setAttribute("alertMsg", "성공적으로 수정되었습니다");
				response.sendRedirect(request.getContextPath()+"/detail.get?bno="+boardNo);
			}else {
				request.setAttribute("errorMsg", "게시글 수정에 실패했습니다");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			}
		}
	}

}
