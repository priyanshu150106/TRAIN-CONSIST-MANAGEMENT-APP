import java.util.*;

class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

class Bogie {
    String id;
    int capacity;

    public Bogie(String id, int capacity) throws InvalidCapacityException {
        if (capacity <= 0 || capacity > 150) {
            throw new InvalidCapacityException(
                    "Invalid capacity for " + id + ": " + capacity
            );
        }
        this.id = id;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return id + "(Capacity:" + capacity + ")";
    }
}

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        List<Bogie> bogies = new ArrayList<>();

        try {
            bogies.add(new Bogie("S1", 72));
            bogies.add(new Bogie("A1", 48));
            bogies.add(new Bogie("GEN1", 0));   // ❌ Invalid
            bogies.add(new Bogie("S2", 200));   // ❌ Invalid
        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Valid Bogies: " + bogies);
    }
}