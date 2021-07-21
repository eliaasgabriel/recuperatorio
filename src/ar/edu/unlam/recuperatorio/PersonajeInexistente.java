package ar.edu.unlam.recuperatorio;

public class PersonajeInexistente extends Exception {
	
	public PersonajeInexistente() {
		super("El personaje no existe");
	}
}
