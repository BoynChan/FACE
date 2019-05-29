
/**
 * 文档加载时运行
 */
$(document).ready(function () {
    getWorkerPageList();

    $(".tiptop a").click(function () {
        $(".tip").fadeOut(200);
    });

    $(".sure").click(function () {
        $(".tip").fadeOut(100);
    });

    $(".cancel").click(function () {
        $(".tip").fadeOut(100);
    });
});



/**
 * 详情按钮加载数据的ajax过程与将数据显示的DOM操作
 * @param id
 */
function info(id) {
    $('#my_modal').modal('show');
    $.ajax("http://114.213.210.211:8080/api/worker/"+id,
        {
            dataType: "json",
            contentType: "application/json",
            async: true,
            success: function (data) {
                var info = document.getElementById("info_modal");
                info.innerHTML="";
                var img = document.createElement("img");
                img.style = "width:150px;height:150px;margin-left:30%;margin-top:5px;margin-bottom:3px";
                img.setAttribute("src","/resources/photo/"+data.photoName);
                info.appendChild(img);

                var span = document.createElement("span");
                span.innerHTML = "姓名:"+data.workerName;
                var hr = document.createElement("hr");
                info.appendChild(span);
                info.appendChild(hr);

                var span = document.createElement("span");
                span.innerHTML = "性别:"+data.gender;
                var hr = document.createElement("hr");
                info.appendChild(span);
                info.appendChild(hr);

                var span = document.createElement("span");
                span.innerHTML = "年龄:"+data.age;
                var hr = document.createElement("hr");
                info.appendChild(span);
                info.appendChild(hr);

                var span = document.createElement("span");
                span.innerHTML = "手机号码:"+data.phone;
                var hr = document.createElement("hr");
                info.appendChild(span);
                info.appendChild(hr);

                var span = document.createElement("span");
                span.innerHTML = "邮箱:"+data.email;
                var hr = document.createElement("hr");
                info.appendChild(span);
                info.appendChild(hr);

                var span = document.createElement("span");
                span.innerHTML = "所属部门:"+data.workerGroup;
                var hr = document.createElement("hr");
                info.appendChild(span);
                info.appendChild(hr);

                var span = document.createElement("span");
                span.innerHTML = "职务:"+data.workerPosition;
                var hr = document.createElement("hr");
                info.appendChild(span);
                info.appendChild(hr);
            },
            error: function () {
                alert("Error");
            }
        });

}


/**
 * 修改功能 按下时将ajax向后台请求数据并自动填充
 */
function change(id) {
    $('#my_modal2').modal('show');
    $.ajax("http://114.213.210.211:8080/api/worker/"+id,
        {
            dataType: "json",
            contentType: "application/json",
            async: true,
            success: function (data) {
                $("#update_img").attr("src","/resources/photo/"+data.photoName);
                $("#update_age").attr("value",data.age);
                $("#update_duty").attr("value",data.workerPosition);
                $("#update_email").attr("value",data.email);
                $("#update_gender").attr("value",data.gender);
                $("#update_phone_number").attr("value",data.phone);
                $("#update_group").attr("value",data.workerGroup);
                $("#update_name").attr("value",data.workerName);
                $("#update_id").attr("value",data.id);
            },
            error: function () {
                alert("Error");
            }
        });
}

/**
 * 删除页显示函数
 * @param id
 */
function deleteOneConfirm(id) {
    $("#delcfmModel1").modal("show");
    $("#deleteOneConfirm").attr("onclick","deleteWorkerById("+id+")");
}

function deletePageConfirm() {
    $("#delcfmModel2").modal("show");
    $("#deletePageConfirm").attr("onclick","deleteWorkerSelected()");
}

function deleteWorkerSelected(){
    var deleteID = [];
    var table = document.getElementById("workerTableBody");
    var length = table.childNodes.length;
    for(var i = 0;i<length;i++){
        if(table.childNodes[i].childNodes[0].firstElementChild.checked){
            deleteID.push(table.childNodes[i].childNodes[0].firstElementChild.name);
        }
    }
    deleteID.forEach(function (value, index, array) {
        deleteWorkerById(value);
    });

}

/**
 * 搜索功能
 * 点击搜索按钮时会通过ajax传值到后台,然后将返回的数据显示到首页
 */
function searchWorker() {
    var username = document.getElementById("SearchWorkerName").value;
    var phone = document.getElementById("SearchWorkerPhone").value;
    data = {
        "workerName": username,
        "phone": phone
    };
    $.ajax("http://114.213.210.211:8080/api/worker/list/search",
        {
            dataType: "json",
            contentType: "application/json; charset=utf-8",
            async: true,
            data: JSON.stringify(data),//RequestBody接受的是JSON字符串,所以要将JSON对象转化成字符串
            type: "POST",
            success: function (data) {
                listWorker(data)
            },
            error: function () {
                alert("删除失败");
            }
        });
}

function formClose(){
    $("#my_modal2").modal('hide');
    var photo = document.getElementById("update_photo");
    photo.value = "";
}

/**
 * 修改功能提交时使用ajax提交表单
 */
