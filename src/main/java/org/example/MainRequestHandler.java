package org.example;

import org.example.handler.Handler;
import org.example.handler.RoleCheckHandler;
import org.example.handler.UserExistsHandler;
import org.example.handler.ValidPasswordHandler;
import org.example.model.Database;
import org.example.service.AuthService;

/**
 * Hello world!
 *
 */
public class MainRequestHandler
{
    public static void main(String[] args) {

        Database database = new Database();
        Handler handler = new UserExistsHandler(database);
        handler.setNextHandler(new ValidPasswordHandler(database))
                .setNextHandler(new RoleCheckHandler());
        AuthService service = new AuthService(handler);

        System.out.println("==========================================");

        System.out.println(service.logIn("username", "password"));

        System.out.println("==========================================");

        System.out.println(service.logIn("user_username", "password"));

        System.out.println("==========================================");

        System.out.println(service.logIn("admin_username", "admin_password"));

        System.out.println("==========================================");

    }
}
