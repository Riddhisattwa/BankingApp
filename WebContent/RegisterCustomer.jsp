<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<center><h2><i><u>Enter Your Details</u></i></center>
</head>
<body bgcolor=lightblue>
<center><form action="CreateAccount" method="post"><pre>
NAME:     <input type="text"  name="username" placeholder="Name"><br>
	     ACCOUNT TYPE:   <input type="radio" name="account_type" value="savings" >savings <input type="radio" name="account_type" value="current" >current  <input type="radio" name="account_type" value="fixed">fixed<br>
AMOUNT:   <input type="text" name="amount" placeholder="enter amount"><br>
PASSWORD: <input type="password" name="password"><br>
DOB:	  <input type="text" name="DOB"><br>
PHONENO:  <input type="text" name="phoneNo"><br>
ADDRESS:  <input type="text" name="address"><br></pre>
<button type="submit">Submit</button>
</form>
</body>
</html>