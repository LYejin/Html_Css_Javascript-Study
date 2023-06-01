package kr.or.kosa.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;


@WebFilter("/Encoding")
public class Encoding extends HttpFilter implements Filter {
    
	//추가 코드
	//member filter 생성
	private String encoding;
	

    public Encoding() {
        super();
    }

	public void init(FilterConfig fConfig) throws ServletException {
		// 최초 요청시 컴파일 되고 한번만 실행되는 함수 (언제 > 코드 수정, 서버 리부팅)
		// web.xml 설정되어 있는 초기값을 read해서 FilterConfig 통해서 ...
		this.encoding = fConfig.getInitParameter("encoding"); //web.xml 설정된 값 read
		System.out.println("filter init 함수 실행" + this.encoding);
	}
	
	public void destroy() {
		
	}
	
	//처리하는 함수
	//request, response 호출
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//doGet, doPost 와 비슷
		// TODO Auto-generated method stub
		// place your code here

		//request 요청에 대한 필터를 실행하는 코드 영역
		if (request.getCharacterEncoding() == null) {
			System.out.println("before : " + request.getCharacterEncoding());
			
			request.setCharacterEncoding(this.encoding);
			
			System.out.println("after : " + request.getCharacterEncoding());
		} 
		
		
		
		chain.doFilter(request, response); // 다른 필터가 존재한다면 ... 다음 필터 doFilter 호출 (연결)
		
		//response 응답에 대한 필터 실행하는 코드 영역 
		System.out.println("응답처리 실행 영역");
		
	}

}
