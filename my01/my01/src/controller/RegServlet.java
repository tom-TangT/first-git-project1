package controller;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MessageInfo;

import db.ProcessData;
import model.UserInfo;

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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//接收数据
		request.setCharacterEncoding("UTF-8");
		String strName=request.getParameter("username");
		String strPassword=request.getParameter("password");
		
		MessageInfo messageInfo =new MessageInfo();
		request.setAttribute("messageInfo", messageInfo);
		//验证数据:1(是否为空)
		if(strName == null||strName.equals("")){
			messageInfo.setMess("用户名不能为空");
			RequestDispatcher dispatcher = request.getRequestDispatcher("reg.jsp");
			dispatcher.forward(request, response);
			
			return ;
		}
		
		
		
		String strSQL="select * from userreg where username='"+strName+"'";
		ProcessData processData=new ProcessData();
		Vector rows=processData.getData(strSQL);
		if(rows.size()>0){
			messageInfo.setMess("用户名重复");
			RequestDispatcher dispatcher = request.getRequestDispatcher("reg.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		
		String sql="insert into userreg values('"+strName+"','"+strPassword+"')";
		ProcessData pro=new ProcessData();
		pro.insert(sql);
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
		return ;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
