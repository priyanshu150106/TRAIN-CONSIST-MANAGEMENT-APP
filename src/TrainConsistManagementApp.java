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

// Main Application Class
public class TrainConsistManagementApp {

    // Train consist (list of bogies)
    static List<Bogie> train = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("🚆 Train Consist Management System");

        initializeTrain();

        displayConsistSummary();
    }

    // UC1: Initialize Train
    public static void initializeTrain() {
        train.clear(); // ensures train is empty
        System.out.println("Train initialized successfully.");
    }

    // UC1: Display Summary
    public static void displayConsistSummary() {

        System.out.println("\n--- Train Consist Summary ---");
        System.out.println("Total Bogies: " + train.size());

        if (train.isEmpty()) {
            System.out.println("Status: Empty Train (No bogies attached)");
        } else {
            System.out.println("Status: Train has bogies");
        }
    }
}