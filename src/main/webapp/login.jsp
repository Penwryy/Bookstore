<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8" import="java.util.*" isELIgnored="false"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="author" content="LiJin">
	<title>登录 - 当当网</title>
	<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/css/pop_cheat.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
	<script>
		$(function (){
			$("#send").click(function () {
				sendCode();
			})
		})
		function sendCode(){
			//通过$.get()发送异步请求
			$.get(
					"${pageContext.request.contextPath}/user/sendCode",
					"phone="+$("#txtUsername").val(),
					function (result){
						if(result==="ok"){
							alert("验证码已经发送！");
						}else{
							if (result==="验证码已发送"){
								alert("请稍后再试");
							}else{
								alert(result);
							}
						}
					},
					"text"
			);
		}
	</script>
</head>
<body>
	<div class="head">
		<a href="http://www.dangdang.com"> <img src="${pageContext.request.contextPath }/images/signin_logo.png" /></a>
		<div class="improve">
			<img src="${pageContext.request.contextPath }/images/bz.jpg" width="178" height="61" />
		</div>
	</div>

	<div class="login_bg" style="width:960px; margin:0 auto;">
		<img src="http://a.dangdang.com/api/data/cpx/img/38930001/1" style="display: none;">
		<div id="J_cheatProofTop" class="new_tip">
			<div id="component_2747856"></div>
			<div>为保障账户安全，请勿向任何人透露您的验证码，<a href="javascript:;">谨防诈骗</a>！</div>
		</div>
		<div class="set_area clearfix">
			<div class="wrap clearfix">
				<div id="J_loginDiv">
					<form action="${pageContext.request.contextPath }/user/checkCode" method="post">
						<span style="color:red;font-size: 21px;margin-left: 45px;">${sessionScope.message}</span>
						<div id="J_loginCoreWrap" class="infro">
							<div class="username" id="username_div">
								<span></span> <input class="user" id="txtUsername" name="phone" type="text" placeholder="请输入手机号"/>
							</div>
							<br /><br />

							<div class="password" id="password_div">
								<span></span> <input class="pass" id="txtPassword" name="code" type="text" placeholder="请输入验证码"/>
								<br/><br/><br/>
								<input type="button" id="send" value="发送验证码"/>
							</div>
							<br /> <br /><br /><br />
							<p class="btn">
								<input id="submitLoginBtn" type="submit" value="登&nbsp;录" />
							</p>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>