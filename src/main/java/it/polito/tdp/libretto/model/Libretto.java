package it.polito.tdp.libretto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Memorizza e gestisce un insieme di vori superati
 * 
 * @author Marco
 *
 */

public class Libretto {

	private List<Voto> voti = new ArrayList<>();
	
	public Libretto() {
		
	}
	
	/**
	 * Copy Constructor
	 * "Shallow" (copia superficiale)
	 * 
	 * @param lib
	 */
	public Libretto (Libretto lib) {
		super();
		this.voti.addAll(lib.voti);
	}

	/**
	 * Aggiunge nuovo voto al libretto
	 * 
	 * @param v
	 * @return
	 */
	public boolean add(Voto v) {
		if (this.isConflitto(v) || this.isDuplicato(v)) {
			// non inserire il voto
			return false;
		} else {
			// inserisci voto perche' non in conflitto e non duplicato
			this.voti.add(v);
			return true;
		}
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
	 * Genera nuovo libretto, a partire da quello esistente, che conterra'
	 * esclusivamente voti con valutazione pari a quella specificata
	 * 
	 * @param voto voto votazione specificata
	 * @return nuovo Libretto "ridotto"
	 */
	public Libretto estraiVotiUguali(int voto) {
		Libretto nuovo = new Libretto();
		for (Voto v : this.voti) {
			if (v.getVoto() == voto) {
				nuovo.add(v);
			}
		}
		// meglio lavorare con oggetti che con stringhe perche' posso farci piu' cose
		return nuovo;
	}

	public String toString() {
		String s = "";
		for (Voto v : this.voti) {
			s += v.toString() + "\n";
		}
		return s;
	}

	/**
	 * Dato nome corso cerca se esiste il corso nel libretto e in caso affermativo
	 * restituisce oggetto {@link Voto} corrispondente. Se l'esame non esiste,
	 * restituisce null.
	 * 
	 * @param nomeCorso nome esame da cercare
	 * @return {@link Voto} corrispondente, o null se non esiste
	 */
	public Voto cercaNomeCorso(String nomeCorso) {
		/*
		 * for (Voto v : this.voti) { if(nomeCorso.equals(v.getCorso())) { return v; } }
		 * return null;
		 */

		int pos = this.voti.indexOf(new Voto(nomeCorso, 0, null));
		if (pos != -1) {
			return this.voti.get(pos);
		} else {
			return null;
		}
	}

	/**
	 * True se il corso specificato esiste nel libretto con la stessa valutazione
	 * 
	 * @param v il {@link Voto} da cercare
	 * @return l'esistenza di un duplicato
	 */
	public boolean isDuplicato(Voto v) {
		Voto esiste = this.cercaNomeCorso(v.getCorso());
		if (esiste == null) {
			return false;
		}
		/*
		 * if(esiste.getVoto()==v.getVoto()) { return true; }else { return false; }
		 */
		return (esiste.getVoto() == v.getVoto());
	}

	/**
	 * Se esiste Voto con lo stesso nome corso ma valutazione diversa
	 * 
	 * @param v
	 * @return
	 */
	public boolean isConflitto(Voto v) {
		Voto esiste = this.cercaNomeCorso(v.getCorso());
		if (esiste == null) {
			return false;
		}
		return (esiste.getVoto() != v.getVoto());
	}
	
	/**
	 * Restituisce un nuovo libretto migliorando i voti del libretto attuale
	 * @return
	 */
	public Libretto creaLibrettoMigliorato() {
		Libretto nuovo= new Libretto();
		
		for(Voto v:this.voti) {
			//Voto v2 = v;
			//Operazione sbagliata, non creo un nuovo oggetto cosi', v e v2 cosi' sono la stessa cosa
			
			//Voto v2=new Voto(v.getCorso()... non ci piace
			
			//Voto v2 = new Voto(v);
			//Questa operazione andava bene
			
			Voto v2=v.clone();
			
			if(v2.getVoto()>=24) {
				v2.setVoto(v2.getVoto()+2);
				if(v2.getVoto()>30) {
					v2.setVoto(30);
				}
			}else if(v2.getVoto()>=18){
				v2.setVoto(v2.getVoto()+1);
			}
			
			nuovo.add(v2);	
		}
		return nuovo;
	}
	
	/**
	 * riordina voti alfabeticamente per corso
	 */
	public void ordinaPerCorso() {
		Collections.sort(this.voti);
	}
	
	public void ordinaPerVoto() {
		Collections.sort(this.voti,new ConfrontaVotiPerValutazione());
	}
	
	/**
	 * elimina voti inferiori a 24
	 */
	public void cancellaVotiScarsi() {
		List<Voto> daRimuovere=new ArrayList<>();
		for(Voto v:this.voti) {
			if(v.getVoto()<24) {
				daRimuovere.add(v);
			}
		}
		/*for(Voto v:daRimuovere) {
			this.voti.remove(v);
		}*/
		//lo faccio sotto piu' easy
		
		/*for(Voto v:this.voti) {
			if(v.getVoto()<24) {
				this.voti.remove(v);
			}
		}*/
		//Cosi si incazza perche' modifica la lista mentre ci itero
		
		this.voti.removeAll(daRimuovere);
	}

}
