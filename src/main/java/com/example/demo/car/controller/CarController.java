package com.example.demo.car.controller;

import com.example.demo.car.service.CarService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(path = "cars")
    public String cars(@RequestParam int count, @RequestParam(required = false) String sortBy, HttpServletResponse response, Model model) throws IOException {

        model.addAttribute("cars", carService.listCarsByCount(count, sortBy, response));

        return "cars";
    }

    @GetMapping("/")
    public String getHomePage(Model model, HttpServletResponse response) throws IOException {
        model.addAttribute("firstCar", carService.listCarsByCount(1, null, response));
        return "index_page";
    }
}
