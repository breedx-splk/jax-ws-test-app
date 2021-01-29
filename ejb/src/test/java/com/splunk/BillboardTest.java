package com.splunk;

import org.junit.jupiter.api.Test;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BillboardTest {

    @Test
    public void test() throws Exception {
        Service billboardService = Service.create(
                new URL("http://localhost:8080/BillboardWSService/BillboardWS?wsdl"),
                new QName("http://splunk.com/wsdl", "BillboardWSService"));

        assertNotNull(billboardService);

        QName portName = new QName("http://splunk.com/wsdl", "BillboardWSPort");
        Billboard billboard = billboardService.getPort(portName, Billboard.class);
        String current = billboard.read();
        System.out.println("Current billboard says: " + current);
        String newMessage = "The time is " + new Date();
        billboard.post(newMessage);
        String result = billboard.read();
        assertEquals(newMessage, result);
        System.out.println("It now says: " + result);
    }
}
