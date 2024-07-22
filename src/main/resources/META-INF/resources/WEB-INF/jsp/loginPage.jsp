<%@ include file="common/header.jsp" %>
<body>
	<div class="container">
		<form method="GET" action="/submission">
			<div>User Name    <input type="text" placeholder="Enter the email" name="name"></div>
			<div>Password     <input type="password" placeholder="min 8 character" name="password"></div>
			<div class="btn btn-success"><input type="submit" value="Login"></div>	
		</form>
	</div>
	<%@ include file="common/footer.jsp" %>
</body>
</html>