package cs.dit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs.dit.member.BoardDAO;
import cs.dit.member.BoardDTO;

public class BoardGetService implements MemberService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
			
		String bcodeStr = request.getParameter("bcode");
		int bcode = Integer.parseInt(bcodeStr);
		
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.get(bcode);
		
		request.setAttribute("dto", dto);
	}

}