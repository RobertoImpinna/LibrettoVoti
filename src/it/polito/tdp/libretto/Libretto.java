package it.polito.tdp.libretto;

import java.util.ArrayList;
import java.util.List;

public class Libretto {
	
	private List <Voto> voti;
	
	public Libretto() {
		this.voti=new ArrayList<>();
	}
	
	public Libretto (List<Voto> voti) {
//  #1 ShallowCopy--> stesso oggetto (lista), una modifica ad una lista comporta la modifica anche all'altra lista pur essendo in due oggetti differenti
//  this.voti=voti;
		
//  #2 ShallowCopy--> stesso oggetto (lista), una modifica ad una lista comporta la modifica anche all'altra lista pur essendo in due oggetti differenti
//  this.voti= new ArrayList<Voto>();
		
//  #3 ShallowCopy--> stesso oggetto (lista), una modifica ad una lista comporta la modifica anche all'altra lista pur essendo in due oggetti differenti
//  this.voti=new ArrayList<Voto>();
//  for(Voto v: voti){
//		this.voti.add(v);
//	}
		
//  #4 DeepCopy--> due oggetti differenti (lista)
//  this.voti=new ArrayList<Voto>();
//  for(Voto v: voti){
//			this.voti.add(new Voto(v.getEsame(), v.getVoto()));
//		}
//  che sarebbe a dire 

		this.voti=new ArrayList<Voto>();
		this.voti=voti; //l'uguale permette ciò
	}
	
	public void add(Voto v) {
		if (this.voti.contains(v)) { //per fare questo ho dovtuo riscrivere equals and hashcode di voto
			System.out.println("Il voto esiste già");
			return;
		}
		for(Voto voto: this.voti) {
			if(v.getEsame().equals(voto.getEsame())){
				System.out.println("Trovato lo stesso esame, aggiorno il voto");
				voto.setVoto(v.getVoto());
				return;
			}
			
		}
		this.voti.add(v);
	}
	
	public void stampa() {
		System.out.println("Ci sono "+voti.size()+" voti");
		for(Voto v:this.voti) {
			System.out.println(v);
		}
	}
	
	public void stampa25() {
		for(Voto v: voti) {
			if(v.getVoto()==25) {
				System.out.println(v);
			}
		}
	}
	
	
	public List<Voto> getVoti()
	{
		return this.voti;
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder(); //Serve per concatenare più stringhe insieme
		sb.append("Ci sono "+voti.size()+"\n");
		for(Voto v:this.voti) {
			sb.append(v.toString());
			sb.append("\n");
		}
	return sb.toString(); 
	}

	public String getMarkfromClass(String nomeCorso) {
		for(Voto v: this.voti) {
			if(v.getEsame().toLowerCase().equals(nomeCorso.toLowerCase()))
				return String.valueOf(v.getVoto());
		}
		return "Class name not found";
	}

	public void alzaVoti() {
		for(Voto v: this.voti) {
			if(v.getVoto()>= 24)
				v.setVoto(v.getVoto()+2);
			else if(v.getVoto()>=18)
				v.setVoto(v.getVoto()+1);
		}
	}

	
	
}
