package kr.or.bit.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.EmpDao;
import kr.or.bit.dto.Emp;

public class EmpDetailService implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		String viewpage = null;
		
  	    ActionForward forward = new ActionForward();

		String id = request.getParameter("id");
		
		EmpDao ed = new EmpDao();
		Emp emp = ed.empDetail(id);
		
		request.setAttribute("id", emp.getId());
		request.setAttribute("pwd", emp.getPwd());
		request.setAttribute("name", emp.getName());
		request.setAttribute("age", emp.getAge());
		request.setAttribute("gender", emp.getGender());
		request.setAttribute("email", emp.getEmail());
		viewpage = "/views/Ex03_MemberDetail.jsp";
		

  	    forward.setRedirect(false);
  	    forward.setPath(viewpage);
		return forward;
	}
}