function formSubmit(){
    $("#my_modal2").modal('hide');
    var form = new FormData();
    var photo = document.getElementById("update_photo");
    if(photo.files[0]===undefined) {
        form.append("isUpload","0");
    }else{
        form.append("isUpload","1");
        form.append("photo",photo.files[0]);
    }

    photo.value = "";
    form.append("workerName",$("#update_name").val());
    form.append("age",$("#update_age").val());
    form.append("gender",$("#update_gender").val());
    form.append("phone",$("#update_phone_number").val());
    form.append("workerGroup",$("#update_group").val());
    form.append("workerPosition",$("#update_duty").val());
    form.append("email",$("#update_email").val());
    form.append("id",$("#update_id").val());
    $.ajax("http://114.213.210.211:8080/api/update",
        {
            type: 'POST',
            data: form,
            async: false,
            cache: false,
            contentType: false,
            processData: false,
            success: function (data) {
                location.reload();
            },
            error: function () {
                alert("修改失败");
            }
        });
}



/**
 * 点击删除按钮并确认后将删除信息传到后台
 * @param id
 */
function deleteWorkerById(id) {
    $("#delcfmModel1").modal("hide");
    $("#delcfmModel2").modal("hide");
    var tr = document.getElementById("tr-" + id);
    tr.parentNode.removeChild(tr);
    var count = parseInt(document.getElementById("workerCount").innerHTML);
    document.getElementById("workerCount").innerHTML = count - 1;
    $.ajax("http://114.213.210.211:8080/api/worker/delete/" + id,
        {
            dataType: "json",
            contentType: "application/json",
            async: true,
            success: function () {
                console.log("删除成功");
            },
            error: function () {
                alert("删除失败");
            }
        });
}

/**
 * 获取全部的用户信息
 */
function getWorkerPageList() {
    $.ajax("http://114.213.210.211:8080/api/worker/list",
        {
            dataType: "json",
            contentType: "application/json",
            async: true,
            success: function (data) {
                listWorker(data);
            },
            error: function () {
                alert("Error");
            }
        });
}

/**
 * 将用户名单在页面中删除
 */
function deleteWorker() {
    var tbody = document.getElementById("workerTableBody");
    tbody.innerHTML = "";
}

/**
 * 将用户名单先清空,再将其一个个放到表格中
 * @param data 用户数据
 */
function listWorker(data) {
    deleteWorker();
    var tbody = document.getElementById("workerTableBody");
    document.getElementById("workerCount").innerHTML = data.length;
    for (i = 0; !(i >= data.length); i++) {
        var tr = document.createElement("tr");
        tr.className = "text-center";
        tr.id = "tr-" + data.workerList[i].id;

        var td1 = document.createElement("td");
        var input = document.createElement("input");
        input.type = "checkbox";
        input.name = data.workerList[i].id;
        td1.appendChild(input);
        tr.appendChild(td1);

        var td2 = document.createElement("td");
        if (data.workerList[i].workerName === "") td2.innerHTML = "无";
        else td2.innerHTML = data.workerList[i].workerName;
        tr.appendChild(td2);

        var td3 = document.createElement("td");
        if (data.workerList[i].gender === "无") td3.innerHTML = "无";
        else td3.innerHTML = data.workerList[i].gender;
        tr.appendChild(td3);

        var td4 = document.createElement("td");
        if (data.workerList[i].age === "") td4.innerHTML = "无";
        else td4.innerHTML = data.workerList[i].age;
        tr.appendChild(td4);

        var td5 = document.createElement("td");
        if (data.workerList[i].phone === "") td5.innerHTML = "无";
        else td5.innerHTML = data.workerList[i].phone;
        tr.appendChild(td5);

        var td6 = document.createElement("td");
        if (data.workerList[i].email === "") td6.innerHTML = "无";
        else td6.innerHTML = data.workerList[i].email;
        tr.appendChild(td6);

        var td7 = document.createElement("td");
        if (data.workerList[i].workerGroup === "请选择就职部门") td7.innerHTML = "无";
        else td7.innerHTML = data.workerList[i].workerGroup;
        tr.appendChild(td7);

        var td8 = document.createElement("td");
        if (data.workerList[i].workerPosition === "") td8.innerHTML = "无";
        else td8.innerHTML = data.workerList[i].workerPosition;
        tr.appendChild(td8);

        var td9 = document.createElement("td");
        var a1 = document.createElement("a");
        a1.setAttribute("type","button");
        a1.setAttribute("onclick","info("+data.workerList[i].id+")");
        a1.innerHTML="详情";
        a1.className = "btn btn-sm btn-primary";
        a1.style = "width: 50px;height: 30px;padding-left:1px";
        var a2 = document.createElement("a");
        a2.setAttribute("onclick","change("+data.workerList[i].id+")");
        a2.type = "button";
        a2.className = "btn btn-sm btn-warning";
        a2.style = "width: 50px;height: 30px;padding-left:1px;margin-left:4px";
        a2.innerHTML = "修改";
        var a = document.createElement("a");
        a.type = "button";
        a.className = "btn btn-sm btn-danger";
        a.style = "width: 50px;height: 30px;padding-left:1px;margin-left:4px";
        a.innerHTML = "删除";
        a.setAttribute("onclick", "deleteOneConfirm(" + data.workerList[i].id + ")");

        td9.appendChild(a1);
        td9.appendChild(a2);
        td9.appendChild(a);
        tr.appendChild(td9);
        tbody.appendChild(tr);
    }
    $('.tablelist tbody tr:odd').addClass('odd');
}