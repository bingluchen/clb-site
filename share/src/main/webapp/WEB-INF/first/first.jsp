<%@page contentType="text/html; charset=utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<body>
		This is My first Jsp ${modelname.name0 }
		<form action="first/upForm.sh" method="post">
			<input name="upName" />
			<input name="newname" />
			<input type="submit" value="提交"/>
		</form>
	</body>
</html>