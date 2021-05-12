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
 * Servlet implementation class ContextExp1
 */
public class ContextExp1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       ServletContext context = null;
    
    public ContextExp1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {

		context = config.getServletContext();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		context.setAttribute("goldrate","4500.00");
		pw.println("<h3 style= color:green>GoldRate:"+context.getAttribute("goldrate"));
		pw.println("servlet version="+context.getMajorVersion()+"."+context.getMajorVersion()+"</h3>");
		
		
		
	}

}
