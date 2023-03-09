<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false"%>
<html>
<head>
	<meta name="author" content="LiJin">
	<style>
	.btn-logout {
		display: inline-block;
		width: 120px;
		height: 36px;
		text-align: center;
		line-height: 36px;
		border-radius: 10px;
		border: 1px solid #fbc4c4;
		color: #f56c6c;
		background: #fef0f0;
		cursor: pointer;
	}
	.btn-logout:hover {
		background: #f56c6c;
		border-color: #f56c6c;
		color: #fff;
	}
	html,body{
		margin: 0;
		padding: 0;
	}
	</style>
</head>
<body style="text-align:center;font-family:'KaiTi';">
	<div style="opacity:0.6;background-image: url('${pageContext.request.contextPath}/back/img/aaa.png');background-size:100% auto;background-size: cover;height:149.6px;position:absolute;width:100%;z-index:-1"></div>
	<div style="padding-top: 8px;">
		<img src="${pageContext.request.contextPath}/back/images/logo1.png" style="position:absolute;left:20px;top:40px;width: 229px;height: 65px;"
			onclick="window.parent.location.href='${pageContext.request.contextPath}/main/main.jsp'"/>
		<div style="position:absolute;right:24px;">
			<div onclick="window.parent.location.href='${pageContext.request.contextPath}/user/logout'" class="btn-logout">安全退出</div>
		</div>
		<div style="font-size:24px;line-height:36px;position:absolute;right:162px;color:#d74b4b">当前用户:${sessionScope.phone}</div>
		<h1 style="padding-top:28px;">三味书屋管理系统</h1>
	</div>
</body>
</html>