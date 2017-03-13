<%--
  Created by IntelliJ IDEA.
  User: vic
  Date: 2017/1/25
  Time: 下午5:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!doctype html>
<html>
<head>
    <base href="<%=basePath%>">

    <title>注册页面</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link href="css/login.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="js/register.js"></script>
    <script type="text/javascript" src="js/jquery/jquery-1.8.0.min.js"></script>

</head>
<body>
<div id="box">
    <br>
    <br>
    <div id="top"><img src="images/login/91405.png" width="950" height="251" border="0" usemap="#Map"/>
        <map name="Map" id="Map">
            <area shape="rect" coords="742,222,842,250" href="login.jsp"/>
        </map>
    </div>

    <div id="main">
        <form id="form1" name="registerFrom" method="post">
            <table style="width: 500px;">
                <tr>
                    <td style="width: 95px;"><img src="images/login/emil.png" width="91" height="30"/></td>
                    <td style="width: 150px;"><input type="text" width="20" name="user.email" id="em" onblur="emailCheck()"/></td>
                    <td id="email"></td>
                </tr>
                <tr>
                    <td><img src="images/login/zh.png" width="91" height="30"/></td>
                    <td><input type="text" name="user.username" id="userName" onblur="checkUser()"/></td>
                    <td id="u"></td>
                </tr>
                <tr>
                    <td><img src="images/login/mm.png" width="91" height="30"/></td>
                    <td><input type="password" name="user.password" id="password" onblur="passwordCheck()"/></td>
                    <td id="pwd"></td>
                </tr>
                <tr>
                    <td><img src="images/login/qrmm.png" width="91" height="30"/></td>
                    <td><input type="password" name="password2" id="password1" onblur="checkPwdSame()"/></td>
                    <td id="pwd1"></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="image" id="dl" src="images/login/92403.png" onclick="formCheck()"/></td>
                    <td></td>
                </tr>
            </table>
        </form>
        <img src="images/login/91404.png" name="img" width="221" height="146" border="0" usemap="#imgMap" id="img"/>
    </div>
</div>
</body>
</html>