<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ include file="common/header.jsp" %>
<body>
	<%@ include file="common/navigation.jsp" %>
	<div class="container">
	
		<form:form action="update-todo" method="post" modelAttribute="todo" >
			 	<h1>Update Your Todo Detail</h1></br>
			 	
			 	Description <form:input  type="text" path="description" required="required" placeholder="Set Your Goal"/>
			 				<form:errors path="description" />	
			 	Date		<form:input type="date" path="date" required="required" />
			 	
			 	<!--//int can't be null-->
			 	<form:input type="hidden" path="id"/>
			 	<!--  //date can be null 
			 	//boolean can't be null-->
			 	<form:input type="hidden" path="flag"/>
				<br>
				<input type="submit" class="btn btn-success" value="Update">
		</form:form>
	</div>
	<%@ include file="common/footer.jsp" %>
</body>
</html>