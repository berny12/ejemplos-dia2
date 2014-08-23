
package com.synergyj.cursos.webservices.lab13.cliente;

import javax.activation.DataHandler;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.synergyj.cursos.webservices.lab13.cliente package. 
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

    private final static QName _GetSong_QNAME = new QName("http://document.sei.webservices.cursos.synergyj.com/", "getSong");
    private final static QName _GetSongResponse_QNAME = new QName("http://document.sei.webservices.cursos.synergyj.com/", "getSongResponse");
    private final static QName _GetSongResponseReturn_QNAME = new QName("", "return");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.synergyj.cursos.webservices.lab13.cliente
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetSongResponse }
     * 
     */
    public GetSongResponse createGetSongResponse() {
        return new GetSongResponse();
    }

    /**
     * Create an instance of {@link GetSong }
     * 
     */
    public GetSong createGetSong() {
        return new GetSong();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSong }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://document.sei.webservices.cursos.synergyj.com/", name = "getSong")
    public JAXBElement<GetSong> createGetSong(GetSong value) {
        return new JAXBElement<GetSong>(_GetSong_QNAME, GetSong.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSongResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://document.sei.webservices.cursos.synergyj.com/", name = "getSongResponse")
    public JAXBElement<GetSongResponse> createGetSongResponse(GetSongResponse value) {
        return new JAXBElement<GetSongResponse>(_GetSongResponse_QNAME, GetSongResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DataHandler }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "return", scope = GetSongResponse.class)
    @XmlMimeType("application/octect-stream")
    public JAXBElement<DataHandler> createGetSongResponseReturn(DataHandler value) {
        return new JAXBElement<DataHandler>(_GetSongResponseReturn_QNAME, DataHandler.class, GetSongResponse.class, value);
    }

}
