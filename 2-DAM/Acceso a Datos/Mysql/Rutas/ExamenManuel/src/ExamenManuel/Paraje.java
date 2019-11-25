package ExamenManuel;

public class Paraje {
	public int id;
	public String nombre;
	public int hectareas;
	
	public Paraje() {

	}

	public Paraje(int id, String nombre, int hectareas) {
		this.id = id;
		this.nombre = nombre;
		this.hectareas = hectareas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getHectareas() {
		return hectareas;
	}

	public void setHectareas(int hectareas) {
		this.hectareas = hectareas;
	}
	public void mostrar() {
		System.out.println("Id:"+id+"\tNombre:"+nombre+"\tHectareas:"+hectareas);
	}
	
}
