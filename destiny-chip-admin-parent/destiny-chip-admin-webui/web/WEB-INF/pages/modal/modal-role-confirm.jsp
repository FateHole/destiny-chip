<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="confirmModal" class="modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">尚筹网系统提示</h4>
            </div>
            <div class="modal-body">
               <h4>确认删除如下选择的角色？</h4>
                <div id="roleNameDiv" style="text-align: center"></div>
            </div>
            <div class="modal-footer">
                <button id="removeRoleBtn" type="button" class="btn btn-success">确认删除</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->