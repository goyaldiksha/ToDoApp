<html>
<head><meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>New Account</title>
<link rel="stylesheet" href="loginCSS.css" type="text/css"/>
</head>
<body>
<div id="heading">New Account</div>
		<div id="form">
					<form class="validate-form" action="register" onsubmit="return validateit()">

					
					<div id="col">
					<div class="validate-input" data-validate = "Full Name required">
						<input class="input100" type="text" name="name" placeholder="Name" required>
						
					</div>
					<br/>
					<div class="validate-input" data-validate = "Valid email is required: ex@abc.xyz">
						<input class="input100" type="text" name="email" placeholder="Email" required>
					</div>
					<br/>

					<div class="validate-input" data-validate = "Password is required">
						<input class="input100" type="password" name="pass" placeholder="Password" required>
					</div>
					<br/>
					<div class="form-btn">
						<button class="btn">
							Create Account
						</button>
					</div>
					</div>
				</form>
			</div>
	
</body>
</html>