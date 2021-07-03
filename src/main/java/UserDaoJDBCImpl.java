
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements  UserDao{
    private static Connection connection = Util.getConnection();
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS mydbtest" + "(id INT NOT NULL AUTO_INCREMENT," + " name VARCHAR(30)," + "lastname VARCHAR(30)," + "age TINYINT(3)," + "PRIMARY KEY (id))");
        } catch (SQLException e) {
            System.out.println("Не удалось создать таблицу");
        }
    }

    public void dropUsersTable() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("DROP TABLE IF EXISTS mydbtest");
        } catch (SQLException e) {
            System.out.println("Не удалось удалить таблицу");
        }
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO mydbtest (name,lastname,age) VALUES (?,?,?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, String.valueOf(age));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Не удалось добавить Userа в таблицу");
        }
    }

    public void removeUserById(long id) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM mydbtest WHERE id =?");
            preparedStatement.setString(1, String.valueOf(id));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Не удалось удалить Userа по Id");
        }
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery("SELECT * FROM mydbtest");
            while (result.next()) {
                User user = new User();
                user.setId((long) result.getInt("id"));
                user.setName(result.getString("name"));
                user.setLastName((result.getString("lastname")));
                user.setAge((byte) result.getInt("age"));
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println("Не удалось получить данные из таблицы");
        }
        return users;
    }

    public void cleanUsersTable() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("TRUNCATE TABLE mydbtest");
        } catch (SQLException e) {
            System.out.println("Не удалось очистить таблицу от данных");
        }

    }
}
