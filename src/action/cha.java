package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JDBC.manage;
import beans.news;

@WebServlet("/cha")
public class cha extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title = req.getParameter("title");
		//System.out.print(title);
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		news news1 = new news();
		news1.setTitle(title);
		manage manage1 = new manage();
		ResultSet rs =null;
		try {
			rs = manage1.cha(news1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter out = resp.getWriter();
		int id = 1;
		
		try {
			while(rs.next()){
				//System.out.print(rs.getString("content"));
				out.print("第"+id+"条:"+rs.getString("content"));
				id++;
				return;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		out.print("error");
			
		
	}
}
