package cs.dit.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs.dit.member.BoardDAO;
import cs.dit.member.BoardDTO;

public class BoardListService implements MemberService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		BoardDAO dao = new BoardDAO();
		int count = dao.countRecords();//테이블 전체 레코드의 수
		
		//현재 페이지번호 : 초기값 설정
		int p = 1; //초기값
		int numOfRecords = 10;
		int numOfPages = 5;

		String p_= request.getParameter("p");
		
		if(p_ !=null && !p_.equals(""))
			p = Integer.parseInt(p_);
		
		//startNum : 한 화면에서 페이지의 시작 번호
		int startNum = p-((p-1)%numOfPages);
		
		// lastNum
		int lastNum = (int)Math.ceil(count/(float)numOfRecords);
		System.out.println(lastNum);
		
		ArrayList<BoardDTO> dtos = dao.list(p, numOfRecords);
		
		request.setAttribute("p", p);
		request.setAttribute("startNum", startNum);
		request.setAttribute("lastNum", lastNum);
		request.setAttribute("numOfPages", numOfPages);
		
		request.setAttribute("dtos", dtos);

	}

}