<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>

<script type="text/javascript">
	$(function(){
        $("#addAlbumTitle").validatebox({
            required:true,
            validType:"length[2,15]"
        });
        $("#addAlbumCount").numberbox({
            required:true,
            min:0
        });
        $("#addAlbumCoverImg").filebox({
            required:true,
            prompt:"选择文件",
            buttonText:"&nbsp;选&nbsp;择&nbsp;"
        });
        $("#addAlbumScore").numberbox({
            required:true,
            min:0
        });
        $("#addAlbumAuthor").validatebox({
            required:true,
            validType:"length[2,15]"
        });
		$("#addAlbumBroadcast").validatebox({
            required:true,
            validType:"length[2,15]"
        });
        $("#addAlbumBrief").validatebox({
            required:true,
            validType:"length[2,15]"
        });
        $("#addAlbumPubDate").datebox({
            required:true,
            validType:"length[2,15]"
        });
        $("#addAlbumButton").linkbutton({
            iconCls:"icon-edit",
			onClick:function(){
				$("#addAlbumForm").form("submit",{
				    url:"${pageContext.request.contextPath}/album/insertAlbum",
					onSubmit:function(){
				        return $("#addAlbumForm").form("validate");
					},
					success:function(){
                        $("#addAlbumDialog").dialog("close");
                        $("#albumTreegrid").treegrid("load");
                        $.messager.show({
                            title:"系统提示",
                            msg:"提交成功"
                        });
                    }
				});
			}
		});
        $("#clearAlbumButton").linkbutton({
            iconCls:"icon-remove",
            onClick:function(){
                $("#addAlbumForm").form("reset");
            }
		});
	});
</script>



<form id="addAlbumForm" method="post" enctype="multipart/form-data">
	标题：<input id="addAlbumTitle" name="title"/><br/>
	章节数：<input id="addAlbumCount" name="count"/><br/>
	封面：<input id="addAlbumCoverImg" name="albumCoverImg"><br/>
	评价：<input id="addAlbumScore" name="score"/><br/>
	作者：<input id="addAlbumAuthor" name="author"/><br/>
	播音：<input id="addAlbumBroadcast" name="broadcast"/><br/>
	简介：<input id="addAlbumBrief" name="brief"/><br/>
	发布日期：<input id="addAlbumPubDate" name="pubDate"/><br/>
	<a id="addAlbumButton" type="button">提交</a>
	<a id="clearAlbumButton" type="button">重置</a>

</form>