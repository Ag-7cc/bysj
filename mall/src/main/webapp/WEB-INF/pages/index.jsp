<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vic
  Date: 2017/1/25
  Time: 下午4:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="commons/head_taglib.jsp"/>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!doctype html>
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>玩具批发商城</title>
    <link href="css/div/jumei.v10.0.css" rel="stylesheet" type="text/css"/>
    <link href="css/div/jumei_home.v10.0.css" rel="stylesheet" type="text/css"/>
    <style type="text/css">

    </style>
    <script type="text/javascript" src="js/jquery/jquery-1.8.0.min.js"></script>
    <script type="text/javascript">
        function checkUser() {
            var t = new Date().getMilliseconds();
            var url = 'Login_loginUser?t=' + t;
            var params = {username: $('#userName').attr('value'), password: $('#passWord').attr('value')};
            $("#warn").html("<img src='images/ajax/loading.gif'/>");
            jQuery.post(url, params, callbackFun);
        }
        function callbackFun(data) {
            eval('json=' + data + ';');
            if (json.type == 'no') {
                $("#warn").html("");
                window.alert("用户名或密码错误");
            } else {
                var un = $('#userName').attr('value');
                $("#warn1").html("<li><a href='Cart_showCart' rel='nofollow'>购物车</a><em>|</em></li><li class='menu_phone'><a href='repassword.jsp' rel='nofollow' target='_blank'><span class='arrow'></span><b>会员：" + un + "欢迎使用！</b></a><em>|</em></li>");
                $("#warn").html("");
            }
        }

    </script>
</head>
<body>
<div id="cboxOverlay" style="display: none; "></div>
<div id="colorbox" class="" style="padding-bottom: 58px; padding-right: 58px; display: none; ">
    <div id="cboxWrapper">
        <div>
            <div id="cboxTopLeft" style="float: left; "></div>
            <div id="cboxTopCenter" style="float: left; "></div>
            <div id="cboxTopRight" style="float: left; "></div>
        </div>
        <div style="clear:left">
            <div id="cboxMiddleLeft" style="float: left; "></div>
            <div id="cboxContent" style="float: left; ">
                <div id="cboxLoadedContent" style="width: 0px; height: 0px; overflow: hidden; " class=""></div>
                <div id="cboxLoadingOverlay" class=""></div>
                <div id="cboxLoadingGraphic" class=""></div>
                <div id="cboxTitle" class=""></div>
                <div id="cboxCurrent" class=""></div>
                <div id="cboxNext" class=""></div>
                <div id="cboxPrevious" class=""></div>
                <div id="cboxSlideshow" class=""></div>
                <div id="cboxClose" class=""></div>
            </div>
            <div id="cboxMiddleRight" style="float: left; "></div>
        </div>
        <div style="clear:left">
            <div id="cboxBottomLeft" style="float: left; "></div>
            <div id="cboxBottomCenter" style="float: left; "></div>
            <div id="cboxBottomRight" style="float: left; "></div>
        </div>
    </div>
    <div style="position:absolute; width:9999px; visibility:hidden; display:none"></div>
</div>

