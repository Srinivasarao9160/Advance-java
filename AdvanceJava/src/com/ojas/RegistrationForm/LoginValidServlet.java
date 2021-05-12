package com.ojas.RegistrationForm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginValidServlet
 */
public class LoginValidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginValidServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config) throws ServletException {

	}


	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String uname = request.getParameter("uname");
		String upass = request.getParameter("upass");
		
		PersonDao persondao = new PersonDao();
		
		if(persondao.validate(uname,upass)) {
			//pw.println("<h3 style =color:Red>Try Again</h3>");
			response.sendRedirect("./ListPersonsServlet");
		}else {
			//response.sendRedirect("./ListPersonsServlet");
			 pw.println("<h3 style =color:Red>Invalid Details&&&&&&&Try Again</h3>");
			 pw.println("<a href=Registration.html>Register first</a><br>");

		}
		
	}

}
