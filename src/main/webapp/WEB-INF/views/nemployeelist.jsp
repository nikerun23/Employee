<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>직원 관리</title>

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>


<script>
$(document).ready(function() {
	
	//검색 진행후 검색 키워드가 화면에 그대로 남아있도록 액션 추가
	//->검색 폼 부분에 기존 검색 키워드를 재설정
	$("input#value").val("${value}");
	$("select#key option[value='${key}']").attr("selected","selected");
	
	
	//사진보기 버튼에 대한 클릭 이벤트 등록
	//->Ajax 요청 및 응답 처리
	$("button.picture").on("click", function() {
		
		//서버에 사진 정보를 확인하기 위한 직원번호를 전송한다.
		var employeeId = $(this).val();
		var name = $(this).parent().find("span").text();
		
		$.post("ajaxpicture.it", {employeeId:employeeId},  function(data) {
			//Ajax 응답으로 받은 사진 파일명을 가지고 이미지 출력
			console.log(data);
			
			//제목(이름) 동적 출력 과정 추가
			$("div#pictureModal h4").text(name+"의 사진");
		
			//이미지 동적 출력 과정 추가
			$("div#pictureModal img").attr("src", "picture/"+data);
			
			//modal 창 호출 액션 
			$("div#pictureModal").modal();
			
		});
		
		
	});
	
	
}); //ready 이벤트


</script>

</head>
<body>
	<div class="container">
		<div style="margin-bottom: 1%;">
			<div>
				<h1 style="font-size: x-large;">
					<img src="${pageContext.request.contextPath}/resources/img/logo.png" alt="logo"
					style="vertical-align: bottom;"> 직원관리<small>v2.0</small>
				</h1>
			</div>
			<div>
				<ul class="nav nav-pills nav-justified ">

					<li class="active"><a href="nemployeelist.it">직원관리</a></li>
					
					<%-- 세션 정보를 EL 표현으로 출력 --%>
					<li><a href="j_spring_security_logout" style="color: red">${pageContext.request.userPrincipal.name} 로그아웃</a></li>
					
					
				</ul>
			</div>

		</div>
		<div class="panel-group">
			<div class="panel panel-default">
				<div class="panel-heading">직원 출력</div>
				<div class="panel-body">
				
					<%-- form 태그에서 action="" 속성 생략하면 서브밋 주소가 자기 자신이 된다. --%>
					<form class="form-inline" role="form" method="post">
						<select class="form-control" id="key" name="key">
							<option value="1">번호</option>
							<option value="2">이름</option>
							<option value="3">지역</option>
							<option value="4">부서</option>
							<option value="5">직위</option>
						</select> <label for="name"></label> <input type="text"
							class="form-control" id="value" name="value"
							required="required">
						<button type="submit" class="btn btn-default">
							<span class="glyphicon glyphicon-search"></span> Search
						</button>
					</form>


					<table class="table">
						<thead>
							<tr>
								<th>번호</th>
								<th>이름</th>
								<th>생년월일</th>
								<th>양음력</th>
								<th>전화번호</th>
								<th>지역명</th>
								<th>부서명</th>
								<th>직위명</th>
								<th>기본급</th>
								<th>수당</th>
								<th>급여</th>
							</tr>
						</thead>
						<tbody>
						
							<!-- 						
							<tr>
								<td>1</td>
								<td>
									<span>홍길동</span>
									<button type="button" class="btn btn-default btn-xs"
										data-toggle="modal" data-target="#myModal">사진</button>
								</td>
								<td>1980-12-12</td>
								<td>양력</td>
								<td>010-123-1234</td>
								<td>서울</td>
								<td>개발부</td>
								<td>사원</td>
								<td>1,500,000</td>
								<td>1,000,000</td>
								<td>2,500,000</td>
							</tr>
							 --> 
							 <c:forEach var="emp" items="${list}">
							 <tr>
								<td>${emp.employeeId}</td>
								<td>
									<span>${emp.name}</span>
									<c:if test="${not empty emp.employeePicFileName}">
									<button type="button" class="btn btn-default btn-xs picture" value="${emp.employeeId}">사진</button>
									</c:if>
								</td>
								<td>${emp.birthday}</td>
						 		<td>${emp.lunarName}</td>
						 		<td>${emp.telephone}</td>
						 		<td>${emp.regionName}</td>
						 		<td>${emp.departmentName}</td>
						 		<td>${emp.positionName}</td>
						 		<td><fmt:formatNumber value="${emp.basicPay}" groupingUsed="true"></fmt:formatNumber></td>
						 		<td><fmt:formatNumber value="${emp.extraPay}" groupingUsed="true"></fmt:formatNumber></td>
						 		<td><fmt:formatNumber value="${emp.pay}" groupingUsed="true"></fmt:formatNumber></td>
							</tr>
							 </c:forEach>

						</tbody>
					</table>

					<form class="form-inline" role="form" method="post">
						<button type="button" class="btn btn-default">
							<%-- TotalCount <span class="badge">2</span> --%>
							TotalCount <span class="badge">${totalcount}</span>
						</button>
						<button type="button" class="btn btn-default">
							<%-- Count <span class="badge">1</span> --%>
							Count <span class="badge">${count}</span>
						</button>
					</form>

				</div>
			</div>
		</div>

		<div id="pictureModal" class="modal fade" role="dialog">
			<div class="modal-dialog modal-sm">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						
						<%-- 사진 보기 선택한 사용자의 이름 출력 --%>
						<h4 class="modal-title">홍길동의 사진</h4>
						
					</div>
					<div class="modal-body">
						<div style="text-align: center;">
						
							<%-- Ajax 요청에 대한 응답 결과를 가지고 이미지 처리 --%>
							<img src="picture/noimage.jpg" width="100%">
							
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>

			</div>
		</div>

	</div>

</body>
</html>