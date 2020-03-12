<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="basepath"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8"/>
<title>后台管理系统</title>
<meta name="author" content="DeathGhost" />
<link rel="stylesheet" type="text/css" href="${basepath}/css/bcss/style.css">
<!--[if lt IE 9]>
<script src="${basepath}/js/bjs/html5.js"></script>
<![endif]-->
<script src="${basepath}/js/bjs/jquery.js"></script>
<script src="${basepath}/js/bjs/jquery.mCustomScrollbar.concat.min.js"></script>
<script>

	(function($){
		$(window).load(function(){
			
			$("a[rel='load-content']").click(function(e){
				e.preventDefault();
				var url=$(this).attr("href");
				$.get(url,function(data){
					$(".content .mCSB_container").append(data); //load new content inside .mCSB_container
					//scroll-to appended content 
					$(".content").mCustomScrollbar("scrollTo","h2:last");
				});
			});
			
			$(".content").delegate("a[href='top']","click",function(e){
				e.preventDefault();
				$(".content").mCustomScrollbar("scrollTo",$(this).attr("href"));
			});
			
		});
	})(jQuery);
	
	
    //分页
    function fenye(pagenum) {
     	location.href="${basepath}/back/goods/list?pageNum="+pagenum+"&cparentid=${backgoodspage.cparentid}&goodsname=${backgoodspage.goodsname}"
     	};
		
	
</script>
</head>
<body>
<!--header-->

<header>
 <h1><img src="${basepath}/images/bimages/admin_logo.png"/></h1>
 <ul class="rt_nav">
  <li><a href="http://www.mycodes.net" target="_blank" class="website_icon">站点首页</a></li>
  <li><a href="#" class="clear_icon">清除缓存</a></li>
  <li><a href="#" class="admin_icon">DeathGhost</a></li>
  <li><a href="#" class="set_icon">账号设置</a></li>
  <li><a href="login.html" class="quit_icon">安全退出</a></li>
 </ul>
</header>
<!--aside nav-->
<!--aside nav-->
<aside class="lt_aside_nav content mCustomScrollbar">
 <h2><a href="index.html">起始页</a></h2>
 <ul>
  <li>
   <dl>
    <dt>常用布局示例</dt>
    <!--当前链接则添加class:active-->
    <dd><a href="product_list.html" class="active">商品列表示例</a></dd>
    <dd><a href="product_detail.html">商品详情示例</a></dd>
    <dd><a href="recycle_bin.html">商品回收站示例</a></dd>
   </dl>
  </li>
  <li>
   <dl>
    <dt>订单信息</dt>
    <dd><a href="order_list.html">订单列表示例</a></dd>
    <dd><a href="order_detail.html">订单详情示例</a></dd>
   </dl>
  </li>
  <li>
   <dl>
    <dt>会员管理</dt>
    <dd><a href="user_list.html">会员列表示例</a></dd>
    <dd><a href="user_detail.html">添加会员（详情）示例</a></dd>
    <dd><a href="user_rank.html">会员等级示例</a></dd>
    <dd><a href="adjust_funding.html">会员资金管理示例</a></dd>
   </dl>
  </li>
  <li>
   <dl>
    <dt>基础设置</dt>
    <dd><a href="setting.html">站点基础设置示例</a></dd>
   </dl>
  </li>
  <li>
   <dl>
    <dt>配送与支付设置</dt>
    <dd><a href="express_list.html">配送方式</a></dd>
    <dd><a href="pay_list.html">支付方式</a></dd>
   </dl>
  </li>
  <li>
   <dl>
    <dt>在线统计</dt>
    <dd><a href="discharge_statistic.html">流量统计</a></dd>
    <dd><a href="sales_volume.html">销售额统计</a></dd>
   </dl>
  </li>
  <li>
   <p class="btm_infor">© DeathGhost.cn 版权所有</p>
  </li>
 </ul>
</aside>

