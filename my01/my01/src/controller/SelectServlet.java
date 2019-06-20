package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.ProcessData;
import model.BookItem;
import model.MessageInfo;
import model.TableInfo;

/**
 * Servlet implementation class SelectServlet
 */
@WebServlet("/SelectServlet")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String strBookname=request.getParameter("bookname");
		//System.out.println(strBookname);
		String sql="select * from books where name='"+strBookname+"'";
		ProcessData pro=new ProcessData();
		
		
		//验证系统是否存在该书
				String strSQL = "select * from books where name = '"+strBookname+"' ";
				ProcessData processData = new ProcessData();
				Vector rows = processData.getData(strSQL);//动态数组
				MessageInfo messageInfo=new MessageInfo();
				if(rows.size() ==0){
					messageInfo.setMess("操作失败");
					request.setAttribute("messageInfo", messageInfo);
					RequestDispatcher dispatcher = request.getRequestDispatcher("select.jsp");
					dispatcher.forward(request, response);
					return ;
				}
				
				
		List<TableInfo> booklist=new ArrayList<TableInfo>();
		booklist=pro.getData1(sql);
		request.setAttribute("booklist", booklist);
		RequestDispatcher dispatcher = request.getRequestDispatcher("show.jsp");
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
