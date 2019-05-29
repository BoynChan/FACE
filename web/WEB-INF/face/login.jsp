<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>欢迎登录后台信息管理系统</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <script language="JavaScript" src="https://cdn.staticfile.org/jquery/3.4.1/jquery.js"></script>
    <script src="/js/cloud.js" type="text/javascript"></script>
</head>

<body style="background-color:#1c77ac; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">


<div id="mainBody">
    <div id="cloud1" class="cloud"></div>
    <div id="cloud2" class="cloud"></div>
</div>
<div class="logintop">
    <span style="font-size: 18px;">欢迎登录后台信息管理平台</span>
    <ul>
        <li><a href="#">回首页</a></li>
        <li><a href="#">帮助</a></li>
        <li><a href="#">关于</a></li>
    </ul>
</div>
<div class="loginbody" >
    <span class="systemlogo"></span>
    <form action="/login" method="post">
        <div class="loginbox">
            <ul>
                <li><input name="username" type="text" class="loginuser" value="" onclick="JavaScript:this.value=''"
                           placeholder="请输入用户名"/></li>
                <li><input name="password" type="password" class="loginpwd" value="" onclick="JavaScript:this.value=''"
                           placeholder="请输入密码"/></li>
                <li><input name="" type="submit" class="loginbtn" value="登录"/></li>
            </ul>
        </div>
    </form>
</div>
</body>
</html>
