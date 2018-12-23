<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>

<script type="text/javascript">
	$(function(){
        $("#showAlbumForm").form("load","${pageContext.request.contextPath}/album/queryOneById?id="+albumsId);
        $("#title").validatebox({
            required:true,
            readonly:true
        });
        $("#count").validatebox({
            required:true,
            readonly:true
        });
        $("#coverImg").validatebox({
            required:true,
            readonly:true
        });
        $("#score").validatebox({
            required:true,
            readonly:true
        });
        $("#author").validatebox({
            required:true,
            readonly:true
        });
		$("#broadcast").validatebox({
            required:true,
            readonly:true
        });
        $("#brief").validatebox({
            required:true,
            readonly:true
        });
        $("#pubDate").datebox({
            required:true,
            readonly:true
        });
	});
</script>



<form id="showAlbumForm" method="post" >
	标题：<input id="title" name="title"/><br/>
	章节数：<input id="count" name="count"/><br/>
	封面：<input id="coverImg" name="coverImg"><br/>
	评价：<input id="score" name="score"/><br/>
	作者：<input id="author" name="author"/><br/>
	播音：<input id="broadcast" name="broadcast"/><br/>
	简介：<input id="brief" name="brief"/><br/>
	发布日期：<input id="pubDate" name="pubDate"/><br/>

</form>