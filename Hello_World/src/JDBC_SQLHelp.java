import java.awt.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class JDBC_SQLHelp {
	 /*
                 �������ݿ�
     */
	
	public static Connection getConnection(){//�����������ȡsql������
	Connection conn=null;
   	String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";//SQL���ݿ�����
   	String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=TEST";//����Դ  ������ע�������ּ��ػ����������ݿ�ʧ��һ���������������
    String Name="sa";//user���ݿ��û���
   	String Pwd="123";//password���ݿ����룩
   	 try{
   		 Class.forName(driverName);//����������
   		 conn=DriverManager.   
   				 getConnection(dbURL,Name,Pwd);//��url���ݿ��IP��ַ��user���ݿ��û�����password���ݿ����룩
   	 }catch(Exception e){
   		 e.printStackTrace();
   	 }
   	 return conn;
	}
	/*
    JDBC������ѯ����
     */
    public static void jdbcTest(String sql){
    	try {
    		Connection conn=getConnection();
    		if(conn!=null)
    		{
    			PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
                int xx=rs.getMetaData().getColumnCount();
                System.out.println(xx);
                String row=rs.getString(1);
           	 System.out.println(row);
//              for(int i=0;i<rs.getMetaData().getColumnCount();i++) {
//            	 String row=rs.getString(i);
//            	 System.out.println(row);
//              }

              //List<Object> list=new ArrayList<object>();
                while (rs.next()) {
                    String id = rs.getString("cid");
                    System.out.println(id);
                    String khzwmc = rs.getString("cTitle");
                    System.out.println(khzwmc);
                }
                rs.close();
                pstmt.close();
                conn.close();
    		}
    	}
        catch(Exception ex) {
        	ex.printStackTrace();
        }
    }
}
