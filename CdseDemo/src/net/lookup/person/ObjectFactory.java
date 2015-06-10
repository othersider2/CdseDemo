
package net.lookup.person;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the net.lookup.person package. 
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

    private final static QName _GetPersonWS_QNAME = new QName("http://person.lookup.net/", "getPersonWS");
    private final static QName _GetPersonWSResponse_QNAME = new QName("http://person.lookup.net/", "getPersonWSResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: net.lookup.person
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetPersonWS }
     * 
     */
    public GetPersonWS createGetPersonWS() {
        return new GetPersonWS();
    }

    /**
     * Create an instance of {@link GetPersonWSResponse }
     * 
     */
    public GetPersonWSResponse createGetPersonWSResponse() {
        return new GetPersonWSResponse();
    }

    /**
     * Create an instance of {@link PersonListContainer }
     * 
     */
    public PersonListContainer createPersonListContainer() {
        return new PersonListContainer();
    }

    /**
     * Create an instance of {@link PersonWS }
     * 
     */
    public PersonWS createPersonWS() {
        return new PersonWS();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersonWS }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://person.lookup.net/", name = "getPersonWS")
    public JAXBElement<GetPersonWS> createGetPersonWS(GetPersonWS value) {
        return new JAXBElement<GetPersonWS>(_GetPersonWS_QNAME, GetPersonWS.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersonWSResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://person.lookup.net/", name = "getPersonWSResponse")
    public JAXBElement<GetPersonWSResponse> createGetPersonWSResponse(GetPersonWSResponse value) {
        return new JAXBElement<GetPersonWSResponse>(_GetPersonWSResponse_QNAME, GetPersonWSResponse.class, null, value);
    }

}
