package src.components;

import src.Common.Utilities;
import src.entities.NormalUser;

import java.io.IOException;
import java.util.Scanner;

/**
 * Login Module control login and register part of the users.
 * 1. Login part
 * 2. Register part
 * **/
public class LoginModule {
    private SharedData sd;
    private NormalUser user;

    public LoginModule(SharedData sd) throws IOException {
        this.sd = sd;
        this.genWelcomeMsg();
        this.switcher();
        this.sd.setUser(user);
    }

    private void genWelcomeMsg() {
        String welcome = "Welcome to the Zilk website!\n";
        String guidance = "For new user, please type \"register\", for old user please type \"login\".";
        Utilities.addLines(welcome + guidance);
    }

    /* Switch to register or login process.*/
    private void switcher() throws IOException {
        Scanner sc = this.sd.getSc();
        String cmd = sc.nextLine().toLowerCase();

        boolean isEnd = true;
        while (isEnd) {
            if (cmd.equals("register")) {
                isEnd = false;
            } else if (cmd.equals("login")) {
                isEnd = false;
            } else {
                System.out.println("Please type valid command: \"register\" or \"login\".\n");
                cmd = sc.nextLine().toLowerCase();
            }
        }

        if (cmd.equals("register")) {
            this.Register();
        } else {
            this.Login();
        }
    }

    /* Interact with the users data to confirm if user exist.*/
    private void Login() throws IOException {
        // initial login
        Scanner sc = this.sd.getSc();
        System.out.print("Please input your username: ");
        String username = sc.nextLine();
        System.out.print("Please input your password: ");
        String password = sc.nextLine();

        // router and user detection
        this.user = this.sd.getUsers().get(username);
        while (!this.sd.getUsers().containsKey(username) || !password.equals(this.sd.getUsers().get(username).getPassword())) {
            // validation
            System.out.println("Sorry, it seems you are not a registered user.");
            System.out.println("If you want to register, please type \"register\". " +
                    "If you want to input again, please type \"again\". (type any key to exit)");
            String cmd = sc.nextLine();

            // router
            if (cmd.equals("register")) {
                this.Register();
                break;
            } else if (cmd.equals("again")) {
                System.out.print("Please input your username: ");
                password = sc.nextLine();
                System.out.print("Please input your password: ");
                username = sc.nextLine();
                this.user = this.sd.getUsers().get(username);
            } else {
                return;
            }
        }
    }

    /* Validate new user and store user data. */
    private void Register() throws IOException {
        Scanner sc = this.sd.getSc();
        String username, password;
        System.out.print("Please input your username: ");
        username = sc.nextLine();

        // Validation
        while (this.sd.getUsers().containsKey(username)) {
            System.out.print("This username has been occupied. Please try a new one.\n");
            username = sc.nextLine();
        }

        System.out.print("Please input your password: ");
        password = sc.nextLine();

        // Confirmation
        System.out.println("-------------Double Check ------------");
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("Please confirm your username and password. (Y or N) \n");

        // Router
        String cmd = sc.nextLine().toLowerCase();
        while (!cmd.equals("y") && !cmd.equals("n")) {
            System.out.println("Please type \"Y\" or \"N\".\n");
            cmd = sc.nextLine().toLowerCase();
        }

        // Store data
        this.user = new NormalUser(this.sd.getNextUserID(), username, password);
        this.sd.updateUsers(username, password);
    }
}
