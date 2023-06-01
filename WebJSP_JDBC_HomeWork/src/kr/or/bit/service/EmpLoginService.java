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
import kr.or.bit.dto.Emp;

public class EmpLoginService implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {		

		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		System.out.println("id" + id);
		System.out.println("pwd" + pwd);
		
		EmpDao ed = new EmpDao();
		Emp emp = ed.empIdSelect(id);
		System.out.println("emp" + emp.getId());
		System.out.println("emp" + emp.getPwd());
		String empPwd = emp.getPwd();
		///////////////
		//회원 id로 값 찾기
		//업무
		
		//데이터가 있다 (id가 존재)
		String viewpage = null;
		//ID 존재
		if(pwd.equals(empPwd)){
		  //ID 존재 , PWD(0)
		  //정상회원
		  
		  //Top.jsp 정보 로그인 상태 ...
		  session.setAttribute("userid", emp.getId());
		  
		  //이동처리 (로그인이 되면)
		  viewpage = "/views/Ex02_JDBC_Main.jsp";
		}else{
			//ID 존재 , PWD(x)
			  viewpage = "/views/Ex02_JDBC_Login.jsp";
		}
		
  	    ActionForward forward = new ActionForward();
  	    forward.setRedirect(false);
  	    forward.setPath(viewpage);
		
		return forward;
	}

}
