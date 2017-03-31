<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="sidebar" id="sidebar">

	<ul class="nav nav-list">
		<li <c:if test="${sidebar=='writeBlog'}">class="active"</c:if> >
			<a href="<%=request.getContextPath()%>/blog/to_writeBlog.do">
				<i class="fa fa-file-o"></i>
				<span class="menu-text"> 发布文章 </span>
			</a>
		</li>
		<li <c:if test="${sidebar=='blogManage'}">class="active"</c:if> >
			<a href="<%=request.getContextPath()%>/blog/to_blogManage.do?pagenum=1">
				<i class="fa fa-list-alt"></i>
				<span class="menu-text"> 文章管理 </span>
			</a>
		</li>
		<li>
			<br/>
			&nbsp;&nbsp;以下为开发专用
			<br/>
		</li>
		<li <c:if test="${sidebar=='get_union_id'}">class="active"</c:if> >
			<a href="<%=request.getContextPath()%>/manager/get_union_id.do">
				<i class="fa fa-list-alt"></i>
				<span class="menu-text"> 获取UnionID </span>
			</a>
		</li>
		<li <c:if test="${sidebar=='get_access_token'}">class="active"</c:if> >
			<a href="<%=request.getContextPath()%>/manager/get_access_token.do">
				<i class="fa fa-list-alt"></i>
				<span class="menu-text"> 获取accessToken </span>
			</a>
		</li>
		<li <c:if test="${sidebar=='create-menu'}">class="active"</c:if> >
			<a href="<%=request.getContextPath()%>/manager/create-menu.do">
				<i class="fa fa-list-alt"></i>
				<span class="menu-text"> 初始微信菜单 </span>
			</a>
		</li>
		<!-- 
		<li <c:if test="${sidebar=='test'}">class="active"</c:if> >
			<a href="<%=request.getContextPath()%>/blog/to_test.do">
				<i class="fa fa-paper-plane"></i>
				<span class="menu-text"> test </span>
			</a>
		</li>
		 -->
		 <!-- 
		<li <c:if test="${sidebar=='exams'}">class="active"</c:if> >
			<a href="<%=request.getContextPath()%>/manager/exams">
				<i class="icon-file"></i>
				<span class="menu-text"> 评论管理 </span>
			</a>
		</li>

		<li <c:if test="${sidebar=='classes'}">class="active"</c:if> >
			<a href="LINGZHU4/manager/create-menu">
				<i class="icon-list-alt"></i>
				<span class="menu-text"> 初始微信菜单 </span>
			</a>
		</li>
		<li <c:if test="${sidebar=='classes'}">class="active"</c:if> >
			<a href="LINGZHU4/manager/get-access-token">
				<i class="icon-list-alt"></i>
				<span class="menu-text"> 获取accessToken </span>
			</a>
		</li>
-->
	</ul><!--/.nav-list-->
	<div class="sidebar-collapse" id="sidebar-collapse">
		<i class="icon-double-angle-left"></i>
	</div>
</div>