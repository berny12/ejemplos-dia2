/**
 * Fecha de creación: Feb 20, 2009, 4:46:56 PM
 *
 * Copyright (c) 2010 SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software es información pueder ser mofificado, utilizado
 * haciendo referencia al autor intelectual.
 */
package com.synergyj.cursos.webservices.lab12;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import junit.framework.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.synergyj.cursos.webservices.lab12.cliente.BookImage;
import com.synergyj.cursos.webservices.lab12.cliente.ImageBookSearchServiceImplService;

/**
 * TODO [Descripcion de la clase]
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 * @version 1.0
 */
public class ImageBookSearchServiceTestCase {

	
	/**
	 * Logger para todas las instancias de la clase
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(ImageBookSearchServiceTestCase.class);
	
	
	/**
	 * 
	 */
	@Test
	public void obtenLibros() throws IOException {

		List<BookImage> listaLibros;
		ImageBookSearchServiceImplService service;
		String path = "target/test-classes";
		FileOutputStream fos;

		service = new ImageBookSearchServiceImplService();
		logger.debug("Obteniendo  lobros con imagen.");
		listaLibros = service.getImageBookSearchServiceImplPort().getWebServiceBooks();

		logger.debug("Se obtuvieron: " + listaLibros.size());
		Assert.assertTrue(listaLibros.size() > 0);
		logger.debug("Almacenando imagenes en " + path);

		for (BookImage bookImage : listaLibros) {
			logger.debug("nombre del archivo: " + bookImage.getName());
			fos = new FileOutputStream(new File(path, bookImage.getName()));
			fos.write(bookImage.getImage());
			fos.close();
		}

	}

}
