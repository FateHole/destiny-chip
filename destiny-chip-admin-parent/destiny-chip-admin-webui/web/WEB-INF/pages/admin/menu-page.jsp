<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                        <i class="glyphicon glyphicon-th-list"></i> 权限菜单列表
                        <div style="float:right;cursor:pointer;" data-toggle="modal" data-target="#myModal">
                            <i class="glyphicon glyphicon-question-sign"></i>
                        </div>
                    </div>
                    <div class="panel-body">
                        <ul id="treeDemo" class="ztree">
                            <li id="treeDemo_1" class="level0" tabindex="0" hidefocus="true" treenode="">
                                <span id="treeDemo_1_switch" title="" class="button level0 switch root_open" treenode_switch=""></span>
                                <a id="treeDemo_1_a" class="level0" treenode_a="" onclick="" target="_blank" style="" title="系统权限菜单">
                                    <span id="treeDemo_1_ico" title="" treenode_ico="" class="fa fa-fw fa-sitemap" style="background:url(fa fa-sitemap) 0 0 no-repeat;"></span>
                                    <span id="treeDemo_1_span">系统权限菜单</span>
                                </a>
                                <ul id="treeDemo_1_ul" class="level0 " style="display:block">
                                    <li id="treeDemo_2" class="level1" tabindex="0" hidefocus="true" treenode="">
                                        <span id="treeDemo_2_switch" title="" class="button level1 switch center_docu" treenode_switch=""></span>
                                        <a id="treeDemo_2_a" class="level1" treenode_a="" onclick="" href="dashboard.htm" target="_blank" style="" title="控制面板">
                                            <span id="treeDemo_2_ico" title="" treenode_ico="" class="fa fa-fw fa-desktop" style="background:url(fa fa-desktop) 0 0 no-repeat;"></span>
                                            <span id="treeDemo_2_span">控制面板</span>
                                        </a>
                                    </li>
                                    <li id="treeDemo_3" class="level1" tabindex="0" hidefocus="true" treenode="">
                                        <span id="treeDemo_3_switch" title="" class="button level1 switch center_docu" treenode_switch=""></span>
                                        <a id="treeDemo_3_a" class="level1" treenode_a="" onclick="" href="message/index.htm" target="_blank" style="" title="消息管理">
                                            <span id="treeDemo_3_ico" title="" treenode_ico="" class="fa fa-fw fa-weixin" style="background:url(fa fa-weixin) 0 0 no-repeat;"></span>
                                            <span id="treeDemo_3_span">消息管理</span>
                                        </a>
                                    </li>
                                    <li id="treeDemo_4" class="level1" tabindex="0" hidefocus="true" treenode="">
                                        <span id="treeDemo_4_switch" title="" class="button level1 switch center_open" treenode_switch=""></span>
                                        <a id="treeDemo_4_a" class="level1" treenode_a="" onclick="" target="_blank" style="" title="权限管理">
                                            <span id="treeDemo_4_ico" title="" treenode_ico="" class="fa fa-fw fa-cogs" style="background:url(fa fa-cogs) 0 0 no-repeat;"></span>
                                            <span id="treeDemo_4_span">权限管理</span>
                                        </a>
                                        <ul id="treeDemo_4_ul" class="level1 line" style="display:block">
                                            <li id="treeDemo_5" class="level2" tabindex="0" hidefocus="true" treenode="">
                                                <span id="treeDemo_5_switch" title="" class="button level2 switch center_docu" treenode_switch=""></span>
                                                <a id="treeDemo_5_a" class="level2" treenode_a="" onclick="" href="user/index.htm" target="_blank" style="" title="用户管理">
                                                    <span id="treeDemo_5_ico" title="" treenode_ico="" class="fa fa-fw fa-user" style="background:url(fa fa-user) 0 0 no-repeat;"></span>
                                                    <span id="treeDemo_5_span">用户管理</span>
                                                </a>
                                            </li>
                                            <li id="treeDemo_6" class="level2" tabindex="0" hidefocus="true" treenode="">
                                                <span id="treeDemo_6_switch" title="" class="button level2 switch center_docu" treenode_switch=""></span>
                                                <a id="treeDemo_6_a" class="level2" treenode_a="" onclick="" href="role/index.htm" target="_blank" style="" title="角色管理">
                                                    <span id="treeDemo_6_ico" title="" treenode_ico="" class="fa fa-fw fa-graduation-cap" style="background:url(fa fa-graduation-cap) 0 0 no-repeat;"></span>
                                                    <span id="treeDemo_6_span">角色管理</span>
                                                </a>
                                            </li>
                                            <li id="treeDemo_7" class="level2" tabindex="0" hidefocus="true" treenode="">
                                                <span id="treeDemo_7_switch" title="" class="button level2 switch bottom_docu" treenode_switch=""></span>
                                                <a id="treeDemo_7_a" class="level2" treenode_a="" onclick="" href="permission/index.htm" target="_blank" style="" title="许可管理">
                                                    <span id="treeDemo_7_ico" title="" treenode_ico="" class="fa fa-fw fa-check-square-o" style="background:url(fa fa-check-square-o) 0 0 no-repeat;"></span>
                                                    <span id="treeDemo_7_span">许可管理</span>
                                                </a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li id="treeDemo_8" class="level1" tabindex="0" hidefocus="true" treenode="">
                                        <span id="treeDemo_8_switch" title="" class="button level1 switch center_open" treenode_switch=""></span>
                                        <a id="treeDemo_8_a" class="level1" treenode_a="" onclick="" target="_blank" style="" title="资质管理">
                                            <span id="treeDemo_8_ico" title="" treenode_ico="" class="fa fa-fw fa-certificate" style="background:url(fa fa-certificate) 0 0 no-repeat;"></span>
                                            <span id="treeDemo_8_span">资质管理</span>
                                        </a>
                                        <ul id="treeDemo_8_ul" class="level1 line" style="display:block">
                                            <li id="treeDemo_9" class="level2" tabindex="0" hidefocus="true" treenode="">
                                                <span id="treeDemo_9_switch" title="" class="button level2 switch center_docu" treenode_switch=""></span>
                                                <a id="treeDemo_9_a" class="level2" treenode_a="" onclick="" href="cert/type.htm" target="_blank" style="" title="分类管理">
                                                    <span id="treeDemo_9_ico" title="" treenode_ico="" class="fa fa-fw fa-th-list" style="background:url(fa fa-th-list) 0 0 no-repeat;"></span>
                                                    <span id="treeDemo_9_span">分类管理</span>
                                                </a>
                                            </li>
                                            <li id="treeDemo_10" class="level2" tabindex="0" hidefocus="true" treenode="">
                                                <span id="treeDemo_10_switch" title="" class="button level2 switch bottom_docu" treenode_switch=""></span>
                                                <a id="treeDemo_10_a" class="level2" treenode_a="" onclick="" href="cert/index.htm" target="_blank" style="" title="资质管理">
                                                    <span id="treeDemo_10_ico" title="" treenode_ico="" class="fa fa-fw fa-certificate" style="background:url(fa fa-certificate) 0 0 no-repeat;"></span>
                                                    <span id="treeDemo_10_span">资质管理</span>
                                                </a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li id="treeDemo_11" class="level1" tabindex="0" hidefocus="true" treenode="">
                                        <span id="treeDemo_11_switch" title="" class="button level1 switch center_docu" treenode_switch=""></span>
                                        <a id="treeDemo_11_a" class="level1" treenode_a="" onclick="" href="process/index.htm" target="_blank" style="" title="流程管理">
                                            <span id="treeDemo_11_ico" title="" treenode_ico="" class="fa fa-fw fa-random" style="background:url(fa fa-random) 0 0 no-repeat;"></span>
                                            <span id="treeDemo_11_span">流程管理</span>
                                        </a>
                                    </li>
                                    <li id="treeDemo_12" class="level1" tabindex="0" hidefocus="true" treenode="">
                                        <span id="treeDemo_12_switch" title="" class="button level1 switch bottom_open" treenode_switch=""></span>
                                        <a id="treeDemo_12_a" class="level1" treenode_a="" onclick="" target="_blank" style="" title="审核管理">
                                            <span id="treeDemo_12_ico" title="" treenode_ico="" class="fa fa-fw fa-check-square" style="background:url(fa fa-check-square) 0 0 no-repeat;"></span>
                                            <span id="treeDemo_12_span">审核管理</span>
                                        </a>
                                        <ul id="treeDemo_12_ul" class="level1 " style="display:block">
                                            <li id="treeDemo_13" class="level2" tabindex="0" hidefocus="true" treenode="">
                                                <span id="treeDemo_13_switch" title="" class="button level2 switch bottom_docu" treenode_switch=""></span>
                                                <a id="treeDemo_13_a" class="level2" treenode_a="" onclick="" href="process/cert.htm" target="_blank" style="" title="实名认证人工审核">
                                                    <span id="treeDemo_13_ico" title="" treenode_ico="" class="fa fa-fw fa-check-circle-o" style="background:url(fa fa-check-circle-o) 0 0 no-repeat;"></span>
                                                    <span id="treeDemo_13_span">实名认证人工审核</span>
                                                </a>
                                            </li>
                                        </ul>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <%@ include file="../include/tail.jsp" %>
</body>
</html>