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
		<link href="${pageContext.request.contextPath}/static/css/haoyun.css" rel="stylesheet" media="screen">
		
	</head>
	
	<body>
		<header class="main-header">  <!--创建头部-->
			<div class="container">   <!--头部存放容器-->
				<div class="row">     <!--在容器使用栅格系统-->
					<div class="col-md-12"><!--头部只包含一个内容，故应占整个部分-->
						<a href="branding" href="http://www.jikexueyuan.com title="Ghos开源博客">
							<img src="http://static.ghostchina.com/image/b/46/4f5566c1f7bc28b3f7ac1fada8abe.png">
							<h2 class="text-hide">现在你看到的是BootStrap实战实例</h2>
						</a>
					</div>
				</div>
			</div>
		</header>
		<div class="container">

				 
				<div class="page-content">
					<div class="page-header position-relative">
						<h1>
							<small>
								<i class="icon-list-alt"></i>
								快递单号管理 （演示用）
							</small>
						</h1>
					</div> 

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