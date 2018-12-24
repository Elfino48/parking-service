import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class OrderRepository {

    public static void save(Order order){

        final String url = "jdbc:mysql://localhost:3306/parkingservice?useSSL=false&serverTimezone=UTC";
        final String user = "root";
        final String password = "0000";

        Connection con = null;
        Statement stmt = null;

        String query = "INSERT INTO parking_service.orders (startDate, endDate," +
                "name, second_name, tel_num, parking_seat_id) " +
                "VALUES ('" + order.getStartDate() + "', '" + order.getEndDate() + "'," +
                "'" + order.getName() + "', '" + order.getSecondName() + "'," +
                "'" + order.getTelNum() + "', '" + order.getParkingSeatID() + "');";
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

        String query = "CREATE TABLE parking_service.p" + parking_id + "_orders" +
                "(startDate VARCHAR(45), \n" +
                " endDate VARCHAR(45), \n" +
                " name VARCHAR(45), \n" +
                " second_name VARCHAR(45), \n" +
                " tel_num VARCHAR(45), \n" +
                " parking_seat_id INT(5)" +
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
