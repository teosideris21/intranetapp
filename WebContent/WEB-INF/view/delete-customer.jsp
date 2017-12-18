<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">

	<h3>Delete a Customer</h3>

	<form:form action="deleteCustomer" modelAttribute="customer" method="POST" class="ui form">
		<div class="field">
			<label>ID</label> 
			<input type="text" name="id" />
		</div>
		<button class="ui button" type="submit">Delete</button>
	</form:form>

</div>