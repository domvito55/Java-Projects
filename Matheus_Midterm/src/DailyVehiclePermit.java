public class DailyVehiclePermit extends ProvincialPark{
    private int numberVehicles;
    private int numberHours;

    public DailyVehiclePermit(int numberVehicles, int numberHours){
        if(availableSites < 1){
            throw new IllegalArgumentException("_______An exception has occurred_______\n" +
                    "Sorry! There are no available sites.");
        }
        if(numberVehicles > 5){
            throw new IllegalArgumentException("_______An exception has occurred_______\n" +
                    "You have requested a site for " + numberVehicles +
                    "vehicles. You are not allowed to bring more than 5 vehicles.");
        }
        if((numberHours < 3) || (numberHours > 6)){
            throw new IllegalArgumentException("_______An exception has occurred_______\n" +
                    "You have requested a site for " + numberHours +
                    "hours. The number of hours must be greater or equal to 3 and less than 6.");
        }

        this.numberVehicles = numberVehicles;
        this.numberHours = numberHours;
        availableSites -= 1;

        System.out.println("Your reservation is a success! You have reserved " + numberHours +
                "hours for: " + numberVehicles +" vehicles." +
                "The number of remaining sites is: " + availableSites);
    }

    @Override
    public double getReservationCost() {
        return 20*numberHours*numberVehicles;
    }

    @Override
    public String toString(){
        return super.toString() + " - Number of vehicles: " + numberVehicles + " - Number of hours: " +
                numberHours + " - Total Cost: " + getReservationCost();
    }
}
