public class CampsiteReservation extends ProvincialPark{
    private int groupSize;
    private int requestedSites;
    private int numberDays;

    CampsiteReservation(int groupSize, int requestedSites, int numberDays){
        if(availableSites < requestedSites){
            throw new IllegalArgumentException("_______An exception has occurred_______\n" +
                    "There are not " + requestedSites +
                    "available. The number of available sites is: " + availableSites);
        }

        if(requestedSites > 3){
            throw new IllegalArgumentException("_______An exception has occurred_______\n" +
                    "You requested: " + requestedSites+
                    " You cannot request more than 3 sites.");
        }

        if(Math.ceil(groupSize/6.0) > requestedSites){
            throw new IllegalArgumentException("_______An exception has occurred_______\n" +
                    "You requested for : " + requestedSites +
                    " sites. And you are bringing: " + groupSize +
                    ". Each site only accommodate 6 people");
        }

        if(numberDays > 6){
            throw new IllegalArgumentException("_______An exception has occurred_______\n" +
                    "You requested for : " + numberDays +
                    "days. You are not allowed to request more than 6 days.");
        }

        this.groupSize = groupSize;
        this.requestedSites = requestedSites;
        this.numberDays = numberDays;
        availableSites -= requestedSites;

        System.out.println("Your reservation is a success! You have reserved " + requestedSites +
                " sites for " + groupSize + " people. You gonna stay for " + numberDays +
                " days. The number of remaining sites available is: " + availableSites);
    }

    //Methods

    @Override
    public double getReservationCost() {
        if(numberDays > 3){
            return 45*numberDays;
        } else{
            return 40*numberDays;
        }
    }

    @Override
    public String toString(){
        return super.toString() + " - Group size: " + groupSize + " - Number of sites requested: " +
                requestedSites + " - Number of Days: " + numberDays + " - Total cost: " + getReservationCost();
    }
}
