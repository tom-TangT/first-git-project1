package controller;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.ProcessData;
import model.MessageInfo;
import model.UserInfo;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		//��������
		request.setCharacterEncoding("UTF-8");
		String  strName = request.getParameter("username");
		String strPwd = request.getParameter("password");
		//System.out.println(1);
		//System.out.println(strName);
		//����request���ڵ�MessageInfo����
		MessageInfo messageInfo = new MessageInfo();
		
		
		//��֤����
		
		if(strName == null||strName.equals("")){
			messageInfo.setMess("�û�������Ϊ��");
			//request.setAttribute("messageInfo", messageInfo);
			System.out.println(2);
			System.out.println(strName);
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
			return ;
			
		}
		
		
		if(strPwd == null||strPwd.equals("")){
			messageInfo.setMess("���벻��Ϊ��");
			//request.setAttribute("messageInfo", messageInfo);
			System.out.println(3);
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
			return ;
			
		}
		
		//System.out.println(2);
		//��֤ϵͳ�Ƿ���ڸ��û� ..Ƕ��ʽSQL
		String strSQL = "select * from userreg where username = '"+strName+"' and password ='"+strPwd+"'";
		ProcessData processData = new ProcessData();
		//System.out.print("strSQL"+strSQL);
		Vector rows = processData.getData(strSQL);//��̬����
		if(rows.size() ==0){
			messageInfo.setMess("�û��������벻����");
			request.setAttribute("messageInfo", messageInfo);
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
			return ;
		}
		//System.out.println(3);
		messageInfo.setMess("��½�ɹ�");
		RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
		dispatcher.forward(request, response);
		//response.sendRedirect("main.jsp");
		//��������
		/*UserInfo userInfo = new UserInfo();
		HttpSession session = request.getSession(true);
		session.setAttribute("userInfo",userInfo);
		userInfo.setUsername(strName);
		userInfo.setPassword(strPwd);	
		response.sendRedirect("main.jsp");*/
		/*RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);	*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
