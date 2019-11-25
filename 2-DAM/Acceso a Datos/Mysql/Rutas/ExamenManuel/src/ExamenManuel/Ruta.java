package ExamenManuel;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ruta {
	public int id;
	public Paraje paraje;
	public String color;
	public Date fecha;
	public int duracion;
	
	public Ruta() {
	}

	public Ruta(int id, Paraje paraje, String color, Date fecha, int duracion) {
		this.id = id;
		this.paraje = paraje;
		this.color = color;
		this.fecha = fecha;
		this.duracion = duracion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Paraje getParaje() {
		return paraje;
	}

	public void setParaje(Paraje paraje) {
		this.paraje = paraje;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public void mostrar() {
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		System.out.println("Id:"+id+"\tParaje:"+paraje.getId()+"\tColor:"+color+"\tFecha:"+formato.format(fecha)+"\tDuracion:"+duracion);
	}
	
}
