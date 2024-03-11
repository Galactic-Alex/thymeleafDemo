package com.example.demo.car.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "car")
public class PropertiesConfig {

    private String isSortByIdOn;

    private String isSortByModelOn;

    private String isSortByMileageOn;

    private String isSortBySeriesOn;

    private int maxCar;

    public int getMaxCar() {
        return maxCar;
    }

    public String getIsSortByIdOn() {
        return isSortByIdOn;
    }

    public String getIsSortByMileageOn() {
        return isSortByMileageOn;
    }

    public String getIsSortByModelOn() {
        return isSortByModelOn;
    }

    public String getIsSortBySeriesOn() {
        return isSortBySeriesOn;
    }

    public void setIsSortByIdOn(String isSortByIdOn) {
        this.isSortByIdOn = isSortByIdOn;
    }

    public void setIsSortByMileageOn(String isSortByMileageOn) {
        this.isSortByMileageOn = isSortByMileageOn;
    }

    public void setIsSortByModelOn(String isSortByModelOn) {
        this.isSortByModelOn = isSortByModelOn;
    }

    public void setIsSortBySeriesOn(String isSortBySeriesOn) {
        this.isSortBySeriesOn = isSortBySeriesOn;
    }

    public void setMaxCar(int maxCar) {
        this.maxCar = maxCar;
    }
}
