/**
 * Fecha de creaci�n: Feb 20, 2009, 4:46:56 PM
 *
 * Copyright (c) 2010 SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software es informaci�n pueder ser mofificado, utilizado
 * haciendo referencia al autor intelectual.
 */
package com.synergyj.cursos.webservices.sei.document;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * TODO [Descripcion de la clase]
 * @author Jorge Rodr�guez Campos (jorge.rodriguez@synergyj.com)
 * @version 1.0
 */
@WebService
public interface RecepcionInfoServer {

	@WebMethod
	void recibeDatos(String datos);
}
