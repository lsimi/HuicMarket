<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${pageContext.request.contextPath}" var="basepath"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

<title>购物车页面</title>

<link href="${basepath}/css/AmazeUI-2.4.2/assets/css/amazeui.css"
	rel="stylesheet" type="text/css" />
<link href="${basepath}/css/basic/css/demo.css" rel="stylesheet"
	type="text/css" />
<link href="${basepath}/css/hcss/cartstyle.css" rel="stylesheet"
	type="text/css" />
<link href="${basepath}/css/hcss/optstyle.css" rel="stylesheet"
	type="text/css" />

<script type="text/javascript" src="${basepath}/js/bjs/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="${basepath}/js/hjs/jquery.js"></script>
<script type="text/javascript">
			$(function(){
				//全选与反选..
				$('#J_SelectAllCbx2').change(function(){
				var flag=$(this).is(':checked');
				$(":checkbox").prop("checked",flag);
				});
				
				//全选与反选..根据店铺选择旗下的所有购物车项
				//点击 select_store_all_goods 找到它自身绑定的date-sid ==> ${sid}
				//动态拼接 store_goods_${sid} 可以通过 $(".store_goods_"+sid)
				$('.select_store_all_goods').on("change",function(){
					var sid = $(this).attr("data-sid");
					var flag=$(this).is(':checked');
					var store_all_goods = $(".store_goods_"+sid);//元素集合
					store_all_goods.each(function(){
						$(this).prop("checked",flag);
					});
				})
				var submitFlag = false;
				//.check改变时，判断它如果是取消了，就将J-Total归零
				$("input[type='checkbox']").on("change",function(){
						setTotalPrice();
						submitFlag = false;
						$('.goods').each(function(){
							if($(this).prop("checked")){
								submitFlag = true;
							}
						});
						if(!submitFlag){
							$("#gotopay").addClass("disabled")
						}else{
							$("#gotopay").removeClass("disabled")
						}
				})
				
			})
			//设置表单提交
			function gotopay(){
					var b = $("#gotopay").hasClass("disabled");
					if(b){
						alert("亲，您没有选中任何商品哦!")
						return ;
					}
					$('#gotopay').attr("disabled","true"); //设置变灰按钮
						var param="";
						var ids=$("input[name='carIds']:checked");
						console.log(ids);
						ids.each(function(index,node){
							if(index!=0){
								param+="&carIds="+$(node).val();
								}else{
								param+="carIds="+$(node).val();
							}
						});
					
					location="${basepath}/order/toPay?"+param;
					setTimeout("$('#gotopay').removeAttr('disabled')",3000); //设置三秒后提交按钮 显示   
				}
			//更改购物车商品数量
				function updateNum(carId,status,price){
					var num=status;
					var salNum = Number($('#salNum_'+carId).val()); 
					if(num == '0'){
						salNum = (salNum-1)<=0?1:(salNum-1);
					}
					if(num == '1'){
						salNum = salNum+1;
					} 
					$.post("${basepath}/cart/updateSalNum",{carId:carId,salNum:salNum},function(data){
						var total = (data.salNum * price).toFixed(2);
						$('#salNum_'+carId).val(data.salNum);
						$('#sumPrice_'+carId).text(total);
						$("#J_CheckBox_"+carId).prop("checked",true).attr("data-total",total);
						setTotalPrice();
					});
				}
			
			//计算总价
			function setTotalPrice(){
				var carTotal = 0;
				var count=0;
				$("input[name='carIds']").each(function(){
					if($(this).is(":checked")){
						count=count+1;
						var thisTotal =eval( $(this).attr("data-total") );
						carTotal += thisTotal;
					}
				})
				$("#J_Total").text(carTotal.toFixed(2));
				$("#J_SelectedItemsCount").text(count);
			}
			
			//引入收藏夹
			function modiCollection(userId,gId){
				$.post("${basepath}/cart/collection",{
					userId:userId,
					gId:gId
				},function(data){
					if(data==1){
						alert("收藏成功");
					}else{
						alert("收藏失败");
					}
					
				});
			}
			
			//删除单个购物车项
			function deleteOne(carId){
				var r=window.confirm("确定要删除该商品吗？");
				if(r){
					location="${basepath}/cart/deleteOneItem?carId="+carId;
				}
			}
			
			//删除多条购物车项
			function clearCheckGoods(){
				var r=window.confirm("确定要删除所选中的商品吗？");
				if(r){
					var param="";
					var ids=$("input[name='carIds']:checked");
					console.log(ids);
					ids.each(function(index,node){
						if(index!=0){
						  param+="&carIds="+$(node).val();
						}else{
							 param+="carIds="+$(node).val();
						}
					});
				   location="${basepath}/cart/delBacthCartItems?"+param;
				}
			}
		</script>
