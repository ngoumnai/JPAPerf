package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ch.heigvd.perfviewer.model.bean.JPQLRequestBean;
import java.util.ArrayList;

public final class JSPPerfViewer_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSPPerfViewer</title>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <!-- Bootstrap -->\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\" media=\"screen\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Requêtes observées</h1>\n");
      out.write("        <!-- JavaScript plugins (requires jQuery) -->\n");
      out.write("        <script src=\"http://code.jquery.com/jquery.js\"></script>\n");
      out.write("        <!-- Include all compiled plugins (below), or include individual files as needed -->\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("        <!-- Optionally enable responsive features in IE8. Respond.js can be obtained from https://github.com/scottjehl/Respond -->\n");
      out.write("        <script src=\"js/respond.js\"></script>\n");
      out.write("        <table bgcolor=\"#FFFFFF\" cellpadding=\"15\" cellspacing=\"0\" border=\"1\" align=\"center\">\n");
      out.write("            <tr>\n");
      out.write("                <td nowrap bgcolor=\"#669999\" style=\"text-align: center;height : 100px\">Query name</td>\n");
      out.write("                <td nowrap bgcolor=\"#669999\" style=\"text-align: center;height : 100px\">Entity queried</td>\n");
      out.write("                <td nowrap bgcolor=\"#669999\" style=\"text-align: center;height : 100px\">Request jpql</td>\n");
      out.write("                <td nowrap bgcolor=\"#669999\" style=\"text-align: center;height : 100px\">Request sql</td>\n");
      out.write("                <td nowrap bgcolor=\"#669999\" style=\"text-align: center;height : 100px\">Number of request</td>\n");
      out.write("                <td nowrap bgcolor=\"#669999\" style=\"text-align: center;height : 100px\">Average time</td>\n");
      out.write("                <td nowrap bgcolor=\"#669999\" style=\"text-align: center;height : 100px\">Minimum time</td>\n");
      out.write("                <td nowrap bgcolor=\"#669999\" style=\"text-align: center;height : 100px\">Maximum time</td>\n");
      out.write("            </tr>\n");
      out.write("            ");

                ArrayList<JPQLRequestBean> jpqlRequest = (ArrayList<JPQLRequestBean>) request.getAttribute("jpqlRequest");
                int i = 0;
                String lineColor;
                for (JPQLRequestBean jRequest : jpqlRequest) {
                    lineColor = i % 2 == 0 ? "#CCCCCC" : "#FFFFFF";

                    out.print("<tr>");
                    out.print("<td bgcolor=" + lineColor + "> <a href=http://localhost:8080/perfViewer/ServletPerfViewerDetail?queryName=" + jRequest.getQueryName() + ">" + jRequest.getQueryName() + "</a>  </td>");
                    out.print("<td bgcolor=" + lineColor + ">" + jRequest.getEntity() + "</td>");
                    out.print("<td bgcolor=" + lineColor + ">" + jRequest.getJpql() + "</td>");
                    out.print("<td bgcolor=" + lineColor + ">" + jRequest.getSql() + "</td>");
                    out.print("<td bgcolor=" + lineColor + ">" + jRequest.getNbrOfQueries() + "</td>");
                    out.print("<td bgcolor=" + lineColor + ">" + jRequest.getAvgTime() + "</td>");
                    out.print("<td bgcolor=" + lineColor + ">" + jRequest.getMinTime() + "</td>");
                    out.print("<td bgcolor=" + lineColor + ">" + jRequest.getMaxTime() + "</td>");
                    out.print("</tr>");
                    i++;
                }
            
      out.write("\n");
      out.write("        </table>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
