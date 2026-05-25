
package messageapp;

import java.util.Scanner;

public class MessageApp {

    public static void main(String[] args) {
        
      

        Scanner input = new Scanner(System.in);

        Login login = new Login();

        System.out.println("=== QUICKCHAT REGISTRATION ===");

        System.out.print("Enter First Name: ");
        String firstName = input.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = input.nextLine();

        login.storeNames(firstName, lastName);

        System.out.print("Enter Username: ");
        String username = input.nextLine();
        login.checkUserName(username);

        System.out.print("Enter Password: ");
        String password = input.nextLine();
        login.checkPassword(password);

        System.out.print("Enter SA Phone Number (+27831234567): ");
        String phone = input.nextLine();

        if (!login.checkCellPhoneNumber(phone)) {
            System.exit(0);
        }

        System.out.println(login.registerUser());

        System.out.println("\n=== LOGIN ===");

        System.out.print("Username: ");
        String loginUser = input.nextLine();

        System.out.print("Password: ");
        String loginPass = input.nextLine();

        if (!login.loginUser(loginUser, loginPass)) {
            System.out.println("Login failed.");
            System.exit(0);
        }

        System.out.println("Welcome to QuickChat.");

        System.out.print("How many messages would you like to send? ");
        int numMessages = input.nextInt();
        input.nextLine();

        Message message = new Message();

        int choice;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Send Messages");
            System.out.println("2. Show Recent Messages");
            System.out.println("3. Quit");

            System.out.print("Choose option: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:

                    for (int i = 0; i < numMessages; i++) {

                        System.out.println("\nMessage " + (i + 1));

                        System.out.print("Enter recipient number: ");
                        String recipient = input.nextLine();

                        if (!message.checkRecipientCell(recipient)) {
                            continue;
                        }

                        System.out.print("Enter message: ");
                        String text = input.nextLine();

                        if (text.length() > 250) {
                            System.out.println("Please enter a message less than 250 characters.");
                            continue;
                        }

                        message.sendMessage(recipient, text);
                    }

                    System.out.println("Total Messages Sent: " + message.returnTotalMessages());
                    break;

                case 2:
                    System.out.println("Coming Soon.");
                    break;

                case 3:
                    System.out.println("Goodbye.");
                    break;

                default:
                    System.out.println("Invalid option.");
            }

        } while (choice != 3);
    }
}
    
      
    
    
