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
<form action="searchDB" modelAttribute="vehicleDB" method="POST">
	<h3>Search db</h3>
<input type="text" name="id" placeholder="License Plate" />&nbsp
	&nbsp <input type="submit" value="Search"><br>
	
	<h4>Arrived in time</h4>
<input type="radio" name="intime" value="true">Yes<br>
<input type="radio" name="outoftime" value="false">No<br>
<br>
	
	<font color="red">  ${message} </font>
	<h3>Total Payment for customer:</h3>
	
	<%
String login_msg=(String)request.getAttribute("payment");  
			
if(login_msg!=null){
	int no = Integer.parseInt(login_msg);
	if(no<200){
	if("false".equals(request.getParameter("intime"))){
		System.out.println("ok");
		no=no+no/2;
		login_msg="Citizen must pay"+no+" $ in total for not being in time and for the tecnhical check";
		
		out.println("<font color=red size=4px>"+login_msg+"</font>");
		
	}else{
		login_msg="Citizen must pay"+no+" $ in total  for the  tecnhical check";
		out.println("<font color=red size=4px>"+login_msg+"</font>");	
	
	}
	}else{
		login_msg="Citizen must pay"+no+ " $ in total  for not having insurance";
		out.println("<font color=red size=4px>"+login_msg+"</font>");
	}
}


%>
	
	</form>