package cs.dit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs.dit.member.BoardDAO;
import cs.dit.member.BoardDTO;

public class BoardUpdateService implements MemberService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String bcodeStr = request.getParameter("bcode");
		int bcode = Integer.parseInt(bcodeStr);
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");

		BoardDTO dto = new BoardDTO();
		dto.setBcode(bcode);
		dto.setSubject(subject);
		dto.setContent(content);
		
		BoardDAO dao = new BoardDAO();
		dao.update(dto);

	}

}