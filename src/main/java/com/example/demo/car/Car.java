package com.example.demo.car;

import jakarta.persistence.*;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "model")
    private String model;

    //How many kilometers the car has gone through
    @Column(name = "mileage")
    private int mileage;

    @Column(name = "series")
    private int series;

    public Car() {
    }

    public Car(String model, int mileage, int series) {
        this.model = model;
        this.mileage = mileage;
        this.series = series;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id = " + id +
                ", model = '" + model + '\'' +
                ", mileage = " + mileage +
                ", series = " + series +
                '}';
    }
}
