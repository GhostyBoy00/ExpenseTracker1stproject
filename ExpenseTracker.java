import java.util.ArrayList;
import java.util.Scanner;

class Expense {
    String description;
    double cost;
    String date;

    public Expense(String description, double cost, String date) {
        this.description = description;
        this.cost = cost;
        this.date = date;
    }

    public String toString() {
        return "Description: " + description + ", Cost: $" + cost + ", Date: " + date;
    }
}

public class ExpenseTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Expense> expenses = new ArrayList<>();
        boolean running = true;

        try {
            while (running) {
            System.out.println("\n--- Expense Tracker Menu ---");
            System.out.println("1. Add a new expense");
            System.out.println("2. View all expenses");
            System.out.println("3. View total cost");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");

            String choice = scanner.next();
            scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter expense description: ");
                    String description = scanner.nextLine();

                    System.out.print("Enter cost: ");
                    double cost = Double.parseDouble(scanner.nextLine());

                    System.out.print("Enter date (e.g., 2025-06-09): ");
                    String date = scanner.nextLine();

                    try {
                        java.time.LocalDate.parse(date);
                    } catch (java.time.format.DateTimeParseException e) {
                        System.out.println("Invalid date format or value. Please use a valid date in YYYY-MM-DD format.");
                        break;
                    }

                    Expense expense = new Expense(description, cost, date);
                    expenses.add(expense);
                    System.out.println("Expense added!");
                    break;

                case "2":
                    System.out.println("\nYour Expenses:");
                    if (expenses.isEmpty()) {
                        System.out.println("No expenses recorded.");
                    } else {
                        for (Expense e : expenses) {
                            System.out.println(e);
                        }
                    }
                    break;

                case "3":
                    double total = 0;
                    for (Expense e : expenses) {
                        total += e.cost;
                    }
                    System.out.printf("Total Spent: $%.2f", total);
                    break;

                case "4":
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        } finally {
            scanner.close();
        }
    }
}
