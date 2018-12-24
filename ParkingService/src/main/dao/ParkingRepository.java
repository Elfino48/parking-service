import java.sql.*;

public class ParkingRepository {

    public static void save(Parking parking){

        final String url = "jdbc:mysql://localhost:3306/parkingservice?useSSL=false&serverTimezone=UTC";
        final String user = "root";
        final String password = "0000";

        Connection con = null;
        Statement stmt = null;

        String query = "INSERT INTO parking_service.parkings (placement, price, id) " +
                "VALUES ('" + parking.getPlacement() + "', " + parking.getPrice() + ", '" +
                parking.getId() + "');";
        System.out.println(query);

        try {
                // opening database connection to MySQL server
                con = DriverManager.getConnection(url, user, password);

                // getting Statement object to execute query
                stmt = con.createStatement();

                // executing SELECT query
                stmt.executeUpdate(query);

        } catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
        } finally {
                try { con.close(); } catch(SQLException se) { /*can't do anything */ }
                try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
        }


    }

}