</head>

<body>

	<!--顶部导航条 -->
	<div id="top">
		<jsp:include page="top.jsp"></jsp:include>
	</div>

	<!--悬浮搜索框-->

	<div class="nav white">
		<div class="logo">
			<img src="${basepath}/images/himages/logo.png" />
		</div>
		<div class="logoBig">
			<li><img src="${basepath}/images/himages/logobig.png" /></li>
		</div>

		<div class="search-bar pr">
			<a name="index_none_header_sysc" href="#"></a>
			<form>
				<input id="searchInput" name="index_none_header_sysc" type="text"
					placeholder="搜索" autocomplete="off"> <input
					id="ai-topsearch" class="submit am-btn" value="搜索" index="1" type="submit">
			</form>
		</div>
	</div>

	<div class="clear"></div>
	<!--购物车 -->
	<div class="concent">
		<div id="cartTable">
			<div class="cart-table-th">
				<div class="wp">
					<div class="th th-chk">
						<div id="J_SelectAll1" class="select-all J_SelectAll"></div>
					</div>
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
					<div class="th th-op">
						<div class="td-inner">操作</div>
					</div>
				</div>
			</div>
			<div class="clear"></div>

			<tr class="item-list">
				<div class="bundle  bundle-last ">
					<c:forEach items="${stores}" var="store">
						<div class="bundle-hd">
								<div class="bd-has-promo" style="margin-left:10px">
								<input class="select_store_all_goods" data-sid="${store.sId}" name="select_${store.sId}" value="true" type="checkbox"> 
								<label for="select_${store.sId}"></label>
									${store.sName}
									<span class="bd-has-promo-content"></span>&nbsp;&nbsp;
								</div>
								<div class="act-promo">
									<!-- <a href="#" target="_blank">第二支半价，第三支免费<span class="gt">&gt;&gt;</span></a> -->
								</div>
								<span class="list-change theme-login">编辑</span>
							</div>
						</div>
						<div class="clear"></div>
						<c:forEach items="${pageInfo.list}" var="cart">
							<input type="hidden" name="gdId" value="${cart.goodsdetail.gdId }"/>
							<c:if test="${cart.goodsdetail.goods.sId==store.sId}">
								<div class="bundle-main">
								<ul class="item-content clearfix">
								<!-- 复选框 -->
									<li class="td td-chk">
										<div class="cart-checkbox ">
											<input id="J_CheckBox_${cart.carId }" 
											data-total="${cart.salNum*cart.goodsdetail.gdPrice}" 
											class="check goods store_goods_${store.sId}" 
												name="carIds" value="${cart.carId}" type="checkbox">
											<label for="J_CheckBox_${cart.carId}"></label>
										</div>
									</li>
								<!-- 复选框 -->
									<li class="td td-item">
										<div class="item-pic">
											<a href="#" target="_blank"
												data-title="${cart.goodsdetail.goods.gName}"
												class="J_MakePoint" data-point="tbcart.8.12"> <img
												src="${basepath}/images/himages/kouhong.jpg_80x80.jpg"
												class="itempic J_ItemImg"></a>
										</div>
										<div class="item-info">
											<div class="item-basic-info">
												<a href="#" target="_blank"
													title="${cart.goodsdetail.goods.gName}"
													class="item-title J_MakePoint" data-point="tbcart.8.11">${cart.goodsdetail.goods.gName}</a>
											</div>
										</div>
									</li>
									<li class="td td-info ws">
										<!-- <div class="item-props  item-props-can"> -->
										<div class="item-props">
											<span class="sku-line">口味：${cart.goodsdetail.taste.tasteVal}</span>
											<span class="sku-line">包装：${cart.goodsdetail.pack.packVal }</span>
											<!-- <span tabindex="0" class="btn-edit-sku theme-login">修改</span> -->
											<i class="theme-login am-icon-sort-desc"></i>
										</div>
									</li>
									<li class="td td-price">
										<div class="item-price price-promo-promo">
											<div class="price-content">
												<div class="price-line">
													<em class="price-original">${cart.goodsdetail.gdOldprice}</em>
												</div>
												<div class="price-line">
													<em class="J_Price price-now" tabindex="0">${cart.goodsdetail.gdPrice}</em>
												</div>
											</div>
										</div>
									</li>
									<li class="td td-amount">
										<div class="amount-wrapper ">
											<div class="item-amount">
												<div class="sl">
													<input class="min am-btn" data-gdPrice="${cart.goodsdetail.gdPrice}" data-carId="${cart.carId}" name="cut" type="button" value="-" style="text-align: center" onclick="updateNum(${cart.carId},'0',${cart.goodsdetail.gdPrice})" /> 
													<input class="text_box" name="salNum" type="text" value="${cart.salNum}" style="width: 30px; text-align: center" id="salNum_${cart.carId}"/>
													<input class="add am-btn" data-gdPrice="${cart.goodsdetail.gdPrice}" data-carId="${cart.carId}" name="add" type="button" value="+" onclick="updateNum(${cart.carId},'1',${cart.goodsdetail.gdPrice})"/>
												</div>
											</div>
										</div>
									</li>
									<li class="td td-sum">
										<div class="td-inner">
											<em tabindex="0" class="J_ItemSum number"><span class="sumPrice" id="sumPrice_${cart.carId}">${cart.salNum*cart.goodsdetail.gdPrice}</span></em>
										</div>
									</li>
									<li class="td td-op">
										<div class="td-inner">
											<a title="移入收藏夹" class="btn-fav" href="javascript:;"
												onclick="modiCollection(${cart.userId},${cart.goodsdetail.goods.gId})" id="collectMsg_${cart.goodsdetail.goods.gId}">移入收藏夹</a>
												<a href="javascript:;" data-point-url="#" class="delete" onclick="deleteOne(${cart.carId})" id="delOne">删除</a>
										</div>
									</li>
								</ul>
							</c:if>
						</c:forEach>
					</c:forEach>

					<div class="float-bar-wrapper">
						<div id="J_SelectAll2" class="select-all J_SelectAll">
							<div class="cart-checkbox">
								<input class="check-all check" id="J_SelectAllCbx2"
									name="select-all" value="true" type="checkbox"> <label
									for="J_SelectAllCbx2"></label>
							</div>
							<span>全选</span>
						</div>
						<div class="operations">
							<a href="javascript:;" hidefocus="true" class="deleteAll" onclick="clearCheckGoods()">删除</a> 
							<a href="#" hidefocus="true" class="J_BatchFav">移入收藏夹</a>
						</div>
						<div class="float-bar-right">
							<div class="amount-sum">
								<span class="txt">已选商品</span> <em id="J_SelectedItemsCount">0</em><span
									class="txt">件</span>
								<div class="arrow-box">
									<span class="selected-items-arrow"></span> <span class="arrow"></span>
								</div>
							</div>
							<div class="price-sum">
								<span class="txt">合计:</span> <strong class="price">¥<em
									id="J_Total">0.00</em></strong>
							</div>
							<div onclick="javascript:gotopay();" class="btn-area disabled" id="gotopay"  style="corsor:pointer;color:#fff;">
								结&nbsp;算
							</div>
						</div>

					</div>

					<div class="footer">
						<div class="footer-hd">
							<p>
								<a href="#">恒望科技</a> <b>|</b> <a href="#">商城首页</a> <b>|</b> <a
									href="#">支付宝</a> <b>|</b> <a href="#">物流</a>
							</p>
						</div>
						<div class="footer-bd">
							<p>
								<a href="#">关于恒望</a> <a href="#">合作伙伴</a> <a href="#">联系我们</a> <a
									href="#">网站地图</a> <em>© 2015-2025 Hengwang.com 版权所有. 更多模板
									<a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a>
									- Collect from <a href="http://www.cssmoban.com/" title="网页模板"
									target="_blank">网页模板</a>
								</em>
							</p>
						</div>
					</div>

				</div>
		</div>

		<!--引导 -->
		<div class="navCir">
			<li><a href="home.html"><i class="am-icon-home "></i>首页</a></li>
			<li><a href="sort.html"><i class="am-icon-list"></i>分类</a></li>
			<li class="active"><a href="shopcart.html"><i
					class="am-icon-shopping-basket"></i>购物车</a></li>
			<li><a href="../person/index.html"><i class="am-icon-user"></i>我的</a></li>
		</div>
</body>
</html>