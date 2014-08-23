/**
 * Fecha de creación: Feb 20, 2009, 4:46:56 PM
 *
 * Copyright (c) 2010 SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software es información pueder ser mofificado, utilizado
 * haciendo referencia al autor intelectual.
 */
package com.synergyj.cursos.webservices.soap.faults;

/**
 * Esta clase muestra en uso de Faults en un WS
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 * @version 1.0
 */
public class CreditoException extends Exception {

	private static final long serialVersionUID = 5756457280118019146L;

	private String detalle;

	/**
	 * Constructor requerido
	 * @param razon
	 * @param detalle
	 */
	public CreditoException(String razon, String detalle) {
		super(razon);
		this.detalle = detalle;
	}

	/**
	 * Metodo requerido por JWS empleado para obtener el detalle del error.
	 */
	public String getFaultInfo() {
		return this.detalle;
	}
}
