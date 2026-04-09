import java.util.*;
import java.util.stream.*;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        List<String> bogies = Arrays.asList(
                "S1", "S2", "A1", "GEN1", "S3"
        );

        System.out.println("Bogies: " + bogies);

        // 🔥 Reduce to calculate total seats
        int totalSeats = bogies.stream()
                .map(b -> getSeatCount(b))
                .reduce(0, (a, b) -> a + b);

        System.out.println("Total Seats: " + totalSeats);
    }

    // 🎯 Seat logic
    private static int getSeatCount(String bogie) {
        if (bogie.startsWith("S")) return 72;
        if (bogie.startsWith("A")) return 48;
        return 100;
    }
}"