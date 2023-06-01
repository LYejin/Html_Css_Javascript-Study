package kr.or.kosa.action;

/*
servlet (client) 요청

1. 화면을 주세요 (UI 경로)
2. 처리해 주세요 (SERVICE)

화면 아니면 로직 처리 
*/

public class ActionForward {
	private boolean isRedirect=false; 
	//뷰의 전환 (redirect(페이지 주소 바뀜/location.href) or forward(uri 변경이 아니라 동일하게 화면만 바꾸고 싶음) 방식
	private String path=null; // 이동경로 (뷰의 주소)
	
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
}
