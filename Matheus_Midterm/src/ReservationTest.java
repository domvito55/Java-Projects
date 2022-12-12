public class ReservationTest {
    public static void main(String[] args) {
        ProvincialPark[] provincialParks = new ProvincialPark[6];

        provincialParks[0] = new CampsiteReservation(12, 2, 4);

        try{
            provincialParks[1] = new CampsiteReservation(15, 2, 4);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        try{
            provincialParks[2] = new CampsiteReservation(40, 20, 4);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        try{
            provincialParks[3] = new CampsiteReservation(10, 3, 8);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        try{
            provincialParks[4] = new DailyVehiclePermit(3, 4);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        try{
            provincialParks[5] = new DailyVehiclePermit(3, 7);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        for (ProvincialPark park:
             provincialParks) {
            if(park instanceof DailyVehiclePermit){
                System.out.println(park.toString() + "Lot B");
            }
            if(park instanceof CampsiteReservation){
                System.out.println(park.toString() + "Lot A");
            }
        }

    }
}