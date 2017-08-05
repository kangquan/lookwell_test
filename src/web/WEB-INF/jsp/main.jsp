<%--
  Created by IntelliJ IDEA.
  User: 马保生
  Date: 2017/6/26
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="utf-8" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页面</title>
</head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/themes/icon.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/themes/default/easyui.css">
<script type="text/javascript"
        src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/jquery.easyui.min.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">

    $(function () {
        initTree();
    });
    function initTree() {

        $("#rootTree").tree({
            url:'${pageContext.request.contextPath}/user/initTree.controller',
            method:'GET',
            lines:true,
            onClick:function (node) {

                if(node.children != null) {
                    return;
                }
                appendTree(node);
                if(node.menuUrl != null && node.menuUrl != ''){

                    addTabs(node.text,'${pageContext.request.contextPath}'+node.menuUrl);

            }

            }
        });
    }
    function appendTree(node) {

        $.get('${pageContext.request.contextPath}/user/appendTree.controller',
            {'parentId':node.menuId},function (data,status) {
                if(status == "success"){

                    var selected = $("#rootTree").tree('getSelected');
                    $("#rootTree").tree('append', {
                        parent: selected.target,
                        data:data
                    });
                }

            });
    }
    function addTabs(title,url) {
//        alert(JSON.stringify(url));
        if($("#gg").tabs("exists",title)) {
            $("#gg").tabs("select",title);
        }else{

            var content = "<iframe src='"+url+"' style='height: 100%;width: 100%' frameborder='0'>"
            $("#gg").tabs('add',{
                content:content,
                title:title,
                closable:true


            });
        }

    }
</script>
<body class="easyui-layout">
<div region="north" style="height: 10%">
    欢迎 ${user.role.roleName}光临
</div>
<div region="west" style="width: 10%" title="菜单栏">



    <ul id="rootTree"></ul>


</div>
<div region="center">
    <div class="easyui-tabs" id="gg" style="width: 100%;height: 100%">
        <div title="首页"></div>
    </div>
</div>
<div region="south" style="height: 10%">TCMP054</div>


</body>
</html>
