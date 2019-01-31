<%@page import="java.util.List"%>
<%@page import="persistence.Livraison"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean beanName="DBManager" id="orderManager" type="web.DBManagerBean" scope="request" />
<%
	List<Livraison> livraisons = orderManager.getLivraisons();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GLA Encheres - livraisons</title>
    </head>
    <body>
        <h1>Gestion livraisons</h1>
		<fieldset>
			<legend>livraisons</legend>
			<table>
				<%
					int i = 0;
					for (Livraison livraison : livraisons) {
						out.print("<tr><td><input type=\"radio\" name=\"livraison\" value=\"" + i++ + "\" /></td><td>" + livraison.toString() + "</td></tr>");
					}
				%>
			</table>
		</fieldset>
    </body>
</html>
