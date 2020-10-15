/**
 * 生成分页效果
 */
function generatePage() {

    // 获取分页数据
    var pageInfo = getPageInfoRemote();

    // 填充表格
    fillTableBody(pageInfo);

}

/**
 * 远程访问服务端程序获取pageInfo数据
 */
function getPageInfoRemote() {

    var ajaxResult = $.ajax({
        url: "role/getPageInfo",
        type: "post",
        data: {
            pageNum: window.pageNum,
            pageSize: window.pageSize,
            keyword: window.keyword
        },
        async: false,
        dataType: "json",
    });

    console.log(ajaxResult);

    // 判断当前响应状态码是否为200
    var statusCode = ajaxResult.status;

    if (statusCode !== 200) {
        layer.msg("失败！响应状态码=" + statusCode + "说明信息=" + ajaxResult.statusText);
        return null;
    }

    // 如果响应状态码是200，说明请求处理成功，获取pageInfo
    var resultEntity = ajaxResult.responseJSON;

    // 从resultEntity中获取result属性
    var result = resultEntity.result;

    // 判断result是否成功
    if (result === 'FAILED') {
        layer.msg(resultEntity.message);
        return  null;
    }

    // 确认result为成功后获取pageInfo
    return resultEntity.data;
}

/**
 * 填充表格
 * @param pageInfo 从后端查询到的数据
 */
function fillTableBody(pageInfo) {

    // 清除tbody中的旧数据
    $("#rolePageBody").empty();

    // 这里清空是为了让没有搜索结果时不显示分页导航条
    $("#Pagination").empty();

    // 判断pageInfo是否有效
    if (pageInfo == null || pageInfo.list == null || pageInfo.list.length === 0) {
        $('#rolePageBody').append('<tr><td colspan="4" align="center">抱歉！没有查到您要的数据！</td></tr>');
        return ;
    }

    // 填充pageInfo的list属性填充tbody
    for (var i = 0; i < pageInfo.list.length; i++) {
        var role = pageInfo.list[i];
        var roleId = role.id;
        var roleName = role.name;
        var numberTd = "<td>" + (i + 1) + "</td>";
        var checkbox = '<td><input type="checkbox"></td>';
        var roleNameTd = "<td>" + roleName + "</td>";
        var checkBtn = '<button type="button" class="btn btn-success btn-xs"><i class=" glyphicon glyphicon-check"></i></button>';
        var pencilBtn = '<button type="button" class="btn btn-primary btn-xs"><i class=" glyphicon glyphicon-pencil"></i></button>';
        var removeBtn = '<button type="button" class="btn btn-danger btn-xs"><i class=" glyphicon glyphicon-remove"></i></button>';
        var buttonTd = "<td>" + checkBtn + " " + pencilBtn + " " + removeBtn + "</td>";

        var tr = "<tr>" + numberTd + checkbox + roleNameTd + buttonTd + "</tr>";

        $('#rolePageBody').append(tr);
    }

    // 生成分页导航条
    generateNavigator(pageInfo);
}

/**
 * 生成分页导航栏
 * @param pageInfo 从后端查询到的数据
 */
function generateNavigator(pageInfo) {

    // 获取总记录数
    var totalRecord = pageInfo.total;

    // 声明相关属性
    var properties = {
        num_edge_entries: 3,    // 边缘页数
        num_display_entries: 5, // 主体页数
        callback: paginateCallBack, // 指定用户点击‘翻页’按钮跳转页面的回调函数
        items_per_page: pageInfo.pageSize,  // 每页要显示的数据的数量
        current_page: pageInfo.pageNum - 1, // 配置pagination内部使用的是pageIndex来管理页码，pageIndex从0开始，pageNum从1开始
        prev_text: "上一页",   // 上一页按钮上现实的文本
        next_text: "下一页"    // 下一页按钮上现实的文本
    };

    // 调用pagination()函数
    $("#Pagination").pagination(totalRecord, properties);
}

/**
 * paginate用的回调函数
 * @param pageIndex 索引
 * @param jQuery ？
 */
function paginateCallBack(pageIndex, jQuery) {

    // 修改window对象的pageNum属性
    window.pageNum = pageIndex + 1;

    // 调用分页函数
    generatePage();

    // 取消按钮的查链接行为
    return false;
}