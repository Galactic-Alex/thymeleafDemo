package com.example.demo.car.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PropertyHelper {

    private final Map<String, Boolean> sortMap;
    @Value("${isSortByIdOn}")
    private String isSortByIdOn;
    @Value("${isSortByModelOn")
    private String isSortByModelOn;
    @Value("${isSortByMileageOn}")
    private String isSortByMileageOn;
    @Value("$isSortBySeriesOn")
    private String isSortBySeriesOn;

    public PropertyHelper() {
        sortMap = new HashMap<>();
    }

    private void populateMap(Map<String, Boolean> map) {
        map.put("id", Boolean.parseBoolean(isSortByIdOn));
        map.put("model", Boolean.parseBoolean(isSortByModelOn));
        map.put("mileage", Boolean.parseBoolean(isSortByMileageOn));
        map.put("series", Boolean.parseBoolean(isSortBySeriesOn));
    }

    public boolean isRequestedSortOn(String sortProperty) {

        if (sortProperty == null || sortProperty.isEmpty()) {
            return false;
        }

        if (sortMap.isEmpty()) {
            populateMap(sortMap);
        }

        return sortMap.getOrDefault(sortProperty, false);
    }
}
