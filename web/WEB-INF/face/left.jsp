<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <script language="JavaScript" src="https://cdn.staticfile.org/jquery/3.4.1/jquery.js"></script>

    <script type="text/javascript">
        $(function () {
            //导航切换
            $(".menuson li").click(function () {
                $(".menuson li.active").removeClass("active")
                $(this).addClass("active");
            });
            $('.title').click(function () {
                var $ul = $(this).next('ul');
                $('dd').find('ul').slideUp();
                if ($ul.is(':visible')) {
                    $(this).next('ul').slideUp();
                } else {
                    $(this).next('ul').slideDown();
                }
            });
        })
    </script>


</head>

<body style="background:#f0f9fd;">
<dl class="leftmenu">
    <dd>
        <div class="title" style="font-size: 16px;">
            <span><img src="/images/leftico01.png"/></span>管理信息
        </div>
        <ul class="menuson">
            <li><cite></cite><a href="/face/register" target="rightFrame" style="margin-top: 40px;font-size: 16px;">员工信息注册</a><i></i>
            </li>
            <li><cite></cite><a href="/face/worker" target="rightFrame"
                                style="margin-top: 30px;font-size: 16px;">员工信息管理</a><i></i></li>
            <li><cite></cite><a href="/face/sign" target="rightFrame"
                                style="margin-top: 30px;font-size: 16px;">员工签到信息</a><i></i></li>
        </ul>
    </dd>

</dl>
</body>
</html>
