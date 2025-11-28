<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title><page:title default="Video Admin"/></title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"/>
</head>
<body>
<header class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <a class="navbar-brand" href="#">Video Admin</a>
        <span class="navbar-text">Sinh viên: Your Name - MSSV</span>
    </div>
</header>

<main class="container mt-4">
    <page:body/>
</main>

<footer class="text-center mt-4 mb-4">
    <a href="https://github.com/">GitHub - bài tập</a>
</footer>

</body>
</html>
