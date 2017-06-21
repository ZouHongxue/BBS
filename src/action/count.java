package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.news;
import JDBC.News;

@WebServlet("/count")
public class count extends HttpServlet{
	
	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String  id = req.getParameter("id");
		System.out.println(id);
		resp.setContentType("text/html");  
        resp.setCharacterEncoding("utf-8");  
        
        News news1 = new News();
        int a = Integer.parseInt(id);
       
        try {
			news1.zan(a);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        PrintWriter out = resp.getWriter();  
        out.print("suc");
	}
	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
}
