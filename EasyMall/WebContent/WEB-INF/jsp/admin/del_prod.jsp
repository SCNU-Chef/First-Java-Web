<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
	<head>
		<title>添加商品</title>
		<meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
		<link href="${ pageContext.request.contextPath }/css/managestyle.css" rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath}/css/prodList.css" rel="stylesheet" type="text/css">
	</head>
	<body>
	<div class="top">
		<h1>&nbsp;&nbsp;EasyMall商城管理后台</h1>
	</div>	
	<div class="content">
		<div class="left">			
			<%@ include file = "_left.jsp" %>
		</div>
	<div class="right">	
		<div>
			<div id="prod_content">
			<c:forEach items="${products}" var="prod">
				<div class="prod_div">
					<a href="${ pageContext.request.contextPath }/prodInfo?pid=${prod.id}" target="_blank">
							<img src="${ pageContext.request.contextPath }${prod.imgurl}" border="0"></img>
					</a>
					<div id="prod_name_div">
						<a href="${ pageContext.request.contextPath }/prodInfo?pid=${prod.id}" target="_blank">
							${prod.name}
						</a>
					</div>
					<div id="prod_price_div">
						￥${prod.price}元
					</div>
					<div>
						<div id="gotocart_div">
							<a href="${ pageContext.request.contextPath }/admin/delprod?pid=${prod.id}">删除</a>
						</div>					
						<div id="gotocart_div">
							<a href="">修改</a>
						</div>					
					</div>
				</div>
			</c:forEach>
			<div style="clear: both"></div>
		</div>
		</div>
	</div><!-- right结束 -->
	</div><!-- content结束 -->		
	
	
	</body>
</html>