import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ParkingSeat {

    private int id;
    private boolean isReserved;
    private String parkingID;

    public ArrayList<Order> orders;

    ParkingSeat(int id, String parkingID){

        orders = new ArrayList<>();
        this.id = id;
        this.parkingID = parkingID;

    }

    public void makeOrder(String name, String secondName,
                          String telNum, String startDate, String endDate){

        if (!checkDate(startDate, endDate)) {
            System.out.println("Парковочное место #" + id + " уже занято в данный период.");
            return;
        }

        isReserved = true;
        orders.add(new Order(name, secondName,
                telNum, startDate, endDate, this.id));


    }

    private boolean checkDate(String orderStartDate, String orderEndDate){

        for (Order order : orders){

            String startDate = order.getStartDate(),
                    endDate = order.getEndDate();

            SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
            Date oStart = null, oEnd = null,
                    start = null, end = null;
            try {
                oStart = sdf.parse(orderStartDate);
                oEnd = sdf.parse(orderEndDate);
                start = sdf.parse(startDate);
                end = sdf.parse(endDate);
            } catch (ParseException e) {
            }


            long oMS = oStart.getTime(), oME = oEnd.getTime(),
                    mS = start.getTime(), mE = end.getTime();

            if ( oMS > mE || oME < mS )
                continue;
            else
                return false;

        }

        return true;


    }

    public void showSeat(){

        System.out.println("Парковочное место #" + id + ": " );
        for (Order order : orders) {

            order.showInfo();

        }

    }

    public int getId() {
        return id;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public String getParkingID() {
        return parkingID;
    }
}
