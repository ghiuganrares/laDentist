package ro.ladentist.LaDentist.service;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import ro.ladentist.LaDentist.entity.ActTerapeutic;
import ro.ladentist.LaDentist.entity.Diagnostic;
import ro.ladentist.LaDentist.entity.Fisa;
import ro.ladentist.LaDentist.entity.Medic;
import ro.ladentist.LaDentist.entity.Pacient;
import ro.ladentist.LaDentist.entity.Tratament;

public class EntityService {
	// singleton;

	private static EntityService instance;
	private Connection connection;

	private EntityService() {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource) envCtx.lookup("jdbc/LaDentist");
			connection = ds.getConnection();

			// connection =
			// DriverManager.getConnection("jdbc:mysql://localhost:3306/ladentist",
			// "root", "orlando");
		} catch (SQLException | NamingException e) {
			throw new RuntimeException("Cannot connect to database", e);
		}
	}

	public static EntityService getInstance() {
		if (instance == null) {
			instance = new EntityService();
		}
		return instance;

		// if (instance == null) {
		// synchronized (instance) {
		// if (instance == null) {
		// instance = new EntityService();
		// }
		// }
		// }
		// return instance;
	}

	public List<Pacient> getAllPacients() {
		List<Pacient> pacienti = new ArrayList<Pacient>();
		try (PreparedStatement read = connection.prepareStatement("select * from pacient");) {
			ResultSet rs = read.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String nume = rs.getString("nume");
				String prenume = rs.getString("prenume");
				String cnp = rs.getString("cnp");
				Date date = rs.getDate("datanastere");
				String adresa = rs.getString("adresa");
				String ocupatia = rs.getString("ocupatia");
				String telefon = rs.getString("telefon");
				String email = rs.getString("email");

				Pacient p = new Pacient(nume, prenume, cnp);
				p.setId(id);
				p.setDataNastere(date);
				p.setAdresa(adresa);
				p.setOcupatia(ocupatia);
				p.setTelefon(telefon);
				p.setEmail(email);
				pacienti.add(p);
			}
			return pacienti;
		} catch (SQLException e) {
			// ResultSet rr = read.executeQuery("ROLLBACK");
			e.printStackTrace();
		}
		return null;
	}
	public List<Diagnostic> getAllDiagnostic(){
		List<Diagnostic> diag = new ArrayList<>();
		try (PreparedStatement read = connection.prepareStatement("select * from diagnostic");){
			ResultSet rs = read.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String nume = rs.getString("nume");
				String descriere = rs.getString("descriere");
				
				Diagnostic dig = new Diagnostic();
				dig.setId(id);
				dig.setNume(nume);
				dig.setDescriere(descriere);
				diag.add(dig);
			}
			return diag;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return diag;
	}

	public List<Medic> getAllMedic() {
		List<Medic> med = new ArrayList<Medic>();
		try (PreparedStatement read = connection.prepareStatement("select * from medic");) {
			ResultSet rs = read.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String nume = rs.getString("nume");
				String prenume = rs.getString("prenume");

				Medic m = new Medic();
				m.setId(id);
				m.setNume(nume);
				m.setPrenume(prenume);
				med.add(m);
			}
			return med;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Fisa getFisaForPacient(Pacient p) {
		Fisa f = new Fisa();
		PreparedStatement read;
		String fisa = "select * from fisa where id_pacient=";
		String tratament = "select id from tratament where id_fisa =";
		try {
			read = connection.prepareStatement(fisa + p.getId());
			ResultSet rs1 = read.executeQuery();
			while (rs1.next()) {
				int idFisa = rs1.getInt("id");
				int idD = rs1.getInt("id_diagnostic");
				int idPacient = rs1.getInt("id_pacient");
				String planTratament = rs1.getString("plan_tratament");

				f.setPlanTratament(planTratament);
				f.setPacient(getPacientById(idPacient));
				f.setId(idFisa);
				f.setDiagnostic(getDiagnosticById(idD));
				ResultSet rs3 = read.executeQuery(tratament + idFisa);
				List<Tratament> tratamente = new ArrayList<Tratament>();
				while (rs3.next()) {
					int idTratament = rs3.getInt("id");
					tratamente.add(getTratamentById(idTratament));
				}
				return f;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public ActTerapeutic getActTerapeuticById(int id) {
		ActTerapeutic a = new ActTerapeutic();
		PreparedStatement read;
		try {
			read = connection.prepareStatement("select * from act_terapeutic" + " where id=" + id);
			ResultSet rs = read.executeQuery();
			while (rs.next()) {
				a.setId(rs.getInt("id"));
				a.setNume(rs.getString("nume"));
				a.setDescriere(rs.getString("descriere"));
				return a;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public Pacient getPacientById(int idP) {
		Pacient p = new Pacient();
		PreparedStatement read;
		try {
			read = connection.prepareStatement("select * from pacient" + " where id=" + idP);
			ResultSet rs = read.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String nume = rs.getString("nume");
				String prenume = rs.getString("prenume");
				String cnp = rs.getString("cnp");
				Date date = rs.getDate("datanastere");
				String adresa = rs.getString("adresa");
				String ocupatia = rs.getString("ocupatia");
				String telefon = rs.getString("telefon");
				String email = rs.getString("email");

				p.setNume(nume);
				p.setPrenume(prenume);
				p.setCnp(cnp);
				p.setId(id);
				p.setDataNastere(date);
				p.setAdresa(adresa);
				p.setOcupatia(ocupatia);
				p.setTelefon(telefon);
				p.setEmail(email);

				return p;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public Tratament getTratamentById(int id) {
		Tratament trat = new Tratament();
		PreparedStatement read;
		try {
			read = connection.prepareStatement("select * from tratament where id=" + id);
			ResultSet rs = read.executeQuery();
			while (rs.next()) {
				int actT = rs.getInt("id_act_terapeutic");
				int idM = rs.getInt("id_medic");
				Date date = rs.getDate("data");
				int idF = rs.getInt("id_fisa");

				trat.setId(rs.getInt("id"));
				trat.setActTerapeutic(getActTerapeuticById(actT));
				trat.setMedic(getMedicById(idM));
				trat.setData(date);
				trat.setFisa(getFisaById(idF));
				return trat;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}

	public Fisa getFisaById(int idF) {
		Fisa fisa = new Fisa();
		PreparedStatement read;
		try {
			read = connection.prepareStatement("select * from fisa where id=" + idF);
			ResultSet rs = read.executeQuery();
			while (rs.next()) {

				int id = rs.getInt("id");
				int idP = rs.getInt("id_pacient");
				int idD = rs.getInt("id_diagnostic");
				String planT = rs.getString("plan_tratament");

				fisa.setId(id);
				fisa.setDiagnostic(getDiagnosticById(idD));
				fisa.setPacient(getPacientById(idP));
				fisa.setPlanTratament(planT);
				return fisa;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;

	}

	public Medic getMedicById(int idM) {
		Medic med = new Medic();
		PreparedStatement read;
		try {
			read = connection.prepareStatement("select * from medic where id=" + idM);
			ResultSet rs = read.executeQuery();
			while (rs.next()) {

				int id = rs.getInt("id");
				String nume = rs.getString("nume");
				String prenume = rs.getString("prenume");

				med.setId(id);
				med.setNume(nume);
				med.setPrenume(prenume);
				return med;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;

	}

	public Diagnostic getDiagnosticById(int idD) {
		Diagnostic diag = new Diagnostic();
		PreparedStatement read;
		try {
			read = connection.prepareStatement("select * from diagnostic where id=" + idD);
			ResultSet rs = read.executeQuery();
			while (rs.next()) {

				int id = rs.getInt("id");
				String nume = rs.getString("nume");
				String descriere = rs.getString("descriere");

				diag.setId(id);
				diag.setNume(nume);
				diag.setDescriere(descriere);
				return diag;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}

	// getByID toate entitatile

	public void insertPacient(Pacient p) {

		String insertP = "INSERT INTO pacient (nume, prenume, cnp, datanastere, adresa, ocupatia, telefon, email) VALUES ('"
				+ p.getNume() + "', '" + p.getPrenume() + "', '" + p.getCnp() + "', ?, '" + p.getAdresa() + "', '"
				+ p.getOcupatia() + "', '" + p.getTelefon() + "', '" + p.getEmail() + "')";

		try (PreparedStatement write = connection.prepareStatement(insertP);) {
			connection.setAutoCommit(false);

			write.setDate(1, getCurrentDate());

			write.addBatch();

			write.executeBatch();

			System.out.println(p.getNume() + " " + p.getPrenume() + " " + p.getCnp());
			if (p.getNume() == null) {
				connection.rollback();
				throw new RuntimeException("Buleala!");
			}
			if (p.getPrenume() == null) {
				connection.rollback();
				throw new RuntimeException("Buleala!");
			}
			if (p.getCnp() == null) {
				connection.rollback();
				throw new RuntimeException("Buleala!");
			}

			connection.commit();

		} catch (SQLException e) {
			throw new RuntimeException("Failed to insert the record.", e);
			// e.printStackTrace();

		}
	}

	public List<Pacient> searchPacient(String numeCautat) {
		List<Pacient> pac = new ArrayList<>();
		String search = "SELECT id FROM pacient WHERE nume LIKE '%" + numeCautat + "%';";
		try (PreparedStatement pst = connection.prepareStatement(search);) {
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");

				Pacient p = getPacientById(id);

				pac.add(p);
			}

			return pac;
		} catch (SQLException e) {
			throw new RuntimeException("Failed to SEARCH the record.", e);
			// e.printStackTrace();

		}
	}

	private static java.sql.Date getCurrentDate() {
		java.util.Date today = new java.util.Date();
		return new java.sql.Date(today.getTime());
	}

	public void insertMedic(Medic m) {
		try (PreparedStatement write = connection.prepareStatement(
				"INSERT INTO medic (nume, prenume) VALUES ('" + m.getNume() + "', '" + m.getPrenume() + "')");) {
			write.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException("Failed to insert the record.", e);
			// e.printStackTrace();

		}
	}

	public void insertDiagnostic(Diagnostic d) {

		try (PreparedStatement write = connection.prepareStatement("INSERT INTO diagnostic (nume, descriere) VALUES ('"
				+ d.getNume() + "', '" + d.getDescriere() + "')");) {
			write.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException("Failed to insert the record.", e);
			// e.printStackTrace();

		}
	}

	public void insertActTerapeutic(ActTerapeutic actT) {

		try (PreparedStatement write = connection
				.prepareStatement("INSERT INTO act_terapeutic (nume, descriere) VALUES ('" + actT.getNume() + "', '"
						+ actT.getDescriere() + "')");) {
			write.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException("Failed to insert the record.", e);
			// e.printStackTrace();

		}
	}

	public void insertFisa(Fisa f) {

		try (PreparedStatement write = connection.prepareStatement(
				"INSERT INTO fisa (id_pacient, id_diagnostic, plan_tratament) VALUES ('" + f.getPacient().getId()
						+ "', '" + f.getDiagnostic().getId() + "', '" + f.getPlanTratament() + "')");) {
			write.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException("Failed to insert the record.", e);
			// e.printStackTrace();

		}
	}

	// insert toate entitatile
	public void insertTratament(Tratament t) {

		try (PreparedStatement write = connection
				.prepareStatement("INSERT INTO tratament (id_act_terapeutic, id_medic, data, id_fisa) VALUES ('"
						+ t.getActTerapeutic().getId() + "', '" + t.getMedic().getId() + "', '" + t.getData() + "', '"
						+ t.getFisa().getId() + "')");) {
			// probleme cu data

			write.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException("Failed to insert the record.", e);
			// e.printStackTrace();

		}
	}

	public void deletePacient(Pacient p) {
		// atentie!!! pacient sters = fisa si tratament, foreign keys din
		// workbench
		try (PreparedStatement delete = connection.prepareStatement("DELETE FROM pacient WHERE id=" + p.getId());) {
			delete.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Failed to delete.", e);
			// e.printStackTrace();

		}

	}

	public void deleteDiagnostic(Diagnostic d) {

		try (PreparedStatement delete = connection.prepareStatement("DELETE FROM diagnostic WHERE id=" + d.getId());) {
			delete.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Failed to delete.", e);
			// e.printStackTrace();

		}
	}

	public void deleteActTerapeutic(ActTerapeutic actT) {

		try (PreparedStatement delete = connection
				.prepareStatement("DELETE FROM act_terapeutic WHERE id=" + actT.getId());) {
			delete.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Failed to delete.", e);
			// e.printStackTrace();

		}
	}

	public void deleteMedic(Medic m) {

		try (PreparedStatement delete = connection.prepareStatement("DELETE FROM medic WHERE id=" + m.getId());) {
			delete.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Failed to delete.", e);
			// e.printStackTrace();

		}
	}

	public void deleteTratament(Tratament t) {

		try (PreparedStatement delete = connection.prepareStatement("DELETE FROM tratament WHERE id=" + t.getId());) {
			delete.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Failed to delete.", e);
			// e.printStackTrace();
		}
	}

	public void deleteFisa(Fisa f) {
		List<Tratament> trat = f.getTratamente();
		for (int i = 0; i < trat.size(); i++) {
			deleteTratament(trat.get(i));
		}
		try (PreparedStatement delete = connection.prepareStatement("DELETE FROM fisa WHERE id=" + f.getId());) {
			delete.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Failed to delete.", e);
			// e.printStackTrace();
		}
	}

	public List<Tratament> getTratamenteForFisa(Fisa f) {
		String tratament = "select id from tratament where id_fisa =";
		List<Tratament> tratamente = new ArrayList<Tratament>();
		try (PreparedStatement read = connection.prepareStatement(tratament + f.getId());) {
			ResultSet rs3 = read.executeQuery();

			while (rs3.next()) {
				int idTratament = rs3.getInt("id");
				tratamente.add(getTratamentById(idTratament));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tratamente;

	}

	public void addTratamentToFisa(Tratament t, Fisa f) {
		insertTratament(t);
		List<Tratament> trat = getTratamenteForFisa(f);
		f.setTratamente(trat);
	}

	public void deleteTratamentFromFisa(Tratament t, Fisa f) {
		List<Tratament> trat = f.getTratamente();
		trat.remove(t);
		deleteTratament(t);
	}

}
