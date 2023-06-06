<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.jquery.ajax.dao.CommentDAO" %>
<%@ page import="com.jquery.ajax.dto.CommentDTO" %>
<%@ page import ="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>CommentLIST</title>
	<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$.ajax(
					{
						url : "CommentList.4zo",  
						dataType : "JSON",           
						async : true ,
						type : "POST",
						success : function(data)
						{	
							PrintData(data);	
						},
						error: function(){
							console.log("에러");
						}
					}
			);
			
			//데이터 출력
			function PrintData(data){
				$('#container').find("table tr").not(":first").remove();
				
				$.each(data, function(){
					//console.log(this);
					$('#container').find("table tr:last").after(
						"<tr>"
						+ " <td>" + this.seq + "</td>"
						+ " <td>" + this.comment + "</td>"
						+ " <td><button seq='" + this.seq +"'>삭제</button></td>"
						+ "</tr>"
					);
				});
				$('#comment').val();
			}
			
			
			//데이터 추가
			$('#addBtn').on("click",function(){
				if($.trim($('#comment').val()) == "")
				{
					alert("덧글을 입력하세여");
					$('#comment').focus();
					return false;
				}
				var data2 = {
						      comment : $.trim($('#comment').val())  
				            };
				$.ajax(
						{
							url : "CommentAdd.4zo",  
							dataType : "JSON",           
							async : true ,
							type : "POST",
							data : data2,
							success : function(data)
							{	
								PrintData(data);		
							},
							error: function(){
								console.log("에러");
							}
						}	
				);
				$('#comment').val('');
			});
			
			//데이터 삭제
			$('#container').on("click","button",function(){
				var data = {
					      seq : $(this).attr("seq")     
				            };
				$.getJSON('CommentDel.4zo',data)
				 .done(function(data){
					 PrintData(data);
				 }) //ajax > success
				 .fail(function(){console.log('delete fail');}) 
				 .always(function(){console.log('delete always');})
				 ;
			});
		});
	
	</script>
</head>
<body>
	<table width="700px" border="1">
		<tr>
			<th width="200px">번호</th>	
			<td>1</td>
		</tr>
		<tr>
			<th width="200px">제목</th>	
			<td>Jquery 넘 재미있어요</td>
		</tr>
		<tr>
			<th width="200px">내용</th>	
			<td>당황하지 않고 Jquery 보면...</td>
		</tr>
	</table>
	<br>
	<!-- 덧글 입력  -->
	<div>
		<input type="text" name="comment" id="comment" style="width: 600px;" placeholder="덧글을 입력하세요"> 
		<button id="addBtn">덧글등록</button>
		<br>
		<div id="container">
			<table border="1">
				<tr>
					<td>순번</td>
					<td>내용</td>
					<td>삭제</td>
				</tr>
				<c:forEach var="comment" items="${requestScope.commentList}">
						<tr>
							<td>${comment.seq}</td>
							<td>${comment.comment}</td>
							<td>
								<button seq="${comment.seq}">삭제</button>
							</td>
						</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<hr>
	<table id="tbllist" border="1">
	</table>
</body>
</html>










