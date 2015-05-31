
package net.lookup.person;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "PersonLookup", targetNamespace = "http://person.lookup.net/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface PersonLookup {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getPhoneNumber", targetNamespace = "http://person.lookup.net/", className = "net.lookup.person.GetPhoneNumber")
    @ResponseWrapper(localName = "getPhoneNumberResponse", targetNamespace = "http://person.lookup.net/", className = "net.lookup.person.GetPhoneNumberResponse")
    @Action(input = "http://person.lookup.net/PersonLookup/getPhoneNumberRequest", output = "http://person.lookup.net/PersonLookup/getPhoneNumberResponse")
    public String getPhoneNumber(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}