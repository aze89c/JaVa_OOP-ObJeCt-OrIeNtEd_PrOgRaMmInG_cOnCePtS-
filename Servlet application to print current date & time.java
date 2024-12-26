
//Servlet application to print current date & time
import java.io.*;
import javax.servlet.*;
public class DateSrv extends GenericServlet
{
//implement service()
public void service(ServletRequest req, ServletResponse res) throws IOException,
ServletException
{
//set response content type
res.setContentType("text/html");
//get stream obj
PrintWriter pw = res.getWriter();
//write req processing logic
java.util.Date date = new java.util.Date();
pw.println("<h2>"+"Current Date & Time: " +date.toString()+"</h2>");
//close stream object
pw.close();
}
}