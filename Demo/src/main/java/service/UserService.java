package service;

import model.User;
import repositories.UserRepositories;

import java.sql.SQLException;

public class UserService {

    private final UserRepositories userRepositories;

    public UserService(UserRepositories userRepositories) {
        this.userRepositories = userRepositories;
    }

    public User insertUser(User user) {
        try {
            return userRepositories.insertUser(user);
        } catch (SQLException e) {
            String errorMessage = "Erro ao inserir usuário: " + e.getMessage();
            throw new RuntimeException(errorMessage, e);
        }
    }

    public User findUserById(String id) {
        try {
            return userRepositories.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        } catch (SQLException e) {
            String errorMessage = "Erro ao buscar usuário: " + e.getMessage();
            throw new RuntimeException(errorMessage, e);
        }
    }


}
