<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html >
	<head>
		<meta charset="utf-8" />
		<title></title>
		<meta http-equiv="pragma" content="no-cache"/>   
		<meta http-equiv="Cache-Control" content="no-cache, must-revalidate"/>   
		<meta http-equiv="expires" content="0"/>
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"> 
		<link href="${pageContext.request.contextPath}/static/bootstrap3.0.0/css/bootstrap.min.css" rel="stylesheet" media="screen">
		<link href="${pageContext.request.contextPath}/static/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
		<%@include file="./css_haoyun.jsp" %>
		
	</head>
	
	<body>
		<%@include file="./logo.jsp" %>
		<div class="container">
			<form action="./check_express.jsp" class="form-horizontal"  role="form">
				<fieldset>
				<div class="page-content">
					<div class="col-sm-12 ">
						<h1>
							<small>
								<i class="icon-list-alt"></i>
								快递单号查询 客户用（演示用 需要关联wechat信息）
							</small>
						</h1>
					</div>
					<br/>

							<!--PAGE CONTENT BEGINS-->
							<table id="sample-table-1" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										
										<th width="14%">日期</th>
										<th width="14%">姓名</th>
										<th width="14%">运单编号</th>
										<th width="14%">目的地</th>
										<th width="14%">包裹内容</th>
										<th width="14%">发货专区</th>
										<th width="14%">备注</th>
									</tr>
								</thead>
								<tbody>
								
									<tr>
									<!--
										<td><a target='_blank' href='${pageContext.request.contextPath}/blog/articles/${blog.id}.html'>${chr.id}</a></td>
										-->
										<td>1.2</td>
										<td>杨文</td>
										<td>350633127859</td>
										<td>杭州</td>
										<td>化妆棉4 </td>
										<td>日本 </td>
										<td>angelhood百世汇通 </td>
									</tr>
								
								</tbody>
							</table>
						 <div class="form-group">
							<div class="col-sm-12 ">
							  <button type="submit" class="btn btn-lg btn-block btn-primary">点击返回</button>
							</div>
						  </div>
				</fieldset>
			</form>
		      
							<!--PAGE CONTENT ENDS-->

	</div><!--/.main-container-->

	

	
	<script type="text/javascript">
		
		
		
		
	</script>

	</div>
	</body>
</html>