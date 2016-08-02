package ro.ladentist.LaDentist.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ro.ladentist.LaDentist.login.UserList;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int MINUTE = 60;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		boolean ok = UserList.getInstance().checkCredentials(username, password);
		
		if(ok){
			Cookie cookie = new Cookie("username", username);
			cookie.setMaxAge(100 * MINUTE);
			response.addCookie(cookie);
			RequestDispatcher distpacher = getServletContext().getRequestDispatcher("/home.jsp");
			distpacher.forward(request, response);
		}else{
			RequestDispatcher distpacher = getServletContext().getRequestDispatcher("/index.jsp");
			request.setAttribute("failed", "Username or password is incorect");
			distpacher.forward(request, response);
		}
	}
}
