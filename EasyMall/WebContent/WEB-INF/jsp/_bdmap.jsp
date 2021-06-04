<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://"
+ request.getServerName() + ":" + request.getServerPort()
+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
<link rel="stylesheet" type="text/css" href="styles.css">
-->
<script type="text/javascript" src=" http://api.map.baidu.com/api?v=1.3"></script>
<script type="text/javascript" src="baidu/convertor.js"></script>
</head>

<body>
<div style="width:1200px;height:600px;border:1px solid gray;margin-left:10%"
id="container"></div>
<script type="text/javascript">
var map = new BMap.Map("container"); // 创建地图实例   
var longitude = "113.034801";//经度  
var latitude = "23.153172";//纬度  
var point = new BMap.Point(longitude, latitude); // 创建点坐标  
map.centerAndZoom(point, 17); // 初始化地图，设置中心点坐标和地图级别  
map.addControl(new BMap.NavigationControl()); //添加平移缩放控件  
map.addControl(new BMap.ScaleControl()); //添加放大、缩小控件  
map.enableScrollWheelZoom();//允许鼠标滑轮操作  
//坐标转换完之后的回调函数  

translateCallback = function(point) {

var marker = new BMap.Marker(point);

map.addOverlay(marker);

//根据坐标得到地址描述    
var myGeo = new BMap.Geocoder();
myGeo.getLocation(point, function(result) {
if (result) {
var label = new BMap.Label(result.address, {
offset : new BMap.Size(20, -10)
});
marker.setLabel(label);
}
});

// 将标注添加到地图中  
map.addOverlay(marker);

//将坐标设置为地图中心位置  
map.setCenter(point);
}

setTimeout(function() {
BMap.Convertor.translate(new BMap.Point(longitude, latitude), 0,
translateCallback); //真实经纬度转成百度坐标  
}, 2000);
</script>
</body>
</html>