package PracticaUnidad2;

public class Jugador {
	public int codigo;
	public Equipo equipo;
	public int dorsal;
	public String nombre;
	public String tipo;
	
	public Jugador() {
	}

	public Jugador(int codigo, Equipo equipo, int dorsal, String nombre, String tipo) {
		this.codigo = codigo;
		this.equipo = equipo;
		this.dorsal = dorsal;
		this.nombre = nombre;
		this.tipo = tipo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void mostrar() {
		System.out.println("Codigo:"+codigo+"\tEquipo:"+equipo.getNombre()+"\tDorsal:"+dorsal+"\tNombre:"+nombre+
				"\tTipo:"+tipo);
	}
	
}
