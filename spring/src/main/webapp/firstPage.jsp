<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Hello</h1>

<form action="register" method="post">
Name <br><input type="text" name="name" placeholder="Enter Your Name" required></input><br>
E-Mail <br><input type="text" name="mail" placeholder="Enter Your e-mail" required></input><br>
Phone <br><input type="text" name="phone" placeholder="Enter Your Phone Number" required></input><br>
Password <br><input type="text" name="pass" placeholder="Enter Atleast 8 Characters" required></input><br>

<input type="submit" value="submit"></input>
</form>

<form action="view" method="post">

<input type="submit" value="View Users"></input>
</form>
<br>
<br>
<form action="login" method="post">
E-Mail<input type="text" name="mail" Placeholder="Enter Your Mail" required><br>
Password<input type="text" name="pass" Placeholder="Enter Your Password" required>
<input type="submit" value="LOGIN"></input>
</form>


</body>
</html>