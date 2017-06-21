package action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.SessionCookieConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import JDBC.baseDao;
import JDBC.manage;
import beans.user;

/**
 * Servlet implementation class log
 */
@WebServlet("/log")
public class log extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
   public log() {
        // TODO Auto-generated constructor stub
   }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username = request.getParameter("name");
		String password = request.getParameter("password");
		user u = new user();
		manage manage1 = new manage();
		u.name=username;
		u.password=password;
		int a;
		try {
			a = manage1.login(u);
			System.out.println(a);
			if(a==1){
				response.sendRedirect("loginSuc.html");
			}else{
				response.sendRedirect("error.html");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}
}


