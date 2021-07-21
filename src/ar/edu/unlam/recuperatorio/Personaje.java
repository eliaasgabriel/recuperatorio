package ar.edu.unlam.recuperatorio;

import java.util.HashSet;
import java.util.Set;

public abstract class Personaje {
	
	private Integer poder = 0;
	private String nombre = "";
	private Set<Gema> gemas;
	
	public Personaje(String nombre, Integer poderInicial) {
		this.nombre = nombre;
		this.poder = poderInicial;
		this.gemas = new HashSet<Gema>();
	}
	
	
	public Integer getPoder() {
		return poder;
	}


	public String getNombre() {
		return nombre;
	}


	public void setPoder(Integer poder) {
		this.poder = poder;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void hechizarGema() throws NoTieneGemaException {
		
		for(Gema g: gemas) {
			if(g.getTipo().equals(TipoDeGema.TIEMPO) || g.getTipo().equals(TipoDeGema.MENTE) || g.getTipo().equals(TipoDeGema.PODER)) {
				this.poder *=3;
			}
			else if(g.getTipo().equals(TipoDeGema.ESPACIO) || g.getTipo().equals(TipoDeGema.ALMA) || g.getTipo().equals(TipoDeGema.REALIDAD)){
				this.poder *=2;
			}
			else {
				throw new NoTieneGemaException();
			}
			
		}
	}


	public void añadirGema(Gema g) {
		// TODO Auto-generated method stub
		this.gemas.add(g);
	}
	
}
