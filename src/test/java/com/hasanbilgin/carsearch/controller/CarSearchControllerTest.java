package com.hasanbilgin.carsearch.controller;

import com.hasanbilgin.carsearch.model.Car;
import com.hasanbilgin.carsearch.service.CarService;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
public class CarSearchControllerTest {
    private final CarService carService = new CarService();

    @Test
    public void controlBrand() throws Exception {
        List<Car> carList = carService.search("marka","BMC");
        Assert.assertEquals(0,carList.stream().filter(car -> !car.getBrand().equals("BMC")).count());
    }

    @Test
    public void controlModel() throws Exception {
        List<Car> carList = carService.search("model","A3");
        Assert.assertEquals(0,carList.stream().filter(car -> !car.getModel().equals("A3")).count());
    }
    @Test
    public void controlType() throws Exception {
        List<Car> carList = carService.search("sınıf","Pick-up");
        Assert.assertEquals(0,carList.stream().filter(car -> !car.getType().contains("Pick-up")).count());
    }
    @Test
    public void controlAll() throws Exception {
        List<Car> carList = carService.search("hepsi","i");
        Assert.assertEquals(9,carList.size());
    }

}