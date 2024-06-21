/*
Student ID: 301236904
Name: Matheus Teixeira
Assignment: 2
*/
public class Test {
    public static void main(String[] args){
        /* Dealer 1*/
        Dealership dealer1 = new Dealership("GD_22",
                "Great Deals inc.", "937 Progress Ave, Toronto");

        //Adding 3 cars
        dealer1.addCar("Honda", 2022, "HR-V", 23125.0, CarType.SUV);
        dealer1.addCar("Honda", 2022, "Accord", 27615.0, CarType.SEDAN);
        dealer1.addCar("Honda", 2023, "Ridgeline", 40095.0, CarType.TRUCK);

        //printing dealer 1 info
        System.out.println("\ndealer 1 info");
        System.out.println(dealer1);

        //demonstrating method overload
        System.out.println("\n___dealer1.showCars(\"Honda\")___");
        dealer1.showCars("Honda");
        System.out.println("\n___dealer1.showCars(\"Honda\", 2022)___");
        dealer1.showCars("Honda", 2022);
        System.out.println("\n___dealer1.showCars(\"Honda\", 2022, 25000.0)___");
        dealer1.showCars("Honda", 2022, 25000.0);

        /* Dealer 2 */
        Dealership dealer2 = new Dealership("BD_22",
                "Best Deals corp.", "739 Ellesmere Ave, Toronto");

        //Adding 3 cars
        dealer2.addCar("Ford", 2019, "Fiesta", 17800.0, CarType.HATCHBACK);
        dealer2.addCar("Ford", 2020, "Fusion", 24365.0, CarType.SEDAN);
        dealer2.addCar("GMC", 2022, "Sierra 1500", 55827.0, CarType.TRUCK);

        //printing dealer 2 info
        System.out.println("\ndealer 2 info");
        System.out.println(dealer2);

        //demonstrating method overload
        System.out.println("\n___dealer2.showCars(\"GMC\")___");
        dealer2.showCars("GMC");
        System.out.println("\n___dealer2.showCars(\"Ford\", 2020)___");
        dealer2.showCars("Ford", 2020);
        System.out.println("\n___dealer2.showCars(\"Ford\", 2019, 20000.0)___");
        dealer2.showCars("Ford", 2019, 20000.0);
    }
}