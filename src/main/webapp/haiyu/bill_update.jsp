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
			<form  id="myform" action="${pageContext.request.contextPath}/haiyu/bill_list_update.jsp" class="form-horizontal"  role="form">
			<div class="page-content">
				
				<div class="col-sm-12 ">
					<h1>
						<small>
							<i class="icon-list-alt"></i>
							订单更新
							
						</small>
					</h1>
				</div>
				<br/>
							<!--PAGE CONTENT BEGINS-->
							
							<div class="form-group">
								<label class="col-sm-2 control-label">客户名称：</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="customer_name" name="customer_name" value="李田田代购公司" placeholder=""    >							
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">联系人：</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="customer_contact" name="customer_contact" value="李田田" placeholder=""    >							
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">联系电话：</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="customer_tel" name="customer_tel" value="13426494750" placeholder=""    >							
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">印品名称：</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="bill_name" name="bill_name" value="广告" placeholder=""    >								
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">印刷数量：</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="bill_num" name="bill_num" value="100" placeholder=""    >								
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">印品单价：</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="bill_unit_price" name="bill_unit_price" value="10" placeholder=""    >								
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">印品总价：</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="bill_all_price" name="bill_all_price" value="1000" placeholder=""    >								
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">印刷要求：</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="bill_require" name="bill_require" value="铜版纸" placeholder=""    >								
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">订单状态：</label>
								<div class="col-sm-10">
									<div class="btn-group btn-group-sm">
									<button type="button" class="btn btn-default">接到活儿</button>
									<button type="button" class="btn btn-default">已交定金</button>
									<button type="button" class="btn btn-default">已经发片</button>
									<button type="button" class="btn btn-default">上机印刷</button>
									<button type="button" class="btn btn-default">等待交货</button>
									<button type="button" class="btn btn-default">已经交货</button>
									<button type="button" class="btn btn-default">尾款结清</button>
									</div>
								</div>
							</div>

							 <div class="form-group">
								<div class="col-sm-12 ">
								  <button type="submit" class="btn btn-lg btn-block btn-primary">提交暂不可用点击返回</button>
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