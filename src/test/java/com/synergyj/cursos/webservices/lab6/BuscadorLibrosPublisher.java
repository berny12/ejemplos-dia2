/**
 * Fecha de creación: Feb 20, 2009, 4:46:56 PM
 *
 * Copyright (c) 2010 SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software es información pueder ser mofificado, utilizado
 * haciendo referencia al autor intelectual.
 */
package com.synergyj.cursos.webservices.lab6;

import javax.xml.ws.Endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.synergyj.cursos.webservices.sib.document.BusquedaLibrosServiceImpl;

/**
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 * @version 1.0
 */
public class BuscadorLibrosPublisher {

	/**
	 * Logger para todas las instancias de la clase
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(BuscadorLibrosPublisher.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String url = "http://127.0.0.1:9879/buscadorLibros?wsdl";

		logger.debug("Publicando WS  document en  " + url);
		logger.debug("Para terminar presione Ctrl + C");
		Endpoint.publish(url, new BusquedaLibrosServiceImpl());

	}

}
