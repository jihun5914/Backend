package cs.dit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs.dit.member.BoardDAO;

public class BoardDeleteService implements MemberService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String bcodeStr = request.getParameter("bcode");
		int bcode = Integer.parseInt(bcodeStr);

		BoardDAO dao = new BoardDAO();
		dao.delete(bcode);
	}

}