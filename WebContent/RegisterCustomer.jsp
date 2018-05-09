<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<center><h2><i><u>Enter Your Details</u></i></center>
<script type="text/javascript">
function fix(id){
	var y=document.getElementById("fixinput");
	if(id==("fixed")){	
	y.style.visibility="visible";
	}
	else{
		y.style.visibility="hidden";
	}
	
}
</script>
</head>
<body bgcolor=lightblue>
<center><form action="CreateAccount" method="post"><pre>
USERNAME:     <input type="email"  name="username" placeholder="Name"><br>
NAME:     <input type="text"  name="name" placeholder="Name"><br>
	     ACCOUNT TYPE:   <input type="radio" name="account_type" value="savings" id="savings" onchange="fix(this.id)">savings <input type="radio" name="account_type" value="current" id="current" onchange="fix(this.id)" >current  <input type="radio" name="account_type" value="fixed" id="fixed" onchange=" fix(this.id)">fixed<br>
AMOUNT:   <input type="text" name="amount" placeholder="enter amount"><br>

PASSWORD: <input type="password" name="password"><br>
DOB:	  <input type="text" name="DOB"><br>
PHONENO:  <input type="text" name="phoneNo"><br>
ADDRESS:  <input type="text" name="address"><br>
<div id="fixinput" style="visibility: hidden;">TENURE:<input type="text" name="tenure"  placeholder="Enter the term"></div><br>
</pre>
<button type="submit">Submit</button>

</form>
</body>
</html>