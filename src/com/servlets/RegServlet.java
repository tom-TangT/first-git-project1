package com.servlets;
import com.beans.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegServlet
 */
@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	public static boolean check(String str){
	    String name = str;
	    String regex = "([A-Z0-9a-z_]|[\\u4e00-\\u9fa5])+";
	    boolean flag = str.matches(regex);
	    return flag;
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//��������
		request.setCharacterEncoding("utf-8"); 
		String logname=request.getParameter("logname");
		String password=request.getParameter("password");
		String againpassword=request.getParameter("again_password");
		String sex=request.getParameter("sex");
		String happy[] = request.getParameterValues("happy");
		//��֤����
		if(logname==null||logname.equals(""))
		{
			request.setAttribute("messlog", "用户名不能为空");
			RequestDispatcher dispatcher=request.getRequestDispatcher("reg.jsp");
			dispatcher.forward(request, response);
			return;
		}if(check(logname)==false){
			request.setAttribute("messname", "用户名格式错误");
			RequestDispatcher dispatcher=request.getRequestDispatcher("reg.jsp");
			dispatcher.forward(request, response);
			return;
		}if(password==null||password.length()==0){
			request.setAttribute("messpwd", "密码不能为空");
			RequestDispatcher dispatcher=request.getRequestDispatcher("reg.jsp");
			dispatcher.forward(request, response);
			return;
		}if(againpassword==null||againpassword.length()==0){
			request.setAttribute("messagapwd", "确认密码不能为空");
			RequestDispatcher dispatcher=request.getRequestDispatcher("reg.jsp");
			dispatcher.forward(request, response);
			return;
		}if(sex==null||sex.length()==0){
			request.setAttribute("messsex", "性别不能为空");
			RequestDispatcher dispatcher=request.getRequestDispatcher("reg.jsp");
			dispatcher.forward(request, response);
			return;
		}if(happy==null||happy.length==0){
			request.setAttribute("messhappy", "兴趣不能为空");
			RequestDispatcher dispatcher=request.getRequestDispatcher("reg.jsp");
			dispatcher.forward(request, response);
			return;
		}if(password.equals(againpassword)==false){
			request.setAttribute("messcor", "密码不一致");
			RequestDispatcher dispatcher=request.getRequestDispatcher("reg.jsp");
			dispatcher.forward(request, response);
			return;
		}
		String strhappy="";
		for(int i=0;i<happy.length;i++){
			strhappy+=happy[i]+",";
	}
//		request.setAttribute("logname",logname);
//		request.setAttribute("sex",sex);
//		request.setAttribute("happy",happy);
		//将用户注册的信息疯子到UserInfo
		UserInfo user=new UserInfo();
		user.setUserName(logname);
		
		user.setSex(sex);
		user.setHobby(strhappy);
		request.setAttribute("user",user);
		//request.setAttribute("logname",logname);
		//request.setAttribute("sex",sex);
		//request.setAttribute("happy",happy);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("reg2.jsp");
		dispatcher.forward(request, response);
	
		//��������

//		happy=strhappy.split(",");
//		if(!strhappy.equals("")){
//			strhappy=strhappy.substring(0,strhappy.length());
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
