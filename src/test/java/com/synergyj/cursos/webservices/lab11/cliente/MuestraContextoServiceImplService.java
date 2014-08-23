
package com.synergyj.cursos.webservices.lab11.cliente;

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
@WebServiceClient(name = "MuestraContextoServiceImplService", targetNamespace = "http://rpc.sib.webservices.cursos.synergyj.com/", wsdlLocation = "http://127.0.0.1:9878/muestraContextoService?wsdl")
public class MuestraContextoServiceImplService
    extends Service
{

    private final static URL MUESTRACONTEXTOSERVICEIMPLSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(com.synergyj.cursos.webservices.lab11.cliente.MuestraContextoServiceImplService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = com.synergyj.cursos.webservices.lab11.cliente.MuestraContextoServiceImplService.class.getResource(".");
            url = new URL(baseUrl, "http://127.0.0.1:9878/muestraContextoService?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://127.0.0.1:9878/muestraContextoService?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        MUESTRACONTEXTOSERVICEIMPLSERVICE_WSDL_LOCATION = url;
    }

    public MuestraContextoServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public MuestraContextoServiceImplService() {
        super(MUESTRACONTEXTOSERVICEIMPLSERVICE_WSDL_LOCATION, new QName("http://rpc.sib.webservices.cursos.synergyj.com/", "MuestraContextoServiceImplService"));
    }

    /**
     * 
     * @return
     *     returns MuestraContextoServiceImpl
     */
    @WebEndpoint(name = "MuestraContextoServiceImplPort")
    public MuestraContextoServiceImpl getMuestraContextoServiceImplPort() {
        return super.getPort(new QName("http://rpc.sib.webservices.cursos.synergyj.com/", "MuestraContextoServiceImplPort"), MuestraContextoServiceImpl.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns MuestraContextoServiceImpl
     */
    @WebEndpoint(name = "MuestraContextoServiceImplPort")
    public MuestraContextoServiceImpl getMuestraContextoServiceImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://rpc.sib.webservices.cursos.synergyj.com/", "MuestraContextoServiceImplPort"), MuestraContextoServiceImpl.class, features);
    }

}