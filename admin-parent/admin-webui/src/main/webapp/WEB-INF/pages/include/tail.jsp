<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="static/jquery/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="static/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="static/script/docs.min.js"></script>
<script type="text/javascript" src="static/layer/layer.js"></script>
<script type="text/javascript">
    $(function () {
        $(".list-group-item").click(function(){
            if ( $(this).find("ul") ) {
                $(this).toggleClass("tree-closed");
                if ( $(this).hasClass("tree-closed") ) {
                    $("ul", this).hide("fast");
                } else {
                    $("ul", this).show("fast");
                }
            }
        });
    });
</script>
