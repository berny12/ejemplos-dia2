/**
 * 
 */
package com.synergyj.cursos.webservices.soap.handlers;

import java.io.IOException;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author edgar
 *
 */
public class SecurityClienteHandler implements SOAPHandler<SOAPMessageContext> {

	
	private static final Logger logger = LoggerFactory.getLogger(SecurityClienteHandler.class);

	@Override
	public void close(MessageContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean handleFault(SOAPMessageContext arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		
		logger.debug("iniciando insercion de pasword");
		
		//obtenemos el mensaje con el handler
		SOAPMessage soapMessage = context.getMessage();
		
		
		try {
			soapMessage.writeTo(System.out);
			
			
			boolean mensajeSalida = (Boolean)context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
			if(mensajeSalida){
				//ontemos el sobre del mensjae
				SOAPEnvelope soapEnvelope = soapMessage.getSOAPPart().getEnvelope();
				//obtenemos el mensaje soap
				SOAPHeader soapHeader = soapEnvelope.getHeader();
				if(soapHeader==null){//validamos que solo vaya de salida, es decir qeu es una peticion al webservice
					logger.debug("Creando Headers en SOAP");
					soapHeader=soapEnvelope.addHeader();
				}
				//se establece la url del namespace de nuestro handler
				QName qname = new QName("http://www.synergyj.com/webservices/handlers","password");
				//se crea el tag en el hearder
				SOAPHeaderElement headerElement = soapHeader.addHeaderElement(qname);
				//ponemos quien va procesar el header en este csao es el ultimo 
				headerElement.setActor(SOAPConstants.URI_SOAP_ACTOR_NEXT);
				//agregamos el valor del nodo
				headerElement.addTextNode("admin123");
				//guardamos los cambiosn en el xml
				soapMessage.saveChanges();
				//imprimir el contenido
				logger.debug("Imprimiendo SOAP despues de agregar el handler");
				soapMessage.writeTo(System.out);
				
			}
			return true; //inidicamos que se vaya al siguiente handler
		} catch (SOAPException e) {
			logger.debug("Hubo una execepcion al obtner el SOAP");
			return false; // indicamos que no salga el mensaje
		} catch (IOException e) {
			logger.debug("Hubo una execepcion al obtner el SOAP");
			return false; //indicamos que no salga el mensaje
		}
		
		
		
	
		return false;
	}

	@Override
	public Set<QName> getHeaders() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
