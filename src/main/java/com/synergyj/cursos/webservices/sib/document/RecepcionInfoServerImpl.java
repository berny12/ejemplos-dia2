/**
 * Fecha de creación: Feb 20, 2009, 4:46:56 PM
 *
 * Copyright (c) 2010 SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software es información pueder ser mofificado, utilizado
 * haciendo referencia al autor intelectual.
 */
package com.synergyj.cursos.webservices.sib.document;

import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.synergyj.cursos.webservices.sei.document.RecepcionInfoServer;

/**
 * Esrte ejemplo muestra el uso de handlers de mensajes SOAP.
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 * @version 1.0
 */
@WebService(endpointInterface = "com.synergyj.cursos.webservices.sei.document.RecepcionInfoServer")
public class RecepcionInfoServerImpl implements RecepcionInfoServer {

	/**
	 * Logger para todas las instancias de la clase
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(RecepcionInfoServerImpl.class);

	/*
	 * (non-Javadoc)
	 * @see com.synergyj.cursos.webservices.sei.document.RecepcionInfoServer#recibeDatos
	 * (java.lang.String)
	 */
	@Override
	public void recibeDatos(String datos) {

		logger.debug("Recibiendo datos: " + datos);

	}

}
