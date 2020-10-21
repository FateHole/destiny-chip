<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <%@ include file="../include/header.jsp" %>
    <title>管理-控制面板</title>
    <link rel="stylesheet" href="static/ztree/zTreeStyle.css">
</head>
<body>
    <%@ include file="../include/nav.jsp" %>

    <div class="container-fluid">
        <div class="row">
            <%@ include file="../include/sidebar.jsp" %>
            <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

                <div class="panel panel-default">
                    <div class="panel-heading">
                        <i class="glyphicon glyphicon-th-list"></i> 权限菜单列表
                        <div style="float:right;cursor:pointer;" data-toggle="modal" data-target="#myModal">
                            <i class="glyphicon glyphicon-question-sign"></i>
                        </div>
                    </div>
                    <div class="panel-body">
                        <%-- 这个url标签是zTree动态生成的节点所依附的静态节点 --%>
                        <ul id="treeDemo" class="ztree">
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <%@ include file="../include/tail.jsp" %>
    <script type="text/javascript" src="static/ztree/jquery.ztree.all-3.5.min.js"></script>
    <script type="text/javascript">

        $(function () {

            // 准备生成树形结构的JSON数据，数据来源是发送Ajax请求得到
            $.ajax({
                url: "menu/whole/tree",
                dataType: "post",
                success: function (response) {
                    let result = response.result;

                    if (result === "SUCCESS") {

                        // 创建一个JSON对象用于储存对zTree所做的设置
                        let setting = {};
                        // 从响应体中获取用来生成树形结构的JSON数据
                        let zNodes = response.data;

                        // 初始化树形结构
                        $.fn.zTree.init($("#treeDemo"), setting, zNodes);
                    }

                    if (result === "FAILED") {
                        layer.msg(response.message);
                    }
                }
            });

        });

    </script>
</body>
</html>