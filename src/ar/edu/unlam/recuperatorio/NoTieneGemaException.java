package ar.edu.unlam.recuperatorio;

public class NoTieneGemaException extends Exception {
	
	public NoTieneGemaException() {
		super("El personaje no posee una gema");
	}
}
