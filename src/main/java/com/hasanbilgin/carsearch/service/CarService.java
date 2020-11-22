package com.hasanbilgin.carsearch.service;

import com.hasanbilgin.carsearch.model.Car;
import org.springframework.stereotype.Component;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class CarService {
    private static List<Car> carList;

    public CarService() {
        readCarInfo();
    }

    private void readCarInfo()  {
        carList = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get("src\\main\\resources\\cars.txt"))) {

            stream.forEach(s -> carList.add(new Car(s)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Car> search(String criteria, String key) {
        if ("marka".equals(criteria.toLowerCase()))
            return carList.stream().filter(car -> car.getBrand().toLowerCase().contains(key.toLowerCase())).collect(Collectors.toList());
        if ("model".equals(criteria.toLowerCase()))
            return carList.stream().filter(car -> car.getModel().toLowerCase().contains(key.toLowerCase())).collect(Collectors.toList());
        if ("sınıf".equals(criteria.toLowerCase()))
            return carList.stream().filter(car -> car.getType().toLowerCase().contains(key.toLowerCase())).collect(Collectors.toList());
        if ("hepsi".equals(criteria.toLowerCase()))
            return carList.stream().filter(car ->
                    car.getBrand().toLowerCase().contains(key.toLowerCase()) ||
                     car.getModel().toLowerCase().contains(key.toLowerCase()) ||
                    car.getType() .toLowerCase().contains(key.toLowerCase())
                        ).collect(Collectors.toList());

        return carList;
    }
}
