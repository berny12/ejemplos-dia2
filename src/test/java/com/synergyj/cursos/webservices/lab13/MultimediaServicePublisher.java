/**
 * Fecha de creación: Feb 20, 2009, 4:46:56 PM
 *
 * Copyright (c) 2010 SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software es información pueder ser mofificado, utilizado
 * haciendo referencia al autor intelectual.
 */
package com.synergyj.cursos.webservices.lab13;

import javax.xml.ws.Endpoint;
import javax.xml.ws.soap.SOAPBinding;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.synergyj.cursos.webservices.sib.document.MultimediaServiceImpl;

/**
 * Ejemplo que muestra la estrategia para publicar un servicio con attachment usando MTOM
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 * @version 1.0
 */
public class MultimediaServicePublisher {

	/**
	 * Logger para todas las instancias de la clase
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(MultimediaServicePublisher.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Endpoint endpoint;
		SOAPBinding binding;
		String url = "http://127.0.0.1:9878/multimediaService?wsdl";

		logger.debug("Habilitando MTOM");
		endpoint = Endpoint.create(new MultimediaServiceImpl());
		binding = (SOAPBinding) endpoint.getBinding();
		//el publisher debe hbilitar el protocolo mtom
		binding.setMTOMEnabled(true);

		logger.debug("Publicando WS estilo document en  " + url);
		logger.debug("Para terminar presione Ctrl + C");
		Endpoint.publish(url, new MultimediaServiceImpl());

	}

}
