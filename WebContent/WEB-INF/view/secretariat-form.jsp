<div>

	<br> <br>
	<h3>Add a Customer</h3>

	<form>
		<input type="button" value="Add"
			onclick="window.location.href='${pageContext.request.contextPath}/customer/showAddForm'" />
	</form>

	<h3>Delete a Customer</h3>

	<form>
		<input type="button" value="Delete"
			onclick="window.location.href='${pageContext.request.contextPath}/customer/showDeleteForm'" />
	</form>

	<h3>Search db</h3>
	<input type="number" name="id" placeholder="License Plate" />&nbsp
	&nbsp <input type="submit" value="Search"><br>
	<font color="red">  ${message} </font>
	<h3>Insured Vehicle</h3>
	<input type="radio" name="insured" value="true">Yes<br> <input
		type="radio" name="uninsured" value="false">No<br>
	</form>
	<h3>Total Payment for customer</h3>