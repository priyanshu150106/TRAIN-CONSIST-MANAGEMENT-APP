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

    // UC5
    static Set<Integer> bogieIds = new LinkedHashSet<>();

    // UC6: Map ID → Capacity
    static Map<Integer, Integer> bogieCapacityMap = new HashMap<>();

    public static void main(String[] args) {

        System.out.println("🚆 Train Consist Management System");

        initializeTrain();

        addPassengerBogie(105, 72);
        addPassengerBogie(101, 72);
        addPassengerBogie(103, 60);

        displayConsistSummary();

        // UC6: Lookup capacity
        getCapacityById(101);
        getCapacityById(999); // not موجود
    }

    // UC1
    public static void initializeTrain() {
        train.clear();
        bogieIds.clear();
        bogieCapacityMap.clear();
        System.out.println("Train initialized successfully.");
    }

    // UC2 + UC3 + UC5 + UC6
    public static void addPassengerBogie(int id, int capacity) {

        if (bogieIds.contains(id)) {
            System.out.println("❌ Bogie ID " + id + " already exists.");
            return;
        }

        Bogie bogie = new Bogie(id, "Passenger", capacity);

        train.add(bogie);
        bogieIds.add(id);

        // UC6: Store in HashMap
        bogieCapacityMap.put(id, capacity);

        System.out.println("✅ Added Bogie | ID: " + id + " | Capacity: " + capacity);
    }

    // UC6: Get capacity by ID
    public static void getCapacityById(int id) {

        if (bogieCapacityMap.containsKey(id)) {
            System.out.println("🔍 Capacity of Bogie " + id + " = " + bogieCapacityMap.get(id));
        } else {
            System.out.println("❌ Bogie ID " + id + " not found.");
        }
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

        System.out.println("Bogie IDs (Insertion Order): " + bogieIds);

        // UC6: Show map
        System.out.println("Bogie → Capacity Map: " + bogieCapacityMap);
    }
}