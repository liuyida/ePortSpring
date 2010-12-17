<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri=”/WEB-INF/runqianReport4.tld” prefix=”report”%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>直接打印测试</title>
</head>
<body>
<h3 align=”center”>直接打印</h3>
<table align=”center”>
<tr><td>
<report:html name=”report1″ reportFileName=”/上方合计.raq”
needDirectPrint=”yes”
/></td>
</tr>
</table>
</body>
</html>