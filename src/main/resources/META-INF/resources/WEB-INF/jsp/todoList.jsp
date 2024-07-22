<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="common/header.jsp" %>
<body>
	<%@ include file="common/navigation.jsp" %> 
	<div class="container">
		<h3>Your Todo List</h3>
		<table class="table">
				<tr>
					<!-- <th>Sr.No</th> -->
					<th>Description</th>
					<th>Date</th>
					<th>Complete</th>
				</tr>
			<c:forEach items="${todoLists}" var="todo">
				
				<tr>
					<td>${todo.description}</td>
					<td>${todo.date}</td>
					<td>${todo.flag}</td>
					<td><a href="update-todo?id=${todo.id}" class="btn btn-success">UPDATE</a></td>
					<td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">DELETE </a></td>
				</tr>
				
			</c:forEach>
			
		</table>
		
		<div ><a href="todo" class="btn btn-success">Add To Do</a></div>

		<!-- <form method="GET" action="/submission">
			<div>User Name    <input type="text" placeholder="Enter the email" name="name"></div>
			<div>Password     <input type="password" placeholder="min 8 character" name="password"></div>
			<div class="btn btn-success"><input type="submit" value="Login"></div>	
		</form> -->
	</div>
	<%@ include file="common/footer.jsp" %>
</body>
</html>