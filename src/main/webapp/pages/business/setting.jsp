<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="<%=request.getContextPath()%>"></c:set>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>菜品维护</title>
    <style>
        @import url(${ctx}/css/business/setting.css);
    </style>
    <script src="${ctx}/js/jquery.min.js"></script>
    <script src="${ctx}/js/bus_setting.js"></script>
</head>
<body>
<div class="title">商品管理</div>
<div class="body_box">
    <div class="top_menu" id="setting">
        <div class="active_menu">全部<span>${size}</span></div>
        <div>已下架<span>${OffStringNumber}</span></div>
        <div>折扣<span>15</span></div>
        <div>已售罄<span>10</span></div>
        <div class="other_menu">...</div>
    </div>


    <div class="item_box">
        <div class="item_l">
            <div>
                门店福利
            </div>
            <div class="active_group">
                优惠套餐
            </div>
            <div>
                热门单品
            </div>
        </div>

        <div class="item_r">


            <c:forEach var="food" items="${foodInfos}">
                <div class="item_r_row">
                    <div>
                        <img src="${ctx}/images/hlt.png"/>
                    </div>
                    <div>
                        <div>${food.name}</div>
                        <div class="item_info">&gt;</div>
                        <div>
                            <span>月销${sales}</span>
                            <span>库存无限</span>
                        </div>
                        <div>
                            <span class="item_new_price">￥${food.price}</span>
                            <del class="item_old_price">
                                <span>￥</span>36.5
                            </del>
                            <span class="item_discount">5.1折</span>
                        </div>
                        <div>
                            <button>促销</button>
                            <button>库存</button>
                            <button onclick=del(${food.id})>下架</button>
                        </div>
                    </div>
                </div>
            </c:forEach>

        </div>
    </div>
</div>


<!-- 底部菜单 -->
<footer id="tabbar" class="tabbar">
    <div>
        <img src="${ctx}/images/bar/home.png"/><br>
        首页
    </div>
    <div>
        <img src="${ctx}/images/bar/order.png"/><br>
        订单
    </div>
    <div class="active">
        <img src="${ctx}/images/bar/setting_active.png"/><br>
        管理
    </div>
    <div>
        <img src="${ctx}/images/bar/about.png"/><br>
        我的
    </div>
</footer>
</body>
</html>