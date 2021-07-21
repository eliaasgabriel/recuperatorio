package ar.edu.unlam.recuperatorio;

import static org.junit.Assert.*;

import org.junit.Test;

public class marvelTest {

	@Test
	public void queSePuedaAñadirUnPersonaje() throws PersonajeInexistente {
		Personaje thor = new Heroe("Thor", 20);
		Batalla nuevaYork = new Batalla();
		
		nuevaYork.agregarPersonaje(thor);
		assertEquals(thor, nuevaYork.buscarPersonaje("Thor"));
	}
	
	@Test
	public void queUnPersonajePuedaAumentarSuPoder() throws NoTieneGemaException {
		Personaje thor = new Heroe("Thor", 20);
		Gema poder = new Gema(TipoDeGema.PODER);
		thor.añadirGema(poder);
		thor.hechizarGema();
		
		assertEquals(60, thor.getPoder(), 0.01);
	}
	
	@Test(expected = WorldDestroyerException.class)
	public void queSePuedaSaberQuienGano() throws NoTieneGemaException, WorldDestroyerException, HuboUnEmpateException {
		Heroe thor = new Heroe("Thor", 20);
		Villano loki = new Villano("Loki", 30);
		Batalla nuevaYork = new Batalla();
		
		nuevaYork.enfrentarPersonajes(thor, loki);
		nuevaYork.obtenerGanador();
	}
	
	@Test(expected = NoSePuedenDarMasGemasException.class)
	public void queNoSePuedanRepartirMasDe6Gemas() throws NoSePuedenDarMasGemasException {
		Heroe thor = new Heroe("Thor", 20);
		Villano loki = new Villano("Loki", 30);
		Batalla nuevaYork = new Batalla();
		nuevaYork.repartirGemas(new Gema(TipoDeGema.ESPACIO));
		nuevaYork.repartirGemas(new Gema(TipoDeGema.TIEMPO));
		nuevaYork.repartirGemas(new Gema(TipoDeGema.PODER));
		nuevaYork.repartirGemas(new Gema(TipoDeGema.ALMA));
		nuevaYork.repartirGemas(new Gema(TipoDeGema.MENTE));
		nuevaYork.repartirGemas(new Gema(TipoDeGema.REALIDAD));
		nuevaYork.repartirGemas(new Gema(TipoDeGema.REALIDAD));
	}

}
