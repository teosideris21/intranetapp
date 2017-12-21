<div>

	<br> <br>

	<h3>Create a new User</h3>
	<form action="createUser" method="POST">
		<input type="text" name="name" placeholder="name" pattern="^[a-zA-Z]+$"/>&nbsp &nbsp &nbsp
		<input type="text" name="surname" placeholder="surname" pattern="^[a-zA-Z]+$"/> &nbsp
		&nbsp &nbsp<input type="text" name="email" placeholder="email" /> <br>
		<br> <input type="text" name="username" placeholder="userid"/>&nbsp
		&nbsp &nbsp <input type="password" name="password"
			placeholder="password" pattern="^[a-zA-Z0-9]+$"/><br>
		<h4>Role</h4>
		<select id="role" name="role">
			<option value="Administrator">Administrator</option>
			<option value="Secretariat">Secretariat</option>
			<option value="Technician">Technician</option>
		</select><br> <br> <input type="submit" value="Create">
	</form>
	<br>
	<%
				String create_msg = (String) request.getAttribute("create");
				if (create_msg != null)
					out.println("<font color=red size=3px>" + create_msg + "</font>");
			%>
	<br>
	<div>
		<h3>Delete a user</h3>
		<form action="deleteUser">
			<select id="username" name="username">
				<c:forEach var="tempCustomer" items="${users}">

					<option value=${tempCustomer.username}>${tempCustomer.username}</option>
					
				</c:forEach>
			</select> <br> <br> 
			<input type="submit" value="Delete">
		</form>
		<br>
		<%
			String delete_msg = (String) request.getAttribute("delete_msg");
			if (delete_msg != null)
				out.println("<font color=red size=4px>" + delete_msg + "</font>");
		%>
		<div>
			<h3>Update a user</h3>
			<form action="updateUser">
				<input type="text" name="username" placeholder="username"><br>
				<br> <input type="submit" value="Update">
			</form>
			<br>
			<%
				String update_msg = (String) request.getAttribute("update_msg");
				if (update_msg != null)
					out.println("<font color=red size=4px>" + update_msg + "</font>");
			%>