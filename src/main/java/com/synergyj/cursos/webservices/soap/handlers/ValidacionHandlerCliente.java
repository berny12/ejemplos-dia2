package com.synergyj.cursos.webservices.soap.handlers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPBody;
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

import com.synergyj.cursos.webservices.soap.utilerias.UtileriasSOAP;

public class ValidacionHandlerCliente implements SOAPHandler<SOAPMessageContext>{

	//creamos un logger para ver el comportamiento del sisitema
	public static Logger logger = LoggerFactory.getLogger(ValidacionHandlerCliente.class);
	
	@Override
	public void close(MessageContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		
		//declamos nuestros partes del mesaje soap
		SOAPEnvelope soapEnvelope;
		SOAPHeader	 soapHeader;
		SOAPBody	 soapBody;
		ByteArrayOutputStream stream;
		//obtenemos el mesaje soap del contexto
		SOAPMessage soapMessage = context.getMessage();
		
		//preguntamos su el mensaje es de salida
		boolean esmensajesalida = (Boolean)context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		if(esmensajesalida){
			logger.debug("Agregando la firma al mensaje desde el cliente");
			try {
				soapEnvelope = soapMessage.getSOAPPart().getEnvelope();
				soapHeader 	= soapEnvelope.getHeader();
				soapBody 	= soapEnvelope.getBody();
				
				//verificamos que el mesaje tenga un header, en caso contrario lo creamos el header al mensaje
				if(soapHeader==null){
					logger.debug("creado el HEADER ..");
					soapHeader 	=	soapEnvelope.addHeader();
				}
				
				//obtenemos la informacion de nuestro body y lo codificamos en md5
				 String prefix = soapBody.getPrefix();
		            
		            stream = new ByteArrayOutputStream();
		            
		            soapMessage.writeTo(stream);
		            
		            String bodyString = UtileriasSOAP.obtenerTextoBody(stream.toString(), prefix);
		            
		            logger.debug("El body es: "+ bodyString);
		            
		            
		            String md5 = UtileriasSOAP.calculateMD5Signature(bodyString);
		            logger.debug("La firma es: "+ md5);

				
				
				//se establece el url de nuestro handler
				QName qname = new QName("http://www.synergyj.com/webservices/handlers","firma");
				//se crea el tag en el hearder
				SOAPHeaderElement headerElement = soapHeader.addHeaderElement(qname);
				//ponemos quien va procesar el header en este csao es el ultimo 
				headerElement.setActor(SOAPConstants.URI_SOAP_ACTOR_NEXT);
				//agregamos el valor del nodo
				headerElement.addTextNode(md5);
				//guardamos los cambiosn en el xml
				soapMessage.saveChanges();
				//imprimir el contenido
				logger.debug("Imprimiendo SOAP despues de agregar el handler");
				soapMessage.writeTo(System.out);
				logger.debug("Terminadno de agregar la firma al header");
				
			} catch (SOAPException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return true;
	}

	@Override
	public Set<QName> getHeaders() {
		// TODO Auto-generated method stub
		return null;
	}
	

	
}
