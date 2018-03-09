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
		<!-- CSS goes in the document HEAD or added to your external stylesheet -->
		<style type="text/css">
		table.gridtable {
			
			
			color:#333333;
			border-width: 1px;
			border-color: #666666;
			border-collapse: collapse;
		}
		table.gridtable th {
			border-width: 1px;
			padding: 8px;
			border-style: solid;
			border-color: #666666;
			text-align:center
		}
		table.gridtable td {
			border-width: 1px;
			padding: 8px;
			border-style: solid;
			border-color: #666666;
			background-color: #ffffff;
		}
		</style>



		<div class="container">
			<form  id="myform"  class="form-horizontal"  role="form">
			<div class="page-content">
				
				<div class="col-sm-12 ">
					<h1>
						<small>
							<i class="icon-list-alt"></i>
							订单查看
							
						</small>
					</h1>
				</div>
				<br/>
				
				
							<!--PAGE CONTENT BEGINS-->
							<input type="hidden" class="form-control" id="id" name="id" value="${bill.id}" placeholder=""    >
							
							<%@include file="./bill_common_contents.jsp" %>
							
							 <div class="form-group">
								<div class="col-sm-12 ">
								  <button type="button" class="btn btn-lg btn-block btn-primary" onclick="do_post()">返回</button>
								</div>
							  </div>
							<!--PAGE CONTENT ENDS-->

	</div><!--/.main-container-->

	

	
<script type="text/javascript">
window.onload=function(){

	$("#bill_status").val("${bill.bill_status}");

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
		var z_month = z_date.getMonth() + 1;
		var z_day = z_date.getDate();
		var z_YYYYMMDDday = z_year + "/" + z_month + "/" +z_day;
		
		document.getElementById("bill_date").value = z_YYYYMMDDday;
		
		//alert(z_YYYYMMDDday);
			
	    //}
	});	
    function do_post() {  
        var form = document.forms[0];  
        form.action = "${pageContext.request.contextPath}/haiyu/to_bill_status.do?FLG=INIT";  
  
        form.method = "post";  
        form.submit();  
    } 



			
</script>
</form>
</div>
</body>
</html>