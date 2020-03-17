package it.polito.tdp.libretto.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Memorizza e gestisce un insieme di vori superati
 * 
 * @author Marco
 *
 */

public class Libretto {

	private List<Voto> voti = new ArrayList<>();

	/**
	 * Aggiunge nuovo voto al libretto
	 * 
	 * @param v voto da aggiungere
	 */
	public void add(Voto v) {
		this.voti.add(v);
	}

	/**
	 * Dato libretto, restituisce stringa nella quale vi sono solo voti pari a
	 * quello specificato
	 * 
	 * @param voto valore specificato
	 * @return stringa formattata per visualizzare il sotto-libretto
	 */
	public String stampaVotiUguali(int voto) {
		String s = "";
		for (Voto v : this.voti) {
			if (v.getVoto() == voto) {
				s += v.toString() + "\n";
			}
		}
		return s;
	}
	
	/**
	 * Genera nuovo libretto, a partire da quello esistente,
	 * che conterra' esclusivamente voti con valutazione pari
	 * a quella specificata
	 * @param voto voto votazione specificata
	 * @return nuovo Libretto "ridotto"
	 */
	public Libretto estraiVotiUguali(int voto) {
		Libretto nuovo=new Libretto();
		for(Voto v:this.voti) {
			if(v.getVoto()==voto) {
				nuovo.add(v);
			}
		}
		//meglio lavorare con oggetti che con stringhe perche' posso farci piu' cose
		return nuovo;
	}

	public String toString() {
		String s = "";
		for (Voto v : this.voti) {
			s += v.toString() + "\n";
		}
		return s;
	}

}
