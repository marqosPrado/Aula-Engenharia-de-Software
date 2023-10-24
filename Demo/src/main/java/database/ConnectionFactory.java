package database;

import model.User;
import repositories.UserRepositories;

import java.sql.*;
import java.util.Optional;


public class ConnectionFactory implements UserRepositories {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "admin";

        return DriverManager.getConnection(url, user, password);
    }

    public static void close(Connection connection) throws SQLException {
        connection.close();
    }

    public void createTable() {
        Statement stmt = null;

        try {
            stmt = getConnection().createStatement();

            stmt.execute("""
                CREATE TABLE IF NOT EXISTS users (
                    id VARCHAR(255) PRIMARY KEY,
                    name VARCHAR(255) NOT NULL,
                    email VARCHAR(255) NOT NULL,
                    phone_number VARCHAR(255) NOT NULL,
                    balance DOUBLE PRECISION NOT NULL
                )
            """);
            close(getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User insertUser(User user) throws SQLException {
        createTable();
        String insertSql = "INSERT INTO users (id, name, email, phone_number, balance) VALUES (?, ?, ?, ?, ?)";

        Connection conn = getConnection();
        PreparedStatement stmt = conn.prepareStatement(insertSql);
        stmt.setString(1, user.getId());
        stmt.setString(2, user.getName());
        stmt.setString(3, user.getEmail());
        stmt.setString(4, user.getPhoneNumber());
        stmt.setDouble(5, user.getBalance());

        int rowsInserted = stmt.executeUpdate();
        if (rowsInserted > 0) {
            String selectSql = "SELECT * FROM users WHERE id = ?";
            PreparedStatement selectStatement = conn.prepareStatement(selectSql);
            selectStatement.setString(1, user.getId());

            ResultSet resultSet = selectStatement.executeQuery();

            if (resultSet.next()) {
                close(conn);
                return convertToUser(resultSet);
            }
        }

        return null;
    }

    @Override
    public Optional<User> findById(String id) throws SQLException {
        createTable();

        String query = "SELECT * FROM users WHERE id = ?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            close(connection);
            return Optional.of(convertToUser(resultSet));
        } else {
            close(connection);
            return Optional.empty();
        }
    }

    private User convertToUser(ResultSet resultSet) {
        User user = new User();
        try {
            user.setId(resultSet.getString("id"));
            user.setName(resultSet.getString("name"));
            user.setEmail(resultSet.getString("email"));
            user.setPhoneNumber(resultSet.getString("phone_number"));
            user.setBalance(resultSet.getDouble("balance"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

}
