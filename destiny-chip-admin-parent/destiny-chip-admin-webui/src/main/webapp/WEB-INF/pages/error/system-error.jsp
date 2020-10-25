<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keys" content="">
    <meta name="author" content="">
    <title>系统异常</title>
    <base
        href="http://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }/" />
    <link rel="stylesheet" href="static/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="static/css/font-awesome.min.css">
    <link rel="stylesheet" href="static/css/login.css">
    <style>

    </style>
</head>

<body>
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <div><a class="navbar-brand" href="index.html" style="font-size:32px;">尚筹网-创意产品众筹平台</a></div>
            </div>
        </div>
    </nav>

    <div class="container">

        <h2 class="form-signin-heading"><i class="glyphicon glyphicon-log-in"></i>尚筹网系统消息</h2>
        <!--
            requestScope对应的是存放request域数据的Map
            requestScope.exception相当于request.getAttribute("exception")
            requestScope.exception.message相当与exception.getMessage()
        -->
        <h3 style="text-align: center">${requestScope.exception.message}</h3>
        <button style="width: 150px;margin: 5% auto;" class="btn btn-lg btn-success btn-block">返回上一步</button>
    </div>
    <script type="text/javascript" src="static/jquery/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="static/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("button").click(function () {
                // 相当于浏览器的退格按钮
                window.history.back();
            });
        });
    </script>
</body>

</html>