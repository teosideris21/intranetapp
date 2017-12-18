<div>

	<br> <br>
	<h3>Search for a Customer</h3>
	<form action="findCustomer" method="POST">

		<input type="text" name="id" placeholder="ID" />&nbsp &nbsp <input
			type="submit" value="Search">
		<h3>Add a Customer</h3>

		<form>
			<input type="button" value="Add"
				onclick="window.location.href='${pageContext.request.contextPath}/customer/showAddForm'" />
		</form>

		<h3>Total Payment for customer</h3>
		<h3>Search db</h3>
		<input type="number" name="id" placeholder="License Plate" />&nbsp &nbsp <input
			type="submit" value="Search">
		<h3>Insured Vehicle</h3>
		<input type="radio" name="insured" value="true">Yes<br> <input
			type="radio" name="uninsured" value="false">No<br>
	</form>