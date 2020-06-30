$(function () {
    <!-- 总页数 -->
    var totalPage = $("#totalPage").text();
    var path = "/infoList?currentPage=";
    <!-- 下一页 -->
    $(".ico-next").click(function () {
        var $currentPage = $("#currentPage");
        var num = Number($currentPage.val()) + 1;
        if (num > totalPage) {
            num = totalPage;
        }
        window.location = path + num;
    });
    <!--上一页-->
    $(".ico-pre").click(function () {
        var $currentPage = $("#currentPage");
        var num = Number($currentPage.val()) - 1;
        if (num < 1) {
            num = 1;
            window.location = path + num;
        }
        window.location = path + num;
    });
    <!-- 首页 -->
    $("#firstPage").click(function () {
        window.location = path + "1";
    });

    <!-- 尾页 -->
    $("#endPage").click(function () {
        window.location = path + totalPage;
    });
    <!-- 检查点赞 -->
    checkPraise();

    function checkPraise() {
        <!--  页面初始化完成后 将点过赞的信息的点赞按钮变成点击后的样式 -->
        var top = $("a[id='top']");
        top.each(function () {
            var $btn_top = $(this);
            praise_Ajax($btn_top, "check");
        });
    }

    $(".Top").click(function () {
        var btn_class = $(this).attr("class");
        //alert(btn_class);
        if (btn_class == "Top toping") {
            praise_Ajax($(this), "add");
        } else {
            praise_Ajax($(this),"del");
        }
    });


    <!--   -->
    function praise_Ajax($btn_top, type) {
        var path;
        if (type == "check") {
            path = "checkPraise?infoId=";
        }
        if (type == "add") {
            path = "doPraise?infoId=";
        }
        if (type == "del") {
            path = "delPraise?infoId=";
        }
        var infoId = $btn_top.parent().parent().parent().children("td.t_1").text();
        //alert(path+infoId);
        $.ajax({
            url: path + infoId,
            datatype: "text",
            success: function (flag) {
                if (flag == "false") {
                    $btn_top.toggleClass("toping");
                } else {
                    if (flag == "addSuccess") {
                        alert("点赞成功");
                    } else {
                        if (flag == "delSuccess") {
                            alert("取消点赞");
                        }
                    }
                }


            },
            error: function () {
                alert("ajax error");
            }
        });
    }

})
;

