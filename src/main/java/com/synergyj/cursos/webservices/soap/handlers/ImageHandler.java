package com.synergyj.cursos.webservices.soap.handlers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ImageHandler implements SOAPHandler<SOAPMessageContext> {

	//creamos el logger para ver mensaje en consola
	public static Logger logger = LoggerFactory.getLogger(ImageHandler.class);
	
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
		
		
		logger.debug("Procesando mensaje de imagnes");
		
		//validamos si el mensaje es de salida
		boolean esSalida = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		
		if(!esSalida){
			//obtenemos el mensaje
			SOAPMessage soapMessage = context.getMessage();
			//donde ponemos la imagne
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			
			//obtenemos la imagne
			try {
				soapMessage.writeTo(bos);
				logger.debug(bos.toString());
				logger.debug("Tamaño aproximado del mensaje es: "+ bos.toByteArray().length);
				return true;
			} catch (SOAPException e) {
				// TODO Auto-generated catch block
				logger.debug("Error al obtener el mensaje: ",e);

				return false;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.debug("Error al obtener el mensaje: ",e);
				return false;
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
