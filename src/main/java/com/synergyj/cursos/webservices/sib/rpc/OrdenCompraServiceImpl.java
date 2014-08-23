/**
 * Fecha de creación: Feb 20, 2009, 4:46:56 PM
 *
 * Copyright (c) 2010 SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software es información pueder ser mofificado, utilizado
 * haciendo referencia al autor intelectual.
 */
package com.synergyj.cursos.webservices.sib.rpc;

import java.util.ArrayList;
import java.util.Date;

import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.synergyj.cursos.webservices.entidades.compras.Orden;
import com.synergyj.cursos.webservices.entidades.compras.Producto;
import com.synergyj.cursos.webservices.sei.rpc.OrdenCompraService;

/**
 * TODO [Descripcion de la clase]
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 * @version 1.0
 */
@WebService(endpointInterface = "com.synergyj.cursos.webservices.sei.rpc.OrdenCompraService")
public class OrdenCompraServiceImpl implements OrdenCompraService {

	/**
	 * Logger para todas las instancias de la clase
	 */
	private static final Logger logger = LoggerFactory.getLogger(OrdenCompraServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * @see com.synergyj.cursos.webservices.sei.OrdenCompraService#validaOrden(com
	 * .synergyj.cursos.webservices.entidades.Cliente, java.util.List)
	 */
	@Override
	public boolean validaOrden(Date fechaValidacion, int tipoValidacion, Orden orden,
			ArrayList<Producto> productos) {

		logger.debug("Recibiendo peticion para validar orden de compra");
		logger.debug("fecha Validacion: " + fechaValidacion);
		logger.debug("tipoValidacion: " + tipoValidacion);
		logger.debug("orden: " + orden);
		logger.debug("Lista de productos: " + productos);

		if (tipoValidacion == 0 || orden == null || orden.getCliente() == null
				|| productos == null || productos.size() == 0) {

			logger.debug("Alguno de los parametros son nulos.");
			return false;
		}

		return true;
	}
}
