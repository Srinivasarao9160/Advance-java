[4:02 PM] Akshaya Kumar Mahanty
    
<!DOCTYPE html>
<%@page import="java.io.PrintWriter"%>
<html>
<body>
<%@page isErrorPage="true" %>
<h4>this is error page</h4>
<%exception.printStackTrace(new PrintWriter(out)); %>
</body>
</html>



