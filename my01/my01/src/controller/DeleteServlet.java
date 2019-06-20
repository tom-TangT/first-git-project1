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
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
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
		
		//��֤ϵͳ�Ƿ���ڸ���
		String strSQL = "select * from books where name = '"+strBookname+"' ";
		ProcessData processData = new ProcessData();
		Vector rows = processData.getData(strSQL);//��̬����
		MessageInfo messageInfo=new MessageInfo();
		if(rows.size() ==0){
			messageInfo.setMess("����ʧ��");
			request.setAttribute("messageInfo", messageInfo);
			//System.out.println("bucunzai");
			RequestDispatcher dispatcher = request.getRequestDispatcher("delete.jsp");
			dispatcher.forward(request, response);
			return ;
		}
		String sql="delete from  books where name='"+strBookname+"'";
		ProcessData pro=new ProcessData();
		pro.insert(sql);
		//MessageInfo messageInfo=new MessageInfo();
		messageInfo.setMess("ɾ�������ɹ�!");
		request.setAttribute("messageInfo", messageInfo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
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
