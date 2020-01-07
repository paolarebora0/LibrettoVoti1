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
	 * @return {@code true} nel caso normale,
	 * 		   {@code false} se non è riuscito ad aggiungere il voto.
	 */
	public boolean add(Voto v) {
		
		if(!this.esisteGiaVoto(v) && !this.votoConflitto(v)) {
			voti.add(v);
			return true;
			//questo metodo delega alla lista sottostante di aggiungere il voto
		} else {
			return false;
		}
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
		
		Voto voto = new Voto (0, nomeEsame, null); //Costruisco un oggetto voto di ricerca mezzo vuoto
		int pos = this.voti.indexOf(voto);
		if(pos==-1) 
			return null;
		else {
			return this.voti.get(pos);
		}
	}
	
	/**
	 * Dato un {@link Voto}, determina se esiste già un voto con uguale corso 
	 * ed uguale punteggio
	 * 
	 * @param v
	 * @return {@code true} se ha trovato un corso e punteggio uguali,
	 * 		   {@code false} se non ha trovato il corso, 
	 * 			oppure l'ha trovato con voto diverso
	 */
	public boolean esisteGiaVoto(Voto v) {
		int pos = this.voti.indexOf(v);
		if(pos==-1)
			return false;
		else {
			return (v.getPunti() == this.voti.get(pos).getPunti());
		}		
	}
	
	
	/**
	 * Mi dice se il {@link Voto} {@code v} è in conflitto con uno dei voti esistenti
	 * se il voto non esiste, non c'è conflitto. Se il voto esiste ed ha punteggi
	 * diversi, c'è conflitto.
	 * 
	 * @param v
	 * @return {@code true} se il voto esiste ed ha un punteggio diverso,
	 * 		   {@code false} se il voto non esiste, oppure esiste ma con lo 
	 * 			stesso punteggio
	 */
	public boolean votoConflitto(Voto v) {
		int pos = this.voti.indexOf(v);
		if(pos==-1)
			return false;
		else {
			return (v.getPunti() != this.voti.get(pos).getPunti());
		}		
	}
	
	public String toString() {
		return this.voti.toString();
	}
	
	
	public Libretto librettoMigliorato() {
		Libretto nuovo = new Libretto();
		for(Voto v: this.voti) {
			nuovo.add(v.clone()); //In questo modo creo un clone ma non modifico quello vecchio
		}
		//I due libretti contengono ancora gli stessi voti
		for(Voto v: nuovo.voti) {
			int punti = v.getPunti();
			if(punti<=24)
				punti = punti +1;
			else if(punti <= 28)
				punti = punti +2;
			v.setPunti(punti);
		}
		return nuovo;
	}
	
	public void cancellaVotiScarsi() {
		List<Voto> cancellare = new ArrayList<Voto>();
		for(Voto v: this.voti) {
			if(v.getPunti()<24) {
				cancellare.add(v); //Non posso rimuovere un elemento mentre lo sto iterando
			}
		}		
		this.voti.removeAll(cancellare);
	}
	
}
