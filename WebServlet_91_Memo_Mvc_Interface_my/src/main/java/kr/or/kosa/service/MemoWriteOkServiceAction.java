package kr.or.kosa.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.MemoDao;
import kr.or.kosa.dto.Memo;

public class MemoWriteOkServiceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		  PrintWriter out = response.getWriter();
	  	  
	  	  String id = request.getParameter("id");
	  	  String email = request.getParameter("email");
	  	  String memo = request.getParameter("memo");
	  	  //out.print(id + "," + email + "," + memo);
	  	  
	  	  
	  	  try{
	  		 MemoDao dao = new MemoDao();
	  		 int n = dao.insertMemo(new Memo(id, email, memo));

	  		 List<Memo> memolist = dao.getMemoList();
			 request.setAttribute("memolist", memolist);
	  	   if(n>0){
	  		    out.print("<script>");
	  	     	out.print("alert('등록성공..');");
	  	    out.print("</script>");
	  	   }else{ //insert 에서 현실적으로 경우 ...
	  		   //...
	  	   }
	  	  }catch(Exception e){
			    out.print("<script>");
			    out.print("alert('등록실패..');");
			    out.print("</script>");
			    out.print("<b> 오류 :" +  e.getMessage()  + "</b>");    	   
	  	  }
		ActionForward forward = new ActionForward();
		forward.setRedirect(false); //forward 방식으로
		forward.setPath("/memolist.jsp");
    	return forward;
	}

}
