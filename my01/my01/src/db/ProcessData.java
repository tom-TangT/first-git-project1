package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import model.TableInfo;

public class ProcessData {
	 String url="jdbc:sqlserver://localhost:1433;" +
				"databaseName=myreg;";
		//操作系统验证，此时要去掉integratedSecurity=true;  连接oracle就用oracle的密码
	 String user="sa";
	 String password="sasasa";
	//添加，删除，修改
	public boolean insert(String sql){
		boolean isSuccess=false;
		try{
			 //加载数据库驱动
		    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		    //获取一个链接
		    Connection conn=DriverManager.getConnection(url, user, password);
		    //
		    Statement stm=conn.createStatement();
		    stm.executeUpdate(sql);
		    isSuccess=true;
		    conn.close();
		}catch(Exception e){
			System.err.println(e);
			//System.out.println("数据库连接失败！");   
		    //e.printStackTrace() ; 
		}
		
		
		return isSuccess;
	}
	//查询
	public Vector getData(String sql){		  
		    Vector rows=new Vector();//存所有记录（行Vector对象的集合）
		    try{
			    //加载数据库驱动
			    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			    //获取一个链接
			    Connection conn=DriverManager.getConnection(url, user, password);
			    //
			    Statement stm=conn.createStatement();
			    //初始游标指向标题的位置
			    ResultSet rst=stm.executeQuery(sql);
			    
			    Vector rowData=null;
			    while(rst.next()){
			    	//一行记录存于一个Vector对象
			    	rowData=new Vector();
			    	int colCount=rst.getMetaData().getColumnCount();
			    	for(int i=0; i<colCount;i++){
				    	rowData.add(rst.getString(i+1));	
			    	}
			    	
			    	rows.add(rowData);
			    }
			    
			   conn.close();
		    }catch(Exception e){
		    	System.out.print(e);
		    }
		    
		    return rows;
	}
	
	
	//原创
	public List getData1(String sql){
		//System.out.println("11111111111");
		List<TableInfo> list =new ArrayList<TableInfo>();
		try{
			//加载数据库驱动
		    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		    //获取一个链接
		    Connection conn=DriverManager.getConnection(url, user, password);
		    //
		    Statement stm=conn.createStatement();
		    //初始游标指向标题的位置
		    ResultSet rst=stm.executeQuery(sql);
			////////////
		    
		    TableInfo t1=null;
		    while(rst.next()){
		    	String strBookname=rst.getString("name");
		    	String strId=rst.getString("id");
		    	System.out.println(strBookname);
		    	System.out.println(strId);
		    	t1=new TableInfo(strBookname,strId);
		    	
		    	list.add(t1);
		    }
		   conn.close();
	    }catch(Exception e){
	    	System.out.print(e);
	    }
		return list;
	}
	
	
	

	
}
