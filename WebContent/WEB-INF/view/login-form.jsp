<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">

	<h3>Login</h3>

	<form:form action="loginForm" modelAttribute="customer" method="POST"
		class="ui form">
		<div class="field">
			<label>Username</label> <input type="text" name="username"/>
		</div>
		<div class="field">
			<label>Password</label> <input type="password" name="password"/>
		</div>

		<button class="ui button" type="submit">Login</button>
		<br>
		<br>
		<%
			String login_msg = (String) request.getAttribute("message");
				if (login_msg != null)
					out.println("<font color=red size=4px>" + login_msg + "</font>");
		%>
	</form:form>

</div>