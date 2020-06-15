<%@page import="com.springmvc.model.Maintenance"%>
<%@page import="java.util.LinkedHashMap"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Maintain Table</title>
</head>

<body>

	<form:form id="maintenanceForm" modelAttribute="maintenance"
		action="maintenanceProcess" method="post">
		<table align="center">

			<tr>
				<td></td>
				<td align="left"><select id="tableName" name="tableName">
						<option value="0" label="Select One" />
						<option value="users" label="users" />
				</select></td>
			</tr>
			<tr>
				<td></td>
				<td align="left"><form:select id="columnNames"
						name="columnNames" path="columnNames" multiple="single">
						<form:options items="${tableDetails.columnNames}" />
					</form:select></td>
			</tr>

			<tr>
				<td></td>
				<td align="left"><form:button id="getTableNames"
						name="getTableNames">GetTableNames</form:button></td>
			</tr>

			<tr></tr>

			<tr>
				<td><a href="home.jsp">Home</a></td>
			</tr>

		</table>
		<table>
			<tr>
				<td>
				<form:input value="${tableDetails.columnNames}" path="columnNames"/>
				</td>
			</tr>
		</table>
	</form:form>
	<table align="center">
		<tr>
			<td style="font-style: italic; color: red;">${message}</td>
		</tr>
	</table>

</body>
</html>