<%-- 
    Document   : JSPPerfViewerDetails
    Created on : 25 juil. 2013, 06:41:09
    Author     : gauss
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="ch.heigvd.perfviewer.model.bean.JPQLRequestDetailsBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Details des requêtes</title>
    </head>
    <body>
        <h1>Détails des requêtes observées</h1>            
        <table bgcolor="#FFFFFF" cellpadding="15" cellspacing="0" border="1" align="center">
            <tr>                
                <td bgcolor="#669999" style="text-align: center;height : 100px">Query name</td>
                <td bgcolor="#669999" style="text-align: center;height : 100px">Execution date</td>
                <td bgcolor="#669999" style="text-align: center;height : 100px">Execution time</td> 
            </tr>
            <%
                ArrayList<JPQLRequestDetailsBean> requestListDetails = (ArrayList<JPQLRequestDetailsBean>) request.getAttribute("requestListDetails");
                int i = 0;
                String lineColor;
                for (JPQLRequestDetailsBean jRequest : requestListDetails) {
                    lineColor = lineColor = i % 2 == 0 ? "#CCCCCC" : "#FFFFFF";
                    out.print("<tr>");
                    out.print("<td nowrap bgcolor=" + lineColor + ">" + jRequest.getQueryName() + "</td>");
                    out.print("<td nowrap bgcolor=" + lineColor + ">" + jRequest.getExecutionDate() + "</td>");
                    out.print("<td nowrap bgcolor=" + lineColor + ">" + jRequest.getExecutionTime() + "</td>");
                    out.print("</tr>");
                    i++;
                }
            %>            
        </table> 
    </body>
</html>
