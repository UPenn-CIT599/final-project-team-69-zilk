package components;

import Common.Utilities;
import entities.NormalUser;

import java.io.IOException;
import java.util.Scanner;

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

    private void Login() throws IOException {
        Scanner sc = this.sd.getSc();
        System.out.print("Please input your username: ");
        String username = sc.nextLine();
        System.out.print("Please input your password: ");
        String password = sc.nextLine();

        this.user = this.sd.getUsers().get(username);
        while (!this.sd.getUsers().containsKey(username) || !password.equals(this.sd.getUsers().get(username).getPassword())) {
            System.out.println("Sorry, it seems you are not a registered user.");
            System.out.println("If you want to register, please type \"register\". " +
                    "If you want to input again, please type \"again\". (type any key to exit)");
            String cmd = sc.nextLine();
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

    private void Register() throws IOException {
        Scanner sc = this.sd.getSc();
        String username, password;
        System.out.print("Please input your username: ");
        username = sc.nextLine();

        while (this.sd.getUsers().containsKey(username)) {
            System.out.print("This username has been occupied. Please try a new one.\n");
            username = sc.nextLine();
        }

        System.out.print("Please input your password: ");
        password = sc.nextLine();

        System.out.println("-------------Double Check ------------");
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("Please confirm your username and password. (Y or N) \n");

        String cmd = sc.nextLine().toLowerCase();
        while (!cmd.equals("y") && !cmd.equals("n")) {
            System.out.println("Please type \"Y\" or \"N\".\n");
            cmd = sc.nextLine().toLowerCase();
        }
        this.user = new NormalUser(this.sd.getNextUserID(), username, password);
        this.sd.updateUsers(username, password);
    }


}
