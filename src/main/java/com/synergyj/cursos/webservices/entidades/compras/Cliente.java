/**
 * Fecha de creación: Feb 20, 2009, 4:46:56 PM
 *
 * Copyright (c) 2010 SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software es información pueder ser mofificado, utilizado
 * haciendo referencia al autor intelectual.
 */
package com.synergyj.cursos.webservices.entidades.compras;

import java.io.Serializable;

/**
 * Entidad cliente
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 * @version 1.0
 */
public class Cliente implements Serializable {

	private static final long serialVersionUID = -5629254375315517514L;

	private String nombre;

	private String apellidoPaterno;

	private String apellidoMaterno;

	private String numeroTarjeta;

	/**
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre para inicializar el atributo nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return apellidoPaterno
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	/**
	 * @param apellidoPaterno para inicializar el atributo apellidoPaterno
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	/**
	 * @return apellidoMaterno
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	/**
	 * @param apellidoMaterno para inicializar el atributo apellidoMaterno
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	/**
	 * @param numeroTarjeta para inicializar el atributo numeroTarjeta
	 */
	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	/**
	 * @return numeroTarjeta
	 */
	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("nombre: ").append(nombre).append(",apPat: ").append(apellidoPaterno)
				.append(",apMat: ").append(apellidoMaterno).append(", numeroTarjeta: ")
				.append(numeroTarjeta);
		return sb.toString();
	}

}
