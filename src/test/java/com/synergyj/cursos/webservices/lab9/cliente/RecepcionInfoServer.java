
package com.synergyj.cursos.webservices.lab9.cliente;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "RecepcionInfoServer", targetNamespace = "http://document.sei.webservices.cursos.synergyj.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface RecepcionInfoServer {


    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "recibeDatos", targetNamespace = "http://document.sei.webservices.cursos.synergyj.com/", className = "com.synergyj.cursos.webservices.lab9.cliente.RecibeDatos")
    @ResponseWrapper(localName = "recibeDatosResponse", targetNamespace = "http://document.sei.webservices.cursos.synergyj.com/", className = "com.synergyj.cursos.webservices.lab9.cliente.RecibeDatosResponse")
    public void recibeDatos(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
