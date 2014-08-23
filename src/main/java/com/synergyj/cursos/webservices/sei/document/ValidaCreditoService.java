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

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.synergyj.cursos.webservices.soap.faults.CreditoException;

/**
 * TODO [Descripcion de la clase]
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 * @version 1.0
 */
@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface ValidaCreditoService {

	/**
	 * Valida una tarjeta de credito
	 * @param numeroTarjeta
	 * @throws @{@link CreditoException Si la tarjeta es invalida
	 */
	@WebMethod
	void validaCredito(String numeroTarjeta) throws CreditoException;
}
