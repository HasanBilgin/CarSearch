package com.hasanbilgin.carsearch.controller;

import com.hasanbilgin.carsearch.model.Car;
import com.hasanbilgin.carsearch.service.CarService;
import com.hasanbilgin.carsearch.util.CarSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarSearchController {
    @Autowired
    private CarService service;

    @GetMapping(value = "/cars", produces = "application/json")
    public List<Car> search (@RequestBody CarSearch carSearch)   {
        return service.search(carSearch.getCriteria(),carSearch.getKey());
    }
    @GetMapping(value = "/{criteria}/{key}", produces = "application/json")
    public List<Car> search (@PathVariable String criteria, @PathVariable String key)   {
        return service.search(criteria,key);
    }
    }
