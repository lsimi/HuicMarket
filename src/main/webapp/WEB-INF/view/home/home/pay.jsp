<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="basepath"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0 ,minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<title>结算页面</title>

		<link href="${basepath}/css/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />

		<link href="${basepath}/css/basic/css/demo.css" rel="stylesheet" type="text/css" />
		<link href="${basepath}/css/hcss/cartstyle.css" rel="stylesheet" type="text/css" />
		<link href="${basepath}/css/hcss/jquery.inputbox.css" rel="stylesheet" type="text/css" />
		<link href="${basepath}/css/hcss/jsstyle.css" rel="stylesheet" type="text/css" />

		<script type="text/javascript" src="${basepath}/js/hjs/address.js"></script>
		<script src="${basepath}/js/hjs/jquery.js" type="text/javascript"></script>
		<script src="${basepath}/js/hjs/jquery.ganged.js" type="text/javascript"></script>
		<script type="text/javascript" src="${basepath}/js/vjs/jquery.validate.js"></script>
		<script type="text/javascript" src="${basepath }/js/vjs/additional-methods.js"></script>
		<style type="text/css">label.error{color:red}</style>
		<script type="text/javascript">
			$(function(){
				//校验格式
				$("#insertAddr_From").validate({
					rules : {
						addrName :"required",
						addrPhone : {
							required : true,
							digits:true,
							minlength : 11,
							maxlength:11
						},
						addrDetail: {
							required : true,
							maxlength:100
						}
					},
					messages : {
						addrName :"请输入收货人姓名",
						addrPhone : {
							required : "请输入收货人手机号码",
							minlength : "手机号码不能小于11位整数",
							maxlength :"手机号码不能超过11位整数",
							digits :"手机号码只能是数字"
						},
						addrDetail: {
							required : "详细地址不能为空",
							maxlength :"输入内容不可以超过100字"
						}
					}
				})
			});	
				//公共方法==>删除地址和修改地址默认状态
				function PublicMethod(addrId,url,msg){
					$.post("${basepath}/address/"+url,{addrId:addrId},
							function(data){
						if(data==1){
							alert(msg+"成功");
							window.location.reload();
						}else{
							alert(msg+"失败");
						}
					});
				}
				$(function(){
					setTotalPrice();
					
					//计算单个价格和==》单价*数量    总价==》totalPrice+=sumPrice
					function setTotalPrice(){
						var totalPrice=0;
						$('.J_ItemSum').each(function(){
							console.log($(this).text());
							totalPrice+=eval($(this).text());
							$(this).parent().find($("input[type='hidden']")).val($(this).text());
						
						});
						
						$('#J_ActualFee').text(totalPrice.toFixed(2));
						$('#paySum').text(totalPrice.toFixed(2));
						$('#orSumprice').val(totalPrice.toFixed(2));
					}
					
					//点击选中收货地址 
					$(".user-addresslist").click(function(){
						$('#addrId').val($(this).attr("data-addrId"));
						$('#buyProvice').text($(this).find('.province').text());
						$('#buyCity').text($(this).find('.city').text());
						$('#buyArea').text($(this).find('.dist').text());
						$('#buyDetail').text($(this).find('.street').text());
						$('#buyUser').text($(this).find('.buy-user').text());
						$('#buyphone').text($(this).find('.buy-phone').text());
					})
					//点击选中物流方式
					$('.OP_LOG_BTN').click(function(){
						$('#expressId').val($(this).attr("data-expressId"));
					})
				});
		</script>	
	</head>
	<body>

		<!--顶部导航条 -->
		<div id="top">
		<jsp:include page="top.jsp"></jsp:include>
		</div>
			<!--悬浮搜索框-->
			<div class="nav white">
				<div class="logo"><img src="${basepath}/images/himages/logo.png" /></div>
				<div class="logoBig">
					<li><img src="${basepath}/images/himages/logobig.png" /></li>
				</div>

				<div class="search-bar pr">
					<a name="index_none_header_sysc" href="#"></a>
					<form>
						<input id="searchInput" name="index_none_header_sysc" type="text" placeholder="搜索" autocomplete="off">
						<input id="ai-topsearch" class="submit am-btn" value="搜索" index="1" type="submit">
					</form>
				</div>
			</div>

			<div class="clear"></div>
			<form action="${basepath}/order/place" method="post">
			<div class="concent">
				<!--地址 -->
				<div class="paycont">
					<div class="address">
						<h3>确认收货地址 </h3>
						<div class="control">
							<div class="tc-btn createAddr theme-login am-btn am-btn-danger">使用新地址</div>
						</div>
						<div class="clear"></div>
						<ul>
						
						<!-- 地址框开始 -->
						<c:forEach items="${addrInfos}" var="addr" >
							<div class="per-border"></div>
							<li data-addrId="${addr.addrId}" ${addr.addrStatus==0?"class='user-addresslist defaultAddr'":"class='user-addresslist'"} >
								<div class="address-left">
									<div class="user DefaultAddr">
										<span class="buy-address-detail">   
                   						<span class="buy-user">${addr.addrName}</span>
										<span class="buy-phone">${addr.addrPhone}</span>
										</span>
									</div>
									<div class="default-address DefaultAddr">
										<span class="buy-line-title buy-line-title-type">收货地址：</span>
										<span class="buy--address-detail">
								        <span class="province">${addr.addrProvice}</span>
										<span class="city">${addr.addrCity }</span>
										<span class="dist">${addr.addrArea }</span>
										<span class="street">${addr.addrDetail }</span>
										</span>
										</span>
									</div>
									<c:if test="${addr.addrStatus==0}"><ins class="deftip">默认地址</ins></c:if>
								</div>
								<div class="address-right">
									<a href="../person/address.html">
										<span class="am-icon-angle-right am-icon-lg"></span></a>
								</div>
								<div class="clear"></div>

								<div class="new-addr-btn">
									<a href="javascript:void(0);" <c:if test="${addr.addrStatus==0}">class="hidden"</c:if> onclick="PublicMethod(${addr.addrId},'updateDefaultAddr','设置');">设为默认</a>
									<span class="new-addr-bar hidden">|</span>
									<a href="#">编辑</a>
									<span class="new-addr-bar">|</span>
									<a href="javascript:void(0);" onclick="PublicMethod(${addr.addrId},'delAddrInfo','删除');">删除</a>
								</div>
							</li>
							<div class="per-border"></div>
						</c:forEach>
							<!-- 地址结束 -->
						</ul>

						<div class="clear"></div>
					</div>
					<!--物流 -->
					<input type="hidden" name="addrId" id="addrId" >
					<input type="hidden" name="expressId" id="expressId"/>
					<div class="logistics">
						<h3>选择物流方式</h3>
						<ul class="op_express_delivery_hot">
							<c:forEach items="${express}" var="express">
								<li class="OP_LOG_BTN" data-expressId="${express.expressId }"><img src="${basepath}/images/himages/expressImgs/${express.expressImg}" style="max-width: 100%;max-height: 100%;"/></li>
							</c:forEach>
						</ul>
					</div>
					<div class="clear"></div>
					<!-- 物流结束 -->
					<!--支付方式-->
					<div class="logistics">
						<h3>支付方式</h3>
						<ul class="pay-list">
							<li class="pay taobao"><img src="${basepath}/images/himages/zhifubao.jpg" />支付宝<span></span></li>
						</ul>
					</div>
					<div class="clear"></div>

					<!--订单 -->
					<div class="concent">
						<div id="payTable">
							<h3>确认订单信息</h3>
							<div class="cart-table-th">
								<div class="wp">

									<div class="th th-item">
										<div class="td-inner">商品信息</div>
									</div>
									<div class="th th-price">
										<div class="td-inner">单价</div>
									</div>
									<div class="th th-amount">
										<div class="td-inner">数量</div>
									</div>
									<div class="th th-sum">
										<div class="td-inner">金额</div>
									</div>
									<div class="th th-oplist">
										<div class="td-inner">配送方式</div>
									</div>

								</div>
							</div>
							<div class="clear"></div>
							<div class="clear"></div>
							</div>
							<!--  -->
							<c:forEach items="${cartItems }" var="item" varStatus="i" >
							<input type="hidden" value="${item.goodsdetail.gdId}" name="orderDetails[${i.index}].gdId"> 
								<tr id="J_BundleList_s_1911116345_1" class="item-list">
									<div id="J_Bundle_s_1911116345_1_0" class="bundle  bundle-last">
										<div class="bundle-main">
											<ul class="item-content clearfix">
												<div class="pay-phone">
													<li class="td td-item">
														<div class="item-pic">
															<a href="#" class="J_MakePoint">
																<img src="${basepath}/images/himages/kouhong.jpg_80x80.jpg" class="itempic J_ItemImg"></a>
														</div>
														<div class="item-info">
															<div class="item-basic-info">
																<a href="#" target="_blank" title="${item.goodsdetail.goods.gName}" class="item-title J_MakePoint" data-point="tbcart.8.11">${item.goodsdetail.goods.gName}</a>
															</div>
														</div>
													</li>
													<li class="td td-info">
														<div class="item-props">
															<span class="sku-line">口味：${item.goodsdetail.taste.tasteVal}</span>
															<span class="sku-line">包装：${item.goodsdetail.pack.packVal}</span>
														</div>
													</li>
													<li class="td td-price">
														<div class="item-price price-promo-promo">
															<div class="price-content">
																<em class="J_Price price-now">${item.goodsdetail.gdPrice}</em>
															</div>
														</div>
													</li>
												</div>
	
												<li class="td td-amount">
													<div class="amount-wrapper ">
														<div class="item-amount ">
															<span class="phone-title">购买数量</span>
															<div class="sl">
																<input class="min am-btn" name="" type="button" value="-" data-price="${item.goodsdetail.gdPrice}" data-cid="${item.carId}"/>
																<input class="text_box" name="orderDetails[${i.index}].gNum" type="text" value="${item.salNum}" style="width:30px;" />
																<input class="add am-btn" name="" type="button" value="+" data-price="${item.goodsdetail.gdPrice}" data-cid="${item.carId}"/>
															</div>
														</div>
													</div>
												</li>
												<input type="hidden" name="orSumprice" id="orSumprice"/>
												<li class="td td-sum">
													<div class="td-inner" >
														<input type="hidden" name="orderDetails[${i.index}].totalprice" id="totalprice_${item.carId}" value="" />
														<em  class="J_ItemSum number" id="ItemSum_${item.carId}" >${item.goodsdetail.gdPrice*item.salNum}</em>
													</div>
												</li>
												<li class="td td-oplist">
													<div class="td-inner">
														<span class="phone-title">配送方式</span>
														<div class="pay-logis">
															包邮
														</div>
													</div>
												</li>
	
											</ul>
											<div class="clear"></div>
	
										</div>
								</tr>
							</c:forEach>
							</div>
							<div class="clear"></div>
							<div class="pay-total">
						<!--留言-->
							<div class="order-extra">
								<div class="order-user-info">
									<div id="holyshit257" class="memo">
										<label>买家留言：</label>
										<input type="text" name="userMessage" title="选填,对本次交易的说明（建议填写已经和卖家达成一致的说明）" placeholder="选填,建议填写和卖家达成一致的说明" class="memo-input J_MakePoint c2c-text-default memo-close">
										<div class="msg hidden J-msg">
											<p class="error">最多输入500个字符</p>
										</div>
									</div>
								</div>

							</div>
							<!--优惠券 -->
							<!-- <div class="buy-agio">
								<li class="td td-coupon">

									<span class="coupon-title">优惠券</span>
									<select data-am-selected>
										<option value="a">
											<div class="c-price">
												<strong>￥8</strong>
											</div>
											<div class="c-limit">
												【消费满95元可用】
											</div>
										</option>
										<option value="b" selected>
											<div class="c-price">
												<strong>￥3</strong>
											</div>
											<div class="c-limit">
												【无使用门槛】
											</div>
										</option>
									</select>
								</li>

								<li class="td td-bonus">

									<span class="bonus-title">红包</span>
									<select data-am-selected>
										<option value="a">
											<div class="item-info">
												¥50.00<span>元</span>
											</div>
											<div class="item-remainderprice">
												<span>还剩</span>10.40<span>元</span>
											</div>
										</option>
										<option value="b" selected>
											<div class="item-info">
												¥50.00<span>元</span>
											</div>
											<div class="item-remainderprice">
												<span>还剩</span>50.00<span>元</span>
											</div>
										</option>
									</select>

								</li>

							</div>
							<div class="clear"></div>
							</div>
							 -->
							<!--含运费小计 -->
							<div class="buy-point-discharge ">
								<p class="price g_price ">
									合计（含运费） <span>¥</span><em class="pay-sum" id="paySum">244.00</em>
								</p>
							</div>

							<!--信息 -->
							<div class="order-go clearfix">
								<div class="pay-confirm clearfix">
									<div class="box">
										<div tabindex="0" id="holyshit267" class="realPay"><em class="t">实付款：</em>
											<span class="price g_price ">
                                    <span>¥</span> <em class="style-large-bold-red " id="J_ActualFee"  name="orSumprice">244.00</em>
											</span>
										</div>

										<div id="holyshit268" class="pay-address">

											<p class="buy-footer-address">
												<span class="buy-line-title buy-line-title-type">寄送至：</span>
												<span class="buy--address-detail">
								   				<span class="province" id="buyProvice"></span>
												<span class="city" id="buyCity"></span>
												<span class="dist" id="buyArea"></span>
												<span class="street" id="buyDetail"></span>
												</span>
												</span>
											</p>
											<p class="buy-footer-address">
												<span class="buy-line-title">收货人：</span>
												<span class="buy-address-detail">   
                                         		<span class="buy-user" id="buyUser"></span>
												<span class="buy-phone" id="buyphone"></span>
												</span>
											</p>
										</div>
									</div>

									<div id="holyshit269" class="submitOrder">
										<div class="go-btn-wrap">
											<input type="submit" id="J_Go"  class="btn-go" style="border:none;display:inline-block;text-align:right;" value="提交订单"/> 
										</div>
									</div>
									<div class="clear"></div>
								</div>
								
							</div>
						</div>

						<div class="clear"></div>
					</div>
				</div>
			</form>
				<div class="footer">
					<div class="footer-hd">
						<p>
							<a href="#">恒望科技</a>
							<b>|</b>
							<a href="#">商城首页</a>
							<b>|</b>
							<a href="#">支付宝</a>
							<b>|</b>
							<a href="#">物流</a>
						</p>
					</div>
					<div class="footer-bd">
						<p>
							<a href="#">关于恒望</a>
							<a href="#">合作伙伴</a>
							<a href="#">联系我们</a>
							<a href="#">网站地图</a>
							<em>© 2015-2025 Hengwang.com 版权所有. 更多模板 <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></em>
						</p>
					</div>
				</div>
			</div>
			<div class="theme-popover-mask"></div>
			<div class="theme-popover">

				<!--标题 -->
				<div class="am-cf am-padding">
					<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">新增地址</strong> / <small>Add address</small></div>
				</div>
				<hr/>

				<div class="am-u-md-12">
				<!-- 添加新地址 -->
					<form class="am-form am-form-horizontal" id="insertAddr_From" action="${basepath}/address/addAddrInfo" method="post">
						<div class="am-form-group">
							<label for="addrName" class="am-form-label">收货人</label>
							<div class="am-form-content">
								<input type="text" id="addrName" placeholder="收货人必填" name="addrName">
							</div>
						</div>

						<div class="am-form-group">
							<label for="addrPhone" class="am-form-label">手机号码</label>
							<div class="am-form-content">
								<input id="addrPhone" placeholder="手机号必填" type="text" name="addrPhone">
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-phone" class="am-form-label">所在地</label>
							<div class="am-form-content address">
								<select id="s_province" name="addrProvice"></select>  
    							<select id="s_city" name="addrCity" ></select>  
   								<select id="s_county" name="addrArea" style="width:104px"></select>
							</div>
						</div>

						<div class="am-form-group">
							<label for="addrDetail" class="am-form-label">详细地址</label>
							<div class="am-form-content">
								<textarea class="" rows="3" id="addrDetail" placeholder="输入详细地址" name="addrDetail"></textarea>
							</div>
						</div>

						<div class="am-form-group theme-poptit">
							<div class="am-u-sm-9 am-u-sm-push-3">
								<input type="submit" value="保存" style="border:none" class="am-btn am-btn-danger">
								<div class="am-btn am-btn-danger close">取消</div>
							</div>
						</div>
					</form>
				<!-- 添加新地址 结束-->
				</div>
			</div>
			<div class="clear"></div>
<script class="resources library" src="${basepath}/js/hjs/area.js" type="text/javascript"></script>
<script type="text/javascript">_init_area();</script>			
<script type="text/javascript">
		var Gid  = document.getElementById ;
		var showArea = function(){
			Gid('show').innerHTML = "<h3>省" + Gid('s_province').value + " - 市" + 	
			Gid('s_city').value + " - 县/区" + 
			Gid('s_county').value + "</h3>"
		};
		Gid('s_county').setAttribute('onchange','showArea()');
</script>
	 	<div id="show"></div> 	
	</body>
</html>