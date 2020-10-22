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
    <script type="text/javascript" src="static/js/my-menu.js"></script>
    <script type="text/javascript">

        $(function () {

            // 调用专门封装好的函数初始化树形结构
            generateTree();
        });

    </script>
</body>
</html>