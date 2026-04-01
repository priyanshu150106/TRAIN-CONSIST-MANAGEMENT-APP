import java.util.ArrayList;
import java.util.List;

// Bogie Class
class Bogie {
    private String type;
    private int capacity;

    public Bogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
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

    public static void main(String[] args) {

        System.out.println("🚆 Train Consist Management System");

        initializeTrain();

        // UC2: Add Passenger Bogies
        addPassengerBogie(72);
        addPassengerBogie(72);
        addPassengerBogie(60);

        displayConsistSummary();
    }

    // UC1
    public static void initializeTrain() {
        train.clear();
        System.out.println("Train initialized successfully.");
    }

    // UC2
    public static void addPassengerBogie(int capacity) {
        Bogie bogie = new Bogie("Passenger", capacity);
        train.add(bogie);

        System.out.println("Passenger bogie added with capacity: " + capacity);
    }

    // UC1
    public static void displayConsistSummary() {

        System.out.println("\n--- Train Consist Summary ---");
        System.out.println("Total Bogies: " + train.size());

        int totalCapacity = 0;

        for (Bogie b : train) {
            totalCapacity += b.getCapacity();
        }

        System.out.println("Total Capacity: " + totalCapacity);
    }
}