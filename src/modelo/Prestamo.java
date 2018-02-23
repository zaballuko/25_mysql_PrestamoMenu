package modelo;

import java.util.Date;

public class Prestamo {
	private int id;
	private Libro libro;
	private Usuario usuario;
	private Date fechaPrestamo;
	private Date fechaLimite;
	
	public Prestamo(){
		
	}
	
	public Prestamo(int id, Libro libro, Usuario usuario, Date fechaPrestamo, Date fechaLimite){
		this.setId(id);
		this.setLibro(libro);
		this.setUsuario(usuario);
		this.setFechaPrestamo(fechaPrestamo);
		this.setFechaLimite(fechaLimite);
				
	}
	
	/**
	 * @return the libro
	 */
	public Libro getLibro() {
		return libro;
	}
	/**
	 * @param libro the libro to set
	 */
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	private boolean entregado;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}
	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}
	public Date getFechaLimite() {
		return fechaLimite;
	}
	public void setFechaLimite(Date fechaLimite) {
		this.fechaLimite = fechaLimite;
	}
	public boolean isEntregado() {
		return entregado;
	}
	public void setEntregado(boolean entregado) {
		this.entregado = entregado;
	}
	
	
	
}
