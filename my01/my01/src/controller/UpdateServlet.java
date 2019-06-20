package controller;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.ProcessData;
import model.MessageInfo;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		MessageInfo messageInfo=new MessageInfo();
		String strBookname=request.getParameter("bookname");
		String strId=request.getParameter("id");
		
		//验证系统是否存在该书
		String strSQL = "select * from books where name = '"+strBookname+"'";
		ProcessData processData = new ProcessData();
		Vector rows = processData.getData(strSQL);//动态数组
		//MessageInfo messageInfo=new MessageInfo();
		if(rows.size() ==0){
			messageInfo.setMess("操作失败");
			request.setAttribute("messageInfo", messageInfo);
			//System.out.println("bucunzai");
			RequestDispatcher dispatcher = request.getRequestDispatcher("update.jsp");
			dispatcher.forward(request, response);
			return ;
		}
		
		String sql="update  books set id='"+strId+"' where name='"+strBookname+"'";
		ProcessData pro=new ProcessData();
		pro.insert(sql);
		messageInfo.setMess("更新操作成功!");
		request.setAttribute("messageInfo", messageInfo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
		dispatcher.forward(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
