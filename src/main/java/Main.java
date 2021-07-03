import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Сергей", "Платонов", (byte) 33);
        System.out.println("User  с именем - Сергей добавлен в базу данных");
        userService.saveUser("Юля", "Малахова", (byte) 32);
        System.out.println("User  с именем - Юля добавлена в базу данных");
        userService.saveUser("Александр", "Фролов", (byte) 34);
        System.out.println("User  с именем - Александр добавлен в базу данных");
        userService.saveUser("Елена", "Палена", (byte) 26);
        System.out.println("User  с именем - Елена добавлена в базу данных");
        List<User> users = userService.getAllUsers();
        Iterator iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = (User) iterator.next();
            System.out.println(user.toString());
        }
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
