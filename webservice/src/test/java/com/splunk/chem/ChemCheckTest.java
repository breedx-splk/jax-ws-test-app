package com.splunk.chem;

import org.junit.jupiter.api.Test;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ChemCheckTest {

    @Test
    public void test() throws Exception {
        Service ChemCheckService = Service.create(
                new URL("http://localhost:8080/ChemCheckService/ChemCheck?wsdl"),
                new QName("http://splunk.com/wsdl", "ChemCheckService"));

        assertNotNull(ChemCheckService);

        ChemCheckWs calculator = ChemCheckService.getPort(ChemCheckWs.class);
        ChemCheckResponse response = calculator.doInquiry(new ChemCheckRequest("billy"));
        assertEquals("great job : billy", response.getStatus());
    }
}
