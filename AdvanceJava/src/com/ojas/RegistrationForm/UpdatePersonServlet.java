package com.ojas.RegistrationForm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdatePersonServlet
 */
public class UpdatePersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PersonDao persondao;

	public void init(ServletConfig config) throws ServletException {
		persondao = new PersonDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		int num = Integer.parseInt(request.getParameter("no"));
		String ename = request.getParameter("ename");
		String connectno = request.getParameter("connectno");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");

		pw.println("<html><head><style type=text/css>");
		pw.println("table{width:50%;border-collapse:collapse;");
		pw.println("background-color:wheat;border-spacing:10px;}");
		pw.println("table,tr,td{border:1px solid blue;}");
		pw.println("th,td{padding:20x;}");
		pw.println("</style></head><body>");
		pw.println("<form action =UpdatePersonServlet method = POST>");
		pw.println("<h1 style = background-color:maroon;color:white;padding:20px;");
		pw.println("text-align:center;>Welcome to registration page</h1>");
		pw.println("<table align = center;>");
		pw.println("<tr>");
		pw.println("<input type=hidden name=pid value=" + num + ">");
		pw.println("<td>Enter Name:</td>");
		pw.println("<td><input type=text name=ename value=" + ename + "></td>");
		pw.println("</tr><tr><td>Enter ConnectNumber:</td>");
		pw.println("<td><input type=text name=connectno value=" + connectno + "></td>");
		pw.println("</tr><tr><td>Enter Email:</td>");
		pw.println("<td><input type=text name=email value=" + email + "></td>");
		pw.println("</tr><tr><td>Gender:</td><td>");
		if (gender.equals("Male")) {
			pw.println("<input type=radio  name=gender value=on>Male");
			pw.println("<input type=radio  name=gender value=off>Female</td>");

		} else {
			pw.println("<input type=radio  name=gender value=off>Male");
			pw.println("<input type=radio  name=gender value=on>Female</td>");
		}
		pw.println("</tr><tr><td>Address:</td><td>");
		pw.println("<textarea name=address rows=5 cols =20>" + address + "</textarea></td>");
		pw.println("</tr><tr><td colspan=2 align=center><input type=submit value=click></td></tr>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		int num = Integer.parseInt(request.getParameter("pid"));
		String ename = request.getParameter("ename");
		String connectno = request.getParameter("connectno");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");

		Person person = new Person();
		person.setPid(num);
		person.setEname(ename);
		person.setConnectno(connectno);
		person.setEmail(email);
		person.setGender(gender);
		person.setAddress(address);

		if (persondao.updatePerson(person)) {
			 pw.println("<h3 style =color:Red>Update Sucessfully</h3>");
		} else {
			 pw.println("<h3 style =color:Red>Not Updated</h3>");
		}

	}

}
