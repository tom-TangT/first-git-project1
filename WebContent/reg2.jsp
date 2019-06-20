<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<jsp:useBean id="user" class="com.beans.UserInfo" scope="request"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" rev="stylesheet" href="css/global.css" type="text/css" media="all" />
</head>
<body>
	<div id="page">
		<div id="header">
			<jsp:include page="header.jsp" />      
       	</div>
       	
       	<div id="div_reg" align=center>
       		<h3>注册成功</h3><br>
       		<hr size=1>  
       		<form action="RegServlet">
					<table>
		
		<tr><td>*用户名称：</td> <td><%=user.getUserName() %></td></tr>

		<tr><td >*用户性别</td> <td ><%=user.getSex() %></td></tr>
		<tr><td>*兴趣爱好：</td> <td><%=user.getHobby() %></td></tr>
		<tr><td colspan=2 align=center><a href="index.jsp">返回</a></td></tr>
	</table>
       		</form>
       		
        </div>
       	
       	<div id="footer">
			<jsp:include page="bottom.jsp" />  
		</div>
	</div>	
</body>
</html>