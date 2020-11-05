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
                <th>short</th>
                <!-- + --><th></th>
            </tr>
        </thead>
        <tdbody>
    <jsp:useBean id="countryBean" scope="request" type="beans.CountryBean"/>
    <c:forEach items="${countryBean.countries}" var="c" >
            <form method="post" action="vendors.html">
        <tr>
            <td>${c.id}</td>
            <td>${c.name}</td>
            <td>${c.shortName}</td>
            <!-- + --><td><button type="submit" name="getoo" value="${c.id}">get vendors</button> </td>
        </tr>
            </form>
    </c:forEach>
        </tdbody>
    </table>
</body>
</html>
