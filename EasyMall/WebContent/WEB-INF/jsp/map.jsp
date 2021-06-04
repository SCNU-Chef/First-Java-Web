<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/index.css"/>
		<title>欢迎光临EasyMall</title>
	</head>
	<body>
	<!-- 将头部(_head.jsp)包含进来 -->
	<jsp:include page="_head.jsp"/>
	
	<!-- 将百度地图(_bdmap.jsp)包含进来 -->
	<jsp:include page="_bdmap.jsp"/>
	
	<!-- 将脚部(_foot.jsp)包含进来 -->
	<jsp:include page="_foot.jsp"/>
	</body>
</html>
