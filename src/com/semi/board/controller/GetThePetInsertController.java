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
import com.semi.board.model.service.GetThePetService;
import com.semi.board.model.vo.Attachment;
import com.semi.board.model.vo.GetThePet;
import com.semi.common.MyFileRenamePolicy;
import com.semi.pet.model.vo.Pet;

/**
 * Servlet implementation class boardInsertController
 */
@WebServlet("/insert.get")
public class GetThePetInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetThePetInsertController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("views/7H_The_Town/getThePet/GetThePetInsert.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (ServletFileUpload.isMultipartContent(request)) {

			int maxSize = 100 * 1024 * 1024;

			String savePath = request.getServletContext().getRealPath("/resources/board_upfiles/");

			MultipartRequest multi = new MultipartRequest(request, savePath, maxSize, "UTF-8",
					new MyFileRenamePolicy());

			if (multi.getParameter("petNo") != null) {

				GetThePet g = new GetThePet();
				String getContent = multi.getParameter("getContent");
//				getContent = getContent.replace("\r\n","<br>");
				g.setGetContent(getContent);
				g.setPetNo(multi.getParameter("petNo"));

				ArrayList<Attachment> list = new ArrayList();

				for (int i = 1; i <= 5; i++) {

					String key = "file" + i;
					String category = "categoryNo" + i;
					if (multi.getOriginalFileName(key) != null) {

						Attachment at = new Attachment();
						at.setOriginName(multi.getOriginalFileName(key));
						at.setChangeName(multi.getFilesystemName(key));
						at.setFilePath("resources/board_upfiles/");
						at.setCategoryNo(multi.getParameter(category));
						at.setBoardNo(multi.getParameter("boadrNo"));

						list.add(at);
					}
				}

				int result = new GetThePetService().insertGetThePet(g, list);

				if (result > 0) {
					request.getSession().setAttribute("alertMsg", "성공적으로 업로드되었습니다.");
					response.sendRedirect(request.getContextPath() + "/list.get");
				} else {
					request.getSession().setAttribute("alertMsg", "사진게시판 업로드 실패");
					response.sendRedirect(request.getContextPath() + "/list.get");
				}

			}

		}
	}

}
