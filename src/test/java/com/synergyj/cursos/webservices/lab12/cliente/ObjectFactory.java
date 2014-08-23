
package com.synergyj.cursos.webservices.lab12.cliente;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.synergyj.cursos.webservices.lab12.cliente package. 
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

    private final static QName _GetWebServiceBooksResponse_QNAME = new QName("http://document.sei.webservices.cursos.synergyj.com/", "getWebServiceBooksResponse");
    private final static QName _GetWebServiceBooks_QNAME = new QName("http://document.sei.webservices.cursos.synergyj.com/", "getWebServiceBooks");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.synergyj.cursos.webservices.lab12.cliente
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetWebServiceBooksResponse }
     * 
     */
    public GetWebServiceBooksResponse createGetWebServiceBooksResponse() {
        return new GetWebServiceBooksResponse();
    }

    /**
     * Create an instance of {@link GetWebServiceBooks }
     * 
     */
    public GetWebServiceBooks createGetWebServiceBooks() {
        return new GetWebServiceBooks();
    }

    /**
     * Create an instance of {@link BookImage }
     * 
     */
    public BookImage createBookImage() {
        return new BookImage();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWebServiceBooksResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://document.sei.webservices.cursos.synergyj.com/", name = "getWebServiceBooksResponse")
    public JAXBElement<GetWebServiceBooksResponse> createGetWebServiceBooksResponse(GetWebServiceBooksResponse value) {
        return new JAXBElement<GetWebServiceBooksResponse>(_GetWebServiceBooksResponse_QNAME, GetWebServiceBooksResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWebServiceBooks }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://document.sei.webservices.cursos.synergyj.com/", name = "getWebServiceBooks")
    public JAXBElement<GetWebServiceBooks> createGetWebServiceBooks(GetWebServiceBooks value) {
        return new JAXBElement<GetWebServiceBooks>(_GetWebServiceBooks_QNAME, GetWebServiceBooks.class, null, value);
    }

}
