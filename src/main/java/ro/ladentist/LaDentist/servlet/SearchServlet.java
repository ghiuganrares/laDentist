package ro.ladentist.LaDentist.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ro.ladentist.LaDentist.entity.Pacient;
import ro.ladentist.LaDentist.service.EntityService;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("search") == null){
			List<Pacient> list = EntityService.getInstance().getAllPacients();
			request.setAttribute("listaPacienti", list);
			RequestDispatcher view = request.getRequestDispatcher("search.jsp");
			view.forward(request, response);
		}else{
			List<Pacient> list = EntityService.getInstance().searchPacient(request.getParameter("search"));
			request.setAttribute("listaPacienti", list);
			RequestDispatcher view = request.getRequestDispatcher("search.jsp");
			view.forward(request, response);
		}
		
		
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
