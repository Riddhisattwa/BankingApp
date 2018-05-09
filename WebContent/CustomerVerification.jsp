<%@page import="com.mybankapp.services.GetTemporaryAccountDataservice"%>
<%@page import="com.mybankapp.model.TemporaryTable"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Verification</title>
</head>
<body>
<table>
<th>Name</th><th>Account Type</th><th>Amount</th><th>DOB</th><th>Phone No</th><th>Address</th>
<%
GetTemporaryAccountDataservice temporaryData=new GetTemporaryAccountDataservice();
ArrayList<TemporaryTable> customers=temporaryData.getdata();
for(TemporaryTable temp:customers){
	%>
	<tr>
	<td><%=temp.getName() %></td><td><%=temp.getAccount_type() %></td><td><%=temp.getAmount() %></td><td><%=temp.getDOB() %></td><td><%=temp.getPhoneNo() %></td><td><%=temp.getAddress() %></td><td><form action="ValidateCustomer" method="post"><input type="hidden" name="username" value="<%= temp.getUsername()%>"><input type="submit" value="submit"></form></td>
	</tr>
	<%
}
%>
</table>
</body>
</html>