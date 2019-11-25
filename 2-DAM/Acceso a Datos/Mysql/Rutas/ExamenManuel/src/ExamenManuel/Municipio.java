package ExamenManuel;

public class Municipio {
	public int id;
	public String nombre;
	public String provincia;
	
	public Municipio() {

	}

	public Municipio(int id, String nombre, String provincia) {
		this.id = id;
		this.nombre = nombre;
		this.provincia = provincia;
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

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	public void mostrar() {
		System.out.println("Id:"+id+"\tNombre:"+nombre+"\tProvincia:"+provincia);
	}
}
