<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html >
	<head>
		<meta charset="utf-8" />
		<title>印刷订单管理</title>
		<meta http-equiv="pragma" content="no-cache"/>   
		<meta http-equiv="Cache-Control" content="no-cache, must-revalidate"/>   
		<meta http-equiv="expires" content="0"/>
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"> 
		<link href="${pageContext.request.contextPath}/static/bootstrap3.0.0/css/bootstrap.min.css" rel="stylesheet" media="screen">
		<link href="${pageContext.request.contextPath}/static/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
		<%@include file="./css_haiyu.jsp" %>
	</head>
	
	<body>
		<%@include file="./logo.jsp" %>
		
		<div class="container">
			<form  id="myform" action="" class="form-horizontal"  role="form">
			<div class="page-content">
				
				<div class="col-sm-12 ">
					<h1>
						<small>
							<i class="icon-list-alt"></i>
							印刷订单管理 
						</small>
					</h1>
				</div>
				<br/>
							<!--PAGE CONTENT BEGINS-->
							<div class="row">
								<div class="col-sm-12 ">
								  <button type="button" class="btn btn-lg btn-block btn-primary" onclick="location.href = '${pageContext.request.contextPath}/haiyu/to_bill_status.do';">查询订单状态</button>
								</div>
							</div><br/>
							<div class="row">
								<div class="col-sm-12 ">
								  <button type="button" class="btn btn-lg btn-block btn-info" onclick="location.href = '${pageContext.request.contextPath}/haiyu/to_bill_list_update.do?FLG=SELECT';">更新订单状态</button>
								</div>
							</div><br/>
		
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
</form>
</div>
</body>
</html>