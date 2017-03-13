<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vic
  Date: 2017/1/25
  Time: 下午5:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="user_header">
    <div id="user_control">
        <ul class="menu_header">
            <li class="menu_stow">
                <a href="http://localhost:8080/XLToysWholesale/admin/login.jsp" target="_blank" rel="nofollow"
                   id="bookmark_us">
                    <span class="arrow"></span>
                    管理员登录
                </a>
                <em>|</em>
            </li>
            <li><a href="user/register" target="_self">注册</a><em>|</em>
            <li><a href="login.jsp" target="_blank">登录</a><em>|</em>
            <li id="my_jumei_attention_link">
                <a href="Cart_showCart" style="color:#ed145b;position: relative;z-index:9999;">
                    购物车
                    <span class="mycorn"></span>
                </a>
            </li>
        </ul>
        <c:choose>
            <c:when test="${not empty user}">
                <ul class="login_header">
                    <li>
                        <a href='Cart_showCart' rel='nofollow'>购物车</a>
                        <em>|</em>
                    </li>
                    <li class='menu_phone'>
                        <a href='repassword.jsp' rel='nofollow' target='_blank'>
                            <span class='arrow'></span>
                            <b>会员："${session.user.username } "欢迎使用！</b>
                        </a>
                        <em>|</em>
                    </li>
                    <li class="left">&nbsp;</li>
                </ul>
            </c:when>
            <c:otherwise>
                <ul class="login_header">
                    <li id="warn1">
                        <form>
                            用户名：<input type="text" name="username" id="userName"/>
                            密码：<input type="password" id="passWord" name="password"/>
                            <input type="button" value="登录" onclick="checkUser()">
                        </form>
                    </li>
                    <li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
                    <li id="warn"></li>
                    <li class="left">&nbsp;</li>
                </ul>
            </c:otherwise>
        </c:choose>
    </div>
</div>