
package com.synergyj.cursos.webservices.lab10.cliente;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.synergyj.cursos.webservices.lab10.cliente package. 
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

    private final static QName _CreditoException_QNAME = new QName("http://document.sei.webservices.cursos.synergyj.com/", "CreditoException");
    private final static QName _ValidaCredito_QNAME = new QName("http://document.sei.webservices.cursos.synergyj.com/", "validaCredito");
    private final static QName _ValidaCreditoResponse_QNAME = new QName("http://document.sei.webservices.cursos.synergyj.com/", "validaCreditoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.synergyj.cursos.webservices.lab10.cliente
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ValidaCreditoResponse }
     * 
     */
    public ValidaCreditoResponse createValidaCreditoResponse() {
        return new ValidaCreditoResponse();
    }

    /**
     * Create an instance of {@link CreditoException }
     * 
     */
    public CreditoException createCreditoException() {
        return new CreditoException();
    }

    /**
     * Create an instance of {@link ValidaCredito }
     * 
     */
    public ValidaCredito createValidaCredito() {
        return new ValidaCredito();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreditoException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://document.sei.webservices.cursos.synergyj.com/", name = "CreditoException")
    public JAXBElement<CreditoException> createCreditoException(CreditoException value) {
        return new JAXBElement<CreditoException>(_CreditoException_QNAME, CreditoException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidaCredito }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://document.sei.webservices.cursos.synergyj.com/", name = "validaCredito")
    public JAXBElement<ValidaCredito> createValidaCredito(ValidaCredito value) {
        return new JAXBElement<ValidaCredito>(_ValidaCredito_QNAME, ValidaCredito.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidaCreditoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://document.sei.webservices.cursos.synergyj.com/", name = "validaCreditoResponse")
    public JAXBElement<ValidaCreditoResponse> createValidaCreditoResponse(ValidaCreditoResponse value) {
        return new JAXBElement<ValidaCreditoResponse>(_ValidaCreditoResponse_QNAME, ValidaCreditoResponse.class, null, value);
    }

}
