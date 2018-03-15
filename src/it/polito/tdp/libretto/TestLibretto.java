package it.polito.tdp.libretto;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class TestLibretto {
	
	public static void main(String [] args) {
		
		//LIBRETTO 1
		System.out.println("CREO PRIMO LIBRETTO");
		Libretto lib= new Libretto();
		lib.add(new Voto("Analisi 1", 18));
		lib.add(new Voto("Chimica", 18));
		lib.add(new Voto("Geometria", 20));
		lib.add(new Voto("Informatica", 29));
		lib.add(new Voto("Analisi 2", 18));
		lib.add(new Voto("Basi di dati", 21));
		lib.add(new Voto("Statistica", 18));
		lib.add(new Voto("Economia e organizzazione aziendale", 25));
		lib.add(new Voto("Sistemi di produzione", 21));
		lib.add(new Voto("Sistemi elettrici industriali", 18));
		lib.add(new Voto("Programmazione ad oggetti", 21));
		
		
		//--------------Stampa del libretto----------------
		/*System.out.println("Tutte le materie");
		lib.stampa();
		System.out.println("");*/
		System.out.println(lib.toString());
		
		
		//--------------Stampa voto=25---------------------
		System.out.println("Tutti le materie con voto = 25:");
		lib.stampa25();
		System.out.println("");
		
		
		//--------------Stampa voto dato l'esame-----------
		System.out.println("Voto di Informatica: "+lib.getMarkfromClass("Informatica"));
		System.out.println("");
		
		
		//-------------Inserisco esame e voto gia esistenti-------
		System.out.println("Reinserisco PO");
		lib.add(new Voto("Programmazione ad oggetti", 21));
		System.out.println("");
		
		
		//-------------Inserisco esame gia esistente ma con voto diverso-------
		System.out.println("Reinserisco PO ma con nuovo voto=22");
		lib.add(new Voto("Programmazione ad oggetti", 22));
		System.out.println("Programmazione ad oggetti: "+lib.getMarkfromClass("Programmazione ad oggetti"));
		System.out.println("");
		
		
		
		//LIBRETTO 2
		System.out.println("CREO SECONDO LIBRETTO");
		Libretto newLib = new Libretto(lib.getVoti());
		
		//--------------Stampa del libretto----------------
		/*System.out.println("Tutte le materie");
		newLib.stampa();
		System.out.println("");*/
		System.out.println(newLib.toString());
		
		
		//-------------Alzare i voti-----------------------
		newLib.alzaVoti();
		
		
		//--------------Stampa del libretto dopo aver alzato i voti----------------
		System.out.println("voti con alzamento");
		/*newLib.stampa();
		System.out.println("");*/
		System.out.println(newLib.toString());
		System.out.println("");
		
		
		//-------------Ordino alfabeticamente-----------------
		System.out.println("Ordinamento alfabetico");
		Collections.sort(newLib.getVoti());
		System.out.println(newLib.toString());
		System.out.println("");
		//Collections.sort va a cenrcare nell'oggetto della lista passata se esiste un comparatore appunto ne ho dovuto creare uno.
		//al posto di fare una classe comparatore, uno la stessa classe voto come comparatore e ci aggiungo il metodo compare to.
		
		
        //-------------Ordino alfabeticamente e per voto decrescente------------
		System.out.println("Ordinamento alfabeticamente e derescente per voto"); //Perche ormai ogni volta che faccio colletions.sort ordina sempre in ordine alfabetico
		Collections.sort(newLib.getVoti(), new Comparator<Voto>(){
																	public int compare(Voto o1, Voto o2) {
																		return -(o1.getVoto() - o1.getVoto( ));
																	}
																}
						);
		//O ci creo una nuova classe Comparatore che implementa Comparator e scrivo Collections.sort(newLib.getVoti(), Comparatore)
		//Oppure glie lo creo in quel momento come ho fatto, e gli creo subito dopo il metodo di comparazione (che mettere in Comparatore nel primo caso)
		//Tutto dentro le parentesi di sort!!!!
		//--------------Stampa del libretto dopo aver ordinato alfabeticamente e per voto----------------
		
				/*newLib.stampa();
				System.out.println("");*/
				System.out.println(newLib.toString());
				System.out.println("");
	}

}
