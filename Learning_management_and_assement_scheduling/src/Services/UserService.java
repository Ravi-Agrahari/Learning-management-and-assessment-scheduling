package Services;

import DAO.UserDAO;
import DAO.UserDAOImpl;
import Models.User;
import java.util.List;

public class UserService {

    private final UserDAO userDAO;

    public UserService() {
        this.userDAO = new UserDAOImpl();
    }

    public void addUser(User user) throws Exception {
        userDAO.addUser(user);
    }

    public User getUserById(int userId) throws Exception {
        return userDAO.getUserById(userId);
    }

    public User getUserByUsername(String username) throws Exception {
        return userDAO.getUserByUsername(username);
    }

    public List<User> getAllUsers() throws Exception {
        return userDAO.getAllUsers();
    }

    public void updateUser(User user) throws Exception {
        userDAO.updateUser(user);
    }

    public void deleteUser(int userId) throws Exception {
        userDAO.deleteUser(userId);
    }

    public User authenticate(String username, String password) throws Exception {
        User user = userDAO.getUserByUsername(username);

        if (user != null && user.getPassword() != null && user.getPassword().equals(password)) {
            return user; // Return the user if credentials match
        }
        return null; // Return null if authentication fails
    }
}
