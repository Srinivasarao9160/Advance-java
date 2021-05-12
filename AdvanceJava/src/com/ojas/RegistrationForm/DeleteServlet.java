package com.ojas.RegistrationForm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		 int value = Integer.parseInt(request.getParameter("no"));
		 
		 PersonDao persondao = new PersonDao();
		 if(persondao.delPerson(value)) {
			  response.sendRedirect("./ListPersonsServlet");
		 }else {
			 pw.println("<h3 style =color:Red>Try Again</h3>");
		}
		 }
	}


