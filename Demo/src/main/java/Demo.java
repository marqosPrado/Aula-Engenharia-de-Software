// Version: 1.0

import database.ConnectionFactory;
import model.User;
import service.UserService;


public class Demo {

    public static void main(String[] args) {
        User user = new User("12", "Pedro Barrero", "pedrobarreto@email.com", "11986559874", 2000);
        UserService userService = new UserService(new ConnectionFactory());

//        System.out.println(userService.insertUser(user));
        System.out.println(userService.findUserById("12"));
    }

}
