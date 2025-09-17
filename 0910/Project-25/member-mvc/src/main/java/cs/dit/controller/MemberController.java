package cs.dit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs.dit.service.BoardDeleteService;
import cs.dit.service.BoardGetService;
import cs.dit.service.BoardInsertService;
import cs.dit.service.BoardListService;
import cs.dit.service.BoardUpdateService;
import cs.dit.service.MemberDeleteService;
import cs.dit.service.MemberGetService;
import cs.dit.service.MemberInsertService;
import cs.dit.service.MemberListService;
import cs.dit.service.MemberService;
import cs.dit.service.MemberUpdateService;

@WebServlet("*.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		String com = uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf(".do"));
		String viewPage = null;
		
		// 회원 관련 URL 처리
		if(com != null && com.equals("list")){
			MemberService service = new MemberListService();
			service.execute(request, response);
			viewPage = "/WEB-INF/views/list.jsp";
		}else if(com != null && com.equals("insertForm")) {
			viewPage = "/WEB-INF/views/insertForm.jsp";
			
		}else if(com != null && com.equals("insert")) {
			MemberService service = new MemberInsertService();
			service.execute(request, response);
			viewPage = "list.do";
		}else if(com != null && com.equals("updateForm")) {
			MemberService service = new MemberGetService();
			service.execute(request, response);			
			viewPage = "/WEB-INF/views/updateForm.jsp";
		}else if(com != null && com.equals("update")) {
			MemberService service = new MemberUpdateService();
			service.execute(request, response);
			viewPage = "list.do";
		}else if(com != null && com.equals("delete")) {
			MemberService service = new MemberDeleteService();
			service.execute(request, response);			
			viewPage = "list.do";
		}else if(com != null && com.equals("index")) {
			viewPage = "/WEB-INF/views/index.jsp";
		}
		// 게시판 관련 URL 처리
		else if(com != null && com.equals("boardList")){
			MemberService service = new BoardListService();
			service.execute(request, response);
			viewPage = "/WEB-INF/views/boardList.jsp";
		}else if(com != null && com.equals("boardInsertForm")) {
			viewPage = "/WEB-INF/views/boardInsertForm.jsp";
		}else if(com != null && com.equals("boardInsert")) {
			MemberService service = new BoardInsertService();
			service.execute(request, response);
			viewPage = "boardList.do";
		}else if(com != null && com.equals("boardView")) {
			MemberService service = new BoardGetService();
			service.execute(request, response);			
			viewPage = "/WEB-INF/views/boardView.jsp";
		}else if(com != null && com.equals("boardUpdateForm")) {
			MemberService service = new BoardGetService();
			service.execute(request, response);			
			viewPage = "/WEB-INF/views/boardUpdateForm.jsp";
		}else if(com != null && com.equals("boardUpdate")) {
			MemberService service = new BoardUpdateService();
			service.execute(request, response);
			viewPage = "boardList.do";
		}else if(com != null && com.equals("boardDelete")) {
			MemberService service = new BoardDeleteService();
			service.execute(request, response);			
			viewPage = "boardList.do";
		}
		
		//view page로 이동
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}