public class ParkingService {

 //   void addPlace(Long carId, Long parkingId);

    public static void createParking(int numOfSeats,  String placement,
                       int price, String id){

        Parking park = new Parking(numOfSeats, placement, price, id);

        ParkingRepository.save(park);

        ParkingSeatRepository.createTable(park.getId());
        OrderRepository.createTable(park.getId());

        for ( ParkingSeat seat : park.getSeats() ) {

            ParkingSeatRepository.save(seat);

        }

    };

    /* public static void reserveSeat(String parking_plac, String firstName,
                                   String secondName, String ){





    }*/

   // void updateParking(Long parkingId, BigDecimal costPerHour);

    void getAllParkings(){};
}
