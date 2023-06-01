package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(
		description = "서블릿 테스트 중입니다 홍길동", 
		urlPatterns = { 
				"/NowServlet", 
				"/Now.do", 
				"/Now.action", 
				"/Now.kglim"
		}, 
		initParams = { 
				@WebInitParam(name = "id", value = "kosa", description = "id 초기값 활용하기"), 
				@WebInitParam(name = "jdbcDriver", value = "oracle.jdbc.OracleDriver", description = "오라클 드라이버 클래스 제공")
		}) // initParams = 초기화 (name, value) Web.xml에서 설정해도 된다.
public class NowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public NowServlet() {
        super();
        System.out.println("생성자 > 객체 생성시 한번 호출");
    }

	
	public void init(ServletConfig config) throws ServletException {
		//초기화 함수 (자동 호출되는 함수)
		//호출 시점 : NowServlet 클래스에 대한 **** [최초 요청시 한번 실행] **** 한번이라는 기준은? 한번이지만 아래 상황에선 한번 더 실행
		//재실행 : 서버의 재시작 , 개발자의 코드 수정
		
		//it.co.kr 서버 오픈 > WAS (서블릿 : NowServlet.java)
		//홍길동 첫 접속자 -> it.co.kr/Now.do 서버 요청 
		//NowServlet 컴파일 >> class >> 실행 -> 생성자 호출 -> init 자동호출 -> doGET or doPOST -> 자동호출
		
		//김유신 두번째 접속자  -> it.co.kr/Now.do 서버 요청 
		// class >> 실행 -> doGET or doPOST -> 자동호출
		
		//유관순 두번째 접속자  -> it.co.kr/Now.do 서버 요청 
		// class >> 실행 -> doGET or doPOST -> 자동호출
		
		// 생성자 init 초기화는 최초만 하고 안함 -> 이 초기값을 가지고 설정할 수 있다
		
		//DB연결 초기화 
		String drivername = config.getInitParameter("jdbcDriver");
		System.out.println("최초 요청시 한번 실행 : " + drivername);
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGET");
		//servlet -> UI -> JSP(개발) UI작업
		//JSP 없던 시절에 ....
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
			out.print("<head><title>Hello</title></head>");
				out.print("<body>");
					out.print("현재 날짜 : " + new Date() + "<br>");
				out.print("</body>");
		out.print("</html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPOST");
	}

}
