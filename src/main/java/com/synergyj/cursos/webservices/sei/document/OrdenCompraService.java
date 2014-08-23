/**
 * Fecha de creación: Feb 20, 2009, 4:46:56 PM
 *
 * Copyright (c) 2010 SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software es información pueder ser mofificado, utilizado
 * haciendo referencia al autor intelectual.
 */
package com.synergyj.cursos.webservices.sei.document;

import java.util.ArrayList;
import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;

import com.synergyj.cursos.webservices.entidades.compras.Orden;
import com.synergyj.cursos.webservices.entidades.compras.Producto;

/**
 * Interface SEI que representa la funcionalidad del WS OrdenCompraService.
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 * @version 1.0
 */
@WebService
// no es necesario especificar Document, es la opcion por default.
@SOAPBinding(style = Style.DOCUMENT)
public interface OrdenCompraService {

	/**
	 * Valida ordenes de compra.
	 * @param cliente
	 * @param productos
	 * @return
	 */
	@WebMethod
	boolean validaOrden(Date fechaValidacion, int tipoValidacion, Orden orden,
			ArrayList<Producto> productos);
}
