package kr.or.bit.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.EmpDao;

public class EmpDeleteService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		String viewpage = null;
		String id = request.getParameter("id");
		
		EmpDao ed = new EmpDao();
		int row = ed.empDelete(id);
		
		EmpListService empList = new EmpListService();
		empList.execute(request, response);
		
		if (row > 0) {
			viewpage = "/views/Ex03_Memberlist.jsp";
		} else {
			//필요에 따라 추가
		}
		
  	    ActionForward forward = new ActionForward();
  	    forward.setRedirect(false);
  	    forward.setPath(viewpage);
		return forward;
	}

}
