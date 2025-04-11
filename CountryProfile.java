import java.util.ArrayList;
import java.util.Scanner;

// Superclass
class Place {
    protected String name;
    protected String capital;

    public Place(String name, String capital) {
        this.name = name;
        this.capital = capital;
    }

    public String getName() {
        return name;
    }

    // Polymorphic method
    public void displayInfo() {
        System.out.println("Place: " + name);
        System.out.println("Capital: " + capital);
    }
}

// Subclass
class Country extends Place {
    private long population;
    private String language;

    public Country(String name, String capital, long population, String language) {
        super(name, capital); // Call to superclass constructor
        this.population = population;
        this.language = language;
    }

    // Method overriding (Polymorphism)
    @Override
    public void displayInfo() {
        System.out.println("Country: " + name);
        System.out.println("Capital: " + capital);
        System.out.println("Population: " + population);
        System.out.println("Official Language: " + language);
        System.out.println("---------------------------");
    }
}

// Main class
public class CountryProfile {
    private static ArrayList<Place> places = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n==== Country Profile System ====");
            System.out.println("1. Add a Country");
            System.out.println("2. Search for a Country");
            System.out.println("3. Display All Places");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addCountry();
                    break;
                case 2:
                    searchCountry();
                    break;
                case 3:
                    displayAllPlaces();
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);
    }

    private static void addCountry() {
        System.out.print("Enter country name: ");
        String name = scanner.nextLine();
        System.out.print("Enter capital: ");
        String capital = scanner.nextLine();
        System.out.print("Enter population: ");
        long population = scanner.nextLong();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter official language: ");
        String language = scanner.nextLine();

        places.add(new Country(name, capital, population, language));
        System.out.println("Country added successfully!");
    }

    private static void searchCountry() {
        System.out.print("Enter country name to search: ");
        String name = scanner.nextLine();
        boolean found = false;

        for (Place place : places) {
            if (place.getName().equalsIgnoreCase(name)) {
                place.displayInfo(); // Polymorphism in action
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Country not found.");
        }
    }

    private static void displayAllPlaces() {
        if (places.isEmpty()) {
            System.out.println("No places in the database.");
        } else {
            System.out.println("\n=== All Places ===");
            for (Place place : places) {
                place.displayInfo(); // Polymorphism
            }
        }
    }
}
