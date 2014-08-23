/**
 * Fecha de creación: 16/10/2010 11:40:21
 *
 * Copyright (c) 2010 SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software es información pueder ser mofificado, utilizado
 * haciendo referencia al autor intelectual.
 */
package com.synergyj.cursos.webservices.soap.handlers;

import java.io.ByteArrayOutputStream;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO [Descripcion de la clase]
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 * @version 1.0
 */
public class MTOMClientHandler implements SOAPHandler<SOAPMessageContext> {

	/**
	 * Logger para todas las instancias de la clase
	 */
	private static final Logger logger = LoggerFactory.getLogger(MTOMClientHandler.class);

	/*
	 * (non-Javadoc)
	 * @see
	 * javax.xml.ws.handler.Handler#handleMessage(javax.xml.ws.handler.MessageContext)
	 */
	@Override
	public boolean handleMessage(SOAPMessageContext context) {

		SOAPMessage soapMessage;
		boolean outboundMessage;

		logger.debug("Procesando mensaje en Handler");
		soapMessage = context.getMessage();

		try {

			outboundMessage = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
			if (outboundMessage) {
				logger.debug("Mensaje saliente, no se realiza accion alguna");
			} else {
				logger.debug("Mensaje de entrada enviado por el servidor");
				ByteArrayOutputStream bos;
				bos = new ByteArrayOutputStream();
				soapMessage.writeTo(bos);
				logger.debug("tamaño aprox. del mensaje: " + bos.toByteArray().length);

			}

		} catch (Exception e) {
			logger.error("Error al procesar el mensaje SOAP", e);
			return false;
		}

		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see javax.xml.ws.handler.soap.SOAPHandler#getHeaders()
	 */
	@Override
	public Set<QName> getHeaders() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see javax.xml.ws.handler.Handler#close(javax.xml.ws.handler.MessageContext)
	 */
	@Override
	public void close(MessageContext context) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * @see javax.xml.ws.handler.Handler#handleFault(javax.xml.ws.handler.MessageContext)
	 */
	@Override
	public boolean handleFault(SOAPMessageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

}
