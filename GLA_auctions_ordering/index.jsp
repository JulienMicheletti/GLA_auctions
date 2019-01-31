<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean beanName="DBManager" scope="request" id="dbManager" type="web.DBManagerBean"></jsp:useBean>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
		<fieldset>
			<legend>livraisons</legend>
			<table>
				<tr><td></td><td>informations</td></tr>
				<%
					out.print(dbManager.getLivraisonsHTML());
				%>
			</table>
		</fieldset>
    </body>
</html>
