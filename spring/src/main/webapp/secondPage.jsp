<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import= "java.util.List"
     %>
     <%@ page import="com.chainsys.spring.model.Details"%>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table>
		<tr>
			<th>Name</th>
			<th>Mail</th>
			<th>Phone</th>
			<th>Pass</th>
			<th></th>
			
		</tr>
		<%
		List<Details> list = (List<Details>) request.getAttribute("values");
		for(Details values:list){
			
		
	
		%>



		<tr>
			<td><%=values.getName()%></td>
			<td><%=values.getMail()%></td>
			<td><%=values.getPhone()%></td>
			<td><%=values.getPassword()%></td>
			<td><form action="updateForms.jsp">
			<input type="hidden" name="mail"value=<%=values.getMail() %>>
			<button type="submit"  >UPDATE</button>
			</form></td>
			<td><form action="delete" method="get">
		    <input type="hidden" name="mail"value=<%=values.getMail() %>>
			<button type="submit">DELETE</button>
			</form></td>
			
			<%} %>
			
			<form action="search" method="get">
			<input type="text" name="name"placeholder="Search Here"></input>
			<button type="submit">SEARCH</button>
			</form>
</body>
</html>