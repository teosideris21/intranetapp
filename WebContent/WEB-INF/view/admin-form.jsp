<div>

	<br> <br>

	<h3>Create a new User</h3>
	<form action="createUser" method="POST">
		<input type="text" name="name" placeholder="name" />&nbsp &nbsp &nbsp
		<input type="text" name="surname" placeholder="surname" /> &nbsp
		&nbsp &nbsp<input type="text" name="email" placeholder="email" /> <br>
		<br> <input type="text" name="username" placeholder="userid" />&nbsp
		&nbsp &nbsp <input type="password" name="password"
			placeholder="password" /><br>
		<h4>Role</h4>
		<select id="role" name="role">
			<option value="Administrator">Administrator</option>
			<option value="Secretariat">Secretariat</option>
			<option value="Technician">Technician</option>
		</select><br>
		<br> <input type="submit" value="Create">
	</form>
	<br>
	<div>
		<h3>Delete a user</h3>
		<form action="deleteUser">
			<input type="text" name="username" placeholder="username"> <br>
			<br>
			<input type="submit" value="Delete">
		</form>
		<br>
		<%
			String login_msg = (String) request.getAttribute("message");
			if (login_msg != null)
				out.println("<font color=red size=4px>" + login_msg + "</font>");
		%>
		<div>
			<h3>Update a user</h3>
			<form action="updateUser">
				<input type="text" name="username" placeholder="username"><br>
				<br> <input type="submit" value="Update">
			</form>