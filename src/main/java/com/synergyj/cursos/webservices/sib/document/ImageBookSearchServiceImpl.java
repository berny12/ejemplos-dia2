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
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.synergyj.cursos.webservices.entidades.BookImage;
import com.synergyj.cursos.webservices.sei.document.ImageBookSearchService;

/**
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 * @version 1.0
 */
@WebService(endpointInterface = "com.synergyj.cursos.webservices.sei.document.ImageBookSearchService")
public class ImageBookSearchServiceImpl implements ImageBookSearchService {

	/**
	 * Logger para todas las instancias de la clase
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(ImageBookSearchServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * @seecom.synergyj.cursos.webservices.sei.document.ImageBookSearchService#
	 * getWebServiceBooks()
	 */
	@Override
	public List<BookImage> getWebServiceBooks() {
		String path = "imagenes/libros-ws";
		File[] images;
		byte[] image;
		FileInputStream fis;
		BookImage bookImage;
		List<BookImage> listaLibros;
		long longitudTotal = 0;

		logger.debug("Obteniendo imagenes para enviar al cliente");

		images = new File(path).listFiles();
		listaLibros = new ArrayList<BookImage>();
		for (File file : images) {
			try {
				fis = new FileInputStream(file);
				image = new byte[(int) file.length()];
				fis.read(image);
				fis.close();
				bookImage = new BookImage();
				bookImage.setName(file.getName());
				bookImage.setImage(image);
				listaLibros.add(bookImage);
				longitudTotal += file.length();
				logger.debug("Libro con imagen encontrado: " + bookImage.getName());
				logger.debug("tamaño de la imagen (bytes): " + image.length);
			} catch (IOException e) {
				logger.error("Error al leer la imagen, no se incluye en la lista.");
			}
		}
		logger.debug("longitud total de las imagenes (bytes): " + longitudTotal);
		return listaLibros;
	}

}
