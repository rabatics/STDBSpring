<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>
<body>

<h2>Submitted Student Information</h2>
   <table>
    <tr>
        <td>Name</td><td>Age</td><td>ID</td></tr>
       
     <c:forEach items="${userList}" var="currentUser" varStatus="uStatus">
        <tr><td>${currentUser.name}</td>
    
        <td>${currentUser.age}</td>
   
        
        <td>${currentUser.id}</td>
    </tr>
    </c:forEach>
</table>  <br />
<a href="/FirstSpringMVC/student">Add Student</a>
</body>
</html>