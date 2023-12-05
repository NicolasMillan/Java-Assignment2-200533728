package com.example.motorcycle.Models;

public class Motorcycle {
//    No use of Serialized Name bacouse of the API is not necesary
    private String make;
    private String model;
    private String year;
    private String type;
    private String displacement;
    private String engine;
    private String fuel_system;
    private String fuel_capacity;

    //default constructor
    public Motorcycle() {
    }
    //Getters
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getYear() {
        return year;
    }

    public String getType() {
        return type;
    }

    public String getDisplacement() {
        return displacement;
    }

    public String getEngine() {
        return engine;
    }

    public String getFuel_system() {
        return fuel_system;
    }

    public String getFuel_capacity() {
        return fuel_capacity;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %s %s %s (%s)", make, model, year, type, displacement, engine, fuel_system, fuel_capacity);
    }
}
