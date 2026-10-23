package com.pluralsight;

public class Vehicle {

    private long vehicleId = 1000000;
    private String makeModel = "";
    private String color = "";
    private int odometerReading = 0;
    private double price = 0.0;

    public void vehicle(int VID, String MMD, String CLR, int OMR, double PR){
        this.vehicleId = VID;
        this.makeModel = MMD;
        this.color = CLR;
        this.odometerReading = OMR;
        this.price = PR;
    }

    public long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getOdometerReading() {
        return odometerReading;
    }

    public void setOdometerReading(int odometerReading) {
        this.odometerReading = odometerReading;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
