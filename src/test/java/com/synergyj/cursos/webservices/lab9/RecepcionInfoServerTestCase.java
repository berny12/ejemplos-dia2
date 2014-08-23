/**
 * Fecha de creación: Feb 20, 2009, 4:46:56 PM
 *
 * Copyright (c) 2010 SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software es información pueder ser mofificado, utilizado
 * haciendo referencia al autor intelectual.
 */
package com.synergyj.cursos.webservices.lab9;

import java.util.concurrent.ExecutionException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.synergyj.cursos.webservices.lab9.cliente.RecepcionInfoServerImplService;

/**
 * Invocacion de un WS en forma sincrona.
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 * @version 1.0
 */
public class RecepcionInfoServerTestCase {

	/**
	 * Logger para todas las instancias de la clase
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(RecepcionInfoServerTestCase.class);

	@Test
	public void enviaInfo() throws InterruptedException, ExecutionException {

		logger.debug("Enviando info al server");
		RecepcionInfoServerImplService service = new RecepcionInfoServerImplService();
		service.getRecepcionInfoServerImplPort().recibeDatos("datos secretos");
		logger.debug("info enviada al server.");
	}
}


