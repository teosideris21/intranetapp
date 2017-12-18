<div>
<br><br>
<h3>Create Vehicle Card</h3> 
<form action="createCard" method="POST">
<input type="text" name="licenseplate" placeholder="License Plate"/><br><br>
<input type="date" name="inspectiondate" placeholder="Inspection Date"/><br><br>
<input type="date" name="nextinspectiondate" placeholder="NextInspectionDate"/>

<h4>ModelType</h4>
<input type="radio" name="modelType" value="car<=1800cc" checked> car<=1800cc<br>
<input type="radio" name="modelType" value="car>1800cc">car>1800cc<br>
<input type="radio" name="modelType" value="truck<=3t"> truck<=3t<br>
<input type="radio" name="modelType" value="truck>3t"> truck>3t<br>
<h4>Results</h4>
<input type="radio" name="carErrors" value="true">Success<br>
<input type="radio" name="carErrors" value="false">Failure
<br>
<br>
<input type="submit" value="Create">
<br>
<br>
<h3>Update Vehicle Card</h3>
<br>
<form action="updateCard">
<input type="text" name="userid" placeholder="License Plate"> <br><br>
<input type="submit" value="Update">
</form>