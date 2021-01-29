package com.splunk.chem;

public class ChemCheckResponse {

    private String status  = "unknown";

    public ChemCheckResponse() {

    }

    public ChemCheckResponse(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
