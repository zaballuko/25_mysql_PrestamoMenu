package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class PrestamoModelo extends Conector{

	LibroModelo libroModelo = new LibroModelo();
	UsuarioModelo usuarioModelo = new UsuarioModelo();
	ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
	
	public void insertar(Prestamo prestamo){
		try {
			PreparedStatement pst = super.conexion.prepareStatement("insert into prestamos (id_libro, id_usuario, fecha_prestamo, fecha_limite, entregado) values(?,?,?,?,?)");
			pst.setInt(1, prestamo.getLibro().getId());
			pst.setInt(2, prestamo.getUsuario().getId());
			pst.setDate(3, new java.sql.Date(prestamo.getFechaPrestamo().getTime()));
			pst.setDate(4, new java.sql.Date(prestamo.getFechaLimite().getTime()));
			pst.setBoolean(5, prestamo.isEntregado());
			pst.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<Prestamo> selectAll(){
		Statement st;
		Prestamo prestamo;
		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
		try {
			st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from prestamos");
			while(rs.next()){
				prestamo = new Prestamo();
				prestamo.setId(rs.getInt("id"));
				prestamo.setLibro(libroModelo.select(rs.getInt("id")));
				prestamo.setUsuario(usuarioModelo.select(rs.getInt("id")));
				prestamo.setFechaPrestamo(rs.getDate("fecha_prestamo"));
				prestamo.setFechaLimite(rs.getDate("fecha_limite"));
				prestamo.setEntregado(rs.getBoolean("entregado"));
				
				prestamos.add(prestamo);
			
			}
			return prestamos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prestamos;
	}


//	public Prestamo selectPorLibroUsuario(Libro libro, Usuario usuario) {
//		
//		PreparedStatement pst = super.conexion.prepareStatement("select * from prestamos where libro, usuario = ?,?");
//		pst.setInt(1, libro);
//		pst.setString(2, usuario);
//		ResultSet rs = pst.executeQuery();
//		
//		
//		return prestamo;
//	}
}
