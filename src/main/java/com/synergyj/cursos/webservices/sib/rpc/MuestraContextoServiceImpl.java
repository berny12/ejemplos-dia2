/**
 * Fecha de creación: Feb 20, 2009, 4:46:56 PM
 *
 * Copyright (c) 2010 SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software es información pueder ser mofificado, utilizado
 * haciendo referencia al autor intelectual.
 */
package com.synergyj.cursos.webservices.sib.rpc;

import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.synergyj.cursos.webservices.sei.rpc.MuestraContextoService;

/**
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 * @version 1.0
 */
@WebService
public class MuestraContextoServiceImpl implements MuestraContextoService {

	/**
	 * Logger para todas las instancias de la clase
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(MuestraContextoServiceImpl.class);

	/**
	 * Inyecta la referencia al contexto.
	 */
	@Resource
	private WebServiceContext context;

	/*
	 * (non-Javadoc)
	 * @seecom.synergyj.cursos.webservices.sei.rpc.MuestraContextoService#
	 * muestraContexto(java.lang.String)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void muestraContexto(String mensaje) {
		MessageContext msgContext;
		Map<String, Object> headers;

		msgContext = context.getMessageContext();

		logger.debug("headers http");
		headers = (Map<String, Object>) msgContext.get(MessageContext.HTTP_REQUEST_HEADERS);
		dumpMap(headers);
		logger.debug("Otros datos");
		dumpMap((Map) msgContext);
		logger.debug("Mensaje del cliente: " + mensaje);
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
