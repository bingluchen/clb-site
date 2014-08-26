<%@page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"  />
		<title>I Want Share</title>
		<link rel="stylesheet" href="/css/main.css" type="text/css"/>
	</head>
	<body>
		<form action="share/shareMyFtp.action" method="post">
			<input name="ftpDress" value=""/><input type="submit" value="分  享"/>
		</form>
	</body>
</html>