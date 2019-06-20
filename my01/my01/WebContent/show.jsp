<%@page import="java.util.List" %>
<%@page import="model.TableInfo" %>
<%@page import="java.util.ArrayList" %>
<%@page import="db.ProcessData" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
    <head>
        <meta charset="UTF-8" />
        
		<style type="text/css">
	table {

     border-collapse: collapse;

     font-family: Futura, Arial, sans-serif;

}

caption {

     font-size: larger;

     margin: 1em auto;

}

th,td {

     padding: .65em;

}

th {

     background: #555 nonerepeat scroll 0 0;

   /* border: 1px solid #777; */

   color: black;

}

td {

     /* border: 1px solid #777; */

}

tbody tr:nth-child(odd) {

     background: #ccc;

}

th:first-child {

     border-radius: 9px 0 0 0;

}

th:last-child {

     border-radius: 0 9px 0 0;

}

tr:last-child td:first-child {

     border-radius: 0 0 0 9px;

}

tr:last-child td:last-child {

     border-radius: 0 0 9px 0;

}

</style>
    </head>
    <body >

            <% 
		List<TableInfo> slctList=new ArrayList<TableInfo>();
		slctList=(ArrayList)request.getAttribute("booklist");
		 %>
	<table align="center" >
	<caption>搜索结果</caption>
		<thead>
			<tr>
				<th>id</th>
				<th>图书名称</th>
		</thead>
		<tbody>
		<%for(int i=0;i<slctList.size();i++)
		{
			TableInfo t=(TableInfo)slctList.get(i);
			%>
			<tr><td><%=t.getId() %></td><td><%=t.getBookname() %></td></tr>
	<% 	}
			%>
		</tbody>
	</table>



  
	</body>
</html>