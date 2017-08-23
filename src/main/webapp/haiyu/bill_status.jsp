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
			<form  id="myform" action="${pageContext.request.contextPath}/haiyu/check_bill.jsp" class="form-horizontal"  role="form">
			<div class="page-content">
				
				<div class="col-sm-12 ">
					<h1>
						<small>
							<i class="icon-list-alt"></i>
							订单状态
							
						</small>
					</h1>
				</div>
				<br/>
							<!--PAGE CONTENT BEGINS-->
							
							<div class="form-group">
								<label class="col-sm-2 control-label">订单1（上机印刷）：</label>
								<div class="col-sm-10">
									<div class="progress">
											<div class="progress-bar" role="progressbar" aria-valuenow="60" 
												aria-valuemin="0" aria-valuemax="100" style="width: 40%;">
												<span class="sr-only">40% 完成</span>
											</div>
									</div>								
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">订单2（接到活儿）：</label>
								<div class="col-sm-10">
									<div class="progress">
											<div class="progress-bar" role="progressbar" aria-valuenow="60" 
												aria-valuemin="0" aria-valuemax="100" style="width: 10%;">
												<span class="sr-only">10% 完成</span>
											</div>
									</div>								
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">订单3（已经交货）：</label>
								<div class="col-sm-10">
									<div class="progress">
											<div class="progress-bar" role="progressbar" aria-valuenow="60" 
												aria-valuemin="0" aria-valuemax="100" style="width: 80%;">
												<span class="sr-only">80% 完成</span>
											</div>
									</div>								
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">订单4（尾款结清）：</label>
								<div class="col-sm-10">
									<div class="progress">
											<div class="progress-bar" role="progressbar" aria-valuenow="60" 
												aria-valuemin="0" aria-valuemax="100" style="width: 100%;">
												<span class="sr-only">100% 完成</span>
											</div>
									</div>								
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">印刷流程：</label>
								<div class="col-sm-10">
									接到活儿 -- 已交定金 -- 已经发片 -- 上机印刷 -- 等待交货 -- 已经交货 -- 尾款结清								
								</div>
							</div>
							
							 <div class="form-group">
								<div class="col-sm-12 ">
								  <button type="submit" class="btn btn-lg btn-block btn-primary">点击返回</button>
								</div>
							  </div>
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