import java.util.*;
import java.util.stream.*;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        List<String> bogies = new ArrayList<>();

        // 🔥 Create large dataset (for real comparison)
        for (int i = 1; i <= 100000; i++) {
            bogies.add("S" + i);
            bogies.add("A" + i);
            bogies.add("GEN" + i);
        }

        // ⏱️ LOOP APPROACH
        long startLoop = System.nanoTime();

        int totalSeatsLoop = 0;
        for (String b : bogies) {
            totalSeatsLoop += getSeatCount(b);
        }

        long endLoop = System.nanoTime();

        // ⏱️ STREAM APPROACH
        long startStream = System.nanoTime();

        int totalSeatsStream = bogies.stream()
                .mapToInt(TrainConsistManagementApp::getSeatCount)
                .sum();

        long endStream = System.nanoTime();

        // 📊 Results
        System.out.println("Total Seats (Loop): " + totalSeatsLoop);
        System.out.println("Total Seats (Stream): " + totalSeatsStream);

        System.out.println("Loop Time (ns): " + (endLoop - startLoop));
        System.out.println("Stream Time (ns): " + (endStream - startStream));
    }

    private static int getSeatCount(String bogie) {
        if (bogie.startsWith("S")) return 72;
        if (bogie.startsWith("A")) return 48;
        return 100;
    }
}