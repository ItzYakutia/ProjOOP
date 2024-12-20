package Views;

import Controllers.NewsController;
import Models.News;
import java.util.Scanner;

public class NewsView {
    private NewsController controller;
    private Scanner scanner;

    public NewsView(NewsController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        int choice;
        do {
            System.out.println("=== News Menu ===");
            System.out.println("1. Add News");
            System.out.println("2. Remove News");
            System.out.println("3. List News");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addNews();
                case 2 -> removeNews();
                case 3 -> controller.listNews();
                case 0 -> System.out.println("Exiting News Menu...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
    }

    private void addNews() {
        System.out.print("Enter News Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter News Content: ");
        String content = scanner.nextLine();

        controller.addNews(new News(title, content));
    }

    private void removeNews() {
        System.out.print("Enter News Title to remove: ");
        String title = scanner.nextLine();
        controller.removeNews(title);
    }
}
