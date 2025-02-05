<%@page import="java.util.List"%>
<%@page import="com.ty.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  </head>
  <body>
    <div class="container">
    <% List<Student> students = (List<Student>)request.getAttribute("students"); %>
		<h1>Welcome to Home Page</h1>
		<h6>${msg}</h6>
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">Name</th>
		      <th scope="col">Email Address</th>
		      <th scope="col">Phone No.</th>
		      <th scope="col">Update</th>
		      <th scope="col">Delete</th>
		    </tr>
		  </thead>
		  <tbody>
		  <% for(Student student :students){ %>
		    <tr>
		      <td><%= student.getName()%></td>
		      <td><%= student.getEmail() %></td>
		      <td><%= student.getPhone() %></td>
		      <td><a href="<%=request.getContextPath() %>/update?sid=<%=student.getSid()%>">Update</a></td>
		      <td><a href="<%= request.getContextPath() %>/delete?sid=<%=student.getSid()%>">Delete</a></td>
		    </tr>
		   <% } %>
		  </tbody>
		</table>
		<a href="add">Add</a><br> 
		<a href="email">Send Email</a><br>
		<a href="/">Logout</a>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  </body>
</html>