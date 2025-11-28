<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>

<page:applyDecorator name="main">
    <page:parameter name="title" value="Video List" />

    <h2>Video List</h2>

    <form class="row g-2 mb-3" method="get">
        <div class="col-auto">
            <input type="text" name="keyword" class="form-control" placeholder="Search title..."
                   value="${keyword}">
        </div>
        <div class="col-auto">
            <button class="btn btn-primary" type="submit">Search</button>
        </div>
        <div class="col-auto">
            <a href="${pageContext.request.contextPath}/admin/videos/create" class="btn btn-success">New Video</a>
        </div>
    </form>

    <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th><th>Title</th><th>Poster</th><th>Views</th><th>Category</th><th>Active</th><th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="v" items="${items}">
            <tr>
                <td>${v.videoId}</td>
                <td>${v.title}</td>
                <td>${v.poster}</td>
                <td>${v.views}</td>
                <td><c:out value="${v.category != null ? v.category.categoryName : ''}" /></td>
                <td>${v.active}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/admin/videos/edit/${v.videoId}">Edit</a> |
                    <a href="${pageContext.request.contextPath}/admin/videos/delete/${v.videoId}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</page:applyDecorator>
