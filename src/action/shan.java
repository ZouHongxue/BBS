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

@WebServlet("/shan")
public class shan extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title = req.getParameter("title");
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		news news1 = new news();
		news1.setTitle(title);
		manage manage1 = new manage();
		ResultSet rs =null;
		PrintWriter out = resp.getWriter();
		try {
			rs = manage1.cha(news1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(rs.next()){
				
				int a = manage1.shan(news1);
				if(a==1){
					out.print("删除成功");
					return ;
				}else{
					out.print("删除失败");
					return ;
				}
			}else {
				out.print("没有此标题记录");
				return ;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
