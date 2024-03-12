package com.example.demo.car.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "car")
public class PropertiesConfig {
    private Map<String, String> isSortEnabledMap;

    private int maxCar;

    public int getMaxCar() {
        return maxCar;
    }
    public void setMaxCar(int maxCar) {
        this.maxCar = maxCar;
    }

    public Map<String, String> getIsSortEnabledMap() {
        return isSortEnabledMap;
    }

    public void setIsSortEnabledMap(Map<String, String> isSortEnabledMap) {
        this.isSortEnabledMap = isSortEnabledMap;
    }
}
