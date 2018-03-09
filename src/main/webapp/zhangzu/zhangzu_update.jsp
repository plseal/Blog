<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html >
	<head>
		<meta charset="utf-8" />
		<title>流水帐更新</title>
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
			<form  id="myform"  class="form-horizontal"  role="form">
			<div class="page-content">
				
				<div class="col-sm-12 ">
					<h1>
						<small>
							<i class="icon-list-alt"></i>
							流水帐更新
							
						</small>
					</h1>
				</div>
				<br/>
							<!--PAGE CONTENT BEGINS-->
							<input type="hidden" class="form-control" id="id" name="id" value="${zhangzu.id}" placeholder=""    >
							<div class="form-group">
								<label class="col-sm-2 control-label">日期：</label>
								 <div class="col-sm-10 ">
									<div class="input-group date form_date " data-date="${zhangzu.z_date}" data-date-format="yyyy/mm/dd" data-link-field="dtp_input2" data-link-format="yyyy/mm/dd">
										<input  id="child_birth" class="form-control" size="16" type="text" value="${zhangzu.z_date}" readonly >
										<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
										<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
									</div>
									<input type="text" id="z_date" name="z_date" style="display:none" value="${zhangzu.z_date}" check-type="required" required-message="请输入日期"><br/>
								 </div>
								
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">名称：</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="z_name" name="z_name" value="${zhangzu.z_name}" placeholder=""    >							
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">金额：</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="z_amount" name="z_amount" value="${zhangzu.z_amount}" placeholder=""    >							
								</div>
							</div>
							<%@include file="./zhangzu_type.jsp" %>

							<div class="form-group">
								<label class="col-sm-2 control-label">收支：</label>
								<div class="col-sm-10">
									<select class="form-control" id="z_io_div" name="z_io_div" >
									  <option value="支出">支出</option>
									  <option value="收入">收入</option>
									  <option value="买货">买货</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">备注：</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="z_remark" name="z_remark" value="${zhangzu.z_remark}" placeholder=""    >								

								</div>
							</div>


							 <div class="form-group">
								<div class="col-sm-12 ">
								  <button type="button" class="btn btn-lg btn-block btn-primary" onclick="do_post()">更新</button>
								</div>
							  </div>
							 <div class="form-group">
								<div class="col-sm-12 ">
								  <button type="button" class="btn btn-lg btn-block button-caution" onclick="do_delete()">删除</button>
								</div>
							  </div>
							<!--PAGE CONTENT ENDS-->

	</div><!--/.main-container-->

	

	
<script type="text/javascript">
window.onload=function(){

	$("#z_type").val("${zhangzu.z_type}");
	$("#z_io_div").val("${zhangzu.z_io_div}");

}
function do_post() {  
	var form = document.forms[0];  
	form.action = "${pageContext.request.contextPath}/zhangzu/to_index_zhangzu.do?FLG=UPDATE";  

	form.method = "post";  
	form.submit();  
}
function do_delete() {  
	var form = document.forms[0];  
	form.action = "${pageContext.request.contextPath}/zhangzu/to_index_zhangzu.do?FLG=DELETE";  

	form.method = "post";  
	form.submit();  
} 
	


var year = new Date().getFullYear();
var month = new Date().getMonth() + 1;
var day = new Date().getDate();
var today = year + "/" + month + "/" +day;
//alert(today);
$('.form_date').datetimepicker({
	language:  'zh-CN',
	weekStart: 1,
	todayBtn:  1,
	autoclose: 1,
	todayHighlight: 1,
	startView: 2,
	minView: 2,
	endDate: today,
	forceParse: 0
});	

$('.form_date').on('changeDate', function(ev){

	var nowdate = new Date();
	var z_date = ev.date;

	var z_year = z_date.getFullYear();
	var z_month = ("00" + (z_date.getMonth()+1)).slice(-2);
	var z_day = ("00" + z_date.getDate()).slice(-2);
	
	var z_YYYYMMDDday = z_year + "/" + z_month + "/" +z_day;
	
	document.getElementById("z_date").value = z_YYYYMMDDday;
	
	//alert(z_YYYYMMDDday);
		
	//}
});	
</script>
</form>
</div>
</body>
</html>