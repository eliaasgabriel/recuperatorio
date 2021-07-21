package ar.edu.unlam.recuperatorio;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Batalla {
	
	private Integer heroesConGemas = 0;
	private Integer villanosConGemas = 0;
	private Set<Personaje>personajes;
	private Set<Heroe> heroesGanadores;
	private Set<Villano> villanosGanadores;
	
	public Batalla() {
		this.heroesGanadores = new TreeSet<Heroe>();
		this.villanosGanadores = new TreeSet<Villano>(Collections.reverseOrder());
		this.personajes = new HashSet<Personaje>();
	}
	
	public void agregarPersonaje(Personaje p) {
		this.personajes.add(p);
	}
	
	public String obtenerGanador() throws WorldDestroyerException, HuboUnEmpateException{
		
		if(this.heroesGanadores.size() > this.villanosGanadores.size()) {
			return "Ganaron los heroes";
		}
		else if(this.heroesGanadores.size() < this.villanosGanadores.size()) {
			throw new WorldDestroyerException();
		}
		throw new HuboUnEmpateException();
	}
	
	
	public void enfrentarPersonajes(Heroe heroe, Villano villano) throws NoTieneGemaException {
		heroe.hechizarGema();
		villano.hechizarGema();
		
		if(heroe.getPoder() > villano.getPoder()) {
			heroesGanadores.add(heroe);
		}
		else {
			this.villanosGanadores.add(villano);
		}
		}
		
	
	
	public void repartirGemas(Gema gema) throws NoSePuedenDarMasGemasException  {
		
		for(Personaje p: personajes) {
			
			if(p instanceof Heroe) {
				if(this.heroesConGemas != 3) {
				p.añadirGema(gema);
				this.heroesConGemas++;
			}
			}
			if(p instanceof Villano) {
				p.añadirGema(gema);
				this.villanosConGemas++;
			}
			if(this.heroesConGemas == 3 && this.villanosConGemas == 3) {
				throw new NoSePuedenDarMasGemasException();
			}
		}
	}
	
	public Personaje buscarPersonaje(String nombre) throws PersonajeInexistente {
		for(Personaje p : personajes) {
			if(p.getNombre().equals(nombre)) {
				return p;
			}
		}
		throw new PersonajeInexistente();
	}
	public Set<Heroe> obtenerHeroesGanadores(){
		return this.heroesGanadores;
	}
	
	public Set<Villano> obtenerVillanosGanadores(){
		return this.villanosGanadores;
	}
}
