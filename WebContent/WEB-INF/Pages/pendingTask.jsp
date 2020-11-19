<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page isELIgnored="false"%>
<html lang="en">
<head>
  <title>Pending Tasks</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <center><h2>Pending Tasks</h2></center>
              <br/>
              <br/>
  <table class="table table-dark">
    <thead>
      <tr>
        <th>Task Description</th>
        <th>Due Date</th>
        <th>Completed</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${list}" var="x" varStatus="loop">
					<tr>
					<td>${x.name}</td>
					<td>${x.date}</td>
					<td>${x.completed}</td>
					<td>
					<form action="taskOption">
						<input type="hidden" name="taskId" value=${x.id}>
						<input type="hidden" name = "sessionId" value= <%=request.getParameter( "sessionId") %>>
						<c:if test="${x.completed == 'No'}" >
						<button type="submit" name="button" value="complete">Mark Complete</button>
						</c:if>
						<button type="submit" name="button" value="delete">Delete</button>
					</form>
					</td>
					<!-- <td>
					<form action="edit">
					<input type="hidden" name="taskId" value=${x.id}>
					<button action="deleteTask">Delete</button>
					</form>-->
					</tr> 
	</c:forEach>
    </tbody>
  </table>
</div>

</body>
</html>
