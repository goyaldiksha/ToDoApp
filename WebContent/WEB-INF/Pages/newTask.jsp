<html>
<title>Add Task</title>
<head>
<link rel="stylesheet" href="loginCSS.css" type="text/css"/>
<link rel="icon" type="image/png" href="images/icon.png"/>
</head>
<body>
	<br/>
	<br/>
	<div id="formBlock">
	
	<div id="heading">Add Task</div>
	
	<div id="form">
	<form align="center" action="addTask">
	<div id="col">
	<label><span>Task Name</span><input class="fields" type="text" name="name" required></label><br/><br/>
	
	<label><span>Due Date</span><input class="fields" type="text" name="date" required></label><br/>
	<input type="hidden" name = "sessionId" value= <%=request.getParameter( "sessionId") %>>
	<br/><br/>
	<div class="container-login100-form-btn">
							<button class="login100-form-btn">
								ADD
							</button>
						</div>
						</div>
	<br/><br/><br/>
	</form>
	</div>
</div>
<br/><br/>
</body>
</html>