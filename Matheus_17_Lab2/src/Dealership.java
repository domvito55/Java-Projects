/*
Student ID: 301236904
Name: Matheus Teixeira
Assignment: 2
*/
import java.util.ArrayList;

public class Dealership {
    //static member
    private static ArrayList<Car> carList = new ArrayList<Car>();

    //Other properties
    private String id;
    private String name;
    private String address;

    //constructor
    Dealership (String ID, String name, String address){
        this.id = ID;
        this.name = name;
        this.address = address;
    }

    //getters
    public static ArrayList<Car> getCarList() {
        return carList;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }

    //methods
    void addCar(String manufacturer, int make, String model, double basePrice, CarType type){
        Car car = new Car(manufacturer, make, model, basePrice, type);
        carList.add(car);
    }
    void showCars(String manufacturer){
        for (Car car: carList){
            if(car.getManufacturer() == manufacturer){
                System.out.println(car);
            }
        }
    }
    void showCars(String manufacturer, int make){
        for (Car car: carList){
            if((car.getManufacturer() == manufacturer) &&
                    (car.getMake() == make)){
                System.out.println(car);
            }
        }
    }
    void showCars(String manufacturer, int make, double basePrice){
        for (Car car: carList){
            if((car.getManufacturer() == manufacturer) &&
                    (car.getMake() == make) &&
                    (car.getBasePrice() <= basePrice)){
                System.out.println(car);
            }
        }
    }

    @Override
    public String toString() {
        return "#################\n" +
                "Dealership ID: " + this.id + "\n" +
                "Name: " + this.name + "\n" +
                "Address: " + this.address;
    }
}
