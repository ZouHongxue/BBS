package action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JDBC.manage;
import beans.user;
@WebServlet("/reg")
public class reg extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		user user1 = new user();
		String username = req.getParameter("name");
		String password = req.getParameter("password");
		user1.name=username;
		user1.password=password;
		manage manage1 = new manage();
		int a;
		try {
			a = manage1.register(user1);
			if (a==1) {
				//System.out.print(1);
				req.setAttribute("name", username);
				req.setAttribute("password", password);
				getServletConfig().getServletContext().getRequestDispatcher("/regSuccess.jsp").forward(req, resp);
			} else {
				
			}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	

}
