package com;


import java.sql.*;

public class HosAppoint {
	
	
	
	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// Provide the correct details: DBServer/DBName, username, password
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public String addHosAppointment(String hospitalid, String hospitalName, String appointmentid, String date, String patientid,
			String doctorid, String doctorName) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error nothing in the database.";
			}
			// create a prepared statement
			String query = " insert into hospital(`hospitalid`,`hospitalName`,`appointmentid`,`date`,`patientid`,`doctorid`,doctorName)"
					+ " values (?, ?, ?, ?, ? ,? ,?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setString(1, hospitalid);
			preparedStmt.setString(2, hospitalName);
			preparedStmt.setString(3, appointmentid);
			preparedStmt.setString(4, date);
			preparedStmt.setString(5, patientid);
			preparedStmt.setString(6, doctorid);
			preparedStmt.setString(7, doctorName);

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";
		} catch (Exception e) {
			output = "Error while inserting the item.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String getHosAppointment() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>hospitalid</th><th>hospitalName</th><th>appointmentid</th>date<th></th><th>patientid</th><th>doctorid</th><th>doctorName</th></tr>";
			String query = "select * from hospital";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String hospitalid = rs.getString("hospitalid");
				String hospitalName = rs.getString("hospitalName");
				String appointmentid = rs.getString("appointmentid");
				String date = rs.getString("date");
				String patientid = rs.getString("patientid");
				String doctorid = rs.getString("doctorid");
				String doctorName = rs.getString("doctorName");
				// Add into the html table
				output += "<tr><td>" + hospitalid + "</td>";
				output += "<td>" + hospitalName + "</td>";
				output += "<td>" + appointmentid + "</td>";
				output += "<td>" + date + "</td>";
				output += "<td>" + patientid + "</td>";
				output += "<td>" + doctorid + "</td>";
				output += "<td>" + doctorName + "</td>";
				
			}
			con.close();
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the items.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updateHosAppointment(String hospitalid, String hospitalName, String appointmentid, String date,
			String patientid, String doctorid, String doctorName)

	{
		String output ="";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			// create a prepared statement
			String query = "UPDATE hospital SET hospitalName=?, appointmentid=?, date=?, patientid=?, doctorid=?, doctorName=?  WHERE hospitalid=?";
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			
			preparedStmt.setString(1, hospitalName);
			preparedStmt.setString(2, appointmentid);
			preparedStmt.setString(3, date);
			preparedStmt.setString(4, patientid);
			preparedStmt.setString(5, doctorid);
			preparedStmt.setString(6, doctorName);
			preparedStmt.setString(7, hospitalid);
		
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Updated successfully";
		} catch (Exception e) {
			output = "Error while updating a appointment details.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String deleteHosAppointment(String hospitalid) {
		String output = " ";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
// create a prepared statement
			String query = "delete from hospital where hospitalid=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
// binding values
			preparedStmt.setString(1, hospitalid);
// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Deleted successfully";
		} catch (Exception e) {
			output = "Error while deleting the appointment detail.";
			System.err.println(e.getMessage());
		}
		return output;
	}

}
