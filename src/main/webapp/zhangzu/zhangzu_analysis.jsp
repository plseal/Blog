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
		

							<!--PAGE CONTENT ENDS-->

	</div><!--/.main-container-->

	

	
<script type="text/javascript">
		
function get_express_by_name(){
	var c_name = document.all.c_name.value;
	
	//alert(getEx(file_name).toString().toLowerCase());
	if (c_name == ""){
		$("#div_alert_c_name_blank").attr("class","alert alert-danger");
	}else {
		document.all.myform.action="${pageContext.request.contextPath}/haoyun/get_express_by_name.do?c_name="+c_name;
		document.all.myform.submit(); 
	}

}
function get_express_by_number(){
	var c_number = document.all.c_number.value;
	
	if (c_number == ""){
		$("#div_alert_c_number_blank").attr("class","alert alert-danger");
	}else {
		document.all.myform.action="${pageContext.request.contextPath}/haoyun/get_express_by_number.do?c_number="+c_number;
		document.all.myform.submit(); 
	}

}

			
</script>

</div>
</body>
</html>