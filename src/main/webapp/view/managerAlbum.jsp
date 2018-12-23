<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>


<script type="text/javascript">
	$(function(){
        var toolbar = [{
            iconCls: 'icon-add',
            text: "专辑详情",
            handler: function () {
                //获取选中行
                var row = $("#albumTreegrid").treegrid("getSelected");
                if (row != null && typeof(row.id)=="string") {
                    //查看指定行
                    console.info(row.id);
                    console.info(typeof(row.id));
                    albumsId=row.id;
                    //根据id去album中查询对应的对象
                    <%--$("#showAlbumForm").form("load","${pageContext.request.contextPath}/album/queryOneById?id="+row.id);--%>
                    $("#showAlbumDialog").dialog("open");
                } else {
                    alert("请选中正确的行");
                }
            }
        }, '-', {
            text: "添加专辑",
            iconCls: 'icon-edit',
            handler: function () {
                //获取选中行
                //var row = $("#albumTreegrid").treegrid("getSelected");
                $("#addAlbumDialog").dialog("open");

            }
        }, '-', {
            text: "添加音频",
            iconCls: 'icon-remove',
            handler: function () {
                var row = $("#albumTreegrid").treegrid("getSelected");
                capterCategoryId=row.id;
                $("#addChapterDialog").dialog("open");
            }
        }, '-', {
            text: "音频下载",
            iconCls: 'icon-save',
            handler: function () {
                var row = $("#albumTreegrid").treegrid("getSelected");
                if(row.id!=null && typeof(row.id)=="number"){
                    <%--$.get(--%>
                        <%--"${pageContext.request.contextPath}/chapter/downChapter",--%>
                        <%--"id="+row.id,--%>
                        <%--function(){--%>
                            <%--$.messager.show({--%>
                                <%--title:"系统提示",--%>
                                <%--msg:"下载成功"--%>
                            <%--});--%>
                        <%--}--%>
                    <%--);--%>
                    location.href="${pageContext.request.contextPath}/chapter/downChapter?url="+row.url;
                }else{
                    alert("请先选中正确的音频");
                }
            }
        }]
        $("#albumTreegrid").treegrid({
            url:"${pageContext.request.contextPath}/album/queryAll",
            idField:"id",
            treeField:"title",
            columns:[[
                {field:"title",title:"名字",width:60},
                {field:"duration",title:"时长",width:80},
                {field:"size",title:"大小",width:80},
                {field:"url",title:"播放", formatter:startbf , width:80}
            ]],
            fit:true,
            fitColumns:true,
            toolbar:toolbar,
            pagination:true,
            pageSize:3,
            pageList:[3,5,10,20]
        });
        $("#showAlbumDialog").dialog({
            title: 'My Dialog',
            width: 400,
            height: 300,
            closed: true,
            cache: false,
            href: "${pageContext.request.contextPath}/view/showAlbum.jsp",
            modal: true
        });
        $("#addAlbumDialog").dialog({
            title: 'My Dialog',
            width: 400,
            height: 300,
            closed: true,
            cache: false,
            href: "${pageContext.request.contextPath}/view/addAlbum.jsp",
            modal: true
        });
        $("#addChapterDialog").dialog({
            title: 'My Dialog',
            width: 400,
            height: 300,
            closed: true,
            cache: false,
            href: "${pageContext.request.contextPath}/view/addChapter.jsp",
            modal: true
        });
	});
	function startbf(value,row,index) {
	    if(row.url!=null) {
            return "<audio class='audio1' src='${pageContext.request.contextPath}/"+value+"' controls=\"controls\">\n" +
                "</audio>";
        }

    }

</script>



<table id="albumTreegrid"></table>
<div id="showAlbumDialog"></div>
<div id="addAlbumDialog"></div>
<div id="addChapterDialog"></div>