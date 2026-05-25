
package messageapp;

import java.util.Random;
import java.util.Scanner;

public class Message {
      private static int totalMessages = 0;

    public boolean checkMessageID(String id) {

        return id.length() <= 10;
    }

    public boolean checkRecipientCell(String recipient) {

        if (recipient.length() <= 13 && recipient.startsWith("+")) {
            return true;
        }

        System.out.println("Cell number incorrectly formatted.");
        return false;
    }

    public String createMessageHash(String id, int num, String message) {

        String[] words = message.split(" ");

        String firstWord = words[0];
        String lastWord = words[words.length - 1];

        return id.substring(0, 2).toUpperCase()
                + ":" + num
                + ":" + firstWord.toUpperCase()
                + lastWord.toUpperCase();
    }

    public String generateMessageID() {

        Random random = new Random();

        long number = 1000000000L
                + (long) (random.nextDouble() * 9000000000L);

        return String.valueOf(number);
    }

    public void sendMessage(String recipient, String text) {

        totalMessages++;

        String id = generateMessageID();

        String hash = createMessageHash(id, totalMessages, text);

        System.out.println("\n1. Send Message");
        System.out.println("2. Discard Message");
        System.out.println("3. Store Message");

        Scanner input = new Scanner(System.in);

        System.out.print("Choose option: ");
        int option = input.nextInt();
        input.nextLine();

        switch (option) {

            case 1:

                System.out.println("Message successfully sent.");

                System.out.println("\n=== MESSAGE DETAILS ===");
                System.out.println("Message ID: " + id);
                System.out.println("Message Hash: " + hash);
                System.out.println("Recipient: " + recipient);
                System.out.println("Message: " + text);

                break;

            case 2:
                System.out.println("Message discarded.");
                totalMessages--;
                break;

            case 3:
                System.out.println("Message successfully stored.");
                break;

            default:
                System.out.println("Invalid option.");
        }
    }

    public int returnTotalMessages() {

        return totalMessages;
    }
}
   