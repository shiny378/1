<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改信息</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://fastly.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改信息</small>
                </h1>
            </div>
        </div>
    </div>


    <form action="${pageContext.request.contextPath}/course/updateCourse" method="post" style="width: 30%">
        <input type="hidden" name="id" value="${course.getId()}"/>
        <div class="form-group">
            <label for="pic">课程图标：</label>
            <input type="file" class="form-control" id="pic" name="pic" value="${course.getPic()}" placeholder="课程图标">
        </div>
        <div class="form-group">
            <label for="name">课程名称：</label>
            <input type="text" class="form-control" id="name" name="name" value="${course.getName()}" placeholder="课程名称">
        </div>
        <div class="form-group">
            <label for="hours"> 开设课时：</label>
            <input type="text" class="form-control" id="hours" name="hours" value="${course.getHours()}" placeholder="开设课时">
        </div>
        <div class="form-group">
            <label for="schools"> 开设学院：</label>
            <input type="text" class="form-control" id="schools" name="schools" value="${course.getSchools()}" placeholder="开设学院">
        </div>
        <input class="btn btn-primary" type="submit" value="提交"/>
    </form>
</div>
</body>
</html>