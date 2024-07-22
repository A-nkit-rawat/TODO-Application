<%@ include file="common/header.jsp" %>
<body>

	<div class="container">
		<h1>Welcome ${name}</h1>
		<br>
		<p>Your password ${password}</p>
		<p>
			<a href="/todo-list">Manage you to do list</a>
		</p>
	</div>
	<%@ include file="common/footer.jsp" %>
</body>
</html>