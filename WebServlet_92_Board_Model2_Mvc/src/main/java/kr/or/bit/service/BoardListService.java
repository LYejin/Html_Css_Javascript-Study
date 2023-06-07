package kr.or.bit.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.BoardDao;
import kr.or.bit.dto.Board;
import kr.or.bit.utils.ThePager;

public class BoardListService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward forward = null;
		try {
			BoardDao dao = new BoardDao();

			// 게시물 총 건수
			int totalboardcount = dao.totalBoardCount();

			// 상세보기 >> 다시 LIST 넘어올때 >> 현재 페이지 설정
			String ps = request.getParameter("ps"); // pagesize
			String cp = request.getParameter("cp"); // current page

			// List 페이지 처음 호출 ...
			if (ps == null || ps.trim().equals("")) {
				// default 값 설정
				ps = "5"; // 5개씩
			}

			if (cp == null || cp.trim().equals("")) {
				// default 값 설정
				cp = "1"; // 1번째 페이지 보겠다
			}

			int pagesize = Integer.parseInt(ps);
			int cpage = Integer.parseInt(cp);
			int pagecount = 0;

			// 23건 % 5
			if (totalboardcount % pagesize == 0) {
				pagecount = totalboardcount / pagesize; // 20 << 100/5
			} else {
				pagecount = (totalboardcount / pagesize) + 1;
			}

			// 102건 : pagesize=5 >> pagecount=21페이지

			// 전체 목록 가져오기
			List<Board> list = dao.list(cpage, pagesize); // 해당 페이지에 맞는 게시판 글 가져오기
			
			int pagersize=3; //[1][2][3]
			ThePager pager = new ThePager(totalboardcount,cpage,pagesize,pagersize,"BoardList.do");
			
			
			request.setAttribute("pagesize", pagesize); // selectbox에서 설정한 pagesize ex) 5
			request.setAttribute("cpage", cpage); // 현재 페이지 정보
			request.setAttribute("pagecount", pagecount); // 하단 페이지 개수
			request.setAttribute("list", list); // 게시글 목록 정보
			request.setAttribute("totalboardcount", totalboardcount); // 총 개시글 수
			request.setAttribute("pager", pager); // 태그까지 완성된 페이지 정보 리턴

			forward = new ActionForward();
			forward.setRedirect(false); // forward
			forward.setPath("/WEB-INF/views/board/board_list.jsp");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return forward;		
	}

}
