<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>


<script type="text/javascript">
	$(function(){
        var toolbar=[{
            iconCls: "icon-add",
            text: "添加",
            handler: function () {
                $("#addBannerDialog").dialog("open");
            }
        }, '-', {
            text: "修改",
            iconCls: 'icon-edit',
            handler: function () {
                //获取选中行
                var row = $("#bannerDatagrid").edatagrid("getSelected");
                if (row != null) {
                    //编辑指定行
                    var index = $("#bannerDatagrid").edatagrid("getRowIndex", row);
                    $("#bannerDatagrid").edatagrid("editRow", index);
                } else {
                    alert("请先选中行")
                }
            }
        }, '-', {
            text: "删除",
            iconCls: "icon-remove",
            handler: function () {
                var row = $("#bannerDatagrid").edatagrid("getSelected");
                if(row!=null){
                    console.info(row.id);
                    $.get(
                        "${pageContext.request.contextPath}/banner/deleteBanner",
                        "id="+row.id,
                        function(){
                            $("#bannerDatagrid").edatagrid("reload");
                        }
                    );
                }else{
                    alert("请先选中行");
                }
            }
        }, '-', {
            text: "保存",
            iconCls: "icon-save",
            handler: function () {
                $("#bannerDatagrid").edatagrid("saveRow")

            }
        }]
		$("#bannerDatagrid").edatagrid({
            url:"${pageContext.request.contextPath}/banner/queryByPage",
            updateUrl:"${pageContext.request.contextPath}/banner/updateBanner",
			fitColumns:true,
			fit:true,
			columns:[[
				{field: "title", title: "名称", width: 100},
				{field: "status", title: "状态", width: 100, editor:{
				                                                type:"text",
                                                                options:{required:true}
                                                            }},
				{field: "pubDate", title: "时间", width: 100 ,align: "right"}
			]],
            pagination:true,
            pageList:[3,5,10,20],
                    pageSize:3,
                    toolbar:toolbar,
                    view:detailview,
                    detailFormatter: function(rowIndex, rowData){
                    return '<table><tr>' +
                        '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}' + rowData.imgPath + '" style="height:50px;"></td>' +
                        '<td style="border:0">' +
                        '<p>描述: ' + rowData.description + '</p>' +
                        '<p>路径: ' + rowData.imgPath + '</p>' +
                        '</td>' +
                    '</tr></table>';
            }
        });
        $("#addBannerDialog").dialog({
            title: 'My Dialog',
            width: 400,
            height: 300,
            closed: true,
            cache: false,
            href: "${pageContext.request.contextPath}/view/addBanner.jsp",
            modal: true
        });

	});
	function showPubDate(value,row,index){
        var date = new Date(value);
        var y = date.getFullYear();
        var m = date.getMonth() + 1;
        var d = date.getDate();
        return y + '-' +m + '-' + d;
    }
</script>



<table id="bannerDatagrid"></table>
<div id="addBannerDialog"></div>