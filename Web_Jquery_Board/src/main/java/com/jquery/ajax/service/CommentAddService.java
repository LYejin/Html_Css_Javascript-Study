package com.jquery.ajax.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jquery.ajax.action.Action;
import com.jquery.ajax.action.ActionForward;
import com.jquery.ajax.dao.CommentDAO;
import com.jquery.ajax.dto.CommentDTO;

import net.sf.json.JSONArray;

public class CommentAddService implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String comment = request.getParameter("comment");
		ActionForward forward=null;
		
		System.out.println(comment);
		
		try {
			CommentDAO dao = new CommentDAO();
			//덧글등록
			dao.addComment(comment);
			List<CommentDTO> commentlist = dao.getCommentList();
			
			//JSON 데이터
			JSONArray jsonarray = JSONArray.fromObject(commentlist);
			//JSON 날짜 형식 (DATE 형식 안되요 ....)
			
			request.setAttribute("commentList", jsonarray);
			
	    	forward = new ActionForward();
		    forward.setRedirect(false); //True 클라이언트가 새로운 페이지를 요청하게 할 거예요 
			forward.setPath("/WEB-INF/views/commentAdd.jsp");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return forward;
	}

}
