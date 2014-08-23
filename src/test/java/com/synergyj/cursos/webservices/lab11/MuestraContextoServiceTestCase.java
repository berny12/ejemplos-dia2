/**
 * Fecha de creación: Feb 20, 2009, 4:46:56 PM
 *
 * Copyright (c) 2010 SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software es información pueder ser mofificado, utilizado
 * haciendo referencia al autor intelectual.
 */
package com.synergyj.cursos.webservices.lab11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.synergyj.cursos.webservices.lab11.cliente.MuestraContextoServiceImpl;
import com.synergyj.cursos.webservices.lab11.cliente.MuestraContextoServiceImplService;

/**
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 * @version 1.0
 */
public class MuestraContextoServiceTestCase {

	/**
	 * Logger para todas las instancias de la clase
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(MuestraContextoServiceTestCase.class);

	/**
	 * 
	 */
	@Test
	public void invokeService() {
		MuestraContextoServiceImplService service;
		Map<String, Object> requestContext, responseContext;
		Map<String, List<String>> headers;
		List<String> headerValues;
		MuestraContextoServiceImpl port;

		service = new MuestraContextoServiceImplService();
		port = service.getMuestraContextoServiceImplPort();
		requestContext = ((BindingProvider) port).getRequestContext();
		// agregando algunos headers
		headers = new HashMap<String, List<String>>();
		headerValues = new ArrayList<String>(1);
		headerValues.add("hola");
		headers.put("saludo", headerValues);
		requestContext.put(MessageContext.HTTP_REQUEST_HEADERS, headers);

		logger.debug("Mostrando el contenido de la peticion antes de enviar");
		dumpMap(requestContext);
		logger.debug("invocando al servicio");

		port.muestraContexto("Mostrando contexto de invocacion");

		logger.debug("Obteniendo contexto de la respuesta");
		responseContext = ((BindingProvider) port).getResponseContext();
		logger.debug("Mostrando el contenido del contexto despues de invocar");
		dumpMap(responseContext);
		logger.debug("codigo de la respuesta: "
				+ responseContext.get(MessageContext.HTTP_RESPONSE_CODE));
	}

	/**
	 * @param map
	 */
	@SuppressWarnings("rawtypes")
	private void dumpMap(Map map) {
		Set keys = map.keySet();
		for (Object key : keys) {
			if (key instanceof Map) {
				logger.debug("submap:");
				dumpMap((Map) key);
			}
			logger.debug("key:" + key);
			logger.debug("value: " + map.get(key));
		}

	}

}
