package PracticaUnidad2;

public class Partido {
	public int codigo;
	public Equipo local;
	public Equipo visitante;
	
	public Partido() {
	}

	public Partido(int codigo, Equipo local, Equipo visitante) {
		this.codigo = codigo;
		this.local = local;
		this.visitante = visitante;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Equipo getLocal() {
		return local;
	}

	public void setLocal(Equipo local) {
		this.local = local;
	}

	public Equipo getVisitante() {
		return visitante;
	}

	public void setVisitante(Equipo visitante) {
		this.visitante = visitante;
	}
	public void mostrar() {
		System.out.println("Codigo:"+codigo+"\tEquipo Local:"+local.getNombre()+"\tEquipo Visitante:"+visitante.getNombre());
	}
}
