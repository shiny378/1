<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>课程列表</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <!-- 引入 Bootstrap -->
  <link href="https://fastly.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    .b{
      text-decoration: none;
    }
  </style>
</head>
</html>

<div class="container">

  <div class="row clearfix">
    <div class="col-md-12 column">
      <div class="page-header">
        <h1>
          <small>课程列表 —— 显示所有课程</small>
        </h1>

      </div>
    </div>
  </div>

  <div class="row">
    <div class="col-md-9 column">
      <a class="btn btn-primary" href="${pageContext.request.contextPath}/course/toAddCourse">新增</a>
      <span style="color: red">${error}</span>
    </div>
    <div class="col-md-3 column">
      <form action="${pageContext.request.contextPath}/course/queryCourse" method="" >
        <div class="input-group">
          <ul class="nav navbar-nav">
            <li class="dropdown user user-menu">
              <a>
                用户：<span class="hidden-xs">${USER_SESSION.name}， </span>
              </a>
            </li>
            <li class="dropdown user user-menu">
              <a href="${pageContext.request.contextPath}/admin/login.jsp">
                <span class="hidden-xs">退出</span>
              </a>
            </li>
          </ul>
        </div><!-- /input-group -->
      </form>
    </div>
  </div>


  <div class="row clearfix">
    <div class="col-md-12 column">
      <table class="table table-hover table-striped">
        <thead>
        <tr>
          <th>课程图片</th>
          <th>课程名称</th>
          <th>开设课时</th>
          <th>开设学院</th>
          <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="course" items="${list.data}">
          <tr>
            <td>  <!-- 头像显示 -->
              <img src="${pageContext.request.contextPath}/course/showPic/${course.getPic()}" style="width:100px; height: 100px;"/></td>
            <td>${course.getName()}</td>
            <td>${course.getHours()}</td>
            <td>${course.getSchools()}</td>
            <td>
              <a color="red" class="b" href="${pageContext.request.contextPath}/course/toUpdateCourse?id=${course.getId()}">更改</a> |
              <a color="red" class="b" href="${pageContext.request.contextPath}/course/del/${course.getId()}">删除</a>
            </td>
          </tr>
        </c:forEach>

        </tbody>
      </table>
    </div>
  </div>
  <nav aria-label="Page navigation">
    <ul class="pagination" style="float: right">
      <c:if test="${list.showFirstPage}">
        <li>
          <a href="${pageContext.request.contextPath}/course/queryCourseByName?curPage=1&name=${name}" aria-label="Previous">
            <span aria-hidden="true">首页</span>
          </a>
        </li>
      </c:if>

      <c:if test = "${list.showPrevious}">
        <li>
          <a href="${pageContext.request.contextPath}/course/queryCourse?curPage=${list.page -1}&name=${name}" aria-label="Previous">
            <span aria-hidden="true">上一页</span>
          </a>
        </li>
      </c:if>

      <c:forEach var="page" items="${list.pages}" >
        <li><a href="${pageContext.request.contextPath}/course/queryCourse?curPage=${page}&name=${name}" >${page}</a></li>
      </c:forEach>

      <c:if test = "${list.showNext}">
        <li >
          <a href="${pageContext.request.contextPath}/course/queryCourse?curPage=${list.page + 1}&name=${name}" aria-label="Next">
            <span aria-hidden="true">下一页</span>
          </a>
        </li>
      </c:if>

      <c:if test = "${list.showEndPage}">
        <li>
          <a href="${pageContext.request.contextPath}/course/queryCourse?curPage=${list.totalPage}&name=${name}" aria-label="Previous">
            <span aria-hidden="true">尾页</span>
          </a>
        </li>
      </c:if>

    </ul>
  </nav>
</div>