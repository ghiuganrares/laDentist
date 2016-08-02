package ro.ladentist.LaDentist.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ro.ladentist.LaDentist.entity.Diagnostic;
import ro.ladentist.LaDentist.entity.Pacient;
import ro.ladentist.LaDentist.service.EntityService;

/**
 * Servlet implementation class AdaugarePacient
 */
@WebServlet("/addPacient")
public class AdaugarePacient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdaugarePacient() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Diagnostic> diag = EntityService.getInstance().getAllDiagnostic();
		request.setAttribute("listDiagnostic", diag);
		RequestDispatcher view = request.getRequestDispatcher("addPacient.jsp");
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String nume = request.getParameter("nume");
		String prenume = request.getParameter("prenume");
		String cnp = request.getParameter("cnp");
		String dataNastere = request.getParameter("datanastere");
		String adresa = request.getParameter("adresa");
		String ocupatie = request.getParameter("ocupatie");
		String telefon = request.getParameter("telefon");
		String email = request.getParameter("email");
		
		Pacient pac = new Pacient();
		
		pac.setNume(nume);
		pac.setPrenume(prenume);
		pac.setCnp(cnp);
		//pac.setDataNastere(dataNastere);
		pac.setAdresa(adresa);
		pac.setOcupatia(ocupatie);
		pac.setTelefon(telefon);
		pac.setEmail(email);
		
		
		EntityService.getInstance().insertPacient(pac);
		
		System.out.println(pac.getNume() + " " + pac.getPrenume());
		RequestDispatcher distpacher = getServletContext().getRequestDispatcher("/addPacient.jsp");
		distpacher.forward(request, response);
	}

}
