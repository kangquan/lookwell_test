<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2017/8/5
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="basic.jsp"></jsp:include>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/format.js"></script>
    <script type="text/javascript">
        $(function () {
            init();
        })
        function init() {
            $("#project").datagrid({
                url:'${pageContext.request.contextPath}/projectList.controller',
                method:'POST',
                //是否隔行变色
                striped:true,
                idField:'projectId',
                //是否显示行序号
                rownumbers:true,
                //标题
                title:'产品信息',
                queryParams:{},
                //是否分页
                pagination:true,

                pageList:[2,5,10],
                toolbar:[
                    {
                        text:'新增',
                        iconCls:'icon-add',
                        handler:function(){
                            addProject();
                        }
                    }, {
                        text: '删除',
                        iconCls: 'icon-remove',
                        handler: function () {
                            deleteProjectList();
                        }
                    }
                ],
                columns:[[
                    {field:'ck',checkbox:true},
                    {field:'projectName',title:'产品名',width:100},
                    {field:'projectDesc',title:'产品描述',width:100},
                    {field:'projectVersion',title:'产品版本号',width:100},
                    {field:'projectStatus',title:'产品状态',width:100},
                    {field:'createTime',title:'创建时间',width:200,formatter:timeformat},
                    {field:'updateTime',title:'修改时间',width:200,formatter:timeformat},
                    {field:'projectId',title:'操作列',width:200,formatter:info}
                ]]
            });
        }
        function info(rowDate) {
            var detailProject='<a href="javascript:detailProject(\''+rowDate+'\')">查看</a>';
            var updateProject='<a href="javascript:showUpdateProject(\''+rowDate+'\')">修改</a>';

            return detailProject+"--"+updateProject;
        }
        function addProject() {
            $("#addProjectWindow").window('open');
        }
        function addProjectSubmit() {
            $("#addProjectForm").form('submit',{
                url:'${pageContext.request.contextPath}/addProject.controller',
                success:function (data) {
                    var dataObj=JSON.parse(data);
                    alert(dataObj.msg);
                    clearForm();
                    $("#addProjectWindow").window('close');
                    $("#project").datagrid('load');
                }
            })
        }
        function clearForm(){
            $("#addProjectForm").form('clear');
        }
        function detailProject(rowDate) {
            $.post('${pageContext.request.contextPath}/detailProject.controller',{"projectId":rowDate},
            function (data,status) {
                if(status=="success"){
                    $("#detailProjectName").textbox("setValue",data.projectName);
                    $("#detailProjectDesc").textbox("setValue",data.projectDesc);
                    $("#detailProjectVersion").textbox("setValue",data.projectVersion);
                    $("#detailProjectStatus").textbox("setValue",data.projectStatus);
                    $("#detailProjectWindow").window('open');
                }
            })
        }
        function showUpdateProject(projectId) {
            $.post('${pageContext.request.contextPath}/detailProject.controller',{"projectId":projectId},
                function (data,status) {
                    if(status=="success"){
                        $("#projectId").textbox("setValue", data.projectId);
                        $("#updateProjectName").textbox("setValue",data.projectName);
                        $("#updateProjectDesc").textbox("setValue",data.projectDesc);
                        $("#updateProjectVersion").textbox("setValue",data.projectVersion);
                        $("#updateProjectStatus").textbox("setValue",data.projectStatus);
                        $("#updateProjectWindow").window('open');
                    }
                });
        }
        function updateSubmit() {
            $("#updateProjectForm").form('submit',{
                url:'${pageContext.request.contextPath}/updateProject.controller',
                success:function(data){
                    var dataObj = JSON.parse(data);
                    alert(dataObj.msg);
                    $("#project").datagrid('load');
                    $("#updateProjectWindow").window('close');
                }
            });
        }
        function deleteProjectList() {
                var item=$("#project").datagrid('getSelections')
                if(item.length<1){
                    alert("请选择要删除的产品");
                    return;
                }
                var ids="";
                for(var i=0;i<item.length;i++){
                    ids+=item[i].projectId+",";
                }
                if(confirm("确定要删除这些产品吗？")){
                    $.post('${pageContext.request.contextPath}/deleteProjectList.controller',
                        {"projectIdList":ids},function(data,status){
                            if(status="success"){
                                alert(data.msg);
                                $("#project").datagrid('load');
                            }
                        });
                }

        }

    </script>
