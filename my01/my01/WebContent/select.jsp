<%@page import="model.MessageInfo" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
    <head>
        <meta charset="UTF-8" />
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
        <title>Login and Registration Form with HTML5 and CSS3</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="description" content="Login and Registration Form with HTML5 and CSS3" />
        <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
        <meta name="author" content="Codrops" />
        <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="css/demo.css" />
        <link rel="stylesheet" type="text/css" href="css/style.css" />
		<link rel="stylesheet" type="text/css" href="css/animate-custom.css" />
    </head>
    <body>
        <div class="container">
		<%
	
		MessageInfo messageInfo = (MessageInfo)request.getAttribute("messageInfo");
		if(messageInfo == null){
			
			messageInfo = new MessageInfo();
		}
	%>
            <header>

				
            </header>
<div style="text-align:center;clear:both;">
<script src="/gg_bd_ad_720x90.js" type="text/javascript"></script>
<script src="/follow.js" type="text/javascript"></script>
</div>
            <section>				
                <div id="container_demo" >
                    <!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
                    <a class="hiddenanchor" id="toregister"></a>
                    <a class="hiddenanchor" id="tologin"></a>
                    <div id="wrapper">
                        <div id="login" class="animate form">
                        <font color=red><%=messageInfo.getMess() %></font><br>
                            <form  action="SelectServlet" autocomplete="on" method=post> 
                                <h1>搜索图书</h1> 
                                <p> 
                                    <input  name="bookname"  type="text" placeholder="书名" />
                                </p>
                                
                                
                                <p class="login button"> 
                                    <input type="submit" value="搜索" /> 
								</p>
                         		</p>
								<a href="main.jsp"><font >返回上一页</font></a>
								<p>
                            </form>
                        </div>

                        
						
                    </div>
                </div>  
            </section>
        </div>

  
	</body>
</html>