<section class="rt_wrap content mCustomScrollbar">
 <div class="rt_content">
      <div class="page_title">
       <h2 class="fl">商品列表示例</h2>
       <a href="product_detail.html" class="fr top_rt_btn add_icon">添加商品</a>
      </div>
      <form action="${basepath}/back/goods/list" method="get">
      <section class="mtb">
       <select class="select" name="cparentid">
       <option value="">全部</option>
       <c:forEach items="${categorys}" var="category"> 
       <option value="${category.cateId}" <c:if test="${category.cateId==backgoodspage.cparentid}">selected="selected"</c:if>>${category.cateName}</option>
       </c:forEach>
       </select>
       <input type="text" name="goodsname" class="textbox textbox_225" placeholder="输入产品关键词或产品货号..." value="${backgoodspage.goodsname}"/>
       <input type="submit" value="查询" class="group_btn"/>
      </section>
      
      
      <table class="table">
       <tr>
        <th>缩略图</th>
        <th>产品名称</th>
        <th>货号</th>
        <th>销量</th>
        <th>类目</th>
        <th>状态</th>
        <th>上架时间</th>
        <th>下架时间</th>
        <th>推荐</th>
        <th>操作</th>
       </tr>
       
       
  		<c:forEach items="${pages.list}" var="good">
        <tr>
        <td class="center"><img src="${basepath}/upload/goods01.jpg" width="50" height="50"/></td>
        <td><a href="${basepath}/back/goodsdetail/list?gName=${good.gName}&gid=${good.gId}">${good.gName}</a></td>
        <td class="center">${good.gId}</td>
        <td class="center"><strong>${good.gSalenum}</strong></td>
        <td class="center">${good.backcategory.cateName}</td>
        <td class="center"><c:if test="${good.gStatus==0}">下架</c:if><c:if test="${good.gStatus==1}">在售</c:if></td>
        <td class="center"><fmt:formatDate value="${good.gUptime}"></fmt:formatDate></td>
        <td class="center"><fmt:formatDate value="${good.gDowntime}"></fmt:formatDate></td>
        <td class="center">
        <c:if test="${good.gGreat==0}"><a title="否" class="link_icon" href="${basepath}/back/goods/updategreat?gGreat=1&gId=${good.gId}&pageNum=${pages.pageNum}&cparentid=${backgoodspage.cparentid}&goodsname=${backgoodspage.goodsname}">&#88;</a></c:if>
        <c:if test="${good.gGreat==1}"><a title="是" class="link_icon" href="${basepath}/back/goods/updategreat?gGreat=0&gId=${good.gId}&pageNum=${pages.pageNum}&cparentid=${backgoodspage.cparentid}&goodsname=${backgoodspage.goodsname}">&#89;</a></c:if>
        </td>
        <td class="center">
        <c:if test="${good.gStatus==0}">
        <a target="_self" href="${basepath}/back/goods/updatestatus?gStatus=1&gId=${good.gId}&pageNum=${pages.pageNum}&cparentid=${backgoodspage.cparentid}&goodsname=${backgoodspage.goodsname}" title="上架"  target="_blank">↑</a>
        </c:if>
        <c:if test="${good.gStatus==1}">
        <a target="_self" href="${basepath}/back/goods/updatestatus?gStatus=0&gId=${good.gId}&pageNum=${pages.pageNum}&cparentid=${backgoodspage.cparentid}&goodsname=${backgoodspage.goodsname}" title="下架"  target="_blank">↓</a>
        </c:if>
         
         <a href="${basepath}/back/goods/toupdategoods?gId=${good.gId}" title="编辑" class="link_icon">&#101;</a>
         <a href="${basepath}/back/goods/deletegoods?gDelete=0&gId=${good.gId}&pageNum=${pages.pageNum}&cparentid=${backgoodspage.cparentid}&goodsname=${backgoodspage.goodsname}" title="删除" class="link_icon">&#100;</a>
         
        </td>
       	</tr>
       </c:forEach> 
       
      
      </table>
      <aside class="paging">
        <a href="javascript:;" onclick="fenye(1)">首页</a>
      <a href="javascript:;" onclick="fenye(${pages.pageNum-1>1?pages.pageNum-1:1})">上一页</a>
	        <c:forEach begin="${pages.pageNum}" end="${pages.pageNum+5<pages.pages?pages.pageNum+5:pages.pages}" var="page">
	        <a href="javascript:;" onclick="fenye(${page})">${page}</a>
	        </c:forEach>
        <a href="javascript:;" onclick="fenye(${pages.pageNum+1<pages.pages?pages.pageNum+1:pages.pages})">下一页</a>
       <a href="javascript:;"  onclick="fenye(${pages.pages})">末页</a>	
      </aside> 
      
      </form>
      
 </div>
</section>
</body>
</html>
