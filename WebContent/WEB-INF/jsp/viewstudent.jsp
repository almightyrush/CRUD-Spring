<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Data</title>
</head>
<body>
	    
  
<h1>Employees List</h1>  
<table border = 1>  
<tr><th>Id</th><th>Name</th><th>Marks</th><th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="student" items="${list}">   
   <tr>  
   <td>${student.id}</td>  
   <td>${student.name}</td>  
   <td>${student.marks}</td>  
    
   <td><a href="editform/${student.id}">Edit</a></td>  
   <td><a href="deletestudent/${student.id}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a href="studentform">Add New Employee</a>  
	
</body>
</html>