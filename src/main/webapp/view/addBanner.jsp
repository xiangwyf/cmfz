<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>

<script type="text/javascript">
	$(function(){
        $("#albumTitle").validatebox({
            required:true,
            validType:"length[2,15]"
        });
        $("#albumImgPath").filebox({
            required:true,
            prompt:"选择文件",
            buttonText:"&nbsp;选&nbsp;择&nbsp;"
        });
        // $("#status").validatebox({
        //     required:true,
        //     validType:"length[1,2]"
        // });
        $("#albumDescription").validatebox({
            required:true,
            validType:"length[5,30]"
        });
        $("#addBannerButton").linkbutton({
            iconCls:"icon-edit",
            onClick:function(){
                $("#addBannerForm").form("submit",{
                    url:"${pageContext.request.contextPath}/banner/insertBanner",
                    onSubmit:function(){
                        return $("#addBannerForm").form("validate");
                    },
                    success:function(){
                        $("#addBannerDialog").dialog("close");
                        $("#BannerDatagrid").datagrid("load");
                        $.messager.show({
                            title:"系统提示",
                            msg:"提交成功"
                        });
                    }
                });
            }
        });
        $("#clearBannerButton").linkbutton({
            iconCls:"icon-remove",
            onClick:function(){
                $("#addBannerForm").form("reset");
            }
        });

	});
</script>



<form id="addBannerForm" method="post" enctype="multipart/form-data">
	标题：<input id="albumTitle" name="title"/><br/>
	图片路径：<input id="albumImgPath" name="imgFile"/><br/>
	<%--状态：<input id="status" name="status"/><br/>--%>
	状态：<input type="radio" id="albumStatus" name="status" value="Y"/>显示<input type="radio" id="albumStatus" name="status" value="N"/>不显示<br/>
	图片描述：<input id="albumDescription" name="description"/><br/>
	<a id="addBannerButton" type="button">提交</a>
	<a id="clearBannerButton" type="button">重置</a>
</form>