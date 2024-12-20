package DesignPattern.Behavioural.MementoPattern.Sol1;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        StateManagement sm = new StateManagement();
        while (true) {
            Scanner action = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Enter action /n exit /n write /n undo /n redo /n display");
            String actionData = action.nextLine();

            if (actionData.equals("exit")) {
                System.exit(0);
            } else if (actionData.equals("write")) {
                Scanner header = new Scanner(System.in);  // Create a Scanner object
                System.out.println("Enter header");
                String headerData = header.nextLine();  // Read user input

                Scanner content = new Scanner(System.in);
                System.out.println("Enter content");
                String contentData = content.nextLine();


                sm.write(headerData, contentData);
            } else if (actionData.equals("display")) {
                sm.display();
            } else if (actionData.equals("undo")) {
                sm.undo();
            } else if (actionData.equals("redo")) {
                sm.redo();
            } else {
                System.out.println("Action is not valid. Retry....");
            }
        }
    }
}
