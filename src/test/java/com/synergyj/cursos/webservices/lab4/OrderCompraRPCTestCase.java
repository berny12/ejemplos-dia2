/**
 * Fecha de creaci�n: Feb 20, 2009, 4:46:56 PM
 *
 * Copyright (c) 2010 SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software es informaci�n pueder ser mofificado, utilizado
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
import com.synergyj.cursos.webservices.sei.rpc.OrdenCompraService;

/**
 * Test case empleado para invocar al WS de orden de compras empleando estilo RPC
 * @author Jorge Rodr�guez Campos (jorge.rodriguez@synergyj.com)
 * @version 1.0
 */
public class OrderCompraRPCTestCase {

	/**
	 * Logger para todas las instancias de la clase
	 */
	private static final Logger logger = LoggerFactory.getLogger(OrderCompraRPCTestCase.class);

	@Test
	public void generaOrdenCompra() throws Exception {

		Orden ordenCompra;
		ArrayList<Producto> lista;
		boolean valido;

		logger.debug("Creando orden de compra");

		ordenCompra = TestCaseMocks.getOrdenCompra();
		lista = TestCaseMocks.getListaProductos();

		logger.debug("Invocando WS OrdenCompraService estilo rpc");
		URL url = new URL("http://127.0.0.1:8080/ordenCompraService?wsdl");

		// Qualified name del WS
		QName qname = new QName("http://rpc.sib.webservices.cursos.synergyj.com/",
				"OrdenCompraServiceImplService");

		// creacion factory del servicio
		Service service = Service.create(url, qname);

		// endpoint interface � service port.
		OrdenCompraService ordenCompraService = service.getPort(OrdenCompraService.class);

		valido = ordenCompraService.validaOrden(new Date(), 1, ordenCompra, lista);

		logger.debug("orden valida: " + valido);

	}
}
