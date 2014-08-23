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
import java.util.Date;

/**
 * Entidad Orden
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 * @version 1.0
 */
public class Orden implements Serializable {

	private static final long serialVersionUID = 6009800830123058750L;

	private long numeroOrden;

	private Cliente cliente;

	private Date fechaOrden;

	/**
	 * @return numeroOrden
	 */
	public long getNumeroOrden() {
		return numeroOrden;
	}

	/**
	 * @param numeroOrden para inicializar el atributo numeroOrden
	 */
	public void setNumeroOrden(long numeroOrden) {
		this.numeroOrden = numeroOrden;
	}

	/**
	 * @return cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente para inicializar el atributo cliente
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return fechaOrden
	 */
	public Date getFechaOrden() {
		return fechaOrden;
	}

	/**
	 * @param fechaOrden para inicializar el atributo fechaOrden
	 */
	public void setFechaOrden(Date fechaOrden) {
		this.fechaOrden = fechaOrden;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("numero: ").append(numeroOrden).append(", cliente: ").append(cliente)
				.append(",fechaOrden: ").append(fechaOrden);
		return sb.toString();

	}

}
