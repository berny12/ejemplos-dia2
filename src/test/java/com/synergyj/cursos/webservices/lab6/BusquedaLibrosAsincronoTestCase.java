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

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.synergyj.cursos.webservices.lab6.cliente.BuscaLibrosResponse;
import com.synergyj.cursos.webservices.lab6.cliente.BusquedaLibrosService;
import com.synergyj.cursos.webservices.lab6.cliente.BusquedaLibrosServiceImplService;
import com.synergyj.cursos.webservices.lab6.cliente.Libro;
import com.synergyj.cursos.webservices.soap.handlers.SecurityClienteHandler;

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
	public void buscaLibrosFormaSincrona() throws InterruptedException, ExecutionException,
			TimeoutException {

		BusquedaLibrosServiceImplService service;
		BusquedaLibrosService busqueda = null;

		service = new BusquedaLibrosServiceImplService();
		
		//se agrega el handlerresolver para que use el handler
		service.setHandlerResolver(new HandlerResolver() {

			@Override
			public List<Handler> getHandlerChain(PortInfo portInfo) {
				List<Handler> lista = new ArrayList<Handler>();
				lista.add(new SecurityClienteHandler());
				return lista;
			}
			
		});
		
		busqueda = service.getBusquedaLibrosServiceImplPort();
		List<Libro> libros = busqueda.buscaLibros("Andrew J. Oppel", "SOA", null);		
		
		logger.debug("Resultados de la busqueda");
		for (Libro libro : libros) {
			logger.debug("titulo: " + libro.getTitulo());
			logger.debug("autor: " + libro.getAutor());
		}

	}

	//consumiendo en WS de forma asincorna
	//@Test
	public void buscaLibrosFormaAsincrona() throws InterruptedException,ExecutionException, TimeoutException{
		
		BusquedaLibrosServiceImplService service = new BusquedaLibrosServiceImplService();
		
		//clase que permite manejar la respuesta de mi WS BusquedadLibrosResponse
		AsyncHandler<BuscaLibrosResponse> handler;
		Future<?> future;
		
		handler = new AsyncHandler<BuscaLibrosResponse>() {

			@Override
			public void handleResponse(Response<BuscaLibrosResponse> res) {
				
				
				logger.debug("Respuesta-- El numero de libros obtenidos:");
				
				 try {
					
					logger.debug(""+res.get().getReturn().size());

					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		};
		
		//agregamos las respuesta para que sea manejada por future
		logger.debug("Peticion-- Haciendo la invocacion al webservice ");
		future = service.getBusquedaLibrosServiceImplPort().buscaLibrosAsync("Andrew J. Oppel", "SOA", null, handler);
		
		//simulamos que hacemos algo
		logger.debug("Cliente-- Haciendo algo");
		Thread.sleep(10000);
		
		//para exigir la respuesta ahora pero si no esperar 3000 ms, pero rompe el patron por que manda la exececion
		//future.get(3000,TimeUnit.MILLISECONDS);
		
		//indicar que se termino la peticion
		logger.debug("Terminando la peticion");
		
		//imprimimos los libros
		for(Libro libro : ((BuscaLibrosResponse)(future.get())).getReturn()){
			logger.debug("Titulo: "+ libro.getTitulo());
			logger.debug("Autor: "+libro.getAutor());
		}
	}
	
	
}
