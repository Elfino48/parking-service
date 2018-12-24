public class Parking {

    private String id;
    private double price;
    private String placement;

    private ParkingSeat seats[];

    Parking(int n, String placement, int price, String id){

        this.placement = placement;
        this.price = price;
        this.id = id;

        seats = new ParkingSeat[n];

        for ( int i = 0; i < n; i++ ){

            seats[i] = new ParkingSeat(i+1, id);

        }

    }

    public void showSeats(){

        for (ParkingSeat seat : seats) {
            seat.showSeat();
        }

    }

    public void reserveSeat(int id, String name, String secondName,
                          String telNum, String startDate, String endDate){

        seats[id].makeOrder(name, secondName,
                telNum, startDate, endDate);

    }

    public double getPrice() {
        return price;
    }

    public String getPlacement() {
        return placement;
    }

    public ParkingSeat getParkingSeat(int id){
        return seats[id];
    }

    public String getId() {
        return id;
    }

    public ParkingSeat[] getSeats() {
        return seats;
    }
}
