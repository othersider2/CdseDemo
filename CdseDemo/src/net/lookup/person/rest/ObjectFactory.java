
package net.lookup.person.rest;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated package. 
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

    private final static QName _PersonRest_QNAME = new QName("", "personRest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PersonRest }
     * 
     */
    public PersonRest createPersonRest() {
        return new PersonRest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonRest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "personRest")
    public JAXBElement<PersonRest> createPersonRest(PersonRest value) {
        return new JAXBElement<PersonRest>(_PersonRest_QNAME, PersonRest.class, null, value);
    }

}
