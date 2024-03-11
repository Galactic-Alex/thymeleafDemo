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

    private final PropertyHelper propertyHelper;

    @Autowired
    public CarController(CarService carService, PropertyHelper propertyHelper) {
        this.carService = carService;
        this.propertyHelper = propertyHelper;
    }

    @GetMapping(path = "cars")
    public String cars(@RequestParam int count, @RequestParam(required = false) String sortBy, HttpServletResponse response, Model model) throws IOException {

        if (!propertyHelper.isRequestedSortOn(sortBy)) {
            response.sendError(403, "Requested sort is off or doesn't exist");
            return null;
        }

        if (count == 0) {
            response.sendError(400, "Count can't be 0");
            return null;
        }

        model.addAttribute("cars", carService.listCarsByCount(count, sortBy));

        return "cars";
    }

    @GetMapping("/")
    public String getHomePage(Model model) {
        model.addAttribute("firstCar", carService.listCarsByCount(1, null));
        return "index_page";
    }
}
