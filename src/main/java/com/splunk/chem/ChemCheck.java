package com.splunk.chem;
import com.signalfx.tracing.api.Trace;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.jws.HandlerChain;
import javax.jws.WebService;

@Stateless
@WebService(
        serviceName = "ChemCheckService",
        portName = "ChemCheckPort",
        endpointInterface = "com.splunk.chem.ChemCheckWs",
        targetNamespace = "http://splunk.com/wsdl"
//        wsdlLocation = "META-INF/wsdl/ChemCheck/ChemCheck.wsdl" // I couldn't ever get this to work
)
@HandlerChain(name = "com.splunk.chem.GenericSoapHandler", file = "handlers.xml")
// handlerchain extracts data from the request and response and writes it async to a log/database.
public class ChemCheck extends DefaultRetailWebService {

    @PostConstruct
    public void init() {
        System.out.println("DEBUG: ChemCheck init()");
    }

    @Trace
    public ChemCheckResponse doInquiry(ChemCheckRequest inquiry) {
        return new ChemCheckResponse("great job : " + inquiry.getValue());
    }
}