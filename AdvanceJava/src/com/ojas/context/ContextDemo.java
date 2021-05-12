package com.ojas.context;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextDemo
 */
public class ContextDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       ServletContext ctx = null;
    
    public ContextDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void init(ServletConfig config) throws ServletException {

		ctx = config.getServletContext();
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String driver = ctx.getInitParameter("driver");
		String url = ctx.getInitParameter("url");
		String user = ctx.getInitParameter("user");
		String password = ctx.getInitParameter("password");
		
		pw.println("<h3 style=color:blue>DriverName="+driver+"<br>");
		pw.println("url="+url+"<br>");
		pw.println("user="+user+"<br>");
		pw.println("password="+password+"<br>");


		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
