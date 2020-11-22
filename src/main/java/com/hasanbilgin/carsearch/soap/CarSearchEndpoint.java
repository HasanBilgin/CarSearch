package com.hasanbilgin.carsearch.soap;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CarSearchEndpoint {
    @PayloadRoot(namespace = "http://localhost:8080/carSearchSoap", localPart = "GetCarSearchRequest")
    @ResponsePayload
    public GetCarSearchResponse processCourseDetailsRequest(@RequestPayload GetCarSearchRequest request) {
        GetCarSearchResponse response = new GetCarSearchResponse();
        return response;
    }
}