package com.hasanbilgin.carsearch.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarSearch {
    private String criteria;
    private String key;

    public CarSearch(String criteria, String key) {
        this.criteria = criteria;
        this.key = key;
    }

    public CarSearch() {
    }
}
