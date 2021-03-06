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
							新增订单
							
						</small>
					</h1>
				</div>
				<br/>
							<!--PAGE CONTENT BEGINS-->
							
							<div class="form-group">
								<label class="col-sm-2 control-label">客户名称：</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="customer_name" name="customer_name" value="" placeholder=""    >							
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">联系人：</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="customer_contact" name="customer_contact" value="" placeholder=""    >							
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">联系电话：</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="customer_tel" name="customer_tel" value="" placeholder=""    >							
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">印品名称：</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="bill_name" name="bill_name" value="" placeholder=""    >								
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">印刷数量：</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="bill_num" name="bill_num" value="" placeholder=""    >								
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">印品单价：</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="bill_unit_price" name="bill_unit_price" value="" placeholder=""    >								
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">印品总价：</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="bill_all_price" name="bill_all_price" value="" placeholder=""    >								
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">印刷要求：</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="bill_require" name="bill_require" value="" placeholder=""    >								
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">订单状态：</label>
								<div class="col-sm-10">
									<select class="form-control" id="bill_status" name="bill_status" >
									  <option value="接到活儿">接到活儿</option>
									  <option value="已交定金">已交定金</option>
									  <option value="已经发片">已经发片</option>
									  <option value="上机印刷">上机印刷</option>
									  <option value="等待交货">等待交货</option>
									  <option value="已经交货">已经交货</option>
									  <option value="尾款结清">尾款结清</option>
									</select>
								</div>
							</div>

							 <div class="form-group">
								<div class="col-sm-12 ">
								  <button type="button" class="btn btn-lg btn-block btn-primary"onclick="do_post()">提交</button>
								</div>
							  </div>
							<!--PAGE CONTENT ENDS-->

	</div><!--/.main-container-->

	

	
<script type="text/javascript">
	

    function do_post() {  
        var form = document.forms[0];  
        form.action = "${pageContext.request.contextPath}/haiyu/to_bill_list_update.do?FLG=INSERT";  

        form.method = "post";  
        form.submit();  
    } 



			
</script>
</form>
</div>
</body>
</html>