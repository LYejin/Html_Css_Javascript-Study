package kr.or.bit.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.EmpDao;
import kr.or.bit.dto.Emp;

public class EmpMemberSearchService implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, SQLException {
		
		String viewpage = null;
  	    ActionForward forward = new ActionForward();

		EmpDao ed = new EmpDao();
		String name = request.getParameter("search");
		List<Emp> emplist = ed.empNameSelect(name);
		
		request.setAttribute("emplist",emplist);
		request.setAttribute("rowcount", emplist.size());
		request.setAttribute("name", name);
		viewpage = "/views/Ex03_MemberSearch.jsp";
  	    forward.setRedirect(false);
  	    forward.setPath(viewpage);
		return forward;
	}

}
