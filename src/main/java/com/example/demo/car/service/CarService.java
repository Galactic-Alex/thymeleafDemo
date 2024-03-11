package com.example.demo.car.service;


import com.example.demo.car.Car;
import com.example.demo.car.config.PropertiesConfig;
import com.example.demo.car.repository.CarRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CarService {

    private final PropertiesConfig propertiesConfig;
    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository, PropertiesConfig propertiesConfig) {
        this.carRepository = carRepository;
        this.propertiesConfig = propertiesConfig;
    }

    public List<Car> listCarsByCount(int count, String sortParam, HttpServletResponse response) throws IOException {

        if (!isRequestRight(count, sortParam, response)) {
            return null;
        }

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
    private boolean isRequestRight(int count, String sortParam, HttpServletResponse response) throws IOException {
        if (!isRequestedSortOn(sortParam)) {
            response.sendError(403, "Requested sort is off or doesn't exist");
            return false;
        }

        if (count == 0) {
            response.sendError(400, "Count can't be 0");
            return false;
        }

        return true;
    }

    private boolean isRequestedSortOn(String sortParam) {
        if (sortParam == null) {
            return true;
        }

        return Boolean.parseBoolean(propertiesConfig.getIsSortEnabledMap().getOrDefault(sortParam.toLowerCase(), "false"));
    }
}
