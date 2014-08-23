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
 * Entidad producto
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 * @version 1.0
 */
public class Producto implements Serializable {

	private static final long serialVersionUID = 9205815095796376735L;

	private int numeroProducto;

	private String descripcion;

	private int cantidad;

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return "nomProducto: " + numeroProducto + ", descripcion: " + descripcion;
	}

	/**
	 * @return numeroProducto
	 */
	public int getNumeroProducto() {
		return numeroProducto;
	}

	/**
	 * @param numeroProducto para inicializar el atributo numeroProducto
	 */
	public void setNumeroProducto(int numeroProducto) {
		this.numeroProducto = numeroProducto;
	}

	/**
	 * @return descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion para inicializar el atributo descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad para inicializar el atributo cantidad
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
