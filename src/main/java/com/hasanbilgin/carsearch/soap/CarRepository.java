package com.hasanbilgin.carsearch.soap;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class CarRepository {
    private static final List<Car> carList = new ArrayList<>();
    @PostConstruct
    public void initData() {
        Car car = new Car();
        car.setBrand("asd");
        car.setModel("asd");
        car.setType("asd");
        carList.add(car);

        car.setBrand("def");
        car.setModel("def");
        car.setType("def");
        carList.add(car);
    }

}
