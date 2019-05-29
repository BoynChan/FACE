<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html
PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>员工信息注册</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="/css/work.css" type="text/css"/>
    <link rel="stylesheet" href="/css/admin.css" type="text/css"/>
    <link rel="stylesheet" href="/css/bootstrap.min.css" type="text/css"/>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script>
        $(document).ready(function () {
            if ("${success}") {
                alert("注册成功!");
            }
        });
    </script>
    <script type="text/javascript" src="/js/uploadimage.js"></script>
</head>
<style>
    .act {
        height: 50px;
    }

    .act2 {
        margin-left: 100px;
        width: 60%;
    }
</style>

<body style="margin-top: -11px;">

<div class="place" style="height: 36px;">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="/face/index">首页</a></li>
        <li><a href="/face/register">员工信息注册</a></li>
        <li><a href="#">基本内容</a></li>
    </ul>
</div>
<div class="formbody">
    <div class="formtitle"><span>员工基本信息注册</span></div>
    <div>
        <form method="POST" action="/face/register" enctype="multipart/form-data">
            <div class="leftbox">

                <div class="form-group act2" style="margin-top: 30px;/*margin-left: 100px;width: 400px;*/">
                    <label for="workername" style="font-size:16px;">姓名:</label>
                    <input type="text" class="form-control" id="workerName" name="workerName" placeholder="请输入姓名"/>
                </div>
                <div class="form-group act2" style="margin-top: 20px;/*margin-left: 100px;width:400px*/">
                    <label for="gender" style="font-size:16px;">性别:</label>
                    <select class="form-control" name="gender" id="gender">
                        <option style="display:none">请选择性别</option>
                        <option>男</option>
                        <option>女</option>
                    </select>
                    <!--<input type="text" class="form-control" id="gender" name="gender" placeholder="请输入性别"/>-->
                </div>
                <div class="form-group act2" style="margin-top: 20px;/*margin-left: 100px;width: 400px;*/">
                    <label for="age" style="font-size:16px;">年纪:</label>
                    <input type="text" class="form-control" id="age" name="age" placeholder="请输入年纪"/>
                </div>
                <div class="form-group act2" style="margin-top: 20px;/*margin-left: 100px;width: 400px;*/">
                    <label for="phone_number" style="font-size:16px;">手机号码:</label>
                    <input type="tel" class="form-control" id="phone_number" name="phone"
                           placeholder="请输入手机号码"/>
                </div>
                <div class="form-group act2" style="margin-top: 20px;/*margin-left: 100px;width: 400px;*/">
                    <label for="email" style="font-size:16px;">邮箱:</label>
                    <input type="email" class="form-control" id="email" name="email" placeholder="请输入邮箱"/>
                </div>
                <div class="form-group act2" style="margin-top: 20px;/*margin-left: 100px;width: 400px;*/">
                    <label for="workerGroup" style="font-size:16px;">就职部门:</label>
                    <select class="form-control" name="workerGroup" id="workerGroup">
                        <option style="display:none">请选择就职部门</option>
                        <option>开发组</option>
                        <option>应用组</option>
                        <option>安全组</option>
                    </select>
                    <!--<input type="text" class="form-control" id="group" name="group" placeholder="请输入所属组别"/>-->
                </div>
                <div class="form-group act2" style="margin-top: 20px;/*margin-left: 100px;width: 400px;*/">
                    <label for="email" style="font-size:16px;">职务:</label>
                    <input type="text" class="form-control" id="duty" name="workerPosition" placeholder="请输入职务"/>
                </div>
                <div class="form-group" style="margin-left: 75%;margin-top: 70px;">
                    <button type="submit" class="btn btn-sm btn-success" id="register_button"
                            style="font-size: 20px;padding: 0">注册
                    </button>
                </div>
            </div>
            <div class="rightbox">
                <table class="right1" align="center">
                    <tr>
                        <td colspan="2" align="center" style="font-size: 26px;">请上传人脸照片</td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <img src="/images/iconfont-tianjia.png" style="width:200px;height:200px;margin-top: 20px;"
                                 id="img_driver">
                        </td>
                    </tr>
                    <tr>
                        <td align="center">

                        </td>
                    </tr>
                </table>
                <input type="file"
                       class="btn btn-primary"
                       style="width:200px"
                       id="photo"
                       accept="image/jpg,image/png,image/jpeg" name="photo"
                       onChange="preview(this,'img_driver');">
            </div>
        </form>
    </div>
</div>
</body>

</html>