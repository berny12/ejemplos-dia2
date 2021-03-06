/**
 * Fecha de creación: Feb 20, 2009, 4:46:56 PM
 *
 * Copyright (c) 2010 SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software es información pueder ser mofificado, utilizado
 * haciendo referencia al autor intelectual.
 */
package com.synergyj.cursos.webservices.lab10;

import javax.xml.ws.Endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.synergyj.cursos.webservices.sib.document.ValidaCreditoServiceImpl;

/**
 * Esta clase se encarga de publicar un WS. En ambientes de producción se emplea un
 * servidor de aplicaciones, pero se puede emplear esta clase para propósitos de prueba.<br>
 * El servicio responde al url:<br>
 * http://127.0.0.1:9876/timerService?wsdl
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 * @version 1.0
 */
public class ValidaCreditoPublisher {

	/**
	 * Logger para todas las instancias de la clase
	 */
	private static final Logger logger = LoggerFactory.getLogger(ValidaCreditoPublisher.class);

	/**
	 * @param args
	 */

	public static void main(String[] args) {

		String url = "http://127.0.0.1:9878/validaCreditoService?wsdl";

		logger.debug("Publicando WS estilo document en  " + url);
		logger.debug("Para terminar presione Ctrl + C");
		Endpoint.publish(url, new ValidaCreditoServiceImpl());

	}

}
