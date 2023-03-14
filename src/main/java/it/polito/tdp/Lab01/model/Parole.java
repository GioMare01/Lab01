package it.polito.tdp.Lab01.model;

import java.util.*;

public class Parole {
	
	List<String> elencoParole;
		
	public Parole() {
		this.elencoParole = new LinkedList<>();
	}
	
	public void addParola(String p) {
		elencoParole.add(p);
	}
	
	public List<String> getElenco() {
		Collections.sort(elencoParole);
		return elencoParole;
	}
	
	public void reset() {
		elencoParole.clear();
	}

	public void elimina(String parolaSelezionata) {
		elencoParole.remove(parolaSelezionata);
		/*
		 * List<String> copia = new LinkedList<String>(elencoParole); 
		 * for (String p: elencoParole) { 
		 * 		if (p.equals(parolaSelezionata)) { 
		 * 			copia.remove(p); 
		 * 		} 
		 * }
		 * elencoParole = copia;
		 * 
		 */
	}
}