package com.synergyj.cursos.webservices.soap.utilerias;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO [Descripcion de la clase]
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 * @version 1.0
 */
public class UtileriasSOAP {

	/**
	 * Logger para todas las instancias de la clase
	 */
	private static final Logger logger = LoggerFactory.getLogger(UtileriasSOAP.class);

	/**
	 * Este metodo regresa el body en formato XML
	 * @param xml
	 * @param prefix
	 * @return Cadena en XML del body
	 */
	static public String obtenerTextoBody(String xml, String prefix) {
		String body = null;

		// find soap body start index
		String cuerpo = xml;

		// Encontramos el inicio del body
		int indiceInicioBody = cuerpo.indexOf("<" + prefix + ":Body");

		int indiceInicioFinBody = cuerpo.indexOf("</" + prefix + ":Body>");
		// Encontramos el fin del body
		int indiceFinTagBody = cuerpo.indexOf(">", indiceInicioFinBody);

		// Obtenemos el XML del body del mensaje SOAP
		body = cuerpo.substring(indiceInicioBody, indiceFinTagBody + 1);
		logger.debug("El body es el siguiente: " + body);

		return body;

	}

	/**
	 * Método que calcula la firma MD5 del contenido XML, debe ser el mismo algoritmo del
	 * cliente.
	 * @param texto String para el que se calculará la firma MD5.
	 * @return String, la firma MD5 como secuencia de digitos hexadecimales.
	 */

	static public String calculateMD5Signature(String texto) {
		logger.debug("Estoy firmando :");
		logger.debug("La longitud es :" + texto.length());
		StringBuffer hexString = new StringBuffer();

		try {
			MessageDigest algorithm = MessageDigest.getInstance("MD5");

			algorithm.reset();
			algorithm.update(texto.getBytes());
			byte[] digest = algorithm.digest();

			for (int i = 0; i < digest.length; i++) {
				hexString.append(Integer.toHexString(0xFF & digest[i]));
				hexString.append(" ");
			}

			logger.debug(hexString.toString());
		} catch (NoSuchAlgorithmException e) {
			logger.debug("Error al calcular el MD5", e);
		}
		return hexString.toString();
	}

	/**
	 * Este metodo valida el nombre y password
	 * @param usuario
	 * @param password
	 * @return Si es valido
	 */
	static public boolean validaUsuario(String usuario, String password) {
		boolean valida = false;
		if (usuario.startsWith("user") && password.startsWith("admin"))
			valida = true;

		return valida;

	}

	/**
	 * Funcion que obtiene los datos de un archivo en file System.
	 * @param nombreArchivo
	 * @return Los datos del archivo
	 */
	static public String datosArchivo(String nombreArchivo) {
		String datos = null;
		File archivo = new File(nombreArchivo);

		if (archivo.exists()) {
			datos = "Nombre :" + archivo.getName() + " longitud :" + archivo.length();

		}
		return datos;

	}

	/**
	 * Funcion que obtiene que abre un archivo y lo regresa como un arreglo de bytes.
	 * @param fileName
	 * @param datos
	 */
	static public void writeBytes(String fileName, byte[] datos) {
		try {
			FileOutputStream salida = new FileOutputStream(new File(fileName));

			salida.write(datos);

			salida.close();

		} catch (FileNotFoundException fileNotFoundException) {
			logger.error("No extiste el archivo " + fileName, fileNotFoundException);
		} catch (IOException ioException) {
			logger.error("Error al escribir al archivo " + fileName, ioException);
		}
	}
}
