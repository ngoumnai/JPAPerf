<%--
    Document : JspPerfViewer
    Created on : 15 juil. 2013, 15:25:17
    Author : gauss
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="ch.heigvd.perfviewer.model.bean.JPQLRequestBean"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSPPerfViewer</title>
        <!-- Bootstrap -->
        <link href="../dist/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <!--h1>Requêtes observées</h1-->
        <!-- Le styles -->
        <link href="../dist/css/bootstrap.css" rel="stylesheet">
        <style>
            body {
                padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
            }
        </style>

        <table cellspacing="0" border="1" align="center" class="table table-bordered table-striped table-condensed">
            <caption>
                <h1>Requêtes observées</h1>
            </caption>
            <thead>
                <!--table bgcolor="#FFFFFF" cellpadding="15" cellspacing="0" border="1" align="center"-->
                <tr>
                    <td nowrap bgcolor="#669999" style="text-align: center;height : 100px">Query name</td>
                    <td nowrap bgcolor="#669999" style="text-align: center;height : 100px">Entity queried</td>
                    <td nowrap bgcolor="#669999" style="text-align: center;height : 100px">Request jpql</td>
                    <td nowrap bgcolor="#669999" style="text-align: center;height : 100px">Request sql</td>
                    <td nowrap bgcolor="#669999" style="text-align: center;height : 100px">Number of request</td>
                    <td nowrap bgcolor="#669999" style="text-align: center;height : 100px">Average time</td>
                    <td nowrap bgcolor="#669999" style="text-align: center;height : 100px">Minimum time</td>
                    <td nowrap bgcolor="#669999" style="text-align: center;height : 100px">Maximum time</td>
                </tr>
            </thead>
            <tbody>
                <%
                    ArrayList<JPQLRequestBean> jpqlRequest = (ArrayList<JPQLRequestBean>) request.getAttribute("jpqlRequest");
                    int i = 0;
                    String lineColor;
                    for (JPQLRequestBean jRequest : jpqlRequest) {
                        lineColor = i % 2 == 0 ? "#CCCCCC" : "#FFFFFF";

                        out.print("<tr>");
                        out.print("<td bgcolor=" + lineColor + "> <a href=http://localhost:8080/perfViewer/ServletPerfViewerDetail?queryName=" + jRequest.getQueryName() + ">" + jRequest.getQueryName() + "</a>  </td>");
                        out.print("<td align=center bgcolor=" + lineColor + ">" + jRequest.getEntity() + "</td>");
                        out.print("<td align=center bgcolor=" + lineColor + ">" + jRequest.getJpql() + "</td>");
                        out.print("<td align=center bgcolor=" + lineColor + ">" + jRequest.getSql() + "</td>");
                        out.print("<td align=center bgcolor=" + lineColor + ">" + jRequest.getNbrOfQueries() + "</td>");
                        out.print("<td align=center bgcolor=" + lineColor + ">" + jRequest.getAvgTime() + "</td>");
                        out.print("<td align=center bgcolor=" + lineColor + ">" + jRequest.getMinTime() + "</td>");
                        out.print("<td align=center bgcolor=" + lineColor + ">" + jRequest.getMaxTime() + "</td>");
                        out.print("</tr>");
                        i++;
                    }
                %>
            </tbody>
        </table>
    </body>
</html>

