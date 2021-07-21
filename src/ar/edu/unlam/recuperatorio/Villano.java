package ar.edu.unlam.recuperatorio;

import java.util.Comparator;

public class Villano extends Personaje implements Comparable<Villano>{

	public Villano(String nombre, Integer poderInicial) {
		super(nombre, poderInicial);
	}

	@Override
	public int compareTo(Villano o) {
		
		return this.getNombre().compareTo(o.getNombre());
	}


}
