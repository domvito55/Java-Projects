/*
Student ID: 301236904
Name: Matheus Teixeira
Assignment: 2
*/

public enum CarType {
    SUV("SUV"),
    HATCHBACK("Hatchback"),
    SEDAN("Sedan"),
    TRUCK("Truck");

    private final String name;

    CarType(){
        this.name = "NA";
    }

    CarType(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Car type: " + this.name;
    }
}
