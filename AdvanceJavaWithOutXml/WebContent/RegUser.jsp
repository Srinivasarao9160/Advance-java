<%@ page import="java.sql.*"%>

<%! 
 Connection con = null;
 public void jspInit(){
	 try{
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/java200","root","root");
		 System.out.println("connected successfully"+con);
		 
		 
	 }catch(Exception e){
		 System.out.println(e);
	 }
 }
 %>
 <%
 try{
	 String name = request.getParameter("name");
	 String upass = request.getParameter("upass");
	 PreparedStatement pst = con.prepareStatement("insert into user(username,password)value(?,?)");
	 pst.setString(1, name);
	 pst.setString(2, upass);
	 int num = pst.executeUpdate();
	 if(num>0){
		 out.println("<h1 style=color:pink>insert sucessfully</h1>");
		 }
	 else{
		 out.println("<h1> Tryagain</h1>");
	 }
 }catch(Exception e){
	 System.out.println(e);
 }
%>
 
 