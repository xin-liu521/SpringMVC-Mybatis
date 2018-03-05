package com.infoyb.supplier.base;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.4.3
 * 2017-12-06T10:10:54.439+08:00
 * Generated source version: 2.4.3
 * 
 */
@WebServiceClient(name = "SubmitOutUnitService", 
                  wsdlLocation = "http://10.20.2.45:8080/bymdm/services/SubmitOutUnitService?wsdl",
                  targetNamespace = "urn:SubmitOutUnitService") 
public class SubmitOutUnitService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("urn:SubmitOutUnitService", "SubmitOutUnitService");
    public final static QName OutUnitServiceImplPort = new QName("urn:SubmitOutUnitService", "OutUnitServiceImplPort");
    static {
        URL url = null;
        try {
            url = new URL("http://10.20.2.45:8080/bymdm/services/SubmitOutUnitService?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(SubmitOutUnitService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:/F:/workspace/infoyb-supplier/src/main/java/com/infoyb/supplier/base/SubmitOutUnitService.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public SubmitOutUnitService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public SubmitOutUnitService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SubmitOutUnitService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public SubmitOutUnitService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public SubmitOutUnitService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public SubmitOutUnitService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns OutUnitService
     */
    @WebEndpoint(name = "OutUnitServiceImplPort")
    public OutUnitService getOutUnitServiceImplPort() {
        return super.getPort(OutUnitServiceImplPort, OutUnitService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns OutUnitService
     */
    @WebEndpoint(name = "OutUnitServiceImplPort")
    public OutUnitService getOutUnitServiceImplPort(WebServiceFeature... features) {
        return super.getPort(OutUnitServiceImplPort, OutUnitService.class, features);
    }

}
