package com.example.demo.car.config;

import com.example.demo.car.Car;
import com.example.demo.car.repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CarConfig {

    //filling DB for testing purposes
    @Bean
    CommandLineRunner commandLineRunner(CarRepository carRepository) {
        return args -> {
            Car car1 = new Car("model2", 125, 1);
            Car car2 = new Car("model1", 85, 2);
            Car car3 = new Car("model3", 0, 3);
            Car car4 = new Car("model4", 1823, 1);
            carRepository.saveAll(List.of(car1, car2, car3, car4));
        };
    }
}
