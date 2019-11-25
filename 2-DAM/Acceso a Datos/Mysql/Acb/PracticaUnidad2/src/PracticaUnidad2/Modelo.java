package PracticaUnidad2;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Modelo {
	private Connection conexion =null;
	private String url = "jdbc:mysql://localhost:3306/acb?serverTimezone=Europe/Madrid";
	private String usuario="root";
	private String clave ="root";
	
	public Modelo() {
		//Cargar el driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Crear la conexion
			conexion = DriverManager.getConnection(url,usuario,clave);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}

	public void cerrar() {
		try {
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void mostrarPartidos() {
		
		try {
			PreparedStatement sentencia = conexion.prepareStatement("select * from partido");
			ResultSet r = sentencia.executeQuery();
			while(r.next()) {
				Partido p = new Partido(r.getInt(1),new Equipo(r.getString(2),null),new Equipo(r.getString(3),null));
				p.mostrar();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void mostrarTipoAcciones() {
		try {
			PreparedStatement sentencia = conexion.prepareStatement("select * from tipoaccion");
			ResultSet r = sentencia.executeQuery();
			while(r.next()) {
				TipoAccion ta = new TipoAccion(r.getInt(1),r.getString(2));
				ta.mostrar();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public Partido establecerPartido(int codigoPartido) {
		PreparedStatement sentencia;
		Partido p = null;
		try {
			sentencia = conexion.prepareStatement("select * from partido where codigo = ? ");
			sentencia.setInt(1, codigoPartido);
			ResultSet r = sentencia.executeQuery();
			if(r.next()) {
				 p = new Partido(r.getInt(1),new Equipo(r.getString(2),null),new Equipo(r.getString(3),null));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return p;
	}

	public void mostrarJugadoresPartido(Partido p) {
		try {
			PreparedStatement sentencia = conexion.prepareStatement("select * from jugador where equipo = ? or equipo = ? order by codigo and equipo");
			sentencia.setString(1, p.getLocal().getNombre());
			sentencia.setString(2, p.getVisitante().getNombre());
			ResultSet r = sentencia.executeQuery();
			while(r.next()) {
				Jugador j = new Jugador(r.getInt(1),new Equipo(r.getString(2),null),r.getInt(3),r.getString(4),r.getString(5));
				j.mostrar();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public boolean generarAccion(Partido p, TipoAccion t, Jugador j) {
		boolean resultado= true;
		try {
			PreparedStatement sentencia = conexion.prepareStatement("insert into accion values(null,?,?,?,?)");
			sentencia.setInt(1, p.getCodigo());
			sentencia.setInt(2, t.getTipo());
			sentencia.setInt(3, j.getCodigo());
			sentencia.setBoolean(4, false);
			int r = sentencia.executeUpdate();
			if(r==1) {
				resultado=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}

	public void mostrarAcciones() {
		try {
			PreparedStatement sentencia = conexion.prepareStatement("select * from accion");
			ResultSet r = sentencia.executeQuery();
			while(r.next()) {
				Accion a = new Accion(r.getInt(1),new Partido(r.getInt(2),null,null),new TipoAccion(r.getInt(3),null),
						new Jugador(r.getInt(4),new Equipo(null,null),0,null,null),r.getBoolean(5));
				a.mostrar();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public boolean anularAccion(int codAccion) {
		boolean resultado= true;
		try {
			PreparedStatement sentencia = conexion.prepareStatement("update accion set anulada = true where codigo = ?");
			sentencia.setInt(1,codAccion);
			int r = sentencia.executeUpdate();
			if(r==1) {
				resultado=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
		
	}

	public boolean comprobarAccionesPartido(int codigoPartido) {
		boolean resultado = false;
		try {
			PreparedStatement sentencia = conexion.prepareStatement("select * from accion where partido = ?");
			sentencia.setInt(1,codigoPartido);
			ResultSet r = sentencia.executeQuery();
			if(r.next()) {
				resultado=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}

	public boolean borrarPartido(int codigoPartido) {
		boolean resultado = true;
		try {
			PreparedStatement sentencia = conexion.prepareStatement("delete from partido where codigo = ?");
			sentencia.setInt(1,codigoPartido);
			int r = sentencia.executeUpdate();
			if(r==1) {
				resultado=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}

	public boolean generarEstadistica(Partido p) {
		boolean resultado = false;
		try {
			CallableStatement rutina = conexion.prepareCall("call obtenerEstadistica(?)");
			rutina.setInt(1, p.getCodigo());
			ResultSet r = rutina.executeQuery();
			
			if(r.next()) {
				System.out.println("Puntos Local:"+r.getInt(1)+"\tPuntos Visitante:"+r.getInt(2)+
						"\nCanastas1 Local:"+r.getInt(3)+"\tCanastas1 Visitante:"+r.getInt(4)+
						"\nCanastas2 Local:"+r.getInt(5)+"\tCanastas2 Visitante:"+r.getInt(6)+
						"\nCanastas3 Local:"+r.getInt(7)+"\tCanastas3 Visitante:"+r.getInt(8));
				resultado=true;
			
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}
}
