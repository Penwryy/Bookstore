<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
	<meta name="author" content="LiJin">
	<script>
		<%-- if("${sessionScope.phone == null}"){--%>
		<%--	window.parent.location.href="${pageContext.request.contextPath}/login.jsp";--%>
		<%--}--%>
	</script>
</head>
<frameset rows="150,*" noresize="true" border="2px" bordercolor="#9A9D9F">
	<frame src="${pageContext.request.contextPath }/main/head.jsp">
	<frame name="Homepage" src="${pageContext.request.contextPath }/main/home.jsp">
</frameset>
</html>