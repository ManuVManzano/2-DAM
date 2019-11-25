package ExamenManuel;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Modelo {
	private Connection conexion =null;
	private String url = "jdbc:mysql://localhost:3306/rutas?serverTimezone=Europe/Madrid";
	private String usuario="root";
	private String clave ="root";
	public Modelo() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
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
	public void mostrarParajes() {
		try {
			PreparedStatement sentencia = conexion.prepareStatement("select * from paraje");
			ResultSet r = sentencia.executeQuery();
			while(r.next()) {
				Paraje p = new Paraje(r.getInt(1),r.getString(2),r.getInt(3));
				p.mostrar();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public int insertarRuta(int idparaje, String color, Date fecha, int duracion) {
		int resultado =0;
		try {
			PreparedStatement sentencia = conexion.prepareStatement("insert into ruta values(null,?,?,?,?)");
			sentencia.setInt(1, idparaje);
			sentencia.setString(2, color);
			sentencia.setDate(3, new java.sql.Date(fecha.getTime()));
			sentencia.setInt(4, duracion);
			resultado = sentencia.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}
	
	public void mostrarRutas() {
		try {
			PreparedStatement sentencia = conexion.prepareStatement("select * from ruta");
			ResultSet r = sentencia.executeQuery();
			while(r.next()) {
				java.util.Date fecha =new Date(r.getDate(4).getTime());
				Ruta ru = new Ruta(r.getInt(1), new Paraje(r.getInt(2),null,0), r.getString(3), 
						fecha, r.getInt(5));
				ru.mostrar();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	public boolean comprobarIdRuta(int idRuta) {
		boolean resultado = false;
		try {
			PreparedStatement sentencia = conexion.prepareStatement("select * from ruta where id = ?");
			sentencia.setInt(1, idRuta);
			ResultSet r = sentencia.executeQuery();
			if(r.next()) {
				resultado =true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}
	public boolean modificarDuracionRuta(int idRuta, int duracion) {
		boolean resultado = true;
		try {
			PreparedStatement sentencia = conexion.prepareStatement("update ruta set duracion = ? where id = ?");
			sentencia.setInt(1, duracion);
			sentencia.setInt(2, idRuta);
			int r = sentencia.executeUpdate();
			if(r==1) {
				resultado = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}
	public int obtenerParaje(int idRuta) {
		int idParaje=0;
		try {
			PreparedStatement sentencia = conexion.prepareStatement("select paraje from ruta where id = ?");
			sentencia.setInt(1, idRuta);
			ResultSet r = sentencia.executeQuery();
			if(r.next()) {
				idParaje = r.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idParaje;
	}
	public void mostrarLugaresParaje(int idParaje) {
		try {
			PreparedStatement sentencia = conexion.prepareStatement("select * from lugar where paraje = ? ");
			sentencia.setInt(1, idParaje);
			ResultSet r = sentencia.executeQuery();
			while(r.next()) {
				Lugar l = new Lugar(r.getInt(1), r.getString(2),new Paraje(r.getInt(3),null,0), 
						new Municipio(r.getInt(4),null, null));
				l.mostrar();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public boolean comprobarIdLugar(int idLugar) {
		boolean resultado = false;
		try {
			PreparedStatement sentencia = conexion.prepareStatement("select * from lugar where id = ?");
			sentencia.setInt(1, idLugar);
			ResultSet r = sentencia.executeQuery();
			if(r.next()) {
				resultado =true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}
	public boolean comprobarLugarRuta(int idRuta, int idLugar) {
		boolean resultado = false;
		try {
			PreparedStatement sentencia = conexion.prepareStatement("select * from ruta_lugar where ruta = ? and lugar = ?");
			sentencia.setInt(1, idRuta);
			sentencia.setInt(2, idLugar);
			ResultSet r = sentencia.executeQuery();
			if(r.next()) {
				resultado =true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}
	public boolean aniadirLugarRuta(int idRuta, int idLugar) {
		boolean resultado = false;
		try {
			PreparedStatement sentencia = conexion.prepareStatement("insert into ruta_lugar values(?,?)");
			sentencia.setInt(1, idRuta);
			sentencia.setInt(2, idLugar);
			int r = sentencia.executeUpdate();
			if(r==1) {
				resultado =true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}
	public void mostrarLugaresRuta(int idRuta) {
		try {
			PreparedStatement sentencia = conexion.prepareStatement("select * from ruta_lugar rl join lugar "
					+ "l on rl.lugar = l.id where rl.ruta= ? ");
			sentencia.setInt(1, idRuta);
			ResultSet r = sentencia.executeQuery();
			while(r.next()) {
				Lugar l = new Lugar(r.getInt(3), r.getString(4),new Paraje(r.getInt(5),null,0), 
						new Municipio(r.getInt(6),null, null));
				l.mostrar();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void mostrarMunicipios() {
		try {
			PreparedStatement sentencia = conexion.prepareStatement("select * from municipio");
			ResultSet r = sentencia.executeQuery();
			while(r.next()) {
				Municipio m = new Municipio(r.getInt(1), r.getString(2), r.getString(3));
				m.mostrar();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	public int crearLugar(String nombreLugar, int idParaje, int idMunicipio) {
		int resultado = 0;
		try {
			CallableStatement rutina = conexion.prepareCall("{?=call crear_lugar(?,?,?)}");
			rutina.registerOutParameter(1, java.sql.Types.INTEGER);
			rutina.setString(2, nombreLugar);
			rutina.setInt(3, idParaje);
			rutina.setInt(4, idMunicipio);
			rutina.executeUpdate();
			resultado = rutina.getInt(1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}
	public void mostrarLugares() {
		try {
			PreparedStatement sentencia = conexion.prepareStatement("select * from lugar");
			ResultSet r = sentencia.executeQuery();
			while(r.next()) {
				Lugar l = new Lugar(r.getInt(1), r.getString(2), 
						new Paraje(r.getInt(3),null,0), new Municipio(r.getInt(4), null, null));
				l.mostrar();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	public boolean comprobarRutasLugar(int idLugar) {
		boolean resultado = false;
		try {
			PreparedStatement sentencia = conexion.prepareStatement("select ruta from ruta_lugar where lugar = ?");
			sentencia.setInt(1, idLugar);
			ResultSet r = sentencia.executeQuery();
			if(r.next()) {
				resultado = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return resultado;
	}
	public boolean borrarLugar(int idLugar) {
		boolean resultado = false;
		try {
			PreparedStatement sentencia = conexion.prepareStatement("delete from lugar where id = ?");
			sentencia.setInt(1, idLugar);
			int r = sentencia.executeUpdate();
			if(r == 1) {
				resultado = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return resultado;
	}
	public void mostrarRutaLugar(int idLugar) {
		try {
			PreparedStatement sentencia = conexion.prepareStatement("select * from ruta_lugar rl join ruta r on rl.ruta = r.id "
					+ "where rl.lugar = ?");
			sentencia.setInt(1, idLugar);
			ResultSet r = sentencia.executeQuery();
			while(r.next()) {
				java.util.Date fecha =new Date(r.getDate(6).getTime());
				Ruta ru = new Ruta(r.getInt(3), new Paraje(r.getInt(4), null, 0), r.getString(5), 
						fecha, r.getInt(7));
				ru.mostrar();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	

	
}
