/**
 * Fecha de creación: 29/01/2011 20:33:55
 *
 * Copyright (c) 2011 SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software es información pueder ser mofificado, utilizado
 * haciendo referencia al autor intelectual.
 */
package com.synergyj.cursos.webservices.entidades.libros;

import java.io.Serializable;

/**
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 * @version 1.0
 */
public class Libro implements Serializable {

	private static final long serialVersionUID = 6625765189120984154L;

	private String autor;

	private String titulo;

	private double precio;

	/**
	 * 
	 */
	public Libro() {
	}

	/**
	 * @param autor
	 * @param titulo
	 * @param precio
	 */
	public Libro(String titulo, String autor, double precio) {
		super();
		this.autor = autor;
		this.titulo = titulo;
		this.precio = precio;
	}

	private byte[] foto;

	/**
	 * @return autor
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * @param autor para inicializar el atributo autor
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}

	/**
	 * @return titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo para inicializar el atributo titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return foto
	 */
	public byte[] getFoto() {
		return foto;
	}

	/**
	 * @param foto para inicializar el atributo foto
	 */
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	/**
	 * @return precio
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * @param precio para inicializar el atributo precio
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

}
