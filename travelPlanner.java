import java.util.ArrayList;
import java.util.Scanner;

public class TravelItineraryPlanner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Destination> destinations = new ArrayList<>();
        double totalBudget = 0;
        boolean exit = false;

        System.out.println("Welcome to the Travel Itinerary Planner!");

        while (!exit) {
            // Menu options
            System.out.println("\nSelect an option:");
            System.out.println("1. Add Destination");
            System.out.println("2. View Itinerary");
            System.out.println("3. Calculate Total Budget");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // clear input buffer

            switch (choice) {
                case 1:
                    addDestination(scanner, destinations);
                    break;
                case 2:
                    viewItinerary(destinations);
                    break;
                case 3:
                    totalBudget = calculateTotalBudget(destinations);
                    System.out.printf("Total estimated travel budget: $%.2f%n", totalBudget);
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for using Travel Itinerary Planner!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    // Method to add destination to the itinerary
    public static void addDestination(Scanner scanner, ArrayList<Destination> destinations) {
        System.out.print("Enter destination: ");
        String name = scanner.nextLine();

        System.out.print("Enter start date (YYYY-MM-DD): ");
        String startDate = scanner.nextLine();

        System.out.print("Enter end date (YYYY-MM-DD): ");
        String endDate = scanner.nextLine();

        System.out.print("Enter estimated budget for this destination: $");
        double budget = scanner.nextDouble();
        scanner.nextLine();  // clear input buffer

        destinations.add(new Destination(name, startDate, endDate, budget));
        System.out.println("Destination added successfully!");
    }

    // Method to view the entire itinerary
    public static void viewItinerary(ArrayList<Destination> destinations) {
        if (destinations.isEmpty()) {
            System.out.println("No destinations added to the itinerary yet.");
        } else {
            System.out.println("\nYour Travel Itinerary:");
            for (Destination destination : destinations) {
                System.out.println(destination);
            }
        }
    }

    // Method to calculate the total budget for all destinations
    public static double calculateTotalBudget(ArrayList<Destination> destinations) {
        double total = 0;
        for (Destination destination : destinations) {
            total += destination.getBudget();
        }
        return total;
    }
}
