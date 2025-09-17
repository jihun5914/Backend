package cs.dit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs.dit.member.BoardDAO;
import cs.dit.member.BoardDTO;

public class BoardInsertService implements MemberService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response){

		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");

		BoardDAO dao = new BoardDAO();
		BoardDTO dto = new BoardDTO();
		dto.setSubject(subject);
		dto.setContent(content);
		dto.setWriter(writer);
		
		dao.insert(dto);

	}
}