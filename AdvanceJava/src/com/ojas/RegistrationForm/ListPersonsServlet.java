package com.ojas.RegistrationForm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListPersonsServlet
 */
public class ListPersonsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PersonDao persondao;

	public ListPersonsServlet() {
		super();

	}

	public void init(ServletConfig config) throws ServletException {

		persondao = new PersonDao();

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		List<Person> list = persondao.listPersons();

		pw.println("<html><head><style type=text/css>");
        pw.println("table{width:50%;border-collapse:collapse;");
        pw.println("background-color:wheat;border-spacing:10px;}");
        pw.println("table,tr,td{border:1px solid blue;}");
        pw.println("th,td{padding:20x;}");
        pw.println("</style></head><body>");
        pw.println("<form action =#>");
        pw.println("<h1 style = background-color:maroon;color:white;padding:20px;");
        pw.println("text-align:center;>list Persons</h1>");
        pw.println("<table align = center;>");
        pw.println("<tr>");
        
        for(Person p : list) {
        	
        	int num = p.getPid();
            String ename = p.getEname();
            String connectno = p.getConnectno();
            String email = p.getEmail();
            String gender = p.getGender();
            String address = p.getAddress();
            
            pw.println("<td>" +num + "</td>");
            //pw.println("<td>" + p.getPid() + "</td>");
            pw.println("<td>" + p.getEname() + "</td>");
            pw.println("<td>" + p.getConnectno() + "</td>");
            pw.println("<td>" + p.getEmail() + "</td>");
            pw.println("<td>" + p.getGender() + "</td>");
            pw.println("<td>" + p.getAddress() + "</td>");
            
            pw.println("<td><a href=DeleteServlet?no="+num+">Delete</a></td>");
            
           pw.println("<td><a href=UpdatePersonServlet?no="+num+"&ename="+ename+"&email="+email+"&gender="+gender+"&address="+address+">update</a></td>");
            pw.println("</tr>");
            
            
        }
        pw.println("</table></form></body></html>");

}
}
