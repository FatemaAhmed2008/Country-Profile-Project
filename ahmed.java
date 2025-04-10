package CountryProfileProject;

  import java.util.ArrayList;
import java.util.Scanner;

// Class to represent a Country
class Country {
    private String name;
    private String capital;
    private long population;
    private String language;

    public Country(String name, String capital, long population, String language) {
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void displayInfo() {
        System.out.println("Country: " + name);
        System.out.println("Capital: " + capital);
        System.out.println("Population: " + population);
        System.out.println("Official Language: " + language);
        System.out.println("---------------------------");
    }
}

public class ahmed { // Make sure your file is named ahmed.java
    private static ArrayList<Country> countries = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n==== Country Profile System ====");
            System.out.println("1. Add a Country");
            System.out.println("2. Search for a Country");
            System.out.println("3. Display All Countries");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Please enter a valid number: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addCountry();
                case 2 -> searchCountry();
                case 3 -> displayAllCountries();
                case 4 -> System.out.println("Exiting program...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);
    }

    private static void addCountry() {
        System.out.print("Enter country name: ");
        String name = scanner.nextLine();
        System.out.print("Enter capital: ");
        String capital = scanner.nextLine();
        System.out.print("Enter population: ");
        while (!scanner.hasNextLong()) {
            System.out.print("Please enter a valid number for population: ");
            scanner.next();
        }
        long population = scanner.nextLong();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter official language: ");
        String language = scanner.nextLine();

        countries.add(new Country(name, capital, population, language));
        System.out.println("Country added successfully!");
    }

    private static void searchCountry() {
        System.out.print("Enter country name to search: ");
        String name = scanner.nextLine();
        boolean found = false;

        for (Country country : countries) {
            if (country.getName().equalsIgnoreCase(name)) {
                country.displayInfo();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Country not found.");
        }
    }

    private static void displayAllCountries() {
        if (countries.isEmpty()) {
            System.out.println("No countries in the database.");
        } else {
            System.out.println("\n=== Country Profiles ===");
            for (Country country : countries) {
                country.displayInfo();
            }
        }
    }
}
 