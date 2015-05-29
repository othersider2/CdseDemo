
package com.cdse.lookup;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.cdse.lookup package. 
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

    private final static QName _GetPhoneNumberResponse_QNAME = new QName("http://lookup.cdse.com/", "getPhoneNumberResponse");
    private final static QName _GetPhoneNumber_QNAME = new QName("http://lookup.cdse.com/", "getPhoneNumber");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.cdse.lookup
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetPhoneNumber }
     * 
     */
    public GetPhoneNumber createGetPhoneNumber() {
        return new GetPhoneNumber();
    }

    /**
     * Create an instance of {@link GetPhoneNumberResponse }
     * 
     */
    public GetPhoneNumberResponse createGetPhoneNumberResponse() {
        return new GetPhoneNumberResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPhoneNumberResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lookup.cdse.com/", name = "getPhoneNumberResponse")
    public JAXBElement<GetPhoneNumberResponse> createGetPhoneNumberResponse(GetPhoneNumberResponse value) {
        return new JAXBElement<GetPhoneNumberResponse>(_GetPhoneNumberResponse_QNAME, GetPhoneNumberResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPhoneNumber }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lookup.cdse.com/", name = "getPhoneNumber")
    public JAXBElement<GetPhoneNumber> createGetPhoneNumber(GetPhoneNumber value) {
        return new JAXBElement<GetPhoneNumber>(_GetPhoneNumber_QNAME, GetPhoneNumber.class, null, value);
    }

}
