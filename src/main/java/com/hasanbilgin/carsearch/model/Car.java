package com.hasanbilgin.carsearch.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car {
    private String brand;
    private String model;
    private String type;
    public Car() {};

    public Car(String brand, String model, String type) {
        this.brand = brand;
        this.model = model;
        this.type = type;
    }

    public Car (String line)    {
        String[] carInfo = line.split(";");
        if (carInfo.length == 3 )   {
            this.brand = carInfo[0];
            this.model = carInfo[1];
            this.type  = carInfo[2];
        }



    }
}
