package kr.or.kosa.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.RegisterDao;
/*
URL 방식 (command 방식 상관 없다)
http://192.168.0.46:8090/WebSite/list.do >> *.do 매핑
http://192.168.0.46:8090/WebSite/write.do >> *.do 매핑

Command방식(parameter 업무 파악) 파라미터로 페이지 지정
@WebServlet("site.do")
http://192.168.0.46:8090/WebSite/site.do?cmd=list
http://192.168.0.46:8090/WebSite/site.do?cmd=write
*/
import kr.or.kosa.dto.RegisterDto;
import kr.or.kosa.service.BoardWriteOkServiceAction;
import kr.or.kosa.service.LoginOkServiceAction;
import kr.or.kosa.service.RegisterOkServiceAction;
/*
Url 방식 (command 방식 상관 없다)

Command 방식 (parameter 업무 파악)
*/

@WebServlet("*.do")
public class FrontRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public FrontRegisterController() {
        super();
    }
    
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.한글
		request.setCharacterEncoding("UTF-8");
		//2.데이터받기
		//String cd = request.getParameter("cmd");
		
		//Url 방식으로 요청 판단하기
		//http://192.168.0.46:8090/Website/list.do
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String urlcommand = requestUri.substring(contextPath.length());
		
		System.out.println("requestUri : " + requestUri);
		System.out.println("contextPath : " + contextPath);
		System.out.println("urlcommand : " + urlcommand); // == /register.do
		/*
		requestUri  : /WebServlet_8_Member_Url/register.do
		contextPath : /WebServlet_8_Member_Url
		urlcommand  : /register.do
		 */
		
		Action action = null;
		ActionForward forward = null;
		
		//Client 요청 (1.화면주세요(service 필요없어요) 2.처리해주세요(별도의 service 필요))
		if (urlcommand.equals("/register.do")) {
			//UI 제공 (서비스 객체 필요없어요)
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/register/register.jsp");
		} else if (urlcommand.equals("/registerok.do")) {
			//UI 제공 + 서비스 로직
			action = new RegisterOkServiceAction(); // 다형성 부모 타입
			forward = action.execute(request, response); // request 객체의 주소 넘김
		} else if (urlcommand.equals("/login.do")) {
			//UI 제공 (서비스 객체 필요없어요)
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/login/login.jsp");
		} else if (urlcommand.equals("/registerok.do")) {
			//UI 제공 + 서비스 로직
			action = new LoginOkServiceAction(); // 다형성 부모 타입
			forward = action.execute(request, response); // request 객체의 주소 넘김
		} else if (urlcommand.equals("/write.do")) {
			//UI 제공 (서비스 객체 필요없어요)
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/board/boardwrite.jsp");
		} else if (urlcommand.equals("/writeok.do")) {
			action = new BoardWriteOkServiceAction();
			forward = action.execute(request, response);
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
		
		
		
		/*
		------------------------------------------------
		//3.요청 판단하기 ... 판단에 따른 서비스 실행
	  	response.setContentType("text/html;charset=UTF-8"); //클라언트에게 전달한 페이지의 정보 구성 / 응답할 페이지의 기본정보
	
	  	String viewpage = null;
		
		if (urlcommand.equals("/register.do")) { // register.jsp
			viewpage = "/WEB-INF/views/register/register.jsp";
		} else if (urlcommand.equals("/registerok.do")) { // register_welcome.jsp
			//4.데이터담기
	  	    int id = Integer.parseInt(request.getParameter("id"));
	  	    String pwd = request.getParameter("pwd");
	  	    String email = request.getParameter("email");
	  	    
			RegisterDao rdo = new RegisterDao();
			
			int row = rdo.writeOk(new RegisterDto(id, pwd, email)); // try catch 문 insert에 걸어서 실행된다.(같은 값 걸어도)
			
			String resultdata = "";
			if (row > 0) {
				resultdata = "welcome to kosa" + id + "님";
			} else {
				resultdata = "Insert Fail ... retry ...";
			}
			request.setAttribute("resultdata", resultdata);
			viewpage = "/WEB-INF/views/register/register_welcome.jsp";
		}

		//5.view지정
		RequestDispatcher dis = request.getRequestDispatcher(viewpage);
		//6.view forward
		dis.forward(request, response);
		
		// register 라면 회원가입 주세요
		// registerok 라면 회원데이터 받아서 DB에 insert 하세요 그리고 welcome 페이지 forward
		// request에 회원 id 하고 환영인사 메시지를 담아서 view페이지에서 출력하세요!
		*/
	}    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
