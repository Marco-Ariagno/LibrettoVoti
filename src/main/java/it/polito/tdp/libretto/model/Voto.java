package it.polito.tdp.libretto.model;

import java.time.LocalDate;

/**
 * Classe voto, contiene info su un esame superato
 * @author Marco
 *
 */

public class Voto implements Comparable<Voto>{
	
	private String corso;  // "Tecniche di Programmazione"
	private int voto;  // 28
	private LocalDate date;   //  15/06/2020
	/**
	 * Costruisce un nuovo Voto
	 * 
	 * @param corso nome corso superato
	 * @param voto valore voto acquisito
	 * @param date data superamento esame
	 */
	public Voto(String corso, int voto, LocalDate date) {
		super();
		this.corso = corso;
		this.voto = voto;
		this.date = date;
	}
	
	/**
	 * Copy constructor di {@link Voto}, copiando il contenuto del parametro {@code v}
	 * @param v il Voto da copiare
	 */
	public Voto(Voto v) {
		this.corso=new String(v.corso);
		this.date=v.date;
		this.voto=v.voto;
	}
	
	
	public String getCorso() {
		return corso;
	}
	public void setCorso(String corso) {
		this.corso = corso;
	}
	public int getVoto() {
		return voto;
	}
	public void setVoto(int voto) {
		this.voto = voto;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return corso +": " +voto + " (" + date+")";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((corso == null) ? 0 : corso.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voto other = (Voto) obj;
		if (corso == null) {
			if (other.corso != null)
				return false;
		} else if (!corso.equals(other.corso))
			return false;
		return true;
	}
	
	/**
	 * crea una copia dell'oggetto presente (this), come nuovo oggetto
	 */
	public Voto clone() {
		Voto v=new Voto(this.corso,this.voto, this.date);
		return v;
	}
	
	public int compareTo(Voto other) {
		return this.corso.compareTo(other.getCorso());
	}

}
