<html>
	<head>
		<title>展示用户列表</title>
		<meta charset="utf-8"/>
	</head>
	
	<body>
		<table border="1",align="center",width="50%">
			<tr>
				<th>id</th>
				<th>name</th>
				<th>age</th>
			</tr>
			<#list list as user >
				<tr>
					<td>${user.id}</td>	
					<td>${user.userName}</td>
					<td>${user.age}</td>
				</tr>
			</#list>
		</table>
	</body>
</html>