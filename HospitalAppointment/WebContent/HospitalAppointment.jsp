<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.HosAppoint"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hospital Appointment</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/hosappoint.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-4">

				<h1>Appointments</h1>

				<form id="formItem" name="formItem">

					<div class="input-group input-group-sm mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="lblName">hospitalid:
							</span>
						</div>
						<input id="hospitalid" name="hospitalid" type="text"
							class="form-control form-control-sm">
					</div>
					<div class="input-group input-group-sm mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="lblName">hospitalName:
							</span>
						</div>
						<input id="hospitalName" name="hospitalName" type="text"
							class="form-control form-control-sm">
					</div><div class="input-group input-group-sm mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="lblName">appointmentid:
							</span>
						</div>
						<input id="appointmentid" name="appointmentid" type="text"
							class="form-control form-control-sm">
					</div><div class="input-group input-group-sm mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="lblName">date:
							</span>
						</div>
						<input id="date" name="date" type="text"
							class="form-control form-control-sm">
					</div><div class="input-group input-group-sm mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="lblName">patientid:
							</span>
						</div>
						<input id="patientid" name="patientid" type="text"
							class="form-control form-control-sm">
					</div><div class="input-group input-group-sm mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="lblName">doctorid:
							</span>
						</div>
						<input id="doctorid" name="doctorid" type="text"
							class="form-control form-control-sm">
					</div><div class="input-group input-group-sm mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="lblName">doctorName:
							</span>
						</div>
						<input id="doctorName" name="doctorName" type="text"
							class="form-control form-control-sm">
					</div>
					




					<input id="btnSave" name="btnSave" type="button" value="Save"
						class="btn btn-primary"> <input type="hidden"
						id="hidItemIDSave" name="hidItemIDSave" value="">
				</form>

				<div id="alertSuccess" class="alert alert-success"></div>

				<div id="alertError" class="alert alert-danger"></div>


			</div>
			<div class='col-12'>
				<div id="divItemsGrid">

					<%
						HosAppoint AppointObj=new HosAppoint();
								out.print(AppointObj.getHosAppointment());
					%>
				</div>

			</div>
		</div>
	</div>

</body>
</html>