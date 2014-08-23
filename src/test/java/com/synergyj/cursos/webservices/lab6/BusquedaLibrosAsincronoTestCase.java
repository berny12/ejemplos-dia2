/**
 * Fecha de creación: Feb 20, 2009, 4:46:56 PM
 *
 * Copyright (c) 2010 SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software es información pueder ser mofificado, utilizado
 * haciendo referencia al autor intelectual.
 */
package com.synergyj.cursos.webservices.lab6;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.synergyj.cursos.webservices.lab6.cliente.BusquedaLibrosService;
import com.synergyj.cursos.webservices.lab6.cliente.BusquedaLibrosServiceImplService;
import com.synergyj.cursos.webservices.lab6.cliente.Libro;

/**
 * Invocacion de un WS en forma asincrona.
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 * @version 1.0
 */
public class BusquedaLibrosAsincronoTestCase {

	/**
	 * Logger para todas las instancias de la clase
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(BusquedaLibrosAsincronoTestCase.class);

	@Test
	public void buscaLibrosFormaAsincrona() throws InterruptedException, ExecutionException,
			TimeoutException {

		BusquedaLibrosServiceImplService service;
		BusquedaLibrosService busqueda = null;

		service = new BusquedaLibrosServiceImplService();
		busqueda = service.getBusquedaLibrosServiceImplPort();
		List<Libro> libros = busqueda.buscaLibros("Andrew J. Oppel", "SOA", null);		
		
		logger.debug("Resultados de la busqueda");
		for (Libro libro : libros) {
			logger.debug("titulo: " + libro.getTitulo());
			logger.debug("autor: " + libro.getAutor());
		}

	}

}
