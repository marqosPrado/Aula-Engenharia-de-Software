package repositories;

import model.User;

import java.sql.SQLException;
import java.util.Optional;

public interface UserRepositories {

    User insertUser(User user) throws SQLException;

    Optional<User> findById(String id) throws SQLException;

}
