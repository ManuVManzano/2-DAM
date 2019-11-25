package PracticaUnidad2;

public class TipoAccion {
	public int tipo;
	public String descripcion;
	
	public TipoAccion() {
	}

	public TipoAccion(int tipo, String descripcion) {
		this.tipo = tipo;
		this.descripcion = descripcion;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void mostrar() {
		System.out.println("Tipo:"+tipo+"\tDescripcion:"+descripcion);
	}
}
