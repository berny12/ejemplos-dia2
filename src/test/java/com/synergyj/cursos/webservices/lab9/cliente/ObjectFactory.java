
package com.synergyj.cursos.webservices.lab9.cliente;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.synergyj.cursos.webservices.lab9.cliente package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RecibeDatos_QNAME = new QName("http://document.sei.webservices.cursos.synergyj.com/", "recibeDatos");
    private final static QName _RecibeDatosResponse_QNAME = new QName("http://document.sei.webservices.cursos.synergyj.com/", "recibeDatosResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.synergyj.cursos.webservices.lab9.cliente
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RecibeDatosResponse }
     * 
     */
    public RecibeDatosResponse createRecibeDatosResponse() {
        return new RecibeDatosResponse();
    }

    /**
     * Create an instance of {@link RecibeDatos }
     * 
     */
    public RecibeDatos createRecibeDatos() {
        return new RecibeDatos();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RecibeDatos }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://document.sei.webservices.cursos.synergyj.com/", name = "recibeDatos")
    public JAXBElement<RecibeDatos> createRecibeDatos(RecibeDatos value) {
        return new JAXBElement<RecibeDatos>(_RecibeDatos_QNAME, RecibeDatos.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RecibeDatosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://document.sei.webservices.cursos.synergyj.com/", name = "recibeDatosResponse")
    public JAXBElement<RecibeDatosResponse> createRecibeDatosResponse(RecibeDatosResponse value) {
        return new JAXBElement<RecibeDatosResponse>(_RecibeDatosResponse_QNAME, RecibeDatosResponse.class, null, value);
    }

}
