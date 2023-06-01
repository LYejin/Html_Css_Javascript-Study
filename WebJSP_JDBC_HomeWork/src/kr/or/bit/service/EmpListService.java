package kr.or.bit.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.EmpDao;
import kr.or.bit.dto.Emp;

public class EmpListService implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, SQLException {
		
		EmpDao ed = new EmpDao();
		List<Emp> empList = ed.empList();
		
		request.setAttribute("empList", empList);
		
  	    ActionForward forward = new ActionForward();
  	    forward.setRedirect(false);
  	    forward.setPath("/views/Ex03_Memberlist.jsp");
		
		return forward;
	}

}
