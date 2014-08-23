/**
 * Fecha de creación: 09/10/2010 12:40:48
 *
 * Copyright (c) 2010 SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software es información pueder ser mofificado, utilizado
 * haciendo referencia al autor intelectual.
 */
package com.synergyj.cursos.webservices.lab1;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.synergyj.cursos.webservices.lab1.cliente.TimeService;
import com.synergyj.cursos.webservices.lab1.cliente.TimeServiceImplService;

/**
 * Cliente standalone que consume a un WS empleando las clases generadas por wsimport.
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 * @version 1.0
 */
public class TimeServiceTestCase {

	/**
	 * Logger para todas las instancias de la clase
	 */
	private static final Logger logger = LoggerFactory.getLogger(TimeServiceTestCase.class);

	/**
	 * Este test case muestra el uso de wsimport
	 */
	@Test
	public void muestraFechas() {

		TimeServiceImplService service;
		TimeService sei;
		service = new TimeServiceImplService();
        logger.debug("Enviando peticion al webservice ");
        sei = service.getTimeServiceImplPort();
        logger.debug("Imprimiendo fecha como String: " + sei.getDateAsString());
        logger.debug("Imprimiendo fecha como long: " + sei.getDateALong());

	}

}
