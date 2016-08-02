package ro.ladentist.LaDentist.entity;

import java.util.Date;

public class Tratament {
	private int id;
	private ActTerapeutic actTerapeutic;
	private Medic medic;
	private Date data;
	private Fisa fisa;

	
	
	public Fisa getFisa() {
		return fisa;
	}

	public void setFisa(Fisa fisa) {
		this.fisa = fisa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ActTerapeutic getActTerapeutic() {
		return actTerapeutic;
	}

	public void setActTerapeutic(ActTerapeutic actTerapeutic) {
		this.actTerapeutic = actTerapeutic;
	}

	public Medic getMedic() {
		return medic;
	}

	public void setMedic(Medic medic) {
		this.medic = medic;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
