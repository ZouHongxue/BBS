package JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

import com.mysql.jdbc.UpdatableResultSet;
import com.sun.xml.internal.fastinfoset.util.StringArray;

public class News {
	
	static String sql = null;
	static Statement statement = null;
	
	public static void dao() throws SQLException {
		baseDao con = new baseDao();
		con.doCon();
		Connection connection = con.con;
		statement = connection.createStatement();
	}
	
	//查找index
	public static ResultSet search() throws SQLException {
		dao();
		sql = "select * from news";
		ResultSet rs = statement.executeQuery(sql);
		return rs ;
	}
	
	//赞
	public static void  zan (int id) throws SQLException {
		dao();
		sql = "update news set count = count +'1' where id = '"+id+"'";
		statement.executeUpdate(sql);
	}
	
	
}
