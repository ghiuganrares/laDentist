package ro.ladentist.LaDentist.entity;

import java.util.List;

public class Fisa {
	private int id;
	private Pacient pacient;
	private Diagnostic diagnostic;
	private String planTratament;
	private List<Tratament> tratamente;
	//
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Pacient getPacient() {
		return pacient;
	}
	public void setPacient(Pacient pacient) {
		this.pacient = pacient;
	}
	public Diagnostic getDiagnostic() {
		return diagnostic;
	}
	public void setDiagnostic(Diagnostic diagnostic) {
		this.diagnostic = diagnostic;
	}
	public String getPlanTratament() {
		return planTratament;
	}
	public void setPlanTratament(String planTratament) {
		this.planTratament = planTratament;
	}
	public List<Tratament> getTratamente() {
		return tratamente;
	}
	public void setTratamente(List<Tratament> tratamente) {
		this.tratamente = tratamente;
	}

	
	
}
