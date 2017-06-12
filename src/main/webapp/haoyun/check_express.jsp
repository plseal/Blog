<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html >
	<head>
		<meta charset="utf-8" />
		<title>快递单号管理</title>
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

			<div class="page-content">
				
				<div class="col-sm-12 ">
					<h1>
						<small>
							<i class="icon-list-alt"></i>
							快递单号管理 （演示用）
						</small>
					</h1>
				</div>
				<br/>
							<!--PAGE CONTENT BEGINS-->
							<div class="col-sm-12 ">
							  <button type="button" class="btn btn-lg btn-block btn-primary" onclick="location.href = '<%=request.getContextPath() %>/haoyun/check_express_get.jsp';">查询快递单号</button>
							</div>
							<br/>
							<div class="col-sm-12 ">
							  <button type="button" class="btn btn-lg btn-block btn-primary" onclick="location.href = '<%=request.getContextPath() %>/haoyun/check_express_insert.jsp';">添加快递单号</button>
							</div>
							<br/>
							<br/>
							<table id="sample-table-1" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										
										<th width="33%">姓名</th>
										<th width="33%">快递单号</th>
										<th width="23%">快递日期</th>
										<th width="10%">操作</th>
									</tr>
								</thead>
								<tbody>
								
									<tr>
									<!--
										<td><a target='_blank' href='${pageContext.request.contextPath}/blog/articles/${blog.id}.html'>${chr.id}</a></td>
										-->
										<td>赵云</td>
										<td>1234567890</td>
										<td>2017/6/12</td>
										<td>
										<button class="btn btn-info btn-small" onclick="javascript:window.location.href='<%=request.getContextPath() %>/haoyun/check_express_update.jsp'">
											编辑
										</button>
										</td>
										
									</tr>
									<tr>
									<!--
										<td><a target='_blank' href='${pageContext.request.contextPath}/blog/articles/${blog.id}.html'>${chr.id}</a></td>
										-->
										<td>张飞</td>
										<td>1234567890</td>
										<td>2017/6/12</td>
										<td>
										<button class="btn btn-info btn-small" onclick="javascript:window.location.href='<%=request.getContextPath() %>/haoyun/check_express_update.jsp'">
											编辑
										</button>
										</td>
										
									</tr>
									<tr>
									<!--
										<td><a target='_blank' href='${pageContext.request.contextPath}/blog/articles/${blog.id}.html'>${chr.id}</a></td>
										-->
										<td>关羽</td>
										<td>1234567890</td>
										<td>2017/6/12</td>
										<td>
										<button class="btn btn-info btn-small" onclick="javascript:window.location.href='<%=request.getContextPath() %>/haoyun/check_express_update.jsp'">
											编辑
										</button>
										</td>
										
									</tr>
								</tbody>
							</table>
							<!--PAGE CONTENT ENDS-->

	</div><!--/.main-container-->

	

	
	<script type="text/javascript">
		
		
		
		
	</script>

	</div>
	</body>
</html>