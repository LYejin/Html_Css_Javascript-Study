package kr.or.bit.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;

public class EmpLoginOutService implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, SQLException {

		HttpSession session = request.getSession();
		String viewpage = null;
		
		System.out.println("useriddddd" + session.getAttribute("userid"));
		
		if(session.getAttribute("userid") != null){
			session.invalidate();
			viewpage = "/views/Ex02_JDBC_Login.jsp";
		}else{
			viewpage = "/views/Ex02_JDBC_Login.jsp";
		}
		
  	    ActionForward forward = new ActionForward();
  	    forward.setRedirect(false);
  	    forward.setPath(viewpage);
		return forward;
	}
	
}
