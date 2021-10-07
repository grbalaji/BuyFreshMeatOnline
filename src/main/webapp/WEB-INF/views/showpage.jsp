<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body style="background-color:lavender">
<h1><center>Buy Fresh Meat Online </center></h1>
<form:form method="post" action="result" modelAttribute="item">

<table style="margin: 0px auto; margin-left: auto; margin-right:auto">
		          
			<tr>
				<td>Choose the Item:</td>
				<td>
				 <form:select path="itemName" id="itemName">
						<form:options items="${itemList}"/>
					</form:select>	
					
				</td>
			</tr>
						
			<tr>
			<td>Enter the quantity in KG:</td><td><form:input path="quantity" id="quantity"/></td><td><form:errors path="quantity"/></tr>
			<tr>
			
				<td><input type="submit" value="CalculateCost" name="submit" /></td>
				<td><input type="reset" value="Cancel"/></td>
			</tr>
			
		</table>
</form:form>


</body>
</html>	 	  	    	    	     	      	 	
