<div>
	<br>
	<br>
	<h3>Create Vehicle Card</h3>
	<form action="createCard" method="POST">
		<input type="text" name="license_plate" placeholder="License Plate"
			pattern="^[a-zA-Z0-9]+$" required="true" /><br>
		<h4>Inspection Date</h4>
		<input type="date" name="inspection_date"
			placeholder="inspection_date" required="true"/><br>
		<h4>Next Inspection Date</h4>
		<input type="date" name="next_inspection_date"
			placeholder="next_inspection_date" required="true"/><br>
		<h4>ModelType</h4>
		<input type="radio" name="model" value="car" checked> car<br>
		<input type="radio" name="model" value="truck"> truck<br>
		<h4>CC</h4>
		<input type="text" name="cc" placeholder="CC" pattern="^[0-9]+$" required="true"/><br>
		<h4>Results</h4>
		<input type="radio" name="results" value="Success" checked>Success<br>
		<input type="radio" name="results" value="Failure">Failure <br>
		<br> <input type="submit" value="Create">
	</form>
	<br>
	<%
		String create_msg = (String) request.getAttribute("create");
		if (create_msg != null)
			out.println("<font color=red size=3px>" + create_msg + "</font>");
	%>
	<br>
	<h3>Update Vehicle Card</h3>
	<br>
	<form action="updateCardDelete">
		<input type="text" name="license_plate" placeholder="License Plate">
		<br>
		<br> <input type="submit" value="Update">
	</form>