/**
 * Fecha de creación: Feb 20, 2009, 4:46:56 PM
 *
 * Copyright (c) 2010 SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software es información pueder ser mofificado, utilizado
 * haciendo referencia al autor intelectual.
 */
package com.synergyj.cursos.webservices.lab13;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.activation.DataHandler;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.synergyj.cursos.webservices.lab13.cliente.MultimediaServiceImplService;
import com.synergyj.cursos.webservices.soap.handlers.MTOMClientHandler;

/**
 * TODO [Descripcion de la clase]
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 * @version 1.0
 */
public class MultimediaServiceTestCase {

	/**
	 * Logger para todas las instancias de la clase
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(MultimediaServiceTestCase.class);

	@Test
	public void procesaDocumento() throws IOException {

		MultimediaServiceImplService service;
		DataHandler dataHandler;

		int bufferSize = 1024 * 1024;
		int bytesRead;
		byte[] buffer;

		FileOutputStream fos;
		InputStream is;

		service = new MultimediaServiceImplService();

		logger.debug("Asociando handler");
		service.setHandlerResolver(new HandlerResolver() {

			/*
			 * (non-Javadoc)
			 * @see
			 * javax.xml.ws.handler.HandlerResolver#getHandlerChain(javax.xml.ws.handler
			 * .PortInfo)
			 */
			@Override
			@SuppressWarnings("rawtypes")
			public List<Handler> getHandlerChain(PortInfo portInfo) {
				List<Handler> listaHandler;
				listaHandler = new ArrayList<Handler>(1);
				listaHandler.add(new MTOMClientHandler());
				return listaHandler;
			}
		});

		dataHandler = service.getMultimediaServiceImplPort().getSong();
		logger.debug("Obteniendo una cancion del ws");

		logger.debug("mime type: " + dataHandler.getContentType());
		logger.debug("Content: " + dataHandler.getContent());
		is = dataHandler.getInputStream();
		buffer = new byte[bufferSize];
		fos = new FileOutputStream("target/test-classes/song.mp3");

		while ((bytesRead = is.read(buffer)) != -1) {
			logger.debug("leyendo bytes:" + bytesRead);
			fos.write(buffer, 0, bytesRead);
		}
		fos.close();
		logger.debug("Cancion obtenida con exito en target/test-classes/song.mp3");

	}
}
