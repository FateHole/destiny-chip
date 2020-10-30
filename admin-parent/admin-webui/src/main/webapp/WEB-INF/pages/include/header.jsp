<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<base href="http://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }/" />
<link rel="stylesheet" href="static/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="static/css/font-awesome.min.css">
<link rel="stylesheet" href="static/css/main.css">
<link rel="stylesheet" href="static/css/pagination.css">
<style>
    .tree li {
        list-style-type: none;
        cursor:pointer;
    }
    .tree-closed {
        height : 40px;
    }
    .tree-expanded {
        height : auto;
    }
</style>

