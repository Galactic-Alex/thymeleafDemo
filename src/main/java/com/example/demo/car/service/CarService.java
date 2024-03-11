package com.example.demo.car.service;


import com.example.demo.car.Car;
import com.example.demo.car.config.PropertiesConfig;
import com.example.demo.car.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CarService {

    private final PropertiesConfig propertiesConfig;
    private final CarRepository carRepository;

    private final Map<String, Boolean> sortMap;

    @Autowired
    public CarService(CarRepository carRepository, PropertiesConfig propertiesConfig) {
        this.carRepository = carRepository;
        this.propertiesConfig = propertiesConfig;
        sortMap = new HashMap<>();
        populateMap(sortMap);
    }

    public List<Car> listCarsByCount(int count, String sortParam) {
        if (count >= propertiesConfig.getMaxCar()) {
            count = Integer.MAX_VALUE;
        }

        Pageable pageable;
        if (sortParam == null) {
            pageable = PageRequest.of(0, count);
        } else {
            pageable = PageRequest.of(0, count, Sort.by(sortParam));
        }

        return carRepository.findAll(pageable).toList();
    }

    public boolean isRequestedSortOn(String sortParam) {
        if (sortParam == null) {
            return true;
        }

        return sortMap.getOrDefault(sortParam, false);
    }

    private void populateMap(Map<String, Boolean> map) {
        map.put("id", Boolean.parseBoolean(propertiesConfig.getIsSortByIdOn()));
        map.put("model", Boolean.parseBoolean(propertiesConfig.getIsSortByModelOn()));
        map.put("mileage", Boolean.parseBoolean(propertiesConfig.getIsSortByMileageOn()));
        map.put("series", Boolean.parseBoolean(propertiesConfig.getIsSortBySeriesOn()));
    }
}
