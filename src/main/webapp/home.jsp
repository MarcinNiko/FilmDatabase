<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="test/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
    <h2 id="para1">Find your movie! :)</h2>

    <div>
        <form action="getFilm">
            <input type="text" name="title"><br>
            <input type="submit"><br>
        </form>
    </div>

    Recent searches: <br>
    <c:forEach var="listOfFilm" items="${list}" >
        ${listOfFilm.title} <br>
    </c:forEach>
</body>
</html>