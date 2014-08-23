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

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Este servicio ilustra el envio de informacion binaria entre el cliente y el
 * servidor empleando attachments con la estrategia MTOM. Para ilustrar, se
 * envia al cliente una archivo mp3 mayusculas y lo regresa al cliente.
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 * @version 1.0
 */
@WebService
public interface MultimediaService {

	/**
	 * @return
	 */
	@WebMethod
	byte[] getSong();

}
