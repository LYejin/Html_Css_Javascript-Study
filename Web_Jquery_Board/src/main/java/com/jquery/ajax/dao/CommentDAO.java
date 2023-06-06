package com.jquery.ajax.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jquery.ajax.dto.CommentDTO;
import com.jquery.ajax.utils.ConnectionHelper;

public class CommentDAO {
  //CRUD => method (select ,insert , update ,delete)
	
  	public List<CommentDTO> getCommentList(){ // 댓글 리스트 전체 조회
  		PreparedStatement pstmt = null;
  		ResultSet rs = null;
  		Connection conn = null;
  		List<CommentDTO> commentList =  new ArrayList<>();
  		String sql = "select board_id, seq, commentv from CommentV";
  	  		
  		try {
  			conn = ConnectionHelper.getConnection("oracle");
  	  		
  	  		pstmt = conn.prepareStatement(sql);
  	  		rs = pstmt.executeQuery();
  	  		
  	  		while(rs.next()) {
  	  			CommentDTO comment = new CommentDTO(rs.getInt("board_id"), rs.getInt("seq"), rs.getString("commentv"));
  	  			commentList.add(comment);
  	  		}
  	  		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionHelper.close(rs);
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
  		
  		return commentList; //List<CommentVO> commentlist 리턴 ....
  	}
	
  	
  	public void addComment(String comment){ // insert 댓글 생성
  		int boardID = 1; // 게시판 글번호
  		int seq	= getCommentList().size()+1; // 댓글 번호
  		
  		PreparedStatement pstmt = null;
  		String sql = "insert into CommentV(board_id, seq, commentv) values(?, ?, ?)";
  		Connection conn = null;
  		
  		try {
  			conn = ConnectionHelper.getConnection("oracle");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1,boardID);
			pstmt.setInt(2,seq);
			pstmt.setString(3,comment);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("댓글 생성 DB 오류 : " + e.getMessage());
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
  	}
	
  	public void removeComment(int seq){  //delete  댓글 삭제
  		PreparedStatement pstmt = null;
  		String sql = "delete from CommentV where seq=?";
  		Connection conn = null;
  		
  		try {
			conn = ConnectionHelper.getConnection("oracle");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, seq);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
  	}
}







