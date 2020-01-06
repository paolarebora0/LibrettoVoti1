package it.polito.tdp.libretto;

import java.time.LocalDate;

public class Voto {
	private int voto;
	private String corsoString;
	private LocalDate data;
	
	public Voto(int voto, String corsoString, LocalDate data) {
		super();
		this.voto = voto;
		this.corsoString = corsoString;
		this.data = data;
	}
	
	public int getVoto() {
		return voto;
	}
	public void setVoto(int voto) {
		this.voto = voto;
	}
	public String getCorsoString() {
		return corsoString;
	}
	public void setCorsoString(String corsoString) {
		this.corsoString = corsoString;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	

}
