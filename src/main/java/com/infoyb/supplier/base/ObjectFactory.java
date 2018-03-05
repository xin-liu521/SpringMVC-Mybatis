
package com.infoyb.supplier.base;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.infoyb.supplier.base package. 
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

    private final static QName _OutUnitSubmit_QNAME = new QName("urn:SubmitOutUnitService", "outUnitSubmit");
    private final static QName _OutUnitSubmitResponse_QNAME = new QName("urn:SubmitOutUnitService", "outUnitSubmitResponse");
    private final static QName _SubmitOutUnit_QNAME = new QName("urn:SubmitOutUnit", "SubmitOutUnit");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.infoyb.supplier.base
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link OutUnitSubmit }
     * 
     */
    public OutUnitSubmit createOutUnitSubmit() {
        return new OutUnitSubmit();
    }

    /**
     * Create an instance of {@link OutUnitSubmitResponse }
     * 
     */
    public OutUnitSubmitResponse createOutUnitSubmitResponse() {
        return new OutUnitSubmitResponse();
    }

    /**
     * Create an instance of {@link ReturnMess }
     * 
     */
    public ReturnMess createReturnMess() {
        return new ReturnMess();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OutUnitSubmit }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:SubmitOutUnitService", name = "outUnitSubmit")
    public JAXBElement<OutUnitSubmit> createOutUnitSubmit(OutUnitSubmit value) {
        return new JAXBElement<OutUnitSubmit>(_OutUnitSubmit_QNAME, OutUnitSubmit.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OutUnitSubmitResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:SubmitOutUnitService", name = "outUnitSubmitResponse")
    public JAXBElement<OutUnitSubmitResponse> createOutUnitSubmitResponse(OutUnitSubmitResponse value) {
        return new JAXBElement<OutUnitSubmitResponse>(_OutUnitSubmitResponse_QNAME, OutUnitSubmitResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:SubmitOutUnit", name = "SubmitOutUnit")
    public JAXBElement<String> createSubmitOutUnit(String value) {
        return new JAXBElement<String>(_SubmitOutUnit_QNAME, String.class, null, value);
    }

}
