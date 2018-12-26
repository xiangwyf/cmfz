<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>持名法州主页</title>
<link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../themes/icon.css">
<link rel="stylesheet" type="text/css" href="../themes/IconExtension.css">   
<script type="text/javascript" src="../js/jquery.min.js"></script>   
<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>  
<script type="text/javascript" src="../js/datagrid-detailview.js"></script>
<script type="text/javascript" src="../js/jquery.edatagrid.js"></script>
<script type="text/javascript" src="../js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../js/echarts.min.js"></script>
<script type="text/javascript" src="../js/china.js"></script>
<script type="text/javascript">
	$(function(){
        $.get("${pageContext.request.contextPath}/menu/queryAll",function(result){
            $.each(result,function(index,menu){
                if(menu.parent_id!=null && menu.parent_id!="") {

                }else{
                    var cont="";
                    $.each(menu.menuList,function(ind,smenu){
                        cont+= "<p style='text-align: center'><a href='#' class='easyui-linkbutton' data-options=\"iconCls:'icon-search'\" onclick=\"addTabs('"+smenu.title+"','"+smenu.iconcls+"','"+smenu.url+"')\" >"+smenu.title+"</a></p>";
                    });
                    $("#aa").accordion("add", {
                        title: menu.title,
                        iconCls:menu.iconcls,
                        content:cont,
                        selected:false
                    });

                }
            });
        });
    });
	function addTabs(title,iconcls,url){
        var a=$("#tt").tabs("exists",title)
        if(a){
            $("#tt").tabs("select",title)
        }else{
            $('#tt').tabs('add',{
                title: title,
                iconCls:"icon-save",
                href:"${pageContext.request.contextPath}"+url,
                selected: true,
                closable:true

            });
        }
    }

</script>

</head>
<body class="easyui-layout">
    <!-- 上部 -->
    <div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    	<div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
    	<div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:${sessionScope.admin.username} &nbsp;<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a></div>
    </div>
    <!-- 下部 -->
    <div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    	<div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育 htf@zparkhr.com.cn</div>
    </div>
    <!-- 左部 -->
    <div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
    	<div id="aa" class="easyui-accordion" data-options="fit:true">

        </div>
    </div>
    <!-- 中部 -->
    <div data-options="region:'center'">
    	<div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">   
		    <div title="主页" data-options="iconCls:'icon-neighbourhood',"  style="background-image:url(${pageContext.request.contextPath}/main/image/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
		</div>  
    </div>   
</body> 
</html>