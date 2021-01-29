package com.splunk;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.concurrent.atomic.AtomicReference;

@Stateless
@WebService(targetNamespace = "http://splunk.com/wsdl")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class BillboardWS implements Billboard {

    private final AtomicReference<String> msg = new AtomicReference<>("hello");

    @WebMethod
    @Override
    public void post(String msg) {
        this.msg.set(msg);
    }

    @WebMethod
    @Override
    public String read() {
        return msg.get();
    }
}
