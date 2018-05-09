<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<center><marquee behavior="alternate"><h2 style="color: white;font-size: 43px;"><i><u>Enter Your Details</u></i></h2></marquee></center>
<style>
input {
    border: 2px solid white; 
    -webkit-box-shadow: 
      inset 0 0 2px  rgba(0,0,0,1)
            0 0 4px rgba(0,0,0,1); 
    -moz-box-shadow: 
      inset 0 0 2px  rgba(0,0,0,1),
            0 0 4px rgba(0,0,0,1); 
    box-shadow: 
      inset 0 0 2px  rgba(0,0,0,0.1),
            0 0 4px rgba(0,0,0,0.1); 
    padding: 5px;
    background: rgba(0,0,128,0.7);
    margin: 0 0 10px 0;
}
::placeholder{
color: white;
}
</style>
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
<body style="background: url('http://i.dailymail.co.uk/i/pix/2012/09/27/article-2209474-0CFE87C700000578-772_468x312.jpg');background-size: 100% 100%">
<center><form action="CreateAccount" method="post">

<pre style="color: red; "><h2>
USERNAME:  <input type="email"  name="username" placeholder="Email" style="margin-right: 10px;"><br>
NAME:     <input type="text"  name="name" placeholder="Name"><br>
ACCOUNT TYPE:   <input type="radio" name="account_type" value="savings" id="savings" onchange="fix(this.id)">savings <input type="radio" name="account_type" value="current" id="current" onchange="fix(this.id)" >current  <input type="radio" name="account_type" value="fixed" id="fixed" onchange=" fix(this.id)">fixed<br>
AMOUNT:   <input type="text" name="amount" placeholder="enter amount"><br>

PASSWORD: <input type="password" name="password" placeholder="Password"><br>
DOB:	  <input type="text" name="DOB" placeholder="Date of Birth"><br>
PHONENO:  <input type="text" name="phoneNo" placeholder="phone no"><br>
ADDRESS:  <input type="text" name="address" placeholder="address"><br>
<div id="fixinput" style="visibility: hidden;">TENURE:   <input type="text" name="tenure"  placeholder="Enter the term"></div><br>
</h2></pre>

<button type="submit">Submit</button>

</form>

</body>
</html>