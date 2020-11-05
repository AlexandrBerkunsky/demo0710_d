<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: aberk
  Date: 07.10.2020
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Countries</title>
    <link rel="stylesheet" type="text/css" href="resources/styles.css">
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>id</th>
                <th>name</th>
                <th>country</th>
            </tr>
        </thead>
        <tdbody>
    <jsp:useBean id="vendorBean" scope="request" type="beans.VendorBean"/>
    <c:forEach items="${vendorBean.vendors}" var="v">
        <tr>
            <td>${v.id}</td>
            <td>${v.name}</td>
            <td>${v.countryName}</td>
<%--            <td>${c.shortName}</td>--%>
<%--            <!-- + --><td><button type="submit" name="get" value="${c.id}">get vendors</button> </td>--%>
        </tr>
    </c:forEach>
        </tdbody>
    </table>
</body>
</html>
