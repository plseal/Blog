<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html >
	<head>
		<meta charset="utf-8" />
		<title>宋账本</title>
		<meta http-equiv="pragma" content="no-cache"/>   
		<meta http-equiv="Cache-Control" content="no-cache, must-revalidate"/>   
		<meta http-equiv="expires" content="0"/>
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"> 
		<link href="${pageContext.request.contextPath}/static/bootstrap3.0.0/css/bootstrap.min.css" rel="stylesheet" media="screen">
		<link href="${pageContext.request.contextPath}/static/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
		<%@include file="./css_zhangzu.jsp" %>
	</head>
	
	<body>
		<%@include file="./logo.jsp" %>
		
		<div class="container">
			
			<div class="page-content">
				
				<div class="col-sm-12 ">
					<h1>
						<small>
							<i class="icon-list-alt"></i>
							统计分析
							
						</small>
					</h1>
				</div>
				<br/>

							<!--PAGE CONTENT BEGINS-->
							
							<div class="form-group">
								<label class="col-sm-2 control-label">账单年月：</label>
								<div class="col-sm-10">
									<select class="form-control" id="zhangzu_ac" name="zhangzu_ac" >
									  <option value="2017/01">2017/01</option>
									  <option value="2017/02">2017/02</option>
									  <option value="2017/03">2017/03</option>
									  <option value="2017/04">2017/04</option>
									  <option value="2017/05">2017/05</option>
									  <option value="2017/06">2017/06</option>
									  <option value="2017/07">2017/07</option>
									  <option value="2017/08">2017/08</option>
									  <option value="2017/09">2017/09</option>
									  <option value="2017/10">2017/10</option>
									  <option value="2017/11">2017/11</option>
									  <option value="2017/12">2017/12</option>
									</select>
								</div>

							</div>
							<div class="form-group">
								<table id="sample-table-1" class="table table-striped table-bordered table-hover">
								<thead>
									<tr >
										<!--
										<th width="5%">ID</th>
										-->
										<th width="25%">年月</th>
										<th width="25%">支出</th>
										<th width="25%">收入</th>
										<th width="25%">余额</th>
>
									</tr>
								</thead>
								<tbody>
								<c:forEach items="${list_zz_analysis}"  var="zz_analysis"  >
								
									<tr >

									
										<!--
										<td><a target='_blank' href='${pageContext.request.contextPath}/blog/articles/${blog.id}.html'>${chr.id}</a></td>
										-->
										<!--
										<td>${zhangzu.id}</td>
										-->
										<td>${zz_analysis.ac}</td>
										<td><a href='${pageContext.request.contextPath}/zhangzu/to_index_zhangzu.do?AC=${zz_analysis.ac}&IO=MIN'>${zz_analysis.ac_min}</a></td>
										<td><a href='${pageContext.request.contextPath}/zhangzu/to_index_zhangzu.do?AC=${zz_analysis.ac}&IO=PLUS'>${zz_analysis.ac_plus}</a></td>
										<td>${zz_analysis.ac_result}</td>

										
									</tr>
								</c:forEach>
								</tbody>
							</table>
						</div>
						
						
						
							<div class="form-group">
								<table id="sample-table-1" class="table table-striped table-bordered table-hover">
								<thead>
									<tr >
										<!--
										<th width="5%">ID</th>
										-->
										<th width="33%">年月</th>
										<th width="33%">支出</th>
										<th width="33%">分类</th>
										
>
									</tr>
								</thead>
								<tbody>
								<c:forEach items="${list_zz_type_analysis}"  var="zz_analysis"  >
								
									<tr >

									
										<!--
										<td><a target='_blank' href='${pageContext.request.contextPath}/blog/articles/${blog.id}.html'>${chr.id}</a></td>
										-->
										<!--
										<td>${zhangzu.id}</td>
										-->
										<td>${zz_analysis.ac}</td>
										<td>${zz_analysis.ac_min}</td>
										<td>${zz_analysis.ac_type}</td>
										
										
									</tr>
								</c:forEach>
								</tbody>
							</table>
						</div>
							<!--PAGE CONTENT ENDS-->

	</div><!--/.main-container-->

	

	
<script type="text/javascript">
		
window.onload=function(){
	<c:forEach items="${list_zz_analysis}"  var="zz_analysis"  >
		$("#zhangzu_ac").val("${zz_analysis.ac}");
	</c:forEach>
}

$(document).ready(function(){ 
	$('#zhangzu_ac').change(function(){ 
		//alert($(this).children('option:selected').val()); 
		var p1=$(this).children('option:selected').val();
		 
		
		window.location.href = "<%=request.getContextPath() %>/zhangzu/to_zhangzu_analysis.do?zhangzu_ac="+p1;
	}) 
}) 
			
</script>

</div>
</body>
</html>