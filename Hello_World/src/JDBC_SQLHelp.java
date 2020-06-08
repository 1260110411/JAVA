import java.awt.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class JDBC_SQLHelp {
	 /*
                 连接数据库
     */
	
	public static Connection getConnection(){//用这个方法获取sql的连接
	Connection conn=null;
   	String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";//SQL数据库引擎
   	String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=TEST";//数据源  ！！！注意若出现加载或者连接数据库失败一般是这里出现问题
    String Name="sa";//user数据库用户名
   	String Pwd="123";//password数据库密码）
   	 try{
   		 Class.forName(driverName);//加载驱动类
   		 conn=DriverManager.   
   				 getConnection(dbURL,Name,Pwd);//（url数据库的IP地址，user数据库用户名，password数据库密码）
   	 }catch(Exception e){
   		 e.printStackTrace();
   	 }
   	 return conn;
	}
	/*
    JDBC单个查询操作
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
