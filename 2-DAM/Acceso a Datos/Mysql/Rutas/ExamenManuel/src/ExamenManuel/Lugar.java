package ExamenManuel;

public class Lugar {
	public int id;
	public String nombre;
	public Paraje paraje;
	public Municipio municipio;
	
	public Lugar() {
	}
	public Lugar(int id, String nombre, Paraje paraje, Municipio municipio) {
		this.id = id;
		this.nombre = nombre;
		this.paraje = paraje;
		this.municipio = municipio;
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
	public Paraje getParaje() {
		return paraje;
	}
	public void setParaje(Paraje paraje) {
		this.paraje = paraje;
	}
	public Municipio getMunicipio() {
		return municipio;
	}
	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}
	public void mostrar() {
		System.out.println("Id:"+id+"\tNombre:"+nombre+"\tParaje:"+paraje.getId()+"\tMunicipio:"+municipio.getId());
	}
	
}
