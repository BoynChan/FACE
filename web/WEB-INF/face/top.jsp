<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>主界面</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <script language="JavaScript" src="https://cdn.staticfile.org/jquery/3.4.1/jquery.js"></script>
    <script type="text/javascript">
        $(function () {
            //顶部导航切换
            $(".nav li a").click(function () {
                $(".nav li a.selected").removeClass("selected")
                $(this).addClass("selected");
            })
        })
    </script>


</head>

<body style="background:url(/images/topbg.gif) repeat-x;">

<div class="topleft">
    <a href="/face/index" target="_parent"><img src="/images/logo.png" title="系统首页"/></a>
</div>
<div class="topright">
    <ul>
        <li><a href="/face/login" target="_parent"><span><img src="/images/i07.png" style="width: 20px;height: 20px"></span>退出登录</a></li>
    </ul>
</div>
<div class=>
</body>
</html>
