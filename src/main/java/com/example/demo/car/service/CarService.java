package com.example.demo.car.service;


import com.example.demo.car.Car;
import com.example.demo.car.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;
    @Value("${maxCar}")
    private int maxCar;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> listCarsByCount(int count, String sortParam) {
        if (count >= maxCar) {
            count = Integer.MAX_VALUE;
        }

        Pageable pageable = PageRequest.of(0, count, Sort.by(sortParam));
        return carRepository.findAll(pageable).toList();
    }
}
