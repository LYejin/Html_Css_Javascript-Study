package kr.or.bit.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.service.EmpDeleteService;
import kr.or.bit.service.EmpDetailService;
import kr.or.bit.service.EmpEditService;
import kr.or.bit.service.EmpJoinService;
import kr.or.bit.service.EmpListService;
import kr.or.bit.service.EmpLoginOutService;
import kr.or.bit.service.EmpLoginService;
import kr.or.bit.service.EmpMemberSearchService;
import kr.or.bit.service.EmpViewEditService;


@WebServlet("*.do")
public class FrontEmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public FrontEmpController() {
        super();
        
    }
    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
    	//request.setCharacterEncoding("UTF-8");
    	//필터 한글 처리 고민 하지 마세요 ....
    	
       	String requestURI = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String urlcommand = requestURI.substring(contextPath.length());
    	

    	Action action=null;
    	ActionForward forward=null;
    	
    	if(urlcommand.equals("/views/Ex02_JDBC_JoinOK.do")) {  // 회원가입 처리 
    		action = new EmpJoinService();
    		forward = action.execute(request, response);
    	}else if(urlcommand.equals("/views/Ex02_JDBC_loginok.do")) { // 로그인 처리
    		action = new EmpLoginService();
    		forward = action.execute(request, response);
    	}else if(urlcommand.equals("/views/Ex03_MemberDetail.do")) { // id로 조회하는 기능
    		action = new EmpDetailService();
    		forward = action.execute(request, response);
    	}else if(urlcommand.equals("/views/Ex03_MemberDelete.do")) {  // 회원삭제 기능 
    		action = new EmpDeleteService();
    		forward = action.execute(request, response);
    	}else if(urlcommand.equals("/views/Ex03_MemberEditok.do")) {  // 회원정보 수정 기능
    		action = new EmpEditService();
    		forward = action.execute(request, response);
    	} else if(urlcommand.equals("/views/Ex03_MemberEdit.do")) {  // 뷰 페이지
    		action = new EmpViewEditService();
    		forward = action.execute(request, response);
    	}else if (urlcommand.equals("/views/Ex02_JDBC_Login.do")) {
    		action = new EmpLoginOutService();
    		forward = action.execute(request, response);
    	} else if (urlcommand.equals("/views/Ex03_MemberSearch.do")) {
    		action = new EmpMemberSearchService();
    		forward = action.execute(request, response);
    	}else if (urlcommand.equals("/views/Ex03_Memberlist.do")) {
    		action = new EmpListService();
    		forward = action.execute(request, response);
    	} else if (urlcommand.equals("/views/Ex02_JDBC_Logout.do")) {
    		action = new EmpLoginOutService();
    		forward = action.execute(request, response);
    	} else if (urlcommand.equals("/views/Ex02_JDBC_Login.do")) {
    		action = new EmpLoginOutService();
    		forward = action.execute(request, response);
    	} 
//    	else if (urlcommand.equals("/Ex02_JDBC_Main.do")) {
//    		action = new EmpListService();
//    		forward = action.execute(request, response);
//    	}

//		//UI 제공
//		forward = new ActionForward();
//		forward.setRedirect(false);
//		forward.setPath("/WEB-INF/views/memoview.jsp");
//    	
    	if(forward != null) {
    		if(forward.isRedirect()) { //true 페이지 재 요청 (location.href="페이지"
    			response.sendRedirect(forward.getPath());
    		}else { //기본적으로 forward ....
    			    //1. UI 전달된 경우
    			    //2. UI + 로직
    			RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
    			dis.forward(request, response);
    		}
    	}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			doProcess(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			doProcess(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
