<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <%@ include file="../include/header.jsp" %>
    <title>管理-控制面板</title>
</head>

<body>
    <%@ include file="../include/nav.jsp" %>
    <div class="container-fluid">
        <div class="row">
            <%@ include file="../include/sidebar.jsp" %>
            <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                <ol class="breadcrumb">
                    <li><a href="#">首页</a></li>
                    <li><a href="#">数据列表</a></li>
                    <li class="active">分配角色</li>
                </ol>
                <div class="panel panel-default">
                    <div class="panel-body">
                        <form action="assign/role/assign" method="post" role="form" class="form-inline">
                            <input type="hidden" name="id" value="${param.id }" />
                            <input type="hidden" name="pageNum" value="${param.pageNum }" />
                            <input type="hidden" name="keyword" value="${param.keyword }" />
                            <div class="form-group">
                                <label for="exampleInputPassword1">未分配角色列表</label><br>
                                <select class="form-control" multiple="multiple" size="10" style="width:100px;overflow-y:auto;">
                                    <c:forEach items="${requestScope.unAssignedRoles }" var="role">
                                        <option value="${role.id }">${role.name }</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <ul>
                                    <li id="toRightBtn" class="btn btn-default glyphicon glyphicon-chevron-right"></li>
                                    <br>
                                    <li id="toLeftBtn" class="btn btn-default glyphicon glyphicon-chevron-left" style="margin-top:20px;"></li>
                                </ul>
                            </div>
                            <div class="form-group" style="margin-left:40px;">
                                <label for="exampleInputPassword1">已分配角色列表</label><br>
                                <select name="roleIdList" class="form-control" multiple="multiple" size="10" style="width:100px;overflow-y:auto;">
                                    <c:forEach items="${requestScope.assignedRoles}" var="role">
                                        <option value="${role.id}">${role.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <button id="submitXbox" type="submit" style="width: 150px;margin: 20px 20px 5px 88px" class="btn btn-sm btn-success btn-block">保存</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%@ include file="../include/tail.jsp" %>

    <script type="text/javascript">

        $(function () {

            $("#toRightBtn").click(function () {
                // :eq(0)表示选择第一个；:eq(1)表示选择第二个
                // :selected表示被选中的
                $("select:eq(0) > option:selected").appendTo("select:eq(1)");
            });

            $("#toLeftBtn").click(function () {

                $("select:eq(1) > option:selected").appendTo("select:eq(0)");
            });

            $("#submitXbox").click(function () {
                $("select:eq(1) > option").prop("selected", "selected");
            });
        });

    </script>
</body>
</html>
