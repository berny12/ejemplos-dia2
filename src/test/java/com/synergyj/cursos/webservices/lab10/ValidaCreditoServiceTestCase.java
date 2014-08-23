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

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.synergyj.cursos.webservices.lab10.cliente.ValidaCreditoServiceImplService;
import com.synergyj.cursos.webservices.soap.handlers.MuestraMensajeRespuestaHandlerCliente;

/**
 * Ejemplo que muestra la generacion de Faults empleando excepciones.
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 * @version 1.0
 */
public class ValidaCreditoServiceTestCase {

	/**
	 * Logger para todas las instancias de la clase
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(ValidaCreditoServiceTestCase.class);

	/**
	 * 
	 */
	@Test
	public void validaTarjeta() {
		ValidaCreditoServiceImplService service;

		logger.debug("Invocando la validacion de tarjeta, provocando Fault.");
		service = new ValidaCreditoServiceImplService();
		try {
            service.setHandlerResolver(new HandlerResolver() {

                @SuppressWarnings("rawtypes")
                @Override
                public List<Handler> getHandlerChain(PortInfo portInfo) {
                    List<Handler> lista = new ArrayList<Handler>();
                    lista.add(new MuestraMensajeRespuestaHandlerCliente());
                    return lista;
                }
            });
			service.getValidaCreditoServiceImplPort().validaCredito("1020");
      logger.debug("Continua con el proceso");
			
			
		} catch (Exception e) {
			logger.error("excepcion generada: ", e);
			logger.info("Tipo de excepcion: " + e.getClass().getName());
		}

	}

}
