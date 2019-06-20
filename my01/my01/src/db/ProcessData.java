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
		//����ϵͳ��֤����ʱҪȥ��integratedSecurity=true;  ����oracle����oracle������
	 String user="sa";
	 String password="sasasa";
	//��ӣ�ɾ�����޸�
	public boolean insert(String sql){
		boolean isSuccess=false;
		try{
			 //�������ݿ�����
		    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		    //��ȡһ������
		    Connection conn=DriverManager.getConnection(url, user, password);
		    //
		    Statement stm=conn.createStatement();
		    stm.executeUpdate(sql);
		    isSuccess=true;
		    conn.close();
		}catch(Exception e){
			System.err.println(e);
			//System.out.println("���ݿ�����ʧ�ܣ�");   
		    //e.printStackTrace() ; 
		}
		
		
		return isSuccess;
	}
	//��ѯ
	public Vector getData(String sql){		  
		    Vector rows=new Vector();//�����м�¼����Vector����ļ��ϣ�
		    try{
			    //�������ݿ�����
			    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			    //��ȡһ������
			    Connection conn=DriverManager.getConnection(url, user, password);
			    //
			    Statement stm=conn.createStatement();
			    //��ʼ�α�ָ������λ��
			    ResultSet rst=stm.executeQuery(sql);
			    
			    Vector rowData=null;
			    while(rst.next()){
			    	//һ�м�¼����һ��Vector����
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
	
	
	//ԭ��
	public List getData1(String sql){
		//System.out.println("11111111111");
		List<TableInfo> list =new ArrayList<TableInfo>();
		try{
			//�������ݿ�����
		    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		    //��ȡһ������
		    Connection conn=DriverManager.getConnection(url, user, password);
		    //
		    Statement stm=conn.createStatement();
		    //��ʼ�α�ָ������λ��
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
