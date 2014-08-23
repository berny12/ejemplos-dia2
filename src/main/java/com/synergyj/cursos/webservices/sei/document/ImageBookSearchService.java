/**
 * Fecha de creación: Feb 20, 2009, 4:46:56 PM
 *
 * Copyright (c) 2010 SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software es información pueder ser mofificado, utilizado
 * haciendo referencia al autor intelectual.
 */
package com.synergyj.cursos.webservices.sei.document;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.synergyj.cursos.webservices.entidades.BookImage;

/**
 * TODO [Descripcion de la clase]
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 * @version 1.0
 */
@WebService
public interface ImageBookSearchService {

	/**
	 * Obtiene una lista de libros de WS disponibles en venta
	 * @return
	 */
	@WebMethod
	List<BookImage> getWebServiceBooks();

}
