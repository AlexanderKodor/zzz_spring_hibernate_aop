<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: AlexNoutbook
  Date: 13.07.2024
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All employees</title>
</head>
<body>
<h2>All employees</h2>
<table>
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Department</th>
        <th>Salary</th>
        <th>Operations</th>
    </tr>
    <c:forEach var="employee" items="${allEmployees}">
        <c:url var="updateButton" value="/updateInfo">
            <c:param name="employeeId" value="${employee.id}"/>
        </c:url>
        <c:url var="deleteButton" value="/deleteInfo">
            <c:param name="employeeId" value="${employee.id}"/>
        </c:url>
        <tr>
            <td>${employee.name}</td>
            <td>${employee.surname}</td>
            <td>${employee.department}</td>
            <td>${employee.salary}</td>
            <td>
                <input type="button" value="Update" onclick="window.location.href = '${updateButton}'"/>
                <input type="button" value="Delete" onclick="window.location.href = '${deleteButton}'"/>
            </td>
        </tr>
    </c:forEach>
</table>

<br>
<input type="button" value="Add" onclick="window.location.href = 'addNewEmployee'"/>

</body>
</html>
