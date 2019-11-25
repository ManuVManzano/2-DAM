package PracticaUnidad2;

import java.util.Scanner;


public class Principal {
	private static Modelo acb = new Modelo();
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int opcion=0;
		int codigoPartido = 0;
			Partido p = new Partido();
		do {
			System.out.println("0-Salir");
			System.out.println("1-Seleccionar partido");
			System.out.println("2-Registrar Accion");
			System.out.println("3-Anular accion");
			System.out.println("4-Borrar Partido");
			System.out.println("5-Mostrar estadistica partido");
			opcion = sc.nextInt();sc.nextLine();
			switch(opcion) {
			case 1:
				acb.mostrarPartidos();
				System.out.println("Elige un partido");
				codigoPartido=sc.nextInt();sc.nextLine();
				p = acb.establecerPartido(codigoPartido);
				break;
			case 2:
				if(codigoPartido==0) {
					System.out.println("Error no hay partido seleccionado");
				}
				else {
					acb.mostrarTipoAcciones();
					System.out.println("Elige una accion");
					TipoAccion t = new TipoAccion(sc.nextInt(),null);sc.nextLine();
					acb.mostrarJugadoresPartido(p);
					System.out.println("Elige un jugador:");
					Jugador j = new Jugador();
					j.setCodigo(sc.nextInt());sc.nextLine();
					if(!acb.generarAccion(p,t,j)) {
						System.out.println("Error al registrar la accion");
					}
					
				}
				break;
			case 3:
				acb.mostrarAcciones();
				System.out.println("Introduce codigo accion a anular");
				int codigoAccion = sc.nextInt();sc.nextLine();
				if(!acb.anularAccion(codigoAccion)) {
					System.out.println("Error al anular la accion");
				}
				break;
			case 4:
				acb.mostrarPartidos();
				System.out.println("Introduce codigo de partido:");
				codigoPartido=sc.nextInt();sc.nextLine();
				if(!acb.comprobarAccionesPartido(codigoPartido)) {
					if(!acb.borrarPartido(codigoPartido)) {
						System.out.println("Error no se ha borrado el partido");
					}
					else {
						System.out.println("Partido borrado correctamente");
					}
				}
				else {
					System.out.println("El partido tiene acciones, no se puede borrar");
				}	
				break;
			case 5:
				if(codigoPartido==0) {
					System.out.println("Error no hay partido seleccionado");
				}
				else {
				if(!acb.generarEstadistica(p)) {
					System.out.println("Error al generar la estadistica");
				}
				}
				break;
			}
		}
		while(opcion!=0);
	}

}
