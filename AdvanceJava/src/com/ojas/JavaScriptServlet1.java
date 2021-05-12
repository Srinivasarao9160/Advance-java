package com.ojas;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JavaScriptServlet1
 */
public class JavaScriptServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JavaScriptServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String name = request.getParameter("s1");
		
		if (name.equals("Andhra")) {
			pw.println("<h2 style=color:green>Your Select State is:" + name + "</h2><br>");
			pw.println("<h2 style=color:maroon>captital=Amaravathi</h2>");
		} else if (name.equals("Telangana")) {
			pw.println("<h2 style=color:green>Your Select State is:" + name + "</h2><br>");
			pw.println("<h2 style=color:maroon>captital=Hyd</h2>");

		}
	
	
	
	
	}

}
