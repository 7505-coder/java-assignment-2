// UserInterface.java
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private Calculator calculator;

    public UserInterface() {
        scanner = new Scanner(System.in);
        calculator = new Calculator();
    }

    public void mainMenu() {
        boolean running = true;
        System.out.println("Welcome to the Calculator Application!");
        while (running) {
            System.out.println("\n1. Add Numbers");
            System.out.println("2. Subtract Numbers");
            System.out.println("3. Multiply Numbers");
            System.out.println("4. Divide Numbers");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = readIntSafe();
            switch (choice) {
                case 1 -> performAddition();
                case 2 -> performSubtraction();
                case 3 -> performMultiplication();
                case 4 -> performDivision();
                case 5 -> {
                    running = false;
                    System.out.println("Exiting. Goodbye!");
                }
                default -> System.out.println("Invalid choice. Choose 1-5.");
            }
        }
        scanner.close();
    }

    private void performAddition() {
        System.out.println("--- Addition ---");
        System.out.print("Do you want integer or double addition? (i/d): ");
        String type = scanner.next().trim().toLowerCase();
        if (type.equals("i")) {
            System.out.print("Add 2 numbers or 3 numbers? (2 or 3): ");
            int count = readIntSafe();
            if (count == 2) {
                System.out.print("Enter first integer: ");
                int a = readIntSafe();
                System.out.print("Enter second integer: ");
                int b = readIntSafe();
                System.out.println("Result: " + calculator.add(a, b));
            } else if (count == 3) {
                System.out.print("Enter first integer: ");
                int a = readIntSafe();
                System.out.print("Enter second integer: ");
                int b = readIntSafe();
                System.out.print("Enter third integer: ");
                int c = readIntSafe();
                System.out.println("Result: " + calculator.add(a, b, c));
            } else {
                System.out.println("Invalid count.");
            }
        } else if (type.equals("d")) {
            System.out.print("Enter first double: ");
            double a = readDoubleSafe();
            System.out.print("Enter second double: ");
            double b = readDoubleSafe();
            System.out.println("Result: " + calculator.add(a, b));
        } else {
            System.out.println("Invalid type.");
        }
    }

    private void performSubtraction() {
        System.out.println("--- Subtraction ---");
        System.out.print("Enter first integer: ");
        int a = readIntSafe();
        System.out.print("Enter second integer: ");
        int b = readIntSafe();
        System.out.println("Result: " + calculator.subtract(a, b));
    }

    private void performMultiplication() {
        System.out.println("--- Multiplication ---");
        System.out.print("Enter first double: ");
        double a = readDoubleSafe();
        System.out.print("Enter second double: ");
        double b = readDoubleSafe();
        System.out.println("Result: " + calculator.multiply(a, b));
    }

    private void performDivision() {
        System.out.println("--- Division ---");
        System.out.print("Enter numerator: ");
        int a = readIntSafe();
        System.out.print("Enter denominator: ");
        int b = readIntSafe();
        try {
            System.out.println("Result: " + calculator.divide(a, b));
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private int readIntSafe() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Invalid input, enter integer: ");
                scanner.next();
            }
        }
    }

    private double readDoubleSafe() {
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.print("Invalid input, enter double: ");
                scanner.next();
            }
        }
    }

    public static void main(String[] args) {
        new UserInterface().mainMenu();
    }
}
