<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Tests</title>
</head>

<body>
<table>
    <tr>
        <th>Type</th>
        <th>Questions</th>
        <th>AdditionalInfo</th>
    </tr>
    <c:forEach var="test" items="${tests}">
        <tr>
            <td>${test.type}</td>
            <td>${test.questionsAmount}</td>
            <td>${test.additionalInfo}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
