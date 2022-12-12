/*
Student ID: 301236904
Name: Matheus Teixeira
Assignment: 2
*/

public class Car {
    //static member
    private static int VI_NUMBER = 1001;
    //Vehicle ID
    private int VIN;

    //Other Properties
    private String manufacturer;
    private int make;
    private String model;
    private double basePrice;
    private CarType type;

    //Constructor
    Car (String manufacturer, int make, String model, double basePrice, CarType type){
        //Vehicle ID
        VIN = VI_NUMBER;
        VI_NUMBER += 10;

        this.manufacturer = manufacturer;
        this.make = make;
        this.model = model;
        this.basePrice = basePrice;
        this.type = type;
    }

    //getters
    public static int getVINumber() {
        return VI_NUMBER;
    }
    public int getVIN() {
        return VIN;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public int getMake() {
        return make;
    }
    public String getModel() {
        return model;
    }
    public double getBasePrice() {
        return basePrice;
    }
    public CarType getType() {
        return type;
    }

    @Override
    public String toString() {
        return  "Vehicle identification number (VIN): " + this.VIN + "; " +
                "Manufacturer: " + this.manufacturer + "; " +
                "Model: " + this.model + "; " +
                "Year: " + this.make + "; " +
                "Car Type: " + this.type + "; " +
                "Base Price: " + this.basePrice + ". ";
    }

}
