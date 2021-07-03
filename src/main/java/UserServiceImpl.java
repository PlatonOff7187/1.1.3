import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements  UserService{
    UserDaoJDBCImpl daoUser = new UserDaoJDBCImpl();
    public UserServiceImpl() throws SQLException {

    }

    public void createUsersTable() throws SQLException {
        daoUser.createUsersTable();
    }

    public void dropUsersTable() throws SQLException {
        daoUser.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        daoUser.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) throws SQLException {
        daoUser.removeUserById(id);
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> users = daoUser.getAllUsers();
        return users;
    }

    public void cleanUsersTable() throws  SQLException {
        daoUser.cleanUsersTable();
    }
}
