
package com.cdse.lookup;

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
@WebService(name = "PersonLookup", targetNamespace = "http://lookup.cdse.com/")
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
    @RequestWrapper(localName = "getPhoneNumber", targetNamespace = "http://lookup.cdse.com/", className = "com.cdse.lookup.GetPhoneNumber")
    @ResponseWrapper(localName = "getPhoneNumberResponse", targetNamespace = "http://lookup.cdse.com/", className = "com.cdse.lookup.GetPhoneNumberResponse")
    @Action(input = "http://lookup.cdse.com/PersonLookup/getPhoneNumberRequest", output = "http://lookup.cdse.com/PersonLookup/getPhoneNumberResponse")
    public String getPhoneNumber(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
