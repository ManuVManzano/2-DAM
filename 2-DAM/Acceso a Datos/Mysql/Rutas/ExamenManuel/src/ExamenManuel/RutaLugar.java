package ExamenManuel;

public class RutaLugar {
	public Ruta ruta;
	public Lugar lugar;
	
	public RutaLugar() {
	}

	public RutaLugar(Ruta ruta, Lugar lugar) {
		this.ruta = ruta;
		this.lugar = lugar;
	}

	public Ruta getRuta() {
		return ruta;
	}

	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}

	public Lugar getLugar() {
		return lugar;
	}

	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}
	public void mostrar() {
		System.out.println("Ruta:"+ruta.getId()+"\tLugar:"+lugar.getId());
	}
	
}
