/**
 * Fecha de creación: Feb 20, 2009, 4:46:56 PM
 *
 * Copyright (c) 2010 SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software es información pueder ser mofificado, utilizado
 * haciendo referencia al autor intelectual.
 */
package com.synergyj.cursos.webservices.sib.document;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.jws.HandlerChain;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.synergyj.cursos.webservices.sei.document.MultimediaService;

/**
 * TODO [Descripcion de la clase]
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 * @version 1.0
 */
@WebService(endpointInterface = "com.synergyj.cursos.webservices.sei.document.MultimediaService")
@BindingType(value = SOAPBinding.SOAP11HTTP_MTOM_BINDING)
@HandlerChain(file = "mtom/MTOMServerHandlerChain.xml")
public class MultimediaServiceImpl implements MultimediaService {

	/**
	 * Logger para todas las instancias de la clase
	 */
	private static final Logger logger = LoggerFactory.getLogger(MultimediaServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * @see com.synergyj.cursos.webservices.sei.document.MultimediaService#getSong()
	 */
	@Override
	public byte[] getSong() {
		File song;
		FileInputStream fis;
		byte[] bytes;

		song = new File("songs/song.mp3");
		bytes = new byte[(int) song.length()];
		try {
			fis = new FileInputStream(song);
			fis.read(bytes);
            logger.debug("Se mandaron bytes " + bytes.length);
		} catch (IOException e) {
			logger.error("No se encontro cancion", e);
			return null;
		}
		return bytes;
	}

}
