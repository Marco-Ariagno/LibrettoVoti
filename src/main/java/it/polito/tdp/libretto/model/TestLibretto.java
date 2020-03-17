package it.polito.tdp.libretto.model;

import java.time.LocalDate;

public class TestLibretto {
	
	Libretto lib;
	
	private void run() {
		//faccio tutto il lavoro dentro il metodo run, non si lavora dentro il main
		//perche' lo static del metodo main ci limita
		//MAI NEL MAIN
		
		this.lib=new Libretto();  //creo libretto nuovo
		
		Voto v1=new Voto("Tecniche di Programmazione", 30, LocalDate.of(2020,06,15));
		Voto v2=new Voto("Analisi II", 28, LocalDate.of(2020, 06, 22));
		
		lib.add(v1);
		lib.add(v2);
		lib.add(new Voto("Economia", 24, LocalDate.of(2020, 02, 14)));
		
		System.out.println(this.lib);
		
		System.out.println(this.lib.stampaVotiUguali(28));
		
		System.out.println(this.lib.estraiVotiUguali(28));
	}

	public static void main(String[] args) {
		TestLibretto test=new TestLibretto();
		test.run();
	}

}
