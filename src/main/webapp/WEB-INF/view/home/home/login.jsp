<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${pageContext.request.contextPath}" var="basepath"></c:set>
<!DOCTYPE html>
<head lang="en">
<meta charset="UTF-8">
<title>登录</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="format-detection" content="telephone=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />

<link rel="stylesheet"
	href="${basepath}/css/AmazeUI-2.4.2/assets/css/amazeui.css" />
<link href="${basepath}/css/hcss/dlstyle.css" rel="stylesheet"
	type="text/css">

<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
<script type="text/javascript">
		function tologin(){
			$("#login_form").submit();
		}
		</script>
<style type="text/css">
.msg {
	color: Red;
	font-size: 18px;
	margin-left: 36px;
}
</style>
</head>

<body>

	<div class="login-boxtitle">
		<a href="home.html"><img alt="logo"
			src="${basepath}/images/himages/logobig.png" /></a>
	</div>

	<div class="login-banner">
		<div class="login-main">
			<div class="login-banner-bg">
				<span></span><img src="${basepath}/images/himages/big.jpg" />
			</div>
			<div class="login-box">

				<h3 class="title">登录商城</h3>

				<div class="clear"></div>
			<div class="msg">${msg }</div>
				<div class="login-form">
					<form method="post" action="${basepath }/user/login"
						id="login_form">
						<div class="user-name">
							<label for="user"><i class="am-icon-user"></i></label> <input
								type="text" name="email" id="user" placeholder="请输入邮箱"
								style="width: 100%" value="${email}">
						</div>
						<div class="user-pass">
							<label for="password"><i class="am-icon-lock"></i></label> <input
								type="password" name="password" id="password"
								placeholder="请输入密码" style="width: 100%" value="${password }">
						</div>
				</div>

				<div class="login-links">
					<label for="remember-me"> <input id="remember-me"
						type="checkbox" name="remeber" value="1" <c:if test="${loginStatus ==1}">checked</c:if>>记住密码
					</label> <a href="#" class="am-fr">忘记密码</a> <a
						href="${basepath }/user/toRegister"
						class="zcnext am-fr am-btn-default">注册</a> <br />
				</div>
				<div class="am-cf">
					<input type="button" onclick="tologin()" value="登 录"
						class="am-btn am-btn-primary am-btn-sm">
				</div>
			</div>
		</div>
	</div>
	</form>


	<div class="footer ">
		<div class="footer-hd ">
			<p>
				<a href="# ">商城首页</a> <b>|</b> <a href="# ">支付宝</a> <b>|</b> <a
					href="# ">物流</a>
			</p>
		</div>
	</div>
</body>
</html>