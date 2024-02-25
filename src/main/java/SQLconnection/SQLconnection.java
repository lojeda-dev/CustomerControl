package SQLconnection;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.*;

public class SQLconnection {

    private static final String CONNECTOR_DB = "jdbc:mysql://localhost:3306/customer_control?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static String driver = "com.mysql.cj.jdbc.Driver";

    public static DataSource getDataSource(){
        BasicDataSource bs = new BasicDataSource();
        bs.setDriverClassName(driver);
        bs.setUrl(CONNECTOR_DB);
        bs.setUsername(USER);
        bs.setPassword(PASSWORD);
        bs.setInitialSize(50);
        return bs;
    }

    public static Connection getConnection(){
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
