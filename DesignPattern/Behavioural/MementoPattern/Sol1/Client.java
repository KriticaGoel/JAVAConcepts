package DesignPattern.Behavioural.MementoPattern.Sol1;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        StateManagement sm = new StateManagement();
        Scanner scanner = new Scanner(System.in);  // Single Scanner object for all inputs

        while (true) {
            System.out.println("\nChoose an action:");
            System.out.println("1. exit");
            System.out.println("2. write");
            System.out.println("3. undo");
            System.out.println("4. redo");
            System.out.println("5. display");
            System.out.print("Enter your action: ");

            String action = scanner.nextLine().trim().toLowerCase();  // Normalize input

            switch (action) {
                case "exit":
                    System.out.println("Exiting the application...");
                    scanner.close();
                    return;  // End program gracefully

                case "write":
                    System.out.print("Enter header: ");
                    String header = scanner.nextLine().trim();
                    while (header.isEmpty()) {
                        System.out.println("Header cannot be empty. Please retry.");
                        header = scanner.nextLine().trim();
                    }

                    System.out.print("Enter content: ");
                    String content = scanner.nextLine().trim();
                    while (content.isEmpty()) {
                        System.out.println("Content cannot be empty. Please retry.");
                        content = scanner.nextLine().trim();
                    }

                    sm.write(header, content);
                    System.out.println("Content saved successfully.");
                    break;

                case "display":
                    sm.display();
                    break;

                case "undo":
                    System.out.println("Performing undo...");
                    sm.undo();
                    break;

                case "redo":
                    System.out.println("Performing redo...");
                    sm.redo();
                    break;

                default:
                    System.out.println("Invalid action. Please try again.");
                    break;
            }
        }
    }
}