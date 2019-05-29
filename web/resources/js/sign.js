
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
    $.ajax("http://114.213.210.211:8080/api/sign/list/"+id,
        {
            dataType: "json",
            contentType: "application/json",
            async: true,
            success: function (data) {
                var table = document.getElementById("signTable");
                table.innerHTML="";
                for(var i = 0;i<data.length;i++){
                    var tr = document.createElement("tr");
                    tr.className="text-center";
                    var td1 = document.createElement("td");
                    td1.innerHTML=data.signTime[i];
                    var td2 = document.createElement("td");
                    td2.innerHTML="已签到";
                    tr.appendChild(td1);
                    tr.appendChild(td2);
                    table.appendChild(tr);
                }
            },
            error: function () {
                alert("Error");
            }
        });
    $.ajax("http://114.213.210.211:8080/api/worker/"+id,
        {
            dataType: "json",
            contentType: "application/json",
            async: true,
            success: function (data) {
                var name = document.getElementById("workerName");
                var photo = document.getElementById("workerPhoto");
                name.innerHTML = "员工姓名:"+data.workerName;
                photo.setAttribute("src","/resources/photo/"+data.photoName);
            },
            error: function () {
                alert("Error");
            }
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
    $.ajax("http://114.213.210.211:8080/api/sign/search",
        {
            dataType: "json",
            contentType: "application/json; charset=utf-8",
            async: true,
            data: JSON.stringify(data),//RequestBody接受的是JSON字符串,所以要将JSON对象转化成字符串
            type: "POST",
            success: function (data) {
                listWorker(data);
            },
            error: function () {
                alert("搜索失败");
            }
        });
}







/**
 * 获取全部的用户信息
 */
function getWorkerPageList() {
    $.ajax("http://114.213.210.211:8080/api/sign/list",
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
        td9.innerHTML = data.workerList[i].signTime;
        tr.appendChild(td9);

        var td10 = document.createElement("td");
        var a1 = document.createElement("a");
        a1.setAttribute("type","button");
        a1.setAttribute("onclick","info("+data.workerList[i].id+")");
        a1.innerHTML="详情";
        a1.className = "btn btn-sm btn-primary";
        a1.style = "width: 50px;height: 30px;padding-left:1px";
        td10.appendChild(a1);
        tr.appendChild(td10);

        tbody.appendChild(tr);
    }
}