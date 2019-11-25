package PracticaUnidad2;

public class Equipo {
	String nombre;
	String localidad;
	
	public Equipo() {
	}

	public Equipo(String nombre, String localidad) {
		this.nombre = nombre;
		this.localidad = localidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public void mostrar() {
		System.out.println("Nombre:"+nombre+"\tLocalidad:"+localidad);
	}
	
	
}
