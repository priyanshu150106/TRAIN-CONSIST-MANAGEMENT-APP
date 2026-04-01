import java.util.*;

// Bogie Class
class Bogie {
    private int id;
    private String type;
    private int capacity;

    public Bogie(int id, String type, int capacity) {
        this.id = id;
        this.type = type;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }
}

// Main Class
public class TrainConsistManagementApp {

    static List<Bogie> train = new ArrayList<>();
    static Set<Integer> bogieIds = new HashSet<>(); // UC3

    public static void main(String[] args) {

        System.out.println("🚆 Train Consist Management System");

        initializeTrain();

        // UC3: Adding bogies with unique IDs
        addPassengerBogie(101, 72);
        addPassengerBogie(102, 72);
        addPassengerBogie(101, 60); // Duplicate ID

        displayConsistSummary();
    }

    // UC1
    public static void initializeTrain() {
        train.clear();
        bogieIds.clear();
        System.out.println("Train initialized successfully.");
    }

    // UC2 + UC3
    public static void addPassengerBogie(int id, int capacity) {

        // UC3: Check uniqueness using HashSet
        if (bogieIds.contains(id)) {
            System.out.println("❌ Bogie ID " + id + " already exists. Cannot add duplicate.");
            return;
        }

        Bogie bogie = new Bogie(id, "Passenger", capacity);
        train.add(bogie);
        bogieIds.add(id);

        System.out.println("✅ Passenger bogie added | ID: " + id + " | Capacity: " + capacity);
    }

    // Summary
    public static void displayConsistSummary() {

        System.out.println("\n--- Train Consist Summary ---");
        System.out.println("Total Bogies: " + train.size());

        int totalCapacity = 0;

        for (Bogie b : train) {
            totalCapacity += b.getCapacity();
        }

        System.out.println("Total Capacity: " + totalCapacity);

        // UC3: Show unique IDs
        System.out.println("Unique Bogie IDs: " + bogieIds);
    }
}