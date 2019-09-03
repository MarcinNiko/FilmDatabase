<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="test/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>

Title: ${film.title} <br>
Rated: ${film.rate} <br>
Released: ${film.year} <br>
Director: ${film.director} <br>
Actors: ${film.actors} <br>
<form action="addFilm">
    <input type="submit"><br>
</form>

</body>
</html>