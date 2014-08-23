/**
 * Fecha de creación: Feb 20, 2009, 4:46:56 PM
 *
 * Copyright (c) 2010 SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software es información pueder ser mofificado, utilizado
 * haciendo referencia al autor intelectual.
 */
package com.synergyj.cursos.webservices.lab4;

import java.util.ArrayList;
import java.util.Date;

import com.synergyj.cursos.webservices.entidades.compras.Cliente;
import com.synergyj.cursos.webservices.entidades.compras.Orden;
import com.synergyj.cursos.webservices.entidades.compras.Producto;

/**
 * TODO [Descripcion de la clase]
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 * @version 1.0
 */
public class TestCaseMocks {

	public static Cliente getCliente() {

		Cliente cliente;
		cliente = new Cliente();
		cliente.setNombre("Julian");
		cliente.setApellidoPaterno("Martinez");
		cliente.setApellidoMaterno("Aguirre");
		cliente.setNumeroTarjeta("4567344546344567");
		return cliente;

	}

	public static Orden getOrdenCompra() {

		Orden ordenCompra;

		ordenCompra = new Orden();
		ordenCompra.setCliente(getCliente());
		ordenCompra.setFechaOrden(new Date());
		ordenCompra.setNumeroOrden(7834);
		return ordenCompra;

	}

	public static ArrayList<Producto> getListaProductos() {
		ArrayList<Producto> lista;
		Producto producto;

		lista = new ArrayList<Producto>();
		producto = new Producto();
		producto.setCantidad(10);
		producto.setDescripcion("Lap top dell");
		producto.setNumeroProducto(3940);
		lista.add(producto);

		producto = new Producto();
		producto.setCantidad(5);
		producto.setDescripcion("Monitor LG");
		producto.setNumeroProducto(45904);
		lista.add(producto);

		return lista;
	}
}
