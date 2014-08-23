
package com.synergyj.cursos.webservices.lab11.cliente;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.synergyj.cursos.webservices.lab11.cliente package. 
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

    private final static QName _MuestraContexto_QNAME = new QName("http://rpc.sib.webservices.cursos.synergyj.com/", "muestraContexto");
    private final static QName _MuestraContextoResponse_QNAME = new QName("http://rpc.sib.webservices.cursos.synergyj.com/", "muestraContextoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.synergyj.cursos.webservices.lab11.cliente
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MuestraContexto }
     * 
     */
    public MuestraContexto createMuestraContexto() {
        return new MuestraContexto();
    }

    /**
     * Create an instance of {@link MuestraContextoResponse }
     * 
     */
    public MuestraContextoResponse createMuestraContextoResponse() {
        return new MuestraContextoResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MuestraContexto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rpc.sib.webservices.cursos.synergyj.com/", name = "muestraContexto")
    public JAXBElement<MuestraContexto> createMuestraContexto(MuestraContexto value) {
        return new JAXBElement<MuestraContexto>(_MuestraContexto_QNAME, MuestraContexto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MuestraContextoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rpc.sib.webservices.cursos.synergyj.com/", name = "muestraContextoResponse")
    public JAXBElement<MuestraContextoResponse> createMuestraContextoResponse(MuestraContextoResponse value) {
        return new JAXBElement<MuestraContextoResponse>(_MuestraContextoResponse_QNAME, MuestraContextoResponse.class, null, value);
    }

}
