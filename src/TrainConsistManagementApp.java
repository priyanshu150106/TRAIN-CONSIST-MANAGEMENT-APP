import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        String trainName = "Express";
        String engine = "WAP-7";

        List<String> bogies = new ArrayList<>();

        bogies.add("S1");
        bogies.add("S2");
        bogies.add("A1");
        bogies.add("GEN1");
        bogies.add("S3");

        System.out.println("All Bogies: " + bogies);

        // 🔍 Filter only passenger bogies (Sleeper = S)
        List<String> passengerBogies = bogies.stream()
                .filter(b -> b.startsWith("S"))
                .collect(Collectors.toList());

        System.out.println("Passenger Bogies: " + passengerBogies);
    }
}
