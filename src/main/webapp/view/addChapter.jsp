<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>

<script type="text/javascript">
	$(function(){
        $("#addChapterForm").form("load",{albumId:capterCategoryId});


        $("#addChapterTitle").validatebox({
            required:true,
            validType:"length[2,15]"
        });
        $("#addChapterUrl").filebox({
            required:true,
            prompt:"选择文件",
            buttonText:"&nbsp;选&nbsp;择&nbsp;"
        });
        $("#addChapterCategory").validatebox({
            required:true,
			readonly:true
        });
        $("#addChapterButton").linkbutton({
            iconCls:"icon-edit",
            onClick:function(){
                $("#addChapterForm").form("submit",{
                    url:"${pageContext.request.contextPath}/chapter/insertChapter",
                    onSubmit:function(){
                        return $("#addChapterForm").form("validate");
                    },
                    success:function(){
                        $("#addChapterDialog").dialog("close");
                        $("#albumTreegrid").treegrid("load");
                        $.messager.show({
                            title:"系统提示",
                            msg:"提交成功"
                        });
                    }
                });
            }
		});
        $("#clearChapterButton").linkbutton({
            iconCls:"icon-remove",
            onClick:function(){
                $("#addChapterForm").form("reset");
            }
		});

	});
</script>



<form id="addChapterForm" method="post" enctype="multipart/form-data">
	标题：<input id="addChapterTitle" name="title"/><br/>
	<%--大小：<input id="addChapterSize" name="size"/><br/>--%>
	<%--时长：<input id="addChapterDuration" name="duration"><br/>--%>
	<%--上传时间：<input id="addChapterUploadDate" name="uploadDate"/><br/>--%>
	存放地址：<input id="addChapterUrl" name="chapterFile"/><br/>
	所属分类：<input id="addChapterCategory" name="albumId"/><br/>

	<a id="addChapterButton" type="button">提交</a>
	<a id="clearChapterButton" type="button">重置</a>

</form>