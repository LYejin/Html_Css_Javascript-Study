package kr.or.kosa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.or.kosa.dto.Memo;
import kr.or.kosa.utils.SingletonHelper;
/*
DB연결
CRUD 함수 생성 > memo
1. 전체조회  : select id , email , content from memo
2. 조건조회  : select id , email , content from memo where id=? //제약 id >pk
3. 삽입     : insert into memo(id,email,content) values(?,?,?)
4. 수정     : update memo set email=? , content=? where id=?
5. 삭제     : delete from memo where id=?
알파... LIKE 검색  where email like '%naver%'

자바로 함수를 생성 .... 처리 ... 거의 똑같아요
ArrayList
HashMap
제너릭 ...
*/


public class MemoDao {
	Connection conn = null;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public MemoDao() {
		conn = SingletonHelper.getConnection("oracle"); //singleton
	}
	
	//1. 전체조회
	public List<Memo> getMemoAllList() {
		List<Memo> memoList = new ArrayList<>();
		conn=null;
		pstmt=null;
		rs=null;
		
		try {
			conn = SingletonHelper.getConnection("oracle");
			String str = "select id, email, content from memo";
			pstmt = conn.prepareStatement(str);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Memo memo = new Memo(rs.getString("id"), rs.getString("email"), rs.getString("content"));
				memoList.add(memo);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(pstmt);
			SingletonHelper.close(rs);
		}
		return memoList;
	}
		
	//2. 삽입
	public int insertMemo(Memo memo) {
		int row =0;
		conn=null;
		pstmt=null;
		rs=null;
		
		try {
			conn = SingletonHelper.getConnection("oracle");
			String str = "insert into memo(id, email, content) values(?,?,?)";
			pstmt = conn.prepareStatement(str);
			pstmt.setString(1, memo.getId());
			pstmt.setString(2, memo.getEmail());
			pstmt.setString(3, memo.getContent());
			row = pstmt.executeUpdate();
			
			if (row >0) {
				System.out.println("insert row : "  + row);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(pstmt);
			SingletonHelper.close(rs);
		}
		return row;
	}
}
