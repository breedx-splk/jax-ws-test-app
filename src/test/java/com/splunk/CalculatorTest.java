package com.splunk;

import org.junit.jupiter.api.Test;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CalculatorTest {

    @Test
    public void test() throws Exception {
        Service calculatorService = Service.create(
                new URL("http://localhost:8080/CalculatorService/Calculator?wsdl"),
                new QName("http://splunk.com/wsdl", "CalculatorService"));

        assertNotNull(calculatorService);

        CalculatorWs calculator = calculatorService.getPort(CalculatorWs.class);
        assertEquals(10, calculator.sum(4, 6));
        assertEquals(132, calculator.multiply(33, 4));
    }
}
