<!DOCTYPE html>
<html>
<head>
	<title>Login page</title>
</head>
	<body>
		<div class="container">
			Login page.
			<pre>${errorMessage}</pre>
			<form method="post">
				Name: <input type="text" name="name" value="${name}">
				Password: <input type="password" name="password">
				<input type="submit">
			</form>
		</div>
	</body>
</html>
