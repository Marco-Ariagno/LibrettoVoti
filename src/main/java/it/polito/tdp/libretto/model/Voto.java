package it.polito.tdp.libretto.model;

import java.time.LocalDate;

/**
 * Classe voto, contiene info su un esame superato
 * @author Marco
 *
 */

public class Voto {
	
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
	
	
	

}
