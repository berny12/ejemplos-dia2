/**
 * Fecha de creación: Feb 20, 2009, 4:46:56 PM
 *
 * Copyright (c) 2010 SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software es información pueder ser mofificado, utilizado
 * haciendo referencia al autor intelectual.
 */
package com.synergyj.cursos.webservices.lab4;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.synergyj.cursos.webservices.entidades.compras.Orden;
import com.synergyj.cursos.webservices.entidades.compras.Producto;
import com.synergyj.cursos.webservices.sei.document.OrdenCompraService;

/**
 * Test case empleado para invocar al WS de orden de compras empleando estilo Document
 * 
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 * @version 1.0
 */
public class OrderCompraDocumentTestCase {

	/**
	 * Logger para todas las instancias de la clase
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(OrderCompraDocumentTestCase.class);

	@Test
	public void generaOrdenCompra() throws Exception {
		Orden ordenCompra;
		ArrayList<Producto> lista;
		boolean valido;

		logger.debug("Creando orden de compra");

		ordenCompra = TestCaseMocks.getOrdenCompra();
		lista = TestCaseMocks.getListaProductos();

		logger.debug("Invocando WS OrdenCompraService estilo document");
		URL url = new URL("http://127.0.0.1:8080/ordenCompraService?wsdl");

		// Qualified name del WS
		QName qname = new QName("http://document.sib.webservices.cursos.synergyj.com/",
				"OrdenCompraServiceImplService");

		// creacion factory del servicio
		Service service = Service.create(url, qname);
		logger.debug("Servicio creado");
		
		// endpoint interface ó service port.
		OrdenCompraService ordenCompraService = service.getPort(OrdenCompraService.class);
		logger.debug("Obtenido instancia para invocar");


		valido = ordenCompraService.validaOrden(new Date(), 1, ordenCompra, lista);
		logger.debug("orden valida: " + valido);

	}
}
