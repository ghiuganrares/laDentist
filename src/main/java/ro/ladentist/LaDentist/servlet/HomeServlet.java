package ro.ladentist.LaDentist.servlet;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/navigation")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = request.getParameter("path");
		System.out.println("path = " + path);
		switch (path) {
		case "home":
			request.getRequestDispatcher("/home.jsp").forward(request, response);
			break;
		case "programari":
			request.getRequestDispatcher("/aa.jsp").forward(request, response);
			break;
		case "search":
			request.getRequestDispatcher("/search").forward(request, response);
			break;
		case "addPacient":
			request.getRequestDispatcher("/addPacient").forward(request, response);
			break;
		case "insertData":
			request.getRequestDispatcher("/insertData.jsp").forward(request, response);
			break;
		}

		// List<Pacient> list = EntityService.getInstance().getAllPacients();
		// request.setAttribute("list", list);
		// RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
		// rd.forward(request, response);

		// de folosit
		// List<Pacient> list = EntityService.getInstance().getAllPacients();
		// request.setAttribute("listaPacienti", list);
		//
		// RequestDispatcher view = request.getRequestDispatcher("search.jsp");
		// view.forward(request, response);
		// de folosit

		// HttpSession session = request.getSession();
		// session.setAttribute("list", list);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
