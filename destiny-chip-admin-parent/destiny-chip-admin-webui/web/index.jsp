<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
    <base href="http://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }/" />
    <script type="text/javascript" src="static/jquery/jquery-2.1.1.min.js"></script>
    <script>
        $(function () {
            $("#btn1").click(function () {
                $.ajax({url: "send/array", type: "get", data: {"array": [4,5,6]}})
            })
        })
    </script>
<body>
    <button id="btn1">test request Body</button>
</body>
</html>
