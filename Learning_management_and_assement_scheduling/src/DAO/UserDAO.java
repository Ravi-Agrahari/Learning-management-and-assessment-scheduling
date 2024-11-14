
package DAO;

import Models.User;
import java.util.List;

public interface UserDAO {
    void addUser(User user) throws Exception;
    User getUserById(int userId) throws Exception;
    User getUserByUsername(String username) throws Exception;
    List<User> getAllUsers() throws Exception;
    void updateUser(User user) throws Exception;
    void deleteUser(int userId) throws Exception;
    
}

