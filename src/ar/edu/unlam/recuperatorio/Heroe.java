package ar.edu.unlam.recuperatorio;

public class Heroe extends Personaje implements Comparable<Heroe>{

	public Heroe(String nombre, Integer poderInicial) {
		super(nombre, poderInicial);
	}

	@Override
	public int compareTo(Heroe o) {
		return this.getNombre().compareTo(o.getNombre());
	}

}
