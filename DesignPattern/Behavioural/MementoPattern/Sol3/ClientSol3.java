package DesignPattern.Behavioural.MementoPattern.Sol3;

import java.util.Scanner;

public class ClientSol3 {
    public static void main(String[] args) {
        StateManagementCaretaker caretaker = new StateManagementCaretaker();
        TextEditorOriginator originator = new TextEditorOriginator();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an action:");
            System.out.println("Press 1 for exit");
            System.out.println("Press 2 for write");
            System.out.println("Press 3 for undo");
            System.out.println("Press 4 for redo");
            System.out.println("Press 5 for display");
            System.out.print("Enter your action: ");

            String action = scanner.nextLine().trim().toLowerCase();  // Normalize input

            switch (action) {
                case "1":
                    System.out.println("Exiting the application...");
                    scanner.close();
                    return;

                case "2":
                    System.out.println("Enter the header ");
                    String header = scanner.nextLine().trim();
                    originator.setHeader(header);

                    System.out.println("Enter the content ");
                    String content = scanner.nextLine().trim();
                    originator.setContent(content);

                    caretaker.save(originator);
                    break;

                case "3":
                    caretaker.undo(originator);
                    System.out.println(originator.getData());
                    break;

                case "4":
                    caretaker.redo(originator);
                    System.out.println(originator.getData());
                    break;

                case "5":
                    System.out.println(originator.getData());
                    break;

            }
        }
    }
}
