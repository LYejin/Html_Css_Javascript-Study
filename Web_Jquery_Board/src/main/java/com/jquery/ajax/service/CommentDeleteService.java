package com.jquery.ajax.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jquery.ajax.action.Action;
import com.jquery.ajax.action.ActionForward;
import com.jquery.ajax.dao.CommentDAO;
import com.jquery.ajax.dto.CommentDTO;

import net.sf.json.JSONArray;

public class CommentDeleteService implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		int seq = Integer.parseInt(request.getParameter("seq"));
		ActionForward forward=null;
		
		try {
			CommentDAO dao = new CommentDAO();
			
			//덧글삭제
			//dao.addComment(comment);
			dao.removeComment(seq);
			List<CommentDTO> commentlist = dao.getCommentList();
			
			//JSON 데이터
			JSONArray jsonarray = JSONArray.fromObject(commentlist);
			
			request.setAttribute("commentList", jsonarray);
			
	    	forward = new ActionForward();
		    forward.setRedirect(false); //True 클라이언트가 새로운 페이지를 요청하게 할 거예요 
			forward.setPath("/WEB-INF/views/commentDelete.jsp");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		return forward;
	}
	
}
