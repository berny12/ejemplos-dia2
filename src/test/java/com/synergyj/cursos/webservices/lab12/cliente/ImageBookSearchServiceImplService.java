
package com.synergyj.cursos.webservices.lab12.cliente;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "ImageBookSearchServiceImplService", targetNamespace = "http://document.sib.webservices.cursos.synergyj.com/", wsdlLocation = "http://127.0.0.1:9878/imageBookSearchService?wsdl")
public class ImageBookSearchServiceImplService
    extends Service
{

    private final static URL IMAGEBOOKSEARCHSERVICEIMPLSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(com.synergyj.cursos.webservices.lab12.cliente.ImageBookSearchServiceImplService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = com.synergyj.cursos.webservices.lab12.cliente.ImageBookSearchServiceImplService.class.getResource(".");
            url = new URL(baseUrl, "http://127.0.0.1:9878/imageBookSearchService?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://127.0.0.1:9878/imageBookSearchService?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        IMAGEBOOKSEARCHSERVICEIMPLSERVICE_WSDL_LOCATION = url;
    }

    public ImageBookSearchServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ImageBookSearchServiceImplService() {
        super(IMAGEBOOKSEARCHSERVICEIMPLSERVICE_WSDL_LOCATION, new QName("http://document.sib.webservices.cursos.synergyj.com/", "ImageBookSearchServiceImplService"));
    }

    /**
     * 
     * @return
     *     returns ImageBookSearchService
     */
    @WebEndpoint(name = "ImageBookSearchServiceImplPort")
    public ImageBookSearchService getImageBookSearchServiceImplPort() {
        return super.getPort(new QName("http://document.sib.webservices.cursos.synergyj.com/", "ImageBookSearchServiceImplPort"), ImageBookSearchService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ImageBookSearchService
     */
    @WebEndpoint(name = "ImageBookSearchServiceImplPort")
    public ImageBookSearchService getImageBookSearchServiceImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://document.sib.webservices.cursos.synergyj.com/", "ImageBookSearchServiceImplPort"), ImageBookSearchService.class, features);
    }

}
