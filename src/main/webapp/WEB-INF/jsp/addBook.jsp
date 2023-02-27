<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:import url="header.jsp"></c:import>
<div style="color:red;">${error }</div>
<form:form action="/bookManagement/addbook" method="post" modelAttribute="bean">
<table>
<tr>
<td>
Book Code
</td>
<td>
<form:input type="text" path="bookCode" />
</td>
<td><form:errors path="bookCode" style="color:red;"></form:errors></td>

</tr>
<tr>
<td>
Book Title
</td>
<td>
<form:input type="text" path="bookTitle"/>
</td>
<td><form:errors path="bookTitle" style="color:red;"></form:errors></td>
</tr>
<tr>
<td>
Book Author
</td>
<td>
<form:input type="text" path="bookAuthor" />
</td>
<td><form:errors path="bookAuthor" style="color:red;"></form:errors></td>
</tr>
<tr>
<td>
Book Price
</td>
<td>
<form:input type="text" path="bookPrice" />
</td>
<td><form:errors path="bookPrice" style="color:red;"></form:errors></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="Add"></td>
</tr>
</table>
</form:form>
</body>
</html>