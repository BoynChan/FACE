<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="https://cdn.staticfile.org/jquery/3.4.1/jquery.js"></script>

    <script language="javascript">
        $(function(){
            $('.error').css({'position':'absolute','left':($(window).width()-490)/2});
            $(window).resize(function(){
                $('.error').css({'position':'absolute','left':($(window).width()-490)/2});
            })
        });
    </script>


</head>


<body style="background:#edf6fa;margin-top: -11px;">

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="/face/">首页</a></li>
        <li><a href="#">404错误提示</a></li>
    </ul>
</div>
<div class="error">

    <h2>非常遗憾，您访问的页面不存在！</h2>
    <div class="reindex"><a href="/face/" target="_parent">返回首页</a></div>

</div>
</body>
</html>
