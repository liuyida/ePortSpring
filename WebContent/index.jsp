<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title></title>
<style type="text/css">
<!--
a.abai:link {
	color: #ffffff;
	text-decoration: none
}

a.abai:visited {
	color: #ffffff;
	text-decoration: none
}

a.abai:hover {
	color: #ffffff;
	text-decoration: none
}

a.abai:active {
	color: #ffffff;
	text-decoration: none
}

a {
	font-size: 12px;	
}

a.ahui:link {
	color: #7F7F7F;
}

a.ahui:visited {
	color: #7F7F7F;
}

a.ahui:hover {
	color: #000000;
}

a.ahui:active {
	color: #7F7F7F;
}

.blot {
	width: 100%;
	height: 850px;
	z-index: 10;
	position: absolute;
	left: 0px;
	top: 0px;
	background-color: #000000;
	filter: Alpha(Opacity =       60);
	text-align: center;
}
-->
</style>
<script type="text/javascript">
	function divShow(dd) {
		if (dd.style.display == "none") {
			dd.style.display = "";
		} else {
			dd.style.display = "none";
		}
	}
</script>
</head>

<body style="margin-top: 0px; margin-left: 0px">
<div align="center">
<div align="center" style="z-index: 5; width: 600px; height: 120px;">
<div align="left" style="width: 600px; height: 22px"><span
	style="text-align: center; vertical-align: middle; width: 40px; height: 22px; background-color: #6699FF;">
<a href="#" class="abai" onclick="divShow(content);divShow(login);"
	style="font-size: 14px">登陆</a></span></div>
<table id="login"
	style="height: 400px; width: 100%; border: 0px; display: none; position: relative; z-index: 11;"
	cellspacing="0" cellpadding="0">
	<tr>
		<td>
		<div align="center">
		<table border="5" cellpadding="0" cellspacing="0"
			style="border-color: #959595; background-color: #FFFFFF; margin: 0 auto;">
			<tr>
				<td>
				<table cellspacing="0" cellpadding="2"
					style="height: 140px; width: 100%; border: 0px;">

					<tr bgcolor="#EBEBEB">
						<td colspan="2" height="30">
						<div align="left">&nbsp;<font
							style="color: #7F7F7F; font-size: 12px; font-family: Arial, Helvetica, sans-serif;">Please
						Sign In</font></div>
						</td>
						<td colspan="2" align="right" valign="middle"><a href="#"
							class="ahui" onclick="divShow(content);divShow(login);">close</a>&nbsp;</td>
					</tr>
					<tr>
						<td width="28">&nbsp;</td>
						<td height="20">
						<div align="right">Username:</div>
						</td>
						<td>
						<div align="left"><input name="username" type="text"
							style="width: 150px; height: 20px" /></div>
						</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td height="20">
						<div align="right">Password:</div>
						</td>
						<td>
						<div align="left"><input name="password" type="text"
							style="width: 150px; height: 20px" /></div>
						</td>
						<td width="28">&nbsp;</td>
					</tr>
					<tr>
						<td width="28">&nbsp;</td>
						<td width="65">&nbsp;</td>
						<td width="150" valign="top">
						<div align="right"><input name="Login" type="submit"
							id="Login" style="width: 80px" value="Login" /></div>
						</td>
						<td width="28" valign="top">&nbsp;</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		</div>
		</td>
	</tr>
</table>
</div>
</div>
<div id="content" class="blot" style="display: none;"></div>

</body>
</html>