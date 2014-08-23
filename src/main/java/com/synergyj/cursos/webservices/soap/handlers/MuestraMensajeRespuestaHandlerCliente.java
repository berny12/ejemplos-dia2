/**
 * Fecha de creación: Jul 20, 2010, 4:46:56 PM
 *
 * Copyright (c) 2010 SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software es información pueder ser mofificado, utilizado
 * haciendo referencia al autor intelectual.
 */
package com.synergyj.cursos.webservices.soap.handlers;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.Detail;
import javax.xml.soap.DetailEntry;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Handler empleado para mostrar el mensaje SOAP en la consola.
 * 
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 * @version 1.0
 */
public class MuestraMensajeRespuestaHandlerCliente implements
		SOAPHandler<SOAPMessageContext> {

	/**
	 * Logger para todas las instancias de la clase
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(MuestraMensajeRespuestaHandlerCliente.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @seejavax.xml.ws.handler.Handler#handleMessage(javax.xml.ws.handler.
	 * MessageContext)
	 */
	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		SOAPMessage soapMessage;
		boolean resultado;

		logger.debug("Iniciando procesamiento de mensaje");

		try {
			soapMessage = context.getMessage();
			logger.debug("Imprimiendo mensaje SOAP a la consola");
			soapMessage.writeTo(System.out);
			resultado = true;

		} catch (SOAPException e) {
			logger.error("Error al obtener el XML del body", e);
			resultado = false;
		} catch (IOException e) {
			logger.error("Error al obtener el XML del body", e);
			resultado = false;
		}

		return resultado;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.xml.ws.handler.soap.SOAPHandler#getHeaders()
	 */
	@Override
	public Set<QName> getHeaders() {
		logger.debug("En metodo getHeaders");
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.xml.ws.handler.Handler#close(javax.xml.ws.handler.MessageContext)
	 */
	@Override
	public void close(MessageContext context) {
		logger.debug("En metodo close");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.xml.ws.handler.Handler#handleFault(javax.xml.ws.handler.MessageContext
	 * )
	 */
	// @SuppressWarnings("rawtypes")
	@Override
	public boolean handleFault(SOAPMessageContext context) {
		logger.debug("en Metodo handleFault");
		Boolean outboundMessage = (Boolean) context
				.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

		if (!outboundMessage) {
			SOAPMessage mensaje = context.getMessage();

			try {
				mensaje.writeTo(System.out);
				SOAPFault fault = mensaje.getSOAPPart().getEnvelope().getBody()
						.getFault();
				if (fault != null) {

					logger.debug("Codigo " + fault.getFaultCode());
					logger.debug("Cadena " + fault.getFaultString());

					Detail detalle = fault.getDetail();

					// Get the list of DetailEntry's
					if (detalle != null) {
						Iterator<DetailEntry> it = detalle.getDetailEntries();
						while (it.hasNext()) {
							DetailEntry entry = it.next();
							logger.debug("El detalle es :  "
									+ entry.getTextContent());
						}
					}
					return false;
				}

			} catch (Exception e) {
				logger.debug("Error al obtener el fault", e);

			}
		}
		return true;
	}

}
