<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${pageContext.request.contextPath}" var="basepath"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head lang="en">
<meta charset="UTF-8">
<title>注册</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="format-detection" content="telephone=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />

<link rel="stylesheet"
	href="${basepath}/css/AmazeUI-2.4.2/assets/css/amazeui.min.css" />
<link href="${basepath}/css/hcss/dlstyle.css" rel="stylesheet"
	type="text/css">
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
<script src="${basepath}/css/AmazeUI-2.4.2/assets/js/amazeui.min.js"></script>
<!-- 加载validate验证框架的jar包 -->
<script type="text/javascript"
	src="${basepath}/js/vjs/jquery.validate.js"></script>
<script type="text/javascript"
	src="${basepath }/js/vjs/additional-methods.js"></script>
<script type="text/javascript">
	function onsub() {
		/* window.open('${basepath}/user/test01', '', 'height=400, width=400, top=230, left=600, toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no'); */
		var ischeck = $('#reader-me').is(':checked');
		var email = $("#email").val();
		var password = $("#password").val();
		var confirmPassword = $("#confirm_password").val();
		var vcode = $("#vcode").val();
		var b = onblurToVcode();
		if (b) {
			if (email != '' && password != '' && confirmPassword != null
					&& vcode != null) {
				if (ischeck) {
					/* 	$("#register_form").submit();  */
					$.post("${basepath}/user/insertEmail", {
						"email" : email,
						"password" : password,
						"vcode" : vcode
					}, function(data) {
						if(data == '注册成功'){
							 alert("恭喜你注册成功，两秒后跳转。");   
							 setTimeout(function(){//两秒后跳转  
                                 location.href = "${basepath}/user/toLogin";//PC网页式跳转  
                              },2000);  
						}
						$("#code_msg").html(data);
						setTimeout(function() {
							$("#code_msg").html('');
						}, 3000);
					});
				} else {
					alert("请同意商城《服务协议》");
				}
			}
		}
	}

	//检查验证码是否为空
	function onblurToVcode() {
		var vcode = $("#vcode").val();
		if (vcode == null || vcode == '') {
			$("#code_msg").html("请输入验证码");
			setTimeout(function() {
				$("#code_msg").html('');
			}, 3000);
			return false;
		}
		return true;
	}

	//使用Ajax判断用户名是否存在
	function checkEmail() {
		var email = $("#email").val();
		$.post("${basepath}/user/checkEmail", {
			"email" : email
		}, function(data) {
			$("#email_msg").html(data.msg);
		});
	}

	//发送验证码
	function sendEmail() {
		var email = $("#email").val();
		$.post("${basepath}/user/sendEmail", {
			"email" : email
		}, function(data) {
			if (data) {
				$("#code_msg").html("验证码发送成功");
				setTimeout(function() {
					$("#code_msg").html('');
				}, 3000);
			}
		});
	}

	//倒计时
	var countdown = 60;
	function settime() {
		var btn = $(".getCode").html();
		if (countdown == 0) {
			 $(".getCode").attr("disabled", false);
			 $(".getCode").html('获取验证码');
			countdown = 60;
			return false;
		} else {
			 $(".getCode").attr("disabled", true);
			 $(".getCode").html("重新发送(" + countdown + ")"); 
			countdown--;
		}
		setTimeout(function() {
			settime();
		}, 1000);
	}

	//触发valiate框架
	$(function() {
		$("#register_form").validate({
			rules : {
				email : {
					required : true,
					email : true
				},
				password : {
					required : true,
					minlength : 6
				},
				confirm_password : {
					required : true,
					minlength : 6,
					equalTo : "#password"
				},
			},
			messages : {
				password : {
					required : "请输入密码",
					minlength : "密码长度不能小于6位"
				},
				confirm_password : {
					required : "请输入密码",
					minlength : "密码长度不能小于6位",
					equalTo : "两次密码输入不一致"
				},
				email : "请输入一个正确的邮箱"
			}
		});
	});
</script>
<style type="text/css">
#register_form label.error {
	color: Red;
	width: 40%;
	font-size: 13px;
	margin-left: 221px;
	margin-top: -14px;
	background-color: #F8F8F8;
	padding-left: 16px;
}

#email_msg, #code_msg {
	color: Red;
	font-size: 13px;
	margin-left: 36px;
}
</style>
</head>

<body>

	<div class="login-boxtitle">
		<a href="home/demo.html"><img alt=""
			src="${basepath}/images/himages/logobig.png" /></a>
	</div>

	<div class="res-banner">
		<div class="res-main">
			<div class="login-banner-bg">
				<span></span><img src="${basepath}/images/himages/big.jpg" />
			</div>
			<div class="login-box">

				<div class="am-tabs" id="doc-my-tabs">
					<ul class="am-tabs-nav am-nav am-nav-tabs am-nav-justify">
						<li class="am-active"><a href="">注册</a></li>
					</ul>
					<div class="am-tabs-bd">
						<div class="am-tab-panel am-active">
							<form method="post" action="${basepath }/user/insertEmail"
								id="register_form">

								<div class="user-email">
									<p>
										<label for="email"><i class="am-icon-envelope-o"></i></label>
										<input type="email" name="email" id="email"
											placeholder="请输入邮箱账号" onblur="checkEmail()"> <span
											id="email_msg"></span>
									</p>
								</div>
								<div class="user-pass">
									<p>
										<label for="password"><i class="am-icon-lock"></i></label> <input
											type="password" name="password" id="password"
											placeholder="设置密码">
									</p>
								</div>
								<div class="user-pass">
									<p>
										<label for="confirm_password"><i class="am-icon-lock"></i></label>
										<input type="password" name="confirm_password"
											id="confirm_password" placeholder="确认密码">
									</p>
								</div>
								<div class="yzm">
									<p>
										<input type="text" name="vcode" id="vcode" placeholder="验证码"
											style="width: 150px !important">
										<button class="getCode" onclick="sendEmail();settime()" type="button">获取验证码</button>
										<span id="code_msg" style="color: red"></span>
									</p>
								</div>
							</form>
							<div class="login-links">
								<label for="reader-me"> <input id="reader-me"
									type="checkbox"> 点击表示您同意商城《服务协议》
								</label>
							</div>
							<div class="am-cf">
								<input type="button" name="" value="注册"
									class="am-btn am-btn-primary am-btn-sm am-fl"
									onclick="onsub();">
							</div>
							<div>
								<p>
									已注册?<a href="${basepath }/user/toLogin">去登陆</a>
								</p>
							</div>

						</div>
						<script>
							$(function() {
								$('#doc-my-tabs').tabs();
							})
						</script>

					</div>
				</div>

			</div>
		</div>

		<div class="footer ">
			<div class="footer-hd ">
				<p>
					<a href="# ">恒望科技</a> <b>|</b> <a href="# ">商城首页</a> <b>|</b> <a
						href="# ">支付宝</a> <b>|</b> <a href="# ">物流</a>
				</p>
			</div>
			<div class="footer-bd ">
				<p>
					<a href="# ">关于恒望</a> <a href="# ">合作伙伴</a> <a href="# ">联系我们</a> <a
						href="# ">网站地图</a>
				</p>
			</div>
		</div>
		<img src="${basepath }/kapacha.jpg" alt="验证码" title="点击更换" id="img"
			style="display: none;" />
</body>

</html>