<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>
<body>

<h2>College Information</h2>
<form:form method="POST" action="/FirstSpringMVC/addCollege" modelAttribute="command">
   <table>
    <tr>
        <td><form:label path="collname">Name</form:label></td>
        <td><form:input path="collname" /></td>
    </tr>
   
    <tr>
        <td><form:label path="city">City</form:label></td>
        <td><form:input path="city" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
        <td><a href="/FirstSpringMVC/list">List Students</a></td>
    </tr>
</table>  






</form:form>

<h2>Submitted College Information</h2>
   <table>
    <tr>
        <td>Name</td><td>ID</td></tr>
       
     <c:forEach items="${collList}" var="coll" varStatus="cStatus">
        <tr><td>${coll.collname}</td>
    
       
   
        
        <td>${coll.cid}</td>
    </tr>
    </c:forEach>
</table>  






</body>
</html>