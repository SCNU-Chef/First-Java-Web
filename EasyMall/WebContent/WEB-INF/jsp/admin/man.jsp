<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>后台管理页面</title>
		<meta charset="utf-8"/>
		<link href="${ pageContext.request.contextPath }/css/managestyle.css" rel="stylesheet" type="text/css">
		<script src="${ pageContext.request.contextPath }/js/echarts.js"></script>
	</head>
	<body>
	<div class="top">
		<h1>&nbsp;&nbsp;EasyMall商城管理后台</h1>
	</div>	
	<div class="content">
		<div class="left">			
			<%@ include file = "_left.jsp" %>
<%-- 			<%@ include file = "WEB-INF/jsp/admin/_left.jsp" %> --%>
			
		</div>
		<div class="right">	
			<%@ include file = "_echart.jsp" %>
<%-- 			<%@ include file = "WEB-INF/jsp/admin/_echart.jsp" %> --%>
		</div>
	</div>		
	</body>	
</html>