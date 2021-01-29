package com.splunk;

import javax.jws.WebService;

@WebService(targetNamespace = "http://splunk.com/wsdl")
public interface Billboard {

    void post(String msg);
    String read();

}
