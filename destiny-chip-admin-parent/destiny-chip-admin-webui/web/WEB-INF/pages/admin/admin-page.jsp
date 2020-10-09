<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">

<%@ include file="../include/header.jsp" %>

<body>

    <%@ include file="../include/nav.jsp" %>
    <div class="container-fluid">
        <div class="row">
            <%@ include file="../include/sidebar.jsp" %>
            <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title"><i class="glyphicon glyphicon-th"></i> 数据列表</h3>
                    </div>
                    <div class="panel-body">
                        <form class="form-inline" role="form" style="float:left;">
                            <div class="form-group has-feedback">
                                <div class="input-group">
                                    <div class="input-group-addon">查询条件</div>
                                    <input class="form-control has-success" type="text" placeholder="请输入查询条件">
                                </div>
                            </div>
                            <button type="button" class="btn btn-warning"><i class="glyphicon glyphicon-search"></i>
                                查询</button>
                        </form>
                        <button type="button" class="btn btn-danger" style="float:right;margin-left:10px;"><i
                                class=" glyphicon glyphicon-remove"></i> 删除</button>
                        <button type="button" class="btn btn-primary" style="float:right;"
                            onclick="window.location.href='add.html'"><i class="glyphicon glyphicon-plus"></i>
                            新增</button>
                        <br>
                        <hr style="clear:both;">
                        <div class="table-responsive">
                            <table class="table  table-bordered">
                                <thead>
                                    <tr>
                                        <th width="30">#</th>
                                        <th width="30"><input type="checkbox"></th>
                                        <th>账号</th>
                                        <th>名称</th>
                                        <th>邮箱地址</th>
                                        <th width="100">操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:if test="${empty requestScope.pageInfo.list }">
                                        <tr>
                                            <td colspan="6" style="text-align: center" >抱歉！没有查询到您要的数据</td>
                                        </tr>
                                    </c:if>
                                    <c:if test="${!empty requestScope.pageInfo.list }">
                                        <c:forEach items="${requestScope.pageInfo.list }" var="admin" varStatus="myStatus">
                                            <tr>
                                                <td>${myStatus.count }</td>
                                                <td><input type="checkbox"></td>
                                                <td>${admin.loginAccount }</td>
                                                <td>${admin.username }</td>
                                                <td>${admin.email }</td>
                                                <td>
                                                    <button type="button" class="btn btn-success btn-xs"><i
                                                            class=" glyphicon glyphicon-check"></i></button>
                                                    <button type="button" class="btn btn-primary btn-xs"><i
                                                            class=" glyphicon glyphicon-pencil"></i></button>
                                                    <button type="button" class="btn btn-danger btn-xs"><i
                                                            class=" glyphicon glyphicon-remove"></i></button>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </c:if>
                                </tbody>
                                <tfoot>
                                    <tr>
                                        <td colspan="6" align="center">
                                            <div id="Pagination" class="pagination"></div>
                                        </td>
                                    </tr>

                                </tfoot>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%@ include file="../include/tail.jsp" %>
    <script type="text/javascript" src="static/jquery/jquery.pagination.js"></script>
    <script type="text/javascript">
        $(function () {
            // 调用后面声明的函数对页码导航条进行初始化操作
            initPagination();
        });

        // 生成页码导航条的函数
        function initPagination() {
            // 获得总记录数
            var totalRecord = ${requestScope.pageInfo.total};

            // 声明一个json对象储存Pagination要设置的属性
            var properties = {
                num_edge_entries: 3,    // 边缘页数
                num_display_entries: 5, // 主体页数
                callback: pageSelectCallback,   // 指定用户点击‘翻页’按钮跳转页面的回调函数
                items_per_page: ${requestScope.pageInfo.pageSize},  // 每页要显示的数据的数量
                current_page: ${requestScope.pageInfo.pageNum - 1},  // 配置pagination内部使用的是pageIndex来管理页码，pageIndex从0开始，pageNum从1开始
                prev_text: "上一页",   // 上一页按钮上现实的文本
                next_text: "下一页"    // 下一页按钮上现实的文本
                };

            // 生成页码导航条
            $("#Pagination").pagination(totalRecord, properties);

        }

        // 回调函数的定义：声明出来的以后不是自己调用，而是交给系统或框架去调用
        // 用户点击1、2、3时调用这个方法实现跳转
        function pageSelectCallback(pageIndex, jQuery) {
            // 根据pageIndex计算得到pageNum
            var pageNum = pageIndex + 1;

            // 跳转页面
            window.location.href = "admin/getPageInfo?pageNum=" + pageNum;

            return false;
        }
    </script>
</body>

</html>