package it.polito.tdp.libretto;

import java.time.LocalDate;
import java.util.List;

public class TestLibretto {

	public static void main(String[] args) {
		Libretto libretto = new Libretto();
		
		libretto.add(new Voto(30, "Analisi I", LocalDate.of(2017, 1, 15)));
		libretto.add(new Voto(21, "Analisi II", LocalDate.of(2018, 1, 25)));
		libretto.add(new Voto(25, "Fisica I", LocalDate.of(2017, 6, 10)));
		libretto.add(new Voto(28, "Fisica II", LocalDate.of(2018, 9, 3)));
		libretto.add(new Voto(18, "Geometria", LocalDate.of(2017, 9, 1)));
		libretto.add(new Voto(20, "Economia", LocalDate.of(2018, 1, 28)));
		libretto.add(new Voto(25, "Ricerca Operativa", LocalDate.of(2018, 6, 5)));
		libretto.add(new Voto(24, "Complementi di Economia", LocalDate.of(2018, 2, 15)));
		libretto.add(new Voto(25, "Logistica", LocalDate.of(2019, 2, 1)));
		libretto.add(new Voto(27, "Programmazione a Oggetti", LocalDate.of(2019, 1, 25)));

		List<Voto> venticinque = libretto.cercaVoti(25);
		System.out.println(venticinque);
	}

}
