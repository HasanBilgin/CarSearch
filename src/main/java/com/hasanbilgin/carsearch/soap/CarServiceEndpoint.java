package com.hasanbilgin.carsearch.soap;

import com.hasanbilgin.carsearch.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.stream.Collectors;

@Endpoint
public class CarServiceEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private CarRepository carRepository;
    private CarService service = new CarService();
    @Autowired
    public CarServiceEndpoint(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCarSearchRequest")
    @ResponsePayload
    public GetCarSearchResponse getCarSearchRequest(@RequestPayload GetCarSearchRequest request) {
        GetCarSearchResponse response = new GetCarSearchResponse();
        service.search(request.getCriteria(),request.getSearchKey()).stream().forEach(car -> {
            Car c  = new Car();
            c.setType(car.getType());
            c.setModel(car.getModel());
            c.setBrand(car.getBrand());
            response.getCar().add(c);
        });
        return response;
    }
}
