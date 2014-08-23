/**
 * Fecha de creación: 29/01/2011 20:32:15
 *
 * Copyright (c) 2011 SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software es información pueder ser mofificado, utilizado
 * haciendo referencia al autor intelectual.
 */
package com.synergyj.cursos.webservices.sei.document;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.synergyj.cursos.webservices.entidades.libros.Libro;

/**
 * SEI simula la búsqueda de libros en una tienda empleando un WS
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 * @version 1.0
 */
@WebService
public interface BusquedaLibrosService {

	/**
	 * Invoca la búsqueda de libros.
	 * @param autor
	 * @param titulo
	 * @param editorial
	 * @return
	 */
	@WebMethod
	List<Libro> buscaLibros(String autor, String titulo, String editorial);

}
