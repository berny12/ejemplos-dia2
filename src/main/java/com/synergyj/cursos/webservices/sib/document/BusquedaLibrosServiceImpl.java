/**
 * Fecha de creación: 29/01/2011 20:39:38
 *
 * Copyright (c) 2011 SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software es información pueder ser mofificado, utilizado
 * haciendo referencia al autor intelectual.
 */
package com.synergyj.cursos.webservices.sib.document;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.synergyj.cursos.webservices.entidades.libros.Libro;
import com.synergyj.cursos.webservices.sei.document.BusquedaLibrosService;

/**
 * SIB simula la búsqueda de libros.
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 * @version 1.0
 */
@WebService(endpointInterface = "com.synergyj.cursos.webservices.sei.document.BusquedaLibrosService")
public class BusquedaLibrosServiceImpl implements BusquedaLibrosService {

	/**
	 * Logger para todas las instancias de la clase
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(BusquedaLibrosServiceImpl.class);

	private static final Libro[] libros = new Libro[] {

			new Libro("Databases Demystified (Demystified)", "Andrew J. Oppel", 567.34),
			new Libro("Beginning Database Design: From Novice to Professional",
					" Clare Churcher", 658.34),
			new Libro("Database Systems: The Complete Book (2nd Edition) ",
					" Hector Garcia-Molina", 756.04),
			new Libro("Web Services: Principles and Technology ", " M. Papazoglou", 563.23),
			new Libro("SOA Using Java(TM) Web Services", " Mark D. Hansen", 456.34) };

	/*
	 * (non-Javadoc)
	 * @see
	 * com.synergyj.cursos.webservices.sei.document.BusquedaLibrosService#buscaLibros(
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<Libro> buscaLibros(String autor, String titulo, String editorial) {
		logger.debug(
				"Invocando la busqueda de libros con criterios. Autor: {}, titulo: {}, editorial:{}",
				new Object[] { autor, titulo, editorial });

		List<Libro> resultado;
		resultado = new ArrayList<Libro>();

        try {
            logger.debug("Buscando los libros espere por favor");
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            logger.error("No fue posible deterner el hilo", e);
        }

		for (int i = 0; i < libros.length; i++) {
			if (autor != null && libros[i].getAutor().contains(autor)) {
				resultado.add(libros[i]);
			}
			if (titulo != null && libros[i].getTitulo().contains(titulo)) {
				resultado.add(libros[i]);
			}
		}


		logger.debug("Libros encontrados: {} ", resultado.size());
		return resultado;
	}

}
