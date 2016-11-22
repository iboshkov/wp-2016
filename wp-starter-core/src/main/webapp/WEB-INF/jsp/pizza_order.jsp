<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 131223
  Date: 11/22/2016
  Time: 1:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form action="client" method="get">
    <c:forEach items="${types}" var="item">
        <input type="radio" name="pizzaType" checked value="${item}"/> ${item}
    </c:forEach>
    <input type="submit"/>
</form>
</body>
</html>