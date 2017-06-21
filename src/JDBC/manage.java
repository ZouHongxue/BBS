package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import beans.news;
import beans.user;

public class manage {
	
	public static int login(user u) throws SQLException {
		String name=u.name;
		String pwd = u.password;
		baseDao base = new baseDao();
		base.doCon();
		Connection con = base.con;
		Statement statement = con.createStatement();
		String sql = "select * from user where name ='"+name+"'";
		ResultSet rs = statement.executeQuery(sql);  
		String pwd1 = null;
		while(rs.next()){
          pwd1 = rs.getString("pwd");
          if(pwd.equals(pwd1)){
        	  rs.close();
              con.close();
        	  return 1;
          }
		}
		rs.close();
		con.close();
		return 0;
	}
	
	
	public static int register(user user1) throws SQLException {
		String name=user1.name;
		String pwd = user1.password;
		baseDao baseDao1 = new baseDao();
		baseDao1.doCon();
		Connection connection = baseDao1.con;
		String sql = "insert into user (name,pwd) values('"+name+"','"+pwd+"')";
		PreparedStatement ps = connection.prepareStatement(sql);  
		
		int row = ps.executeUpdate();  
		if(row > 0) {
			return 1;
		} 
		return 0;
	}


	public int zeng(news news1) throws SQLException {
		// TODO Auto-generated method stub
		baseDao baseDao1 = new baseDao();
		baseDao1.doCon();
		Connection connection = baseDao1.con;
		String sql = "insert into news (title,content) values('"+news1.getTitle()+"','"+news1.getContent()+"')";
		PreparedStatement ps = connection.prepareStatement(sql);  
		int row = ps.executeUpdate();  
		if(row > 0) {
			return 1;
		} 
		return 0;
	}


	public ResultSet cha(news news1) throws SQLException {
		// TODO Auto-generated method stub
		
		baseDao base = new baseDao();
		base.doCon();
		Connection con = base.con;
		Statement statement = con.createStatement();
		//System.out.print(news1.getTitle());
		String sql = "select content from news where title ='"+news1.getTitle()+"'";
		ResultSet rs = statement.executeQuery(sql);  
		if(rs!=null){
			return rs;
		}
		
		return null;

	}


	public int shan(news news1) throws SQLException {
		// TODO Auto-generated method stub
		
		baseDao baseDao1 = new baseDao();
		baseDao1.doCon();
		Connection connection = baseDao1.con;
		String sql = "delete from news where title = '"+news1.getTitle()+"'";
		PreparedStatement ps = connection.prepareStatement(sql);  
		int row = ps.executeUpdate();  
		if(row > 0) {
			return 1;
		} 
		return 0;
	}


	public int gai(String ntitle, news news1) throws SQLException {
		// TODO Auto-generated method stub
		baseDao baseDao1 = new baseDao();
		baseDao1.doCon();
		Connection connection = baseDao1.con;
		String sql = "update news set title = '"+ntitle+"'"
				+ ",content='"+news1.getContent()+"'"
				+ " where title = '"+news1.getTitle()+"'";
		PreparedStatement ps = connection.prepareStatement(sql);  
		int row = ps.executeUpdate();  
		if(row > 0) {
			return 1;
		} 
		
		return 0;
	}
	
	
}
