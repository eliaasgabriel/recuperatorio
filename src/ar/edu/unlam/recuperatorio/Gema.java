package ar.edu.unlam.recuperatorio;

public class Gema {
	
	private TipoDeGema tipo;
	
	public Gema(TipoDeGema tipo) {
		this.tipo = tipo;
	}

	public TipoDeGema getTipo() {
		return tipo;
	}

	public void setTipo(TipoDeGema tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gema other = (Gema) obj;
		if (tipo != other.tipo)
			return false;
		return true;
	}
	
	
}
