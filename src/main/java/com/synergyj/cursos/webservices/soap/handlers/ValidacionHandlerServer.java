package com.synergyj.cursos.webservices.soap.handlers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.synergyj.cursos.webservices.soap.utilerias.UtileriasSOAP;

public class ValidacionHandlerServer implements SOAPHandler<SOAPMessageContext>{
	//agregamos un logger para ver el comportamiento de nuesto handler
	public static Logger logger = LoggerFactory.getLogger(ValidacionHandlerServer.class);

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
		
		SOAPEnvelope soapEnvelope;
		SOAPHeader soapHeader;
		SOAPBody   soapBody;
		ByteArrayOutputStream stream=null;
		
		logger.debug("iniciamos la validacion de la firma del mesaje");
		
		//creamos una SOAPEnvelop del mesaje
		SOAPMessage soapMessage= context.getMessage();
		
		
		try {
			
			
			
			//se valida que el mensaje sea de entrada
			boolean mensajeSalida = (Boolean)context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
			if(!mensajeSalida){
					soapEnvelope = soapMessage.getSOAPPart().getEnvelope();
					soapHeader 	= soapEnvelope.getHeader();
					soapBody	=  soapEnvelope.getBody();
					
					//imprimos el body
					logger.debug("el cuerpo del mensaje es: "+ soapBody.toString());
					//obtenemos el prefijo del body
					String prefijo = soapBody.getPrefix();
					//imprmimos el contenido
					stream = new ByteArrayOutputStream();
					//escribimos en mensaje recibido
					soapMessage.writeTo(stream);
					
					//obtenemos el texto del body
					String bodyString = UtileriasSOAP.obtenerTextoBody(stream.toString(),prefijo);
					logger.debug("El body es :"+ bodyString );
					
					//obtenemos la firma
					String md5 = UtileriasSOAP.calculateMD5Signature(bodyString);
					logger.debug("la firma es: "+md5);
					
					//iteramos el header del mesaje para buscar el elemento firma
					Iterator iterator = soapHeader.getChildElements();
					
					String firmaCliente = null;
					
					while(iterator.hasNext()){
						Object object = iterator.next();
						if(object instanceof SOAPElement){
							SOAPElement soapElement = (SOAPElement) object;
							if(soapElement.getTagName().equals("firma")){
								//obtenemos el valor del campo
								firmaCliente = soapElement.getTextContent();
								break;
							}
							
						}
					}
					
					//Se compraran las firmas en caso de ser diferentes se manda una excepxion
					logger.debug("la firma del cliente: "+ firmaCliente);
					if(firmaCliente.equals(md5)){ //si las firmas son  igules pasan al servidor
						logger.debug("las firmas son iguales");
						return true;
					}else{ // si handler manda false no pasa al servidor de peticiones 
						logger.debug("las firmas no son iguales");
						return false;
					}
					
					
			}
			
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}

	@Override
	public Set<QName> getHeaders() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
