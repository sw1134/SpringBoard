<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="../includes/header.jsp"%>
<!-- Model에 담긴 데이터 출력
	-> BoardController에서 Model을 이용 -> 키명 list에 service에 있는 메서드 리턴값을 담음
	=> JSTL 이용 출력함 -->
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board</h1>
	</div>
</div>

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				Board List Pages
				<button id="regBtn" type="button" class="btn btn-xs pull-right btn-primary">
					Register
				</button>
			</div>
			<div class="panel-body">
				<table width="100%" class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>#번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>수정일</th>
						</tr>
					</thead>
					<c:forEach items="${list }" var="board">
						<tr>
							<td><c:out value="${board.bno }"/></td>
							<td><a href='/board/get?bno=<c:out value="${board.bno}"/>'><c:out value="${board.title }"/></a></td>
							<td><c:out value="${board.writer }"/></td>
							<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regdate }"/></td>
							<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.updatedate }"/></td>
						</tr>
					</c:forEach>					
				</table>
<!-- Modal -->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog" 
					aria-labelledby="myModalLabel" aria-hidden="true">
	                <div class="modal-dialog">
	                    <div class="modal-content">
	                        <div class="modal-header">
	                            <button type="button" class="close" data-dismiss="modal" 
	                            	aria-hidden="true">&times;</button>
	                            <h4 class="modal-title" id="myModalLabel">Modal 모달창</h4>
	                        </div>
	                        <div class="modal-body">
	                            처리가 완료되었습니다.
	                        </div>
	                        <div class="modal-footer">
	                            <button type="button" class="btn btn-default" 
	                            data-dismiss="modal">닫기</button>
<!-- 	                            <button type="button" class="btn btn-primary" data-dismiss="modal">확인</button> -->
	                        </div>
	                    </div>
	                </div>
	            </div>				
<!-- /Modal -->					
			</div>
		</div>
	</div>
</div>
<%@ include file="../includes/footer.jsp"%>

<!-- 모달창, 글쓰기 버튼 스크립트 -->
<script type="text/javascript">
	$(document).ready(function(){	
		// 글번호 변수에 담기
		var result = '<c:out value="${result}" />';
		// 함수 호출
		checkModel(result);
		
		// 뒤로가기 문제 해결 = 모달창 한번 보여준 후 스택의 상단에 모달창이 필요하지 않다는 표시를 해주어야 함
// {}=현재 페이지와 관련된 정보 = 현재 상태를 나타내는 객체, 두번째 인수 = 새로운 URL => null이므로 현재 URL이 변경되지 않음
		history.replaceState({},null,null);
// history는 브라우저 동작을 스택으로 기록하면서 쌓아놓음.
		/* 실행 함수 */
		function checkModel(result) {
			if (result === '' || history.state){ // 글번호가 없거나, history 상태 체크
				return;
			}
			if (parseInt(result) > 0){ // 있으면
				$(".modal-body").html("게시글 " + parseInt(result) + " 번이 등록되었습니다.")
			}
			$("#myModal").modal("show");
		}
			
		/* 글쓰기 버튼 클릭시 글쓰기 페이지 이동 */
		$('#regBtn').on('click',function(){
			location.href = "/board/register";
		});
	});
</script>


