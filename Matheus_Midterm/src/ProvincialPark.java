public abstract class ProvincialPark {
    static String address = "Silent Lake Park";
    static int availableSites = 20;

    public abstract double getReservationCost();

    @Override
    public String toString(){
        return "address: " + address + " - sites: " + availableSites;
    }


}
