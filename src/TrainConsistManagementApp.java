import java.util.*;
import java.util.stream.Collectors;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        List<String> bogies = Arrays.asList(
                "S1", "S2", "A1", "GEN1", "S3", "A2"
        );

        System.out.println("All Bogies: " + bogies);

        // 🔥 Grouping logic
        Map<String, List<String>> groupedBogies = bogies.stream()
                .collect(Collectors.groupingBy(b -> {
                    if (b.startsWith("S")) return "Sleeper";
                    else if (b.startsWith("A")) return "AC";
                    else return "General";
                }));

        System.out.println("Grouped Bogies: " + groupedBogies);
    }
}