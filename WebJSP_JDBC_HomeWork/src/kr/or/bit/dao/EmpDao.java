package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.bit.dto.Emp;
import kr.or.bit.utils.Singleton_Helper;

public class EmpDao {
	//회원 Insert
	public int empInsert(Emp emp) {
		Connection conn = null;
		PreparedStatement pstmt=null;
		
		int result = 0;
		
		try{
			conn = Singleton_Helper.getConnection("oracle");
			String sql="insert into koreamember(id,pwd,name,age,gender,email,ip) values(?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, emp.getId());
			pstmt.setString(2, emp.getPwd());
			pstmt.setString(3, emp.getName());
			pstmt.setInt(4, emp.getAge());
			pstmt.setString(5, emp.getGender());
			pstmt.setString(6, emp.getEmail());
			pstmt.setString(7, emp.getIp());
			
			result = pstmt.executeUpdate();
		}catch(Exception e){
//			// pstmt.executeUpdate(); 실행시  PK 위반 예외 발생    if 타지 않고 ....
			System.out.println("empInsert 오류 : " + e.getMessage());
		}finally{
			if(pstmt != null){ try{pstmt.close();}catch(Exception e){} }
			if(conn != null){ try{conn.close();}catch(Exception e){} }
		}
		return result;
	}
	
	//회원 select id 값으로 찾기 / 한 건 조회
	public Emp empIdSelect(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Emp emp = null;
		try{
			//conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","bituser","1004");
			//비기능적 요구사항
			conn = Singleton_Helper.getConnection("oracle");
			String sql="select id, pwd from koreamember where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			rs = pstmt.executeQuery(); 
			
			while(rs.next()) {
				emp = new Emp();
				emp.setId(rs.getString("id"));
				emp.setPwd(rs.getString("pwd"));
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			Singleton_Helper.close(rs);
			Singleton_Helper.close(pstmt);
		} 
		return emp;
	}
	
	//회원 select id 값으로 찾기 / 한 건 조회
	public List<Emp> empList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Emp> empList = new ArrayList<>();
		try{
			//conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","bituser","1004");
			//비기능적 요구사항
			conn = Singleton_Helper.getConnection("oracle");
			String sql="select id, ip from koreamember";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); 
			
			
			while(rs.next()) {
				Emp emp = new Emp();
				emp.setId(rs.getString("id"));
				emp.setIp(rs.getString("ip"));
				System.out.println("emp함수" + emp);
				empList.add(emp);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			Singleton_Helper.close(rs);
			Singleton_Helper.close(pstmt);
		}
		return empList;
	}
	
	// 회원 detail 
	public Emp empDetail(String id) {
		Connection conn = null;
  		PreparedStatement pstmt = null;
  		ResultSet rs = null;
  		Emp emp = null;
  		
  		try{
  			conn = Singleton_Helper.getConnection("oracle");
  			String sql = "select id,pwd,name,age,gender,email from koreamember where id=?";
  			pstmt = conn.prepareStatement(sql);
  			
  			pstmt.setString(1, id);
  			
  			rs = pstmt.executeQuery();
  			//rs.next(); 추후에 데이터 1건 경우  (while 없이 )
  			rs.next();
  			emp = new Emp();
			emp.setId(rs.getString("id"));
			emp.setPwd(rs.getString("pwd"));
			emp.setName(rs.getString("name"));
			emp.setAge(rs.getInt("age"));
			emp.setGender(rs.getString("gender").trim());
			emp.setEmail(rs.getString("email"));
  		}catch(Exception e){
  			System.out.println(e.getMessage());
  		}finally{
  			Singleton_Helper.close(rs);
  			Singleton_Helper.close(pstmt);
  		}
  
		return emp;
	}
	
	//회원 삭제 delete
	public int empDelete(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int row = 0;
		try {
			conn = Singleton_Helper.getConnection("oracle");
			String sql = "delete from koreamember where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			row = pstmt.executeUpdate();


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Singleton_Helper.close(pstmt);
		}
		return row;
	}
	
	//회원 수정 정보 확인 select / 한 건 조회 
	public Emp empEditSelect(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Emp emp = null;
		try{
			conn = Singleton_Helper.getConnection("oracle");
			String sql="select id,pwd,name,age,trim(gender),email from koreamember where id=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,id);
			
			rs = pstmt.executeQuery(); 
			
			//while(rs.next()) {
			rs.next();
			emp = new Emp();
			emp.setId(rs.getString("id"));
			emp.setPwd(rs.getString("pwd"));
			emp.setName(rs.getString("name"));
			emp.setAge(rs.getInt("age"));
			emp.setGender(rs.getString("gender"));
			emp.setEmail(rs.getString("email"));//1건 데이터가 있다면 전제조건
		} catch(Exception e){
  			System.out.println(e.getMessage());
  		}finally{
  			Singleton_Helper.close(rs);
  			Singleton_Helper.close(pstmt);
  		}
		return emp;
	}
	
	//회원 정보 수정하기 update
	public int empUpdate(Emp emp) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		try{
			conn = Singleton_Helper.getConnection("oracle");
			String sql = "update koreamember set name=? , age=? , email=? , gender=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp.getName());
			pstmt.setInt(2, emp.getAge());
			pstmt.setString(3, emp.getEmail());
			pstmt.setString(4, emp.getGender().trim());
			pstmt.setString(5, emp.getId());
			result = pstmt.executeUpdate();

			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			Singleton_Helper.close(pstmt);
		}
		return result;
	}
	
	//회원 이름으로 조회 하기 select / Emp 객체?
	public List<Emp> empNameSelect(String name) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Emp> emplist = new ArrayList<>();
		
		try {
			conn = Singleton_Helper.getConnection("oracle");
			//String sql="select count(*) from koreamember where name like ?";
			String sql ="select id, name, email from koreamember where name like '%"+name+"%'";
			
			pstmt = conn.prepareStatement(sql);
			rs= pstmt.executeQuery();
			while(rs.next()){
				Emp emp = new Emp();
				emp.setId(rs.getString("id"));		
				emp.setName(rs.getString("name"));
				emp.setEmail(rs.getString("email"));
				emplist.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("nameSearch : " + e.getMessage());
		} finally {
			Singleton_Helper.close(rs);
			Singleton_Helper.close(pstmt);
		}
		return emplist;
	}
}
