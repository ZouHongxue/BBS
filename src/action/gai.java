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

@WebServlet("/gai")
public class gai extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String otitle = req.getParameter("otitle");
		String ntitle = req.getParameter("ntitle");
		String content = req.getParameter("content");
		//System.out.print(otitle+ntitle+content);
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		news news1 = new news();
		news1.setTitle(otitle);
		news1.setContent(content);
		news1.setCount(0);
		manage manage1 = new manage();
		int a =0;
		ResultSet rs =null;
		PrintWriter out = resp.getWriter();
		try {
			rs = manage1.cha(news1);
			if(rs.next()){
				try {
					a = manage1.gai(ntitle,news1);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(a==1){
					out.print("修改成功");
				}else {
					out.print("修改失败");
				}
			}else{
				out.print("没有此记录");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
