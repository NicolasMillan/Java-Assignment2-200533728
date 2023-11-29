package com.example.motorcycle.Models;

public class MotorcycleDetails {

    private String displacement;
    private String engine;
    private String power;
    private String torque;
    private String gearbox;
    private String fuel_system;
    private String fuel_capacity;
    private String total_weight;

    public String getDisplacement() {
        return displacement;
    }

    public String getEngine() {
        return engine;
    }

    public String getPower() {
        return power;
    }

    public String getTorque() {
        return torque;
    }

    public String getGearbox() {
        return gearbox;
    }

    public String getFuel_system() {
        return fuel_system;
    }

    public String getFuel_capacity() {
        return fuel_capacity;
    }

    public String getTotal_weight() {
        return total_weight;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %s %s %s (%s)", displacement, engine, power, torque, gearbox, fuel_system, fuel_capacity, total_weight);
    }
}
