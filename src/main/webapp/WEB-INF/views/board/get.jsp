<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="../includes/header.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Get</h1>
	</div>
</div>

<div class="row">
   <div class="col-lg-12">
      <div class="panel panel-default">
	
		 <div class="panel-heading">Board Get page</div>
         <div class="panel-body">            
               <div class="form-group">
                  <label>Bno</label>             
                  <input class="form-control" name='bno' value='<c:out value="${board.bno }"/>' readonly="readonly">
               </div>
			 <div class="form-group">
                  <label>Title</label>             
                  <input class="form-control" name='title' value='<c:out value="${board.title }"/>' readonly="readonly">
             </div>
			 <div class="form-group">
                  <label>Text area</label>             
                  <textarea class="form-control" rows="3" name='content'> <c:out value="${board.content }"></c:out> </textarea>
             </div>
			 <div class="form-group">
                  <label>Writer</label>             
                  <input class="form-control" name='writer' value='<c:out value="${board.writer }"/>' readonly="readonly">
             </div>
             
            
             <button  data-oper='modify' class="btn btn-default">Modify</button>
             <button  data-oper='list' class="btn btn-info">List</button>
             <button  data-oper='remove' class="btn btn-danger">Remove</button>
            
             <form action="/board/modify" method="get" id="operForm">
             	<input type="hidden" name ="bno" id="bno" value='<c:out value="${board.bno }"/>'/>
             </form>             
			</div>
	
		</div>
	</div>

</div>
<!-- 스크립트 처리 -->
<script type="text/javascript">
$(document).ready(function(){
	var operForm = $("#operForm");
	// modify
	$("button[data-oper='modify']").on("click",function(e){
		operForm.attr("action","/board/modify").submit();
	});
	// list
	$("button[data-oper='list']").on("click",function(e){
		// 목록에는 pk bno 필요없음
		operForm.find("#bno").remove();
		operForm.attr("action","/board/list")
		operForm.submit();
	});
	// remove
	$("button[data-oper='remove']").on("click",function(e){
		operForm.attr("action","/board/remove").attr("method","post").submit();
	});
});	
</script>
<%@ include file="../includes/footer.jsp" %>


















<%@ include file="../includes/footer.jsp"%>