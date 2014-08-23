/**
 * Fecha de creación: Feb 20, 2009, 4:46:56 PM
 *
 * Copyright (c) 2010 SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software es información pueder ser mofificado, utilizado
 * haciendo referencia al autor intelectual.
 */
package com.synergyj.cursos.webservices.entidades;

import java.io.Serializable;

/**
 * TODO [Descripcion de la clase]
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 * @version 1.0
 */
public class BookImage implements Serializable {

	private static final long serialVersionUID = -2944510451843101885L;

	private String name;

	private byte[] image;

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name para inicializar el atributo name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return image
	 */
	public byte[] getImage() {
		return image;
	}

	/**
	 * @param image para inicializar el atributo image
	 */
	public void setImage(byte[] image) {
		this.image = image;
	}

}
