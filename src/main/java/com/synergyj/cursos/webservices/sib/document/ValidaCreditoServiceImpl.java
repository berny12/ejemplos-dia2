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

import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.synergyj.cursos.webservices.sei.document.ValidaCreditoService;
import com.synergyj.cursos.webservices.soap.faults.CreditoException;

/**
 * TODO [Descripcion de la clase]
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 * @version 1.0
 */
@WebService(endpointInterface = "com.synergyj.cursos.webservices.sei.document.ValidaCreditoService")
public class ValidaCreditoServiceImpl implements ValidaCreditoService {

	/**
	 * Logger para todas las instancias de la clase
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(ValidaCreditoServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * @see com.synergyj.cursos.webservices.sei.rpc.ValidaCreditoService#validaCredito
	 * (java.lang.String)
	 */
	@Override
	public void validaCredito(String numeroTarjeta) throws CreditoException {
		logger.debug("Validando  tarjeta de credito : " + numeroTarjeta);
		if (numeroTarjeta == null || numeroTarjeta.trim().length() != 16) {
			throw new CreditoException("La tarjeta " + numeroTarjeta + " es invalida",
					"La longitud de la tarjeta debe ser de 16 digitos.");
		} else {
			logger.debug("tarjeta valida, continuando con el pago.");
		}
	}

}
