
import java.sql.Connection;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util  {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest?autoReconnect=true&useSSL=FALSE&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root1";

    public static Connection getConnection() {
        Connection connection = null;
        Driver driver;
        try {

            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);

        } catch (SQLException e) {
            System.out.println("Драйвер или соеденение не установлены");
        }
        return connection;
    }
}
