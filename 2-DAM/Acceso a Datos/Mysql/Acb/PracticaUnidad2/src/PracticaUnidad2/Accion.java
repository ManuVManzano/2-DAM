package PracticaUnidad2;

public class Accion {
	public int codigo;
	public Partido partido;
	public TipoAccion tipo;
	public Jugador jugador;
	public boolean anulada;
	
	public Accion() {
		super();
	}

	public Accion(int codigo, Partido partido, TipoAccion tipo, Jugador jugador, boolean anulada) {
		super();
		this.codigo = codigo;
		this.partido = partido;
		this.tipo = tipo;
		this.jugador = jugador;
		this.anulada = anulada;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	public TipoAccion getTipo() {
		return tipo;
	}

	public void setTipo(TipoAccion tipo) {
		this.tipo = tipo;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public boolean isAnulada() {
		return anulada;
	}

	public void setAnulada(boolean anulada) {
		this.anulada = anulada;
	}
	public void mostrar() {
		System.out.println("Codigo:"+codigo+"\tPartido:"+partido.getCodigo()+"\tTipo:"+tipo.getTipo()+"\tJugador:"+jugador.getCodigo()
		+"\tAnulada:"+anulada);
	}
	
}
