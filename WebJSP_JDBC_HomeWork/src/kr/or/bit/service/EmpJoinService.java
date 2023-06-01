package kr.or.bit.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.EmpDao;
import kr.or.bit.dto.Emp;

public class EmpJoinService implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// 회원가입 처리해주기
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String mname = request.getParameter("mname");
		int age = Integer.parseInt(request.getParameter("age")); 
		String gender = request.getParameter("gender");
		String email =  request.getParameter("email");
		String ip = request.getRemoteAddr();
		
		EmpDao ed = new EmpDao();
		int result = ed.empInsert(new Emp(id, pwd, mname, age, gender, email, ip));
		
		String viewpage = null;
		//나중에 한번 더 생각해보자
		try {
			if(result !=0){
				viewpage = "/views/Ex02_JDBC_Login.jsp";
			}else{ //실행될 확률 거의없다 ...
				viewpage = "/views/Ex02_JDBC_JoinForm.jsp";
			}
		} catch (Exception e) {
			viewpage = "/views/Ex02_JDBC_JoinForm.jsp";
		}
		
  	    ActionForward forward = new ActionForward();
  	    forward.setRedirect(false);
  	    forward.setPath(viewpage);
		return forward;
	}

}
