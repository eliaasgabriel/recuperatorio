package ar.edu.unlam.recuperatorio;

public class NoSePuedenDarMasGemasException extends Exception {

	public NoSePuedenDarMasGemasException() {
		super("No se pueden otorgar mas gemas");
	}
}
