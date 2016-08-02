package ro.ladentist.LaDentist.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ro.ladentist.LaDentist.entity.ActTerapeutic;
import ro.ladentist.LaDentist.entity.Diagnostic;
import ro.ladentist.LaDentist.entity.Medic;
import ro.ladentist.LaDentist.service.EntityService;

/**
 * Servlet implementation class InsertData
 */
@WebServlet("/insertData")
public class InsertData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("diagnostic") != null){
			String diagnostic = request.getParameter("diagnostic");
			String descriere = request.getParameter("descriere");
			Diagnostic diag = new Diagnostic();
			
			diag.setNume(diagnostic);
			diag.setDescriere(descriere);
			
			EntityService.getInstance().insertDiagnostic(diag);
		}
		
		if(request.getParameter("actT") != null){
			String actT = request.getParameter("actT");
			String descriereA = request.getParameter("descriereA");
			
			ActTerapeutic at = new ActTerapeutic();
			at.setNume(actT);
			at.setDescriere(descriereA);
			
			EntityService.getInstance().insertActTerapeutic(at);
		}
		
		if(request.getParameter("nume") != null){
			String nume = request.getParameter("nume");
			String prenume = request.getParameter("prenume");
			
			Medic medic = new Medic();
			
			medic.setNume(nume);
			medic.setPrenume(prenume);
			EntityService.getInstance().insertMedic(medic);
		}
		
		RequestDispatcher distpacher = getServletContext().getRequestDispatcher("/insertData.jsp");
		distpacher.forward(request, response);
	}

}
