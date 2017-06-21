package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JDBC.manage;
import beans.news;

@WebServlet("/zeng")
public class zeng extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//System.out.print("doPost");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		//System.out.print(content);
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		news news1 = new news();
		news1.setTitle(title);
		news1.setContent(content);
		news1.setCount(0);
		manage manage1 = new manage();
		int a =0;
		try {
			a = manage1.zeng(news1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter out = resp.getWriter();
		if(a==1){
			
			out.print("发布成功");
		}else {
			out.print("发布失败");
		}
		
		
	}
}
