package it.polito.tdp.libretto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Libretto {
	
	private List<Voto> voti;
	
	public Libretto() {
		this.voti = new ArrayList<Voto>();
	}
	
	
//	public void add(int voto, String corso, LocalDate data) {
//		
//	}
	
//	Non ho bisogno di sapere come è fatto il voto per aggiungerlo al libretto
	/**
	 * Aggiunge un nuovo voto al libretto
	 * 
	 * @param v il {@link Voto} da aggiungere
	 */
	public void add(Voto v) {
		voti.add(v);
		//questo metodo delega alla lista sottostante di aggiungere il voto
	}
	
	
	/**
	 * Seleziona il sottoinsieme di voti che hanno il punteggio specificato
	 * 
	 * @param punti punteggio da cercare
	 * @return lista di {@link Voto} aventi quel punteggio (eventualmente vuota)
	 */
	public List<Voto> cercaVoti(int punti) {			//Uso la lista perche poi devo fare anche l'interfaccia grafica
		List<Voto> result = new ArrayList<Voto>();
		
		for(Voto v: this.voti) {
			if(v.getPunti() == punti) {
				result.add(v);
			}
		}
		return result;		
	}
	
	/**
	 * Ricerca un {@link Voto} relativo al corso con il nome specificato
	 * 
	 * @param nomeEsame nome dell'esame da cercare
	 * @return il {@link Voto} dell'esame con quel punteggio
	 */
	public Voto cercaEsame(String nomeEsame) {
		for(Voto v: this.voti) {
			if(v.getCorso().equals(nomeEsame)) {
				return v;
			}
		}
		return null;
	}

}
