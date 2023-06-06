package com.jquery.ajax.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jquery.ajax.action.Action;
import com.jquery.ajax.action.ActionForward;
import com.jquery.ajax.service.CommentAddService;
import com.jquery.ajax.service.CommentDeleteService;
import com.jquery.ajax.service.commentListService;

@WebServlet("*.4zo")
public class FrontMemoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public FrontMemoController() {
        super();
        
    }
    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	//request.setCharacterEncoding("UTF-8");
    	//필터 한글 처리 고민 하지 마세요 ....
    	
       	String requestURI = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String urlcommand = requestURI.substring(contextPath.length());
    	

    	Action action=null;
    	ActionForward forward=null;
    	
    	if(urlcommand.equals("/CommentAdd.4zo")) {  //글쓰기 처리
    		action = new CommentAddService();
    		forward = action.execute(request, response);
    	} else if(urlcommand.equals("/CommentDel.4zo")) { //목록보기
    		action = new CommentDeleteService();
    		forward = action.execute(request, response);
    	} else if(urlcommand.equals("/CommentList.4zo")) { //목록보기
    		action = new commentListService();
    		forward = action.execute(request, response);
    	}
    	
    	if(forward != null) {
    		if(forward.isRedirect()) { 
    			response.sendRedirect(forward.getPath());
    		}else { 
    			RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
    			dis.forward(request, response);
    		}
    	}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
