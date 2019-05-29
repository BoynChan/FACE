<!DOCTYPE html
PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>网站后台管理系统</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/css/work.css" rel="stylesheet" type="text/css"/>
    <link href="/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/sign.js" charset="UTF-8"></script>


</head>


<body style="margin-top: -11px;">

<div class="place" style="height: 36px;">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="/face/index">首页</a></li>
        <li><a href="#">员工签到信息</a></li>
        <li><a href="#">基本内容</a></li>
    </ul>
</div>

<div class="rightinfo">

    <div class="tools">

        <ul class="toolbar">
            <div class="two" style="margin-left: 20px;font-family: '微软雅黑';"><span>员工签到表</span></div>
            <div class="three">
                <div class="input-group" style="margin-top: 8px;width:300px;margin-left: 20px;"><span
                        class="input-group-addon" style="width:80px;">姓名：</span><input type="text" class="form-control" id="SearchWorkerName">
                </div>
                <div class="input-group" style="width:300px;margin-top: 8px;margin-left: 20px;"><span
                        class="input-group-addon">手机号码：</span><input type="text" class="form-control" id="SearchWorkerPhone"/></div>
                <li class="click"><a onclick="searchWorker()"><span><img src="/images/t04.png"/></span>查询</a></li>
                <li class="click"><a href="/face/register"><span><img src="/images/t01.png"/></span>添加</a></li>

                </div>
        </ul>
    </div>
    <div style="text-align: left; margin-left: 0px;margin-top: 90px;margin-left: 20px;">
        <a type="button" id="delchecked" onclick="delchecked()" style="" class="btn btn-sm btn-danger">批量删除选定项</a>
    </div>


    <table class="tablelist">
        <thead>
        <tr>
            <th><input name="" type="checkbox" value="" checked="checked"/></th>
            <th>员工姓名</th>
            <th>性别</th>
            <th>年纪</th>
            <th>手机号码</th>
            <th>邮箱</th>
            <th>所属部门</th>
            <th>职务</th>
            <th>签到情况</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody id="workerTableBody">
        <!-- 动态DOM操作 -->
        <!-- <tr class="text-center">
          <td><input name="" type="checkbox" value="" /></td>
          <td>1</td>
          <td>张三</td>
          <td>男</td>
          <td>20</td>
          <td>15505675356</td>
          <td>1473262988@qq.com</td>
          <td>营销部</td>
          <td>员工</td>
          <td>已签到</td>
          <td>
            <a href="#" type="button" class="btn btn-sm btn-primary" style="width: 50px;height: 30px;padding-left: 1px;"
              data-toggle="modal" data-target="#my_modal">详情</a>
          </td>
        </tr> -->

        </tbody>

    </table>
    <div class="pagin">
        <div class="message">共<i class="blue" id="workerCount">100</i>条记录</div>
    </div>

<%--    详情模态框   --%>
    <div class="modal fade" id="my_modal" tabindex="-1" role="dialog" aria-labelleby="myModallabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title" id="myModallabel" style="font-family: '微软雅黑';font-size: 20px;">
                        员工个人签到详情：</h4>
                </div>
                <div class="modal-body">
                    <!--<div class="right1">-->
                    <center>
                        <table>
                            <tr>
                                <td colspan="2" align="center">
                                    <img src="/images/iconfont-tianjia.png"
                                         style="width:150px;height:150px;margin-top: 5px;" id="workerPhoto">
                                </td>
                            </tr>
                            <tr>
                                <td align="center" style="font-family: '微软雅黑';font-size: 18px;margin-top: 5px;" id="workerName">
                                    员工姓名：张三
                                </td>
                            </tr>
                        </table>
                    </center>
                    <center>
                        <table class="tablelist" style="width: 440px;margin-top: 15px;">
                            <thead>
                            <tr>
                                <th style="width: 220px;">签到时间</th>
                                <th style="width:220px">签到情况</th>
                            </tr>
                            </thead>
                            <tbody id="signTable">
<%--                            动态DOM操作--%>
                            <%--<tr class="text-center">
                                <td>2019年1月1日</td>
                                <td>已签到</td>
                            </tr>--%>

                            </tbody>
                        </table>
                    </center>

                    <!--序号：1<hr/>
                        姓名：张三<hr/>
                        性别：男<hr/>
                        年纪：20<hr/>
                        手机号码：15505675356<hr/>
                        邮箱：1473262988@qq.com<hr/>
                        就职部门：营销部<hr/>
                        职务：员工<hr/>
                        签到时间：2019年1月1日</hr>
                    </div>-->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


</body>

</html>