</head>
<body>
<%--修改--%>
<div id="updateProjectWindow" class="easyui-window" title="修改产品" closed="true"
     style="top:30%;left: 30%;width: 500px;height: 300px" >
    <div style="padding:10px 65px 10px 65px">
        <form id="updateProjectForm" method="post">
            <table cellpadding="5">
                <tr>
                    <td>产品名称：</td>
                    <td>
                        <input class="easyui-textbox" id="updateProjectName" name="projectName" value="">

                    </td>
                </tr>
                <tr>
                    <td>产品描述：</td>
                    <td>
                        <input class="easyui-textbox" id="updateProjectDesc" name="projectDesc" value="">
                        <input class="easyui-textbox" type="hidden"  id="projectId" name="projectId"/>
                    </td>
                </tr>
                <tr>
                    <td>产品版本：</td>
                    <td>
                        <input class="easyui-textbox" id="updateProjectVersion" name="projectVersion" value="">
                    </td>
                </tr>
                <tr>
                    <td>产品状态：</td>
                    <td>
                        <input class="easyui-textbox" id="updateProjectStatus" name="projectStatus" value="">
                    </td>
                </tr>
            </table>
        </form>
        <div>
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="updateSubmit()">提交</a>
        </div>
    </div>
</div>
<%--查看--%>
<div id="detailProjectWindow" class="easyui-window" title="查看产品" closed="true"
     style="left: 30%;top: 30%; width: 400px;height: 300px; padding:30px 60px 30px 60px" >

    <form id="detailProjectForm" method="post" >
        <table>
            <tr>
                <td>产品名称：</td>
                <td>
                    <input class="easyui-textbox" id="detailProjectName" readonly>
                </td>
            </tr>
            <tr>
                <td>产品描述：</td>
                <td>
                    <input class="easyui-textbox" id="detailProjectDesc" readonly>
                </td>
            </tr>
            <tr>
                <td>产品版本：</td>
                <td>
                    <input class="easyui-textbox" id="detailProjectVersion" readonly>
                </td>
            </tr>
            <tr>
                <td>产品状态：</td>
                <td>
                    <input class="easyui-textbox" id="detailProjectStatus" readonly>
                </td>
            </tr>
        </table>
    </form>
</div>
<%--list页面--%>
    <div>
        <table id="project"></table>
    </div>
<%--新增--%>
    <div id="addProjectWindow" class="easyui-window" title="添加产品" closed="true"
         style="left: 30%;top: 30%; width: 400px;height: 300px; padding:30px 60px 30px 60px" >

        <form id="addProjectForm" method="post" >
            <table>
                <tr>
                    <td>产品名称：</td>
                    <td>
                        <input type="vaildatebox" id="addProjectName" name="projectName"
                               data-options="required:true">
                    </td>
                </tr>
                <tr>
                    <td>产品描述：</td>
                    <td>
                        <input type="textBox" id="addProjectDesc" name="projectDesc"
                               data-options="multiline:true"
                        >
                    </td>
                </tr>
                <tr>
                    <td>产品版本：</td>
                    <td>
                        <input type="textBox" id="addProjectVersion" name="projectVersion"
                               data-options="multiline:true"
                        >
                    </td>
                </tr>
                <tr>
                    <td>产品状态：</td>
                    <td>
                        <input type="textBox" id="addProjectStatus" name="projectStatus"
                               data-options="multiline:true"
                        >
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="javascript:void(0)" onclick="addProjectSubmit()"
                           class="easyui-linkbutton" >提交</a>
                    </td>
                    <td>
                        <a href="javascript:void(0)" onclick="clearForm()"
                           class="easyui-linkbutton">清空</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
