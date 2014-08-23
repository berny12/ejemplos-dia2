
package com.synergyj.cursos.webservices.lab6.cliente;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.synergyj.cursos.webservices.lab6.cliente package. 
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

    private final static QName _BuscaLibrosResponse_QNAME = new QName("http://document.sei.webservices.cursos.synergyj.com/", "buscaLibrosResponse");
    private final static QName _BuscaLibros_QNAME = new QName("http://document.sei.webservices.cursos.synergyj.com/", "buscaLibros");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.synergyj.cursos.webservices.lab6.cliente
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BuscaLibros }
     * 
     */
    public BuscaLibros createBuscaLibros() {
        return new BuscaLibros();
    }

    /**
     * Create an instance of {@link Libro }
     * 
     */
    public Libro createLibro() {
        return new Libro();
    }

    /**
     * Create an instance of {@link BuscaLibrosResponse }
     * 
     */
    public BuscaLibrosResponse createBuscaLibrosResponse() {
        return new BuscaLibrosResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscaLibrosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://document.sei.webservices.cursos.synergyj.com/", name = "buscaLibrosResponse")
    public JAXBElement<BuscaLibrosResponse> createBuscaLibrosResponse(BuscaLibrosResponse value) {
        return new JAXBElement<BuscaLibrosResponse>(_BuscaLibrosResponse_QNAME, BuscaLibrosResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscaLibros }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://document.sei.webservices.cursos.synergyj.com/", name = "buscaLibros")
    public JAXBElement<BuscaLibros> createBuscaLibros(BuscaLibros value) {
        return new JAXBElement<BuscaLibros>(_BuscaLibros_QNAME, BuscaLibros.class, null, value);
    }

}