<div id="top_collect_main"></div>
<div id="header_container">
    <jsp:include page="commons/head.jsp"/>
    <div id="logo">
        <a href="#" id="home"></a>
        <a id="cart" class="cart" href="Order_productList" rel="nofollow"><img src="images/tu5.png" width="177"
                                                                               height="36"/></a>
        <a href="#tian" rel="nofollow" class="cart_list"><img src="images/tu1.png" width="121" height="39"/></a>
        <a href="#tian" rel="nofollow" class="cart_list"><img src="images/tu2.png" width="116" height="38"/></a>
        <a href="#tian" rel="nofollow" class="cart_list"><img src="images/tu3.png" width="113" height="37"/></a>
        <a href="#tian" rel="nofollow" class="cart_list"><img src="images/tu4.png" width="115" height="38"/></a>

        <a style="position:absolute;top:0px;left:0px;width:300px;height:100px;z-index:100;"
           href="http://localhost:8080/XLToysWholesale/" title="玩具批发">
            <img style="display:block;width:280px;height:90px;" src="images/log1.jpg" width="410" height="80"
                 alt="玩具团购"> </a></div>
    <div class="clear"></div>
    <div id="top_menu">
        <div id="top_menu1">
            <div id="top_nav">
                <div style="float: left;">
                    <ul>
                        <c:forEach items="${navigationList}" var="item" varStatus="vs">
                            <c:choose>
                                <c:when test="${(navId eq item.id) or (empty navId and vs.first)}">
                                    <li class="selected">
                                        <a href="navigation/findByNavIdAndItemId?filter[navId]=${item.id}">${item.name}</a>
                                    </li>
                                </c:when>
                                <c:otherwise>
                                    <li>
                                        <a href="navigation/findByNavIdAndItemId?filter[navId]=${item.id}">${item.name}</a>
                                    </li>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </ul>
                </div>
                <!--控制搜索模块的开启-->
                <div class="top_search_wrap">

                    <form action="List_searchList" method="post" id="mall_search_form">
                        <input name="name" type="text" class="top_search_input" id="mall_search_input" default_val="补水"
                               autofocus="true" autocomplete="off" x-webkit-speech="" x-webkit-grammar="builtin:search"
                               lang="zh">
                        <button type="submit" id="btn_global_search">搜索</button>
                    </form>
                    <!--搜索结果容器-->
                    <div class="search_result_pop" id="top_search_pop_div">

                    </div>
                </div>
            </div>
        </div>
    </div>
    <div id="container" class="grid_v2">
        <div id="body" style="position: relative">

            <div id="top_deal_filter" class="deal_filter">
                <ul class="parent_filter">
                    <li ${empty itemId ? 'class="first selected"':'class="first"'}><a
                            href="navigation/findByNavIdAndItemId?filter[navId]=${navId}">全部</a></li>
                    <c:forEach items="${itemList}" var="item" varStatus="vs">
                        <li ${itemId eq item.id ? 'class="selected"' : ''}>
                            <a href="navigation/findByNavIdAndItemId?filter[navId]=${navId}&filter[itemId]=${item.id}">${item.name}(${not empty item.num ? item.num : 0})</a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
            <div id="home_top_banner">
                <div style="width:100%;margin-bottom:0px;" class="box_shadow">
                    <a href="http://localhost:8080/XLToysWholesale" target="_blank"><img src="images/sytg.png"></a>
                </div>
            </div>
            <div class="clear"></div>

            <div id="main" class="deals home_deal_list" style="position: relative;min-height: 1000px;">
                <div class="deal_brief_trigger">
                    <div class="trigger">
                        <div class="title_box">
                            喜洋洋灰太狼毛茸茸玩具 5岁小孩
                        </div>
                        <span class="arrow"></span>
                    </div>
                    <div class="trigger">
                        <div class="title_box">
                            泰迪熊兔斯基飞天小女警 500ml
                        </div>
                        <span class="arrow"></span>
                    </div>
                    <div class="trigger last current">
                        <div class="title_box">
                            LushJungle玩具小密室 55g
                        </div>
                        <span class="arrow"></span>
                    </div>
                </div>
                <div class="clear"></div>

                <div id="toady_deal_list">
                    <c:if test="${not empty productList}">
                        <c:forEach var="product" items="${productList}">
                            <div class="deal_box">
                                <span class="hid_hashid">d121016bdmlotteryp0</span>
                                <ul class="deal_oper" style="display: none; ">
                                    <li class="li_deal_oper">
                                        <a href="javascript:;" class="deal_share"></a>
                                        <div class="share_pannel">
                                        </div>
                                    </li>
                                    <li class="li_addCart">
                                        <a href="#tian" class="deal_lottery"></a>
                                        <div class="sku_pannel clearfix">
                                        </div>
                                    </li>
                                </ul>
                                <div class="clear"></div>
                                <div class="deal_oper_tip"><span>添加购物车成功</span>,<a href="#tian">去结算</a></div>
                                <div class="img_box">
                                    <a href="#tian">
                                        <img original="#tian" alt="新客户免托运费，欢迎选购！" src="images/${product.imgMain}" style="display: inline; ">
                                    </a>
                                </div>
                                <a class="title_box" href="#tian" target="_blank">
                                    <span class="pink">0折/</span>${product.description} </a>
                                <div class="koubei_box"><font size="5" color="blue">${product.name}</font>
                                </div>

                                <div class="price_box">
                                    <div class="p"><font color="red">${product.price}</font></div>
                                    <a href="List_addItem?id=${product.id}">
                                        <img src="images/gouwu.png" width="61" height="28"></a></a>
                                    <div class="p_detail">
                                        <p>市场价 ¥7.5</p>
                                        <p>您节省 ¥0.8 </p>
                                    </div>
                                </div>
                                <div class="time_box" diff="477839"><span class="icon"></span>13<em>时</em>38<em>分</em>27<em>秒</em>
                                </div>
                                <div class="num_box">
                                    <span class="icon"></span>
                                    <span class="buy_num">8</span>人已经购买
                                </div>
                                <div class="popular_rank"></div>
                                <div class="sale_rank"></div>
                                <div class="discount_rank">0</div>
                                <div class="shadow"></div>
                            </div>
                        </c:forEach>
                    </c:if>
                    <div style="margin-top:20px;">
                        <a href="List_productList?currentPage="><img src="images/next_page.png"></a>
                    </div>
                    <div class="main_pagination">
                        <a href="List_productList?currentPage=0" class="main_up">上一页<span class="main_down_corn"></span></a>
                        <a href="List_productList?currentPage=1">1</a>
                        <a href="List_productList?currentPage=2">2</a>
                        <a href="List_productList?currentPage=3">3</a>
                        <a href="List_productList?currentPage=4" class="main_up">下一页<span class="main_down_corn"></span></a>
                        <span class="main_next"></span>
                    </div>
                </div>


                <div class="clear"></div>

                <div id="home_nav_bar" style="display: none; ">
                    <a href="#" class="nav_cart" target="_blank" rel="nofollow">
                    </a>
                    <a href="#" rel="nofollow" target="_blank" class="nav_service"></a>
                    <a href="javascript:;" class="button_bookmark" rel="nofollow"></a>
                    <a href="javascript:;" class="nav_all on" rel="nofollow"></a>
                    <a href="javascript:;" class="nav_backtotop" rel="nofollow"></a>
                </div>
                <div id="sidebar" style="position:absolute;top: 0px;left: 720px;">
                    <div style="width:100%;margin-bottom:20px;" class="box_shadow"><a
                            href="http://localhost:8080/XLToysWholesale/i/activity/download_app?from=home_sidebar"
                            target="_blank"><img src="images/right1.jpg" original="" style="display: inline; "></a>
                    </div>
                    <div style="width:100%;margin-bottom:20px;" class="box_shadow"></div>
                    <style>
                        #mall_brands a {
                            background: url(http://images.jumei.com/mall/mall_shops3.jpg?) 0px 0 repeat-x transparent
                        }

                        #mall_brands a.olay {
                            background-position: -476px 0;
                        }

                        #mall_brands a.olay:hover {
                            background-position: -476px -120px
                        }

                        #mall_brands a.lancome {
                            background-position: -476px -240px;
                        }

                        #mall_brands a.lancome:hover {
                            background-position: -476px -300px
                        }

                        #mall_brands a.eli {
                            background-position: -476px -360px;
                        }

                        #mall_brands a.eli:hover {
                            background-position: -476px -420px
                        }
                    </style>


                    <div class="box_v1 popular_products_box" id="all_star">

                        <div class="title"><span class="arrow"></span>小梁推荐</div>
                        <div class="content" style="background:#eee;">
                            <div class="info">
                                <div style="display: block;"></div>
                            </div>
                            <div class="info">
                                <div style="display: block;"></div>
                            </div>
                            <div class="info">
                                <div style="">
                                    <a class="info_content" href="#" target="_blank">
                                        <img original="" alt="埃菲尔铜质铁塔（小中大号）  14g" src="images/sptg1.png"
                                             style="display: block; ">
                                    </a>
                                </div>
                            </div>
                            <div class="info">
                                <div class="info_titles">
                                    <a href="#" target="_blank">
                                        <span class="tit_name">小男孩儿最爱的木剑10*10</span>
                                        <span class="color_ecb">643</span>人购买
                                    </a>
                                </div>

                            </div>
                            <div class="info">
                                <div class="info_titles">
                                    <a href="#" target="_blank">
                                        <span class="tit_name">玩具大礼包等你拿~</span>
                                        <span class="color_ecb">693</span>人购买
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div id="home_toolbar"></div>

                    <div id="phone_web"></div>

                    <!-- 往期Deal start -->

                    <!--  往期Deal end -->
                    <div class="enquiry_list" id="enquiry_list">
                        <div class="ac" style="text-align: center;">
                            <a href="#" rel="nofollow" target="_blank">
                                <img original="#" alt="在线客服" src="images/live800_online_v3.png"
                                     style="display: inline; ">
                            </a>
                        </div>
                    </div>


                </div>
            </div>
            <div class="info_collect" id="info_collect" style="display: block; top: 20px; right: -300px;"
                 hash_id="bj121027p19918">
                <div class="func_intro" style="display: block; ">
                    <c:if test="${!empty page1.list}">
                        <c:forEach var="bulletin" items="${page1.list}">
                            <c:if test="${bulletin.bshow==1}">
                                <div class="func_box">
                                    <span>商城公告：${bulletin.name}</span>
                                </div>
                                <div class="text">（动态）${bulletin.description}</div>
                            </c:if>
                        </c:forEach>
                    </c:if>
                    <div class="func_rate">
                        <span>好评率</span>
                        <span class="pink" style="">100%</span>
                        <div class="service_rating small" style="">
                            <div class="rating">
                                <div class="value" style="width: 80px; ">&nbsp;</div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="collect_arrow"></div>
            </div>

        </div>


        <div class="clear"></div>
        <jsp:include page="commons/foot.jsp"/>
    </div>
</div>
</body>
</html>
