/**
 * Fecha de creación: Feb 20, 2009, 4:46:56 PM
 *
 * Copyright (c) 2010 SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software es información pueder ser mofificado, utilizado
 * haciendo referencia al autor intelectual.
 */
package com.synergyj.cursos.webservices.lab5;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Este ejemplo muestra la forma en la que un mensaje SOAP puede ser validado empleando
 * los XSDs que se generan al publicar un web service.
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 * @version 1.0
 */
public class ValidaMessageTestCase {

	/**
	 * Logger para todas las instancias de la clase
	 */
	private static final Logger logger = LoggerFactory.getLogger(ValidaMessageTestCase.class);

	@Test
	public void validateDocumentStyle() throws Exception {

		Validator validator;
		Schema schema;
		logger.debug("validando mensajes SOAP estilo document.");

		String schema_uri = XMLConstants.W3C_XML_SCHEMA_NS_URI;
		SchemaFactory factory = SchemaFactory.newInstance(schema_uri);
		schema = factory.newSchema(new StreamSource("comparativos/ejemplo-document.xsd"));

		logger.debug("validando mensaje soap (peticion document)");
		// valida contra esquema
		validator = schema.newValidator();
		validator.validate(new StreamSource("validaciones/message-request-document.xml"));

		logger.debug("validando mensaje soap (respuesta document)");
		validator = schema.newValidator();
		validator.validate(new StreamSource("validaciones/message-response-document.xml"));
	}

	@Test
	public void validateRPCStyle() throws Exception {

		Validator validator;
		Schema schema;
        logger.debug("validando mensajes SOAP estilo RPC.");

		String schema_uri = XMLConstants.W3C_XML_SCHEMA_NS_URI;
		SchemaFactory factory = SchemaFactory.newInstance(schema_uri);
		schema = factory.newSchema(new StreamSource("comparativos/ejemplo-rpc.xsd"));

		logger.debug("validando mensaje SOAP (peticion RPC)");
		// valida contra esquema
		validator = schema.newValidator();
		validator.validate(new StreamSource("validaciones/message-request-rpc.xml"));
		
		logger.debug("mensaje SOAP (peticion RPC) validado");
        logger.debug("validando mensaje soap  (respuesta RPC)");
		validator = schema.newValidator();
		validator.validate(new StreamSource("validaciones/message-response-rpc.xml"));
		logger.debug("mensaje SOAP (respuesta RPC) validado");

	}

}
