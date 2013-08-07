<%-- 
    Document   : JspPerfViewer
    Created on : 15 juil. 2013, 15:25:17
    Author     : gauss
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="ch.heigvd.perfviewer.model.JPQLRequest"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
			

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JspPerfViewer</title>
    </head>
    <body>
        <h1>Requêtes observées</h1>            
        <table style = "font-size:20px"; text-align ="justify"; border="1">
            <tr>
                <td style="text-align: center;height : 100px">Query name</td>
                <td style="text-align: center;height : 100px">Entity queried</td>
                <td style="text-align: center;height : 100px">Request jpql</td>
                <td style="text-align: center;height : 100px">Request sql</td>
                <td style="text-align: center;height : 100px">Number of request</td>
                <td style="text-align: center;height : 100px">Average time</td>
                <td style="text-align: center;height : 100px">Minimum time</td>
                <td style="text-align: center;height : 100px">Maximum time</td>
            </tr>
            <%
                ArrayList<JPQLRequest> jpqlRequest = (ArrayList<JPQLRequest>)request.getAttribute("jpqlRequest");
                for(JPQLRequest jRequest: jpqlRequest){
                    out.print("<tr>");
                    out.print("<td> <a href=http://localhost:8080/perfViewer/ServletPerfDetail?queryName="+ jRequest.getQueryName() +">"+jRequest.getQueryName()+"</a>  </td>");
                    out.print("<td>"+ jRequest.getEntity()+ "</td>");
                    out.print("<td>"+ jRequest.getJpql()+ "</td>");
                    out.print("<td>"+ jRequest.getSql()+ "</td>");
                    out.print("<td>"+ jRequest.getNbrOfQueries()+ "</td>");
                    out.print("<td>"+ jRequest.getAvgTime()+ "</td>");
                    out.print("<td>"+ jRequest.getMinTime()+ "</td>");
                    out.print("<td>"+ jRequest.getMaxTime()+ "</td>");
                    out.print("</tr>");
                }
            %>
        </table>       
    </body>
</html>
