document.write("<script src='http://cdn.staticfile.org/jquery/3.4.1/jquery.min.js'></script>");

function workerOperation(id) {
    if (confirm("是否删除?")) {
        $.ajax("/test/delete/" + id,
            {
                type: "get",
                success: function () {
                    location.reload();
                }
            });
    }
}

function sign(id) {
    $.ajax("/test/sign/insertToday/" + id,
        {
            type: "get",
            success: function () {
                location.reload();
                console.log(id + "已签到");
            }
        });
}