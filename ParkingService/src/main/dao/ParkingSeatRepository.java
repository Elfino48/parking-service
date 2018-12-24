import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ParkingSeatRepository {
    public static void save(ParkingSeat seat){

        final String url = "jdbc:mysql://localhost:3306/parkingservice?useSSL=false&serverTimezone=UTC";
        final String user = "root";
        final String password = "0000";

        Connection con = null;
        Statement stmt = null;

        String query = "INSERT INTO " +
                "parking_service.p" + seat.getParkingID() + "_seats (id, isReserved, parking_id) " +
                "VALUES (" +
                "" + seat.getId() + ", " +
                "" + seat.isReserved() + ", " +
                "" + Integer.valueOf(seat.getParkingID()) + ");";

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

    public static void createTable(String parking_id){

        final String url = "jdbc:mysql://localhost:3306/parkingservice?useSSL=false&serverTimezone=UTC";
        final String user = "root";
        final String password = "0000";

        Connection con = null;
        Statement stmt = null;

        String query = "CREATE TABLE parking_service.p" + parking_id + "_seats" +
                "(id INT(11) NOT NULL PRIMARY KEY, \n" +
                " isReserved TINYINT(4),\n" +
                " parking_id INT(11)\n" +
                ");";

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
