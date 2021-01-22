package com.splunk.chem;

import javax.jws.WebService;

@WebService(targetNamespace = "http://splunk.com/wsdl")
public interface ChemCheckWs {

     ChemCheckResponse doInquiry(ChemCheckRequest inquiry);

}
