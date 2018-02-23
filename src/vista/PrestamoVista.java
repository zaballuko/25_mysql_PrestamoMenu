package vista;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import javax.management.modelmbean.ModelMBeanOperationInfo;

import comparator.TituloComparator;
import modelo.Libro;
import modelo.LibroModelo;
import modelo.Prestamo;
import modelo.PrestamoModelo;
import modelo.Usuario;
import modelo.UsuarioModelo;

public class PrestamoVista {

	static final int TOMAR_PRESTADO = 1;
	static final int ENTREGAR = 2;
	static final int SALIR = 0;
	
	public void menuPrestamo(){
		int opcion;
		Scanner scan = new Scanner(System.in);
		do{
			System.out.println("--Prestamos--");
			System.out.println(TOMAR_PRESTADO + " tomar prestado un libro");
			System.out.println(ENTREGAR + " entregar un libro");
			opcion = Integer.parseInt(scan.nextLine());
			
			switch (opcion) {
			case TOMAR_PRESTADO:
				realizarPrestamo(scan);
				break;
			case ENTREGAR:
				
				break;
			default:
				break;
			}
			
		}while(opcion != SALIR);	
	}

	
	
	private void realizarPrestamo(Scanner scan) {
		System.out.println("Introduce el titulo del libro");
		String titulo = scan.nextLine();
		LibroModelo libroModelo = new LibroModelo();
		Libro libro = libroModelo.selectPorTitulo(titulo);
		
		if(libro != null){//el libro existe
			System.out.println("Introduce el DNI");
			String dni = scan.nextLine();
			UsuarioModelo usuarioModelo = new UsuarioModelo();
			Usuario usuario = usuarioModelo.selectPorDni(dni);
			
			//crear el objeto prestamo 
			Prestamo prestamo = new Prestamo();

			prestamo.getLibro().getId();
			prestamo.getUsuario().getId();
			
			Date fechaPrestamo = new Date();
			//limite es el dia de hoy mas 21 dias
			Date fechaLimite = new Date(fechaPrestamo.getTime()+(21*24*60*60*1000));
			prestamo.setFechaPrestamo(fechaPrestamo);
			prestamo.setFechaLimite(fechaLimite);
			
			prestamo.setEntregado(false);
			
			
			//crear el objeto modeloprestamo
			PrestamoModelo prestamoModelo = new PrestamoModelo();
			//insertar prestamo utilizando modeloPrestamo
			prestamoModelo.insertar(prestamo);
			System.out.println("Prestamo realizado");
			
		}else{//el libro no existe
			System.out.println("Prestamo no realizado, el libro no existe");
		}
		
	}
	
	private void entregarLibro(Scanner scan){
		
		//pides el dni
		
		System.out.println("Introduce el dni");
		String dni = scan.nextLine();
		String titulo = scan.nextLine();
		
		//Conseguir usuario
		UsuarioModelo usuarioModelo = new UsuarioModelo();
		Usuario usuario = usuarioModelo.selectPorDni(dni);
		
		//pedir el titulo
		System.out.println("Introduce el titulo del libro");
		LibroModelo libroModelo = new LibroModelo();
		Libro libro = libroModelo.selectPorTitulo(titulo);
		
		//Seleccionar Prestamo
		PrestamoModelo prestamoModelo = new PrestamoModelo();
//		Prestamo prestamo = prestamoModelo.selectPorLibroUsuario(libro, usuario);
		
		//cambiar objeto prestamo a entregado
		
//		if (prestamo != null){
//			prestamo.setEntregado(prestamo);
//		}
		
		//hacer el update
//		prestamoModelo.update(prestamo);
		System.out.println("El libro " + libro.getTitulo()+"ha sido entregado");
		
		
	}
	
	public void listarPrestamo(ArrayList <Prestamo> prestamos){
		//recorrer el array y listar los prestamos
		
		Iterator<Prestamo> i = prestamos.iterator();
		while (i.hasNext()) {
		Prestamo prestamo = i.next();
		
		System.out.println(prestamo.getId() + ""+ prestamo.getLibro().getTitulo()+""
		+	prestamo.getLibro().getAutor()+""
		+prestamo.getUsuario() +""
		+ prestamo.getUsuario().getNombre()+""
		+prestamo.getUsuario().getApellido()+""
		+prestamo.getFechaPrestamo()+""
		+prestamo.getFechaLimite());
		
		if (prestamo.isEntregado()== true) { 
			System.out.println("Entregado");
			
		}else{
			System.out.println("No Entregado");	
		}
		
	}
	}
	
	
//	public void menulistar(){
//		int opcion;
//		Scanner scan = new Scanner(System.in);
//		final int LISTAR= 1 ;
//		do{
//			System.out.println("--LISTAR--");
//			System.out.println(LISTAR + "Listar por Titulo");
//			opcion = Integer.parseInt(scan.nextLine());
//			
//			switch (opcion) {
//			case LISTAR:
//				TituloComparator<T> tituloComparator = new TituloComparator();
//				tituloComparator.compare(o1, o2);
//				break;
//			default:
//				break;
//			}
//			
//		}while(opcion != SALIR);	
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
