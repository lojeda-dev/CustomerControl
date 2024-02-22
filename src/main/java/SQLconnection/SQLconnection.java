package SQLconnection;

import entity.Customer;

import java.sql.*;

public class SQLconnection {

    private static final String CONNECTOR_DB = "jdbc:mysql://localhost:3306/customer_control?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(CONNECTOR_DB,USER,PASSWORD);
    }

    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }
    public static void close(PreparedStatement ps) throws SQLException {
        ps.close();
    }
    public static void close(Connection con) throws SQLException {
        con.close();
    }
}
