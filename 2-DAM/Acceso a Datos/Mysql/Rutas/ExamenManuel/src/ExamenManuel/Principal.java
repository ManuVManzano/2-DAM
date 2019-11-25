package ExamenManuel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Principal {
	public static Scanner sc = new Scanner(System.in);
	public static Modelo rutas = new Modelo();
	public static void main(String[] args) {
		int opcion=0;
		do {
			System.out.println("0-Salir");
			System.out.println("1-Crear ruta");
			System.out.println("2-Añadir lugares a una ruta");
			System.out.println("3-Modificar la duración de una ruta");
			System.out.println("4-Crear lugar");
			System.out.println("5-Borrar lugar");
			opcion = sc.nextInt();sc.nextLine();
			int idRuta = 0;
			switch(opcion) {
			case 1:
				try {
					rutas.mostrarParajes();
					System.out.println("Introduce el id del paraje:");
					int idparaje = sc.nextInt();sc.nextLine();
					System.out.println("Introduce el color de la ruta");
					String color = sc.nextLine();
					System.out.println("FECHA:");
					System.out.println("Introduce el día:");
					int dia = sc.nextInt();sc.nextLine();
					System.out.println("Introduce el día:");
					int mes = sc.nextInt();sc.nextLine();
					System.out.println("Introduce el día:");
					int anio = sc.nextInt();sc.nextLine();
					SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
					Date fecha;
					fecha = formato.parse(dia+"-"+mes+"-"+anio);
					System.out.println("Introduce la duración de la ruta");
					int duracion= sc.nextInt();sc.nextLine();
					if(rutas.insertarRuta(idparaje,color,fecha,duracion)==1) {
					rutas.mostrarRutas();
					}
					else {
						System.out.println("Error al insertar la ruta");
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
			case 2:
				rutas.mostrarRutas();
				System.out.println("Introduce id de la ruta:");
				idRuta = sc.nextInt();sc.nextLine();
				if(rutas.comprobarIdRuta(idRuta)) {
					int idParaje = rutas.obtenerParaje(idRuta);
					rutas.mostrarLugaresParaje(idParaje);
					System.out.println("Introduce el id del lugar:");
					int idLugar = sc.nextInt();sc.nextLine();
					if(rutas.comprobarIdLugar(idLugar)) {
						if(!rutas.comprobarLugarRuta(idRuta,idLugar)) {
							if(!rutas.aniadirLugarRuta(idRuta,idLugar)) {
								System.out.println("Error al añadir el lugar a la ruta");
							}
							rutas.mostrarLugaresRuta(idRuta);
						}
						else {
							System.out.println("El lugar ya existe en la ruta");
						}
					}
					else {
						System.out.println("El id del lugar no existe");
					}
					
				}
				else {
					System.out.println("El id de la ruta no existe");
				}
				break;
			case 3:
				rutas.mostrarRutas();
				System.out.println("Introduce id de la ruta:");
				idRuta= sc.nextInt();sc.nextLine();
				if(!rutas.comprobarIdRuta(idRuta)) {
					System.out.println("El id de la ruta no existe");
				}
				else {
					System.out.println("Introduce la nueva duracion");
					int duracion = sc.nextInt();sc.nextLine();
					if(!rutas.modificarDuracionRuta(idRuta,duracion)) {
						System.out.println("Error al modificar la ruta");
					}
				}
				break;
			case 4:
				System.out.println("Nombre del lugar");
				String nombreLugar = sc.nextLine();
				rutas.mostrarParajes();
				System.out.println("Introduce id del paraje");
				int idParaje = sc.nextInt();sc.nextLine();
				rutas.mostrarMunicipios();
				System.out.println("Introduce el id del municipio");
				int idMunicipio = sc.nextInt();sc.nextLine();
				int resultado = rutas.crearLugar(nombreLugar,idParaje,idMunicipio);
				if(resultado == -1) {
					System.out.println("El paraje no existe");
				} 
				else if(resultado==-2) {
					System.out.println("El municipio no existe");
				}
				else {
					System.out.println("Lugar introducido con id:"+resultado);
				}
				
				break;
			case 5:
				rutas.mostrarLugares();
				System.out.println("Introduce el id del lugar a borrar:");
				int idLugar = sc.nextInt();sc.nextLine();
				if(!rutas.comprobarRutasLugar(idLugar)) {
					if(!rutas.borrarLugar(idLugar)) {
						System.out.println("Error al borrar el lugar");
					}
				}
				else {
					System.out.println("Error no se puede borrar el lugar,se encuentra en las siguientes rutas");
					rutas.mostrarRutaLugar(idLugar);
				}
				break;
			}
		}
		while(opcion!=0);
	}

}
