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
    <script type="text/javascript" src="/js/worker.js"></script>


</head>


<body style="margin-top: -11px;">

<div class="place" style="height: 36px;">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="/face/index">首页</a></li>
        <li><a href="/face/worker">员工信息管理</a></li>
        <li><a href="#">基本内容</a></li>
    </ul>
</div>

<div class="rightinfo">

    <div class="tools">

        <ul class="toolbar">
            <div class="two" style="margin-left: 20px;"><span>员工信息列表</span></div>
            <div class="three">
                <div class="input-group" style="margin-top: 8px;width:300px;margin-left: 20px;"><span
                        class="input-group-addon" style="width:80px;">姓名：</span><input type="text"
                                                                                       class="form-control"
                                                                                       id="SearchWorkerName"/></div>
                <div class="input-group" style="width:300px;margin-top: 8px;margin-left: 20px;"><span
                        class="input-group-addon">手机号码：</span><input type="text" class="form-control"
                                                                     id="SearchWorkerPhone"/></div>
                <li class="click"><a onclick="searchWorker()"> <span><img src="/images/t04.png"/></span>查询</a></li>
                <li class="click"><a href="/face/register"><span><img src="/images/t01.png"/></span>添加</a></li>
            </div>
        </ul>
    </div>
    <div style="text-align: left; margin-left: 20px;margin-top: 100px;">
        <a type="button" id="delchecked" onclick="deletePageConfirm()" style=""
           class="btn btn-sm btn-danger">批量删除选定项</a>
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
            <th>操作</th>
        </tr>
        </thead>
        <tbody id="workerTableBody">
        <%--        动态DOM操作     --%>
        </tbody>
    </table>
    <div class="pagin">
        <div class="message">共<i class="blue" id="workerCount"></i>条记录，</div>
    </div>

    <%--模态框部分--%>
    <div class="tip"><%--模态框一 提示是否删除的框体--%>
        <div class="tiptop"><span>提示信息</span><a></a></div>

        <div class="tipinfo">
            <span><img src="/images/ticon.png"/></span>
            <div class="tipright">
                <p>是否确认对信息的删除 ？</p>
                <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
            </div>
        </div>

        <div class="tipbtn">
            <input name="" type="button" class="sure" id="deleteSure" onclick="deleteUserEnter()" value="确定"/>&nbsp;
            <input name="" type="button" class="cancel" value="取消"/>
        </div>

    </div>

    <!-- 详细信息模态框 -->
    <div class="modal fade" id="my_modal" tabindex="-1" role="dialog" aria-labelleby="myModallabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title" style="font-family: '微软雅黑';font-size: 20px">员工详细信息：</h4>
                </div>

                <div class="modal-body" id="info_modal" style="font-size: 16px;">

                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
                </div>
            </div>
        </div>
    </div>


    <%--    确认单个删除模态框--%>
    <div class="modal fade" id="delcfmModel1">
        <div class="modal-dialog">
            <div class="modal-content message_align">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">×</span></button>
                    <h4 class="modal-title">确认信息</h4>
                </div>
                <div class="modal-body">
                    <p id="delcfmMsg1">您确认要删除吗？</p>
                </div>
                <div class="modal-footer">
                    <input type="hidden" id="submitUrl1"/>
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <a class="btn btn-success" id="deleteOneConfirm">确定</a>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->

    <%--    确认批量删除模态框--%>
    <div class="modal fade" id="delcfmModel2">
        <div class="modal-dialog">
            <div class="modal-content message_align">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">×</span></button>
                    <h4 class="modal-title">确认信息</h4>
                </div>
                <div class="modal-body">
                    <p id="delcfmMsg2">您确认要删除所选项吗？</p>
                </div>
                <div class="modal-footer">
                    <input type="hidden" id="submitUrl2"/>
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <a class="btn btn-success" id="deletePageConfirm">确定</a>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->

    <%--    修改信息模态框     --%>
    <div class="modal fade" id="my_modal2" data-backdrop='static' tabindex="-1" role="dialog"
         aria-labelleby="myModallabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form id="update_form" method="post" enctype="multipart/form-data">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                        <h4 class="modal-title" id="myModallabel">修改员工信息:</h4>
                    </div>
                    <div class="modal-body">
                        <!--<div class="right1">-->
                        <table class="table1" align="center">
                            <tr>
                                <td colspan="2" align="center" style="font-size: 16px;">请上传人脸照片<br/>(如无修改则无需上传)</td>
                            </tr>

                            <tr>
                                <td colspan="2" align="center">
                                    <img src=""
                                         style="width:150px;height:150px;margin-top: 20px;"
                                         id="update_img">
                                </td>
                            </tr>

                            <tr>
                                <%--<td align="center">
                                    <button type="button"
                                            onclick="driverUpload();"><i
                                            class="fa fa-cloud-upload"></i>上传
                                    </button>
                                </td>--%>

                            </tr>
                        </table>
                        <input type="file"
                               class="btn btn-primary btn-block"
                               id="update_photo"
                               accept="image/jpg,image/png,image/jpeg" name="photo"
                               style="width:200px;margin-top:5px;margin-right:60px"
                               onChange="preview(this,'update_img');">
                    </div>
                    <input type="hidden" name="id" id="update_id">
                    <div class="form-group" style="margin-top: 20px;margin-left: 40px;width: 500px">
                        <label for="update_name" style="font-size:18px;">姓名:</label>
                        <input type="text" class="form-control" id="update_name" name="workerName" placeholder="请输入姓名"/>
                    </div>
                    <div class="form-group" style="margin-top: 15px;margin-left: 40px;width: 500px">
                        <label for="update_gender" style="font-size:18px;">性别:</label>
                        <input type="text" class="form-control" id="update_gender" name="gender" placeholder="请输入性别"/>
                    </div>
                    <div class="form-group" style="margin-top: 15px;margin-left: 40px;width: 500px">
                        <label for="update_age" style="font-size:18px;">年纪:</label>
                        <input type="text" class="form-control" id="update_age" name="age" placeholder="请输入年纪"/>
                    </div>
                    <div class="form-group" style="margin-top: 15px;margin-left: 40px;width: 500px">
                        <label for="update_phone_number" style="font-size:18px;">手机号码:</label>
                        <input type="text" class="form-control" id="update_phone_number" name="phone"
                               placeholder="请输入手机号码"/>
                    </div>
                    <div class="form-group" style="margin-top: 15px;margin-left: 40px;width: 500px">
                        <label for="update_email" style="font-size:18px;">邮箱:</label>
                        <input type="text" class="form-control" id="update_email" name="email" placeholder="请输入邮箱"/>
                    </div>
                    <div class="form-group" style="margin-top: 15px;margin-left: 40px;width: 500px">
                        <label for="update_group" style="font-size:18px;">所属组别:</label>
                        <input type="text" class="form-control" id="update_group" name="workerGroup"
                               placeholder="请输入所属组别"/>
                    </div>
                    <div class="form-group" style="margin-top: 15px;margin-left: 40px;width: 500px">
                        <label for="update_duty" style="font-size:18px;">职务:</label>
                        <input type="text" class="form-control" id="update_duty" name="workerPosition"
                               placeholder="请输入职务"/>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" onclick="formClose()">关闭</button>
                        <button type="button" id="btn_submit" class="btn btn-primary" onclick="formSubmit()">
                            <!--<span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>-->保存
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>


</div>

<script type="text/javascript" src="/js/uploadimage.js"></script>
</body>

</html>