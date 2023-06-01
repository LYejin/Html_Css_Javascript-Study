package kr.or.kosa.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.service.MemoListOkServiceAction;
import kr.or.kosa.service.MemoWriteOkServiceAction;

@WebServlet("*.do")
public class MemoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MemoController() {
        super();
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  	  request.setCharacterEncoding("UTF-8");
  	  response.setContentType("text/html;charset=UTF-8"); //클라언트에게 전달한 페이지의 정보 구성 / 응답할 페이지의 기본정보
  	  
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String urlcommand = requestUri.substring(contextPath.length());
		
		Action action = null;
		ActionForward forward = null;
		
		//Client 요청 (1.화면주세요(service 필요없어요) 2.처리해주세요(별도의 service 필요))
		if (urlcommand.equals("/MemoServlet.do")) {
			//UI 제공 + 서비스 로직
			action = new MemoWriteOkServiceAction(); // 다형성 부모 타입
			forward = action.execute(request, response); // request 객체의 주소 넘김
		} else if (urlcommand.equals("/MemoList.do")) {
			//UI 제공 + 서비스 로직
			action = new MemoListOkServiceAction(); // 다형성 부모 타입
			forward = action.execute(request, response); // request 객체의 주소 넘김
		}
		
		if (forward != null) {
			if (forward.isRedirect()) { //true location.href="" 새로운 페이지 받겠다 
				response.sendRedirect(forward.getPath());
			} else {
				//false (forward) >> view 페이지에서 객체를 얻어 출력할 수 있다. 
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
