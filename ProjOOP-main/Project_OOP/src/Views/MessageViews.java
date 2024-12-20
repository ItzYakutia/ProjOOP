package Views;

import Controllers.MessageController;
import Models.Message;
import java.util.Scanner;

public class MessageView {
    private MessageController controller;
    private Scanner scanner;

    public MessageView(MessageController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        int choice;
        do {
            System.out.println("=== Message Menu ===");
            System.out.println("1. Send Message");
            System.out.println("2. View Messages");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> sendMessage();
                case 2 -> viewMessages();
                case 0 -> System.out.println("Exiting Message Menu...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
    }

    private void sendMessage() {
        System.out.print("Enter Sender ID: ");
        String senderId = scanner.nextLine();
        System.out.print("Enter Recipient ID: ");
        String recipientId = scanner.nextLine();
        System.out.print("Enter Message Content: ");
        String content = scanner.nextLine();

        controller.sendMessage(new Message(senderId, recipientId, content));
    }

    private void viewMessages() {
        System.out.print("Enter Your ID to View Messages: ");
        String recipientId = scanner.nextLine();
        controller.listMessages(recipientId);
    }
}
