<%--
  Created by IntelliJ IDEA.
  User: xie
  Date: 2019/7/21
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
        .button{
            text-align: center;
            float: right;
            margin-right: 200px;
        }
        body{
            background-color: #5bc0de;
        }
    </style>

</head>
<body>
<div class="container">
    <h3 style="text-align: center">交易记录</h3>

    <form id="form" action="" method="post">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th>交易编号</th>
                <th>用户id</th>
                <th>用户名</th>
                <th>交易类型</th>
                <th>交易时间</th>
                <th>交易金额</th>
                <th>上次余额</th>
                <th>本次余额</th>
            </tr>

            <c:forEach items="${pageBean.list}" var="logList" varStatus="s">
                <tr bgcolor="#faebd7">
                    <td>${logList.opId}</td>
                    <td>${logList.user.id}</td>
                    <td>${logList.user.username}</td>
                    <td>${logList.opType}</td>
                    <td>${logList.opTime}</td>
                    <td>${logList.opMoney}</td>
                    <td>${logList.beforeMoney}</td>
                    <td>${logList.currentMoney}</td>
                </tr>
            </c:forEach>
        </table>
    </form>
</div>
<!--分页 -->
<div style="width: 380px; float: left; margin-left: 200px; margin-top: -8px">
    <ul class="pagination" style="text-align: center; margin-top: 10px;">

        <%--上一页--%>
        <c:if test="${pageBean.currentPage == 1}">
            <li class="disabled">
                <a href="javascript:void (0)" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
        </c:if>
        <c:if test="${pageBean.currentPage != 1}">
            <li>
                <a href="${pageContext.request.contextPath}/userAction.do?command=record&id=${user.id}&currentPage=${pageBean.currentPage - 1}" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
        </c:if>
        <%--显示每一页--%>
        <c:forEach begin="1" end="${pageBean.totalPage}" var="page">
            <%--判断是否是当前页--%>
            <c:if test="${page == pageBean.currentPage}">
                <li class="active"><a href="javascript:void(0);">${page}</a></li>
            </c:if>
            <c:if test="${page != pageBean.currentPage}">
                <li><a href="${pageContext.request.contextPath}/userAction.do?command=record&id=${user.id}&currentPage=${page}">${page}</a></li>
            </c:if>
        </c:forEach>
        <%--下一页--%>

        <c:if test="${pageBean.currentPage == pageBean.totalPage}">
            <li class="disabled">
                <a href="javascript:void (0)" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </c:if>

        <c:if test="${pageBean.currentPage != pageBean.totalPage}">
            <li>
                <a href="${pageContext.request.contextPath}/userAction.do?command=record&id=${user.id}&currentPage=${pageBean.currentPage + 1}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </c:if>
    </ul>
</div>
<!-- 分页结束 -->
<div class="button">
    <input type="button" class="btn btn-primary" value="返回" onclick="window.location='${pageContext.request.contextPath}/userIndex.jsp'">
</div>
</body>
</html>
