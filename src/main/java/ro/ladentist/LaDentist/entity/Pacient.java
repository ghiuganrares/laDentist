package ro.ladentist.LaDentist.entity;

import java.util.Date;

public class Pacient {
	private int id;
	private String nume;
	private String prenume;
	private String cnp;
	private Date dataNastere;
	private String adresa;
	private String ocupatia;
	private String telefon;
	private String email;
	
	public Pacient(){
		
	}
	public Pacient(String nume, String prenume, String cnp){
		this.nume = nume;
		this.prenume = prenume;
		this.cnp = cnp;
		
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public String getPrenume() {
		return prenume;
	}
	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}
	public String getCnp() {
		return cnp;
	}
	public void setCnp(String cnp) {
		this.cnp = cnp;
	}
	public Date getDataNastere() {
		return dataNastere;
	}
	public void setDataNastere(Date dataNastere) {
		this.dataNastere = dataNastere;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getOcupatia() {
		return ocupatia;
	}
	public void setOcupatia(String ocupatia) {
		this.ocupatia = ocupatia;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
