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

public class EmpEditService implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		// 업데이트만 시켜주면 된다.
		String viewpage = null;
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		System.out.println("id : " + id);
		
		//update 시키기
		EmpDao ed = new EmpDao();
		Emp emp = new Emp();
		emp.setName(name);
		emp.setAge(age);
		emp.setEmail(email);
		emp.setGender(gender);
		emp.setId(id);
		
		int result = ed.empUpdate(emp);
		
		System.out.println("result : " + result);
		
		if(result > 0){
			EmpListService empService = new EmpListService();
			empService.execute(request, response);
			viewpage = "/views/Ex03_Memberlist.jsp";
		}
		
		
  	    ActionForward forward = new ActionForward();
  	    forward.setRedirect(false);
  	    forward.setPath(viewpage);
		return forward;
	}
}
