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
        var checkbox = '<td><input id="' + roleId + '" class="itemBox" type="checkbox"></td>';
        var roleNameTd = "<td>" + roleName + "</td>";
        var checkBtn = '<button id="' + roleId + '" type="button" class="btn btn-success btn-xs checkBtn"><i class=" glyphicon glyphicon-check"></i></button>';
        var pencilBtn = '<button id="' + roleId + '" type="button" class="btn btn-primary btn-xs pencilBtn"><i class=" glyphicon glyphicon-pencil"></i></button>';
        var removeBtn = '<button id="' + roleId + '" type="button" class="btn btn-danger btn-xs removeBtn"><i class=" glyphicon glyphicon-remove"></i></button>';
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
    let totalRecord = pageInfo.total;

    // 声明相关属性
    let properties = {
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

/**
 * 声明专门的函数显示修改的模态框
 */
function showConfirmModal(roleArray) {

    // 打开模态框
    $("#confirmModal").modal("show");

    // 清除旧的数据
    let roleNameDiv = $("#roleNameDiv");
    roleNameDiv.empty();

    // 在全局范围创建一个数组专门又用来放角色id
    window.roleIdArray = [];

    // 从传入的roleArray数组中读取
    for (let i = 0; i < roleArray.length; i++) {
        let role = roleArray[i];
        let roleName = role.name;
        roleNameDiv.append(roleName + "<br/>");

        // 调用数组对象的push()方法存入新元素
        window.roleIdArray.push(role.roleId);
    }

}

/**
 * 为权限设置模态框添加树型结构
 */
function fillAuthTree() {

    // 发送Ajax请求查询Auth数据
    let ajaxReturn = $.ajax({
        url: "assign/all/auth",
        type: "post",
        dataType: "json",
        async: false,
    });

    if (ajaxReturn.status !== 200) {
        layer.msg("请求处理出错了！响应码「" + ajaxReturn.status + "」:" + ajaxReturn.statusText);
        return ;
    }

    // 从响应结果中获取Auth的JSON数据
    // 从服务端查询到的list不需要组装成树形结构，这里将他交给zTree处理组装
    let authList = ajaxReturn.responseJSON.data;

    // 准备对zTree进行设置JSON设置
    let setting = {
        data: {
            simpleData: {
                // 开启简单JSON的功能
                enable: true,
                // 使用categoryId属性关联父节点，不用pId
                pIdKey: 'categoryId'
            },
            key: {
                // 使用title属性显示节点，不适用默认的name属性
                name: 'title'
            }
        },
        check: {
            enable: true
        }
    };

    // 生成树形结构
    // <ul id="authTreeDemo" class="ztree"></ul>
    $.fn.zTree.init($("#authTreeDemo"), setting, authList);

    // 获取zTreeObj对象
    let zTreeObj = $.fn.zTree.getZTreeObj("authTreeDemo");

    // 调用zTreeObj对象的方法，把节点展开
    zTreeObj.expandAll(true);

    // 查询已分配的Auth的id组成的数组
    ajaxReturn = $.ajax({
        url: "assign/role/auth/id",
        type: "post",
        data: {
            roleId: window.roleId
        },
        dataType: "json",
        async: false
    });

    if (ajaxReturn.status !== 200) {
        layer.msg("请求处理出错了！响应码「" + ajaxReturn.status + "」:" + ajaxReturn.statusText);
        return ;
    }

    // 从相应结果中获取authIdArray
    let authIdArray = ajaxReturn.responseJSON.data;

    // 根据authIdArray把树形结构中对应节点勾选上
    // 历遍authIdArray
    for (let i = 0; i < authIdArray.length; i++) {
        let authId = authIdArray[i];

        // 根据id查询树形结构中的对应节点
        let treeNode = zTreeObj.getNodeByParam("id", authId);

        // 将treeNode设置为被勾选
        // checked设置为true表示节点勾选
        let checked = true;

        // checkTypeFlag设置为false,表示不’联动‘，避免将不该勾选的勾选上
        let checkTypeFlag = false;

        // 执行
        zTreeObj.checkNode(treeNode, checked, checkTypeFlag);

    }

}