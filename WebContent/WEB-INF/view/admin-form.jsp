<div>

	<br>
	<br>
	<h3>Create a new User</h3>
	<form action="createUser" method="POST">
		<input type="text" name="name" placeholder="name" />&nbsp &nbsp &nbsp
		<input type="text" name="surname" placeholder="surname" /> &nbsp &nbsp &nbsp<input
			type="text" name="email" placeholder="email" /> <br>
		<br> <input type="text" name="userid" placeholder="userid" />&nbsp
		&nbsp &nbsp <input type="password" name="password" placeholder="password" /><br>
		<h4>Role</h4>
		<select>
			<option value="administrator">Administrator</option>
			<option value="secretariat">Secretariat</option>
			<option value="technician">Technician</option>
		</select><br><br> <input type="submit" value="Create">
	</form>
<br>
	<div>
		<h3>Delete a user</h3>
		<form action="deleteUser">
			<input type="text" name="userid" placeholder="id"> <br> <br><input
				type="submit" value="Delete">
		</form>
<br>
		<div>
			<h3>Update a user</h3> 
			<form action="UpdateUser">
				<input type="number" name="userid" placeholder="id"><br><br> <input
					type="submit" value="Update">
			</form>