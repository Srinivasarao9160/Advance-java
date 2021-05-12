package com.ojas.RegistrationForm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	PersonDao persondao;

	public RegistrationServlet() {
		super();
	
	}

	public void init(ServletConfig config) throws ServletException {
		persondao = new PersonDao();
	}

	


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		//int pid = Integer.parseInt(request.getParameter("pid"));
		String ename = request.getParameter("ename");
		String connectno = request.getParameter("connectno");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		
		Person p = new Person();
		//p.setPid(pid);
		p.setEname(ename);
		p.setConnectno(connectno);
		p.setEmail(email);
		p.setGender(gender);
		p.setAddress(address);
		
		
		
		if(persondao.addPreson(p)) {
			pw.println("<h1 style=background-color:green>Registration Sucessfully</h1>");
			 pw.println("<a href=Home.html>Register first</a><br>");

		}else {
			pw.println("<h1 style=background-color:red>Try Again</h1>");

		}
	
	}

}
