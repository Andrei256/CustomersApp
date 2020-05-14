<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Client Manager</title>
</head>
<body>
<div align="center">
    <h2>Client Manager</h2>
    <form method="get" action="search">
        <input type="text" name="string"/> &nbsp;
        <input type="submit" value="Search">
    </form>
    <h3><a href="/new">New Client</a> </h3>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>E-mail</th>
            <th>Address</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${listClient}" var="client">
            <tr>
                <td>${client.id}</td>
                <td>${client.name}</td>
                <td>${client.email}</td>
                <td>${client.address}</td>
                <td>
        <a href="/edit?id=${client.id}">Edit</a>
        &nbsp;&nbsp;&nbsp;
        <a href="/delete?id=${client.id}">Delete</a>
             </td>
        </tr>
        </c:forEach>

</div>
</body>
</html>
