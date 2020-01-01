<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2020-01-01
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>bootstrapCRUD</title>
    <script src="${pageContext.request.contextPath }/static/js/jquery-3.3.1.min.js"></script>
    <link href="${pageContext.request.contextPath }/static/css/bootstrap.min.css"  rel="stylesheet">
    <script src="${pageContext.request.contextPath }/static/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath }/static/js/bootstrap-table.js"></script>


</head>
<body>
<br>
<div class="container">
    <!-- 			记录添加弹出层 -->
    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addLayer"> 添加记录 </button>
    <div class="modal fade" id="addLayer" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">

                    <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title">添加用户</h4>

                </div>
                <div class="modal-body">
                    <form id="add_items_form" class="form-horizontal">
                        <input type="hidden" id="id" class="form-control" name="id"> <br>
                        <input type="text" id="name" class="form-control" placeholder="姓名" name="name"> <br>
                        <input type="text" id="tel" class="form-control" placeholder="电话" name="tel"><br>
                        <input type="text" id="email" class="form-control" placeholder="邮箱" name="email"><br>
                        <input type="text" id="address" class="form-control" placeholder="地址" name="address"><br></form>
                </div>


                <div class="modal-footer">
                    <button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
                    <button class="btn btn-primary" type="button" onclick="addItem()">确认添加</button>
                </div>

            </div>
        </div>
    </div>
    <!-- <div style="height:200px"></div> -->



    <!-- 			记录修改弹出层 -->
    <div class="modal fade" id="editLayer" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">

                    <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title">修改用户</h4>

                </div>
                <div class="modal-body">
                    <form id="edit_items_form" class="form-horizontal">
                        <input type="hidden" id="id" class="form-control" name="id"> <br>
                        <input type="text" id="name" class="form-control" placeholder="姓名" name="name"> <br>
                        <input type="text" id="tel" class="form-control" placeholder="电话" name="tel"><br>
                        <input type="text" id="email" class="form-control" placeholder="邮箱" name="email"><br>
                        <input type="text" id="address" class="form-control" placeholder="地址" name="address"><br>
                    </form>
                </div>


                <div class="modal-footer">
                    <button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
                    <button class="btn btn-primary" type="button" onclick="updateItem()">确认修改</button>
                </div>

            </div>
        </div>
    </div>
    <!-- <div style="height:200px"></div> -->
    <table  class="table table-hover table table-striped" id="mytab">
        <tbody>

        </tbody>
    </table>
</div>








</body>
<script type="text/javascript">
    $(document).ready(function(ev){
        // 初始化数据
        $('#mytab').bootstrapTable({
            url: 'account/list',
            pagination: true,
            search: true,
            columns: [{
                field: 'id',
                title: '编号'
            }, {
                field: 'name',
                title: '姓名'
            }, {
                field: 'tel',
                title: '电话'
            }, {
                field: 'email',
                title: '邮件'
            }, {
                field: 'address',
                title: '地址'
            }, {
                field: 'retime',
                title: '注册时间'
            },{ field: 'Desc',title: '操作',formatter : function (value, row, index) {
                    var desc="<button class='btn btn-success btn-xs'  data-toggle='modal' data-target='#editLayer' onclick='editItems("+row.id+")'>修改</button><button class='btn btn-danger btn-xs' onclick='deleteItem("+row.id+")'>删除</button>";
                    return desc;
                } }
            ]
        });


    });

    //   删除
    function deleteItem(id){
        if(confirm("确定要删除该记录吗？")){
            $.ajax({
                type:"DELETE",
                url:"${pageContext.request.contextPath }/account/delete/"+id,
                dataType:"json",
                success:function(data) {
                    alert("删除成功!");
                    // 刷新
                    window.location.reload();
                }

            });
        }
    }

    //添加记录
    function addItem(){
        var arr = $("#add_items_form").serializeArray();
        var data = {};
        $.each(arr, function (i, item) {
            data[item.name] = item.value
        });
        $.ajax({
            url: '${pageContext.request.contextPath }/account/add',
            data: JSON.stringify(data),
            type:'POST',
            dataType: 'json',
            contentType:'application/json',
            success: function (result) {
                alert("添加成功!");
                // 刷新
                window.location.reload();

            }

        });
    }

    // 	“确认修改”按钮的点击事件
    function updateItem(){
        var arr = $("#edit_items_form").serializeArray();
        var data = {};
        $.each(arr, function (i, item) {
            data[item.name] = item.value
        });
        $.ajax({
            url: '${pageContext.request.contextPath }/account/update',
            data: JSON.stringify(data),
            type:'PUT',
            dataType: 'json',
            contentType:'application/json',
            success: function (result) {
                alert("修改成功!");
                window.location.reload();

            }

        });
    }

    //点击“修改”按钮，打开编辑窗口，回显数据
    function editItems(id){
        $("#edit_items_form")[0].reset();
        $.ajax({
            type:"GET",
            url:"${pageContext.request.contextPath }/account/"+id,
            dataType:"json",
            success:function(data){
                var serializeArray = $("#edit_items_form").serializeArray();
                $.each(serializeArray, function (i, item) {
                    var name = item.name;
                    if (data[name]) {
                        var value = data[name];
                        $("#edit_items_form [name='" + name + "']").val(value);
                    }
                });


            }
        });
    }


</script>
</html>

