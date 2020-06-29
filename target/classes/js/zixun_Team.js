$().ready(function () {
    <!-- 总页数 -->
    var totalPage = $("#totalPage").text();
    var path = "/UserList?currentPage=";
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
});