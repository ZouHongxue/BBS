package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.javafx.css.Declaration;

public class baseDao {
	
	public void baseDao() {
		
	}
	static Connection con;
	public static void doCon(){

	        //驱动程序名
	        String driver = "com.mysql.jdbc.Driver";
	        //URL指向要访问的数据库名mydata
	        String url = "jdbc:mysql://localhost:3306/bbs";
	        //MySQL配置时的用户名
	        String user = "root";
	        //MySQL配置时的密码
	        String password = "admin";
	        //遍历查询结果集
	        try {
	            //加载驱动程序
	            Class.forName(driver);
	            //1.getConnection()方法，连接MySQL数据库！！
	            con = DriverManager.getConnection(url,user,password);
	            if(!con.isClosed())
	                System.out.println("Succeeded connecting to the Database!");
	        } catch(ClassNotFoundException e) {   
	            //数据库驱动类异常处理
	            System.out.println("Sorry,can`t find the Driver!");   
	            e.printStackTrace();   
	            } catch(SQLException e) {
	            //数据库连接失败异常处理
	            e.printStackTrace();  
	            }catch (Exception e) {
	            // TODO: handle exception
	            e.printStackTrace();
	        }finally{
	            System.out.println("数据库数据成功获取！！");
	        }
	}
	
}