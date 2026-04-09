import java.util.*;
import java.util.stream.Collectors;

class GoodsBogie {
    String id;
    int weight;
    int hazardLevel;

    public GoodsBogie(String id, int weight, int hazardLevel) {
        this.id = id;
        this.weight = weight;
        this.hazardLevel = hazardLevel;
    }

    @Override
    public String toString() {
        return id + "(W:" + weight + ", H:" + hazardLevel + ")";
    }
}

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        List<GoodsBogie> bogies = Arrays.asList(
                new GoodsBogie("GD1", 90, 3),
                new GoodsBogie("GD2", 120, 2),
                new GoodsBogie("GD3", 80, 6),
                new GoodsBogie("GD4", 70, 2)
        );

        System.out.println("All Goods Bogies: " + bogies);

        // 🔥 Safety Filter
        List<GoodsBogie> safeBogies = bogies.stream()
                .filter(TrainConsistManagementApp::isSafe)
                .collect(Collectors.toList());

        System.out.println("Safe Bogies: " + safeBogies);

        // ❌ Unsafe Bogies
        List<GoodsBogie> unsafeBogies = bogies.stream()
                .filter(b -> !isSafe(b))
                .collect(Collectors.toList());

        System.out.println("Unsafe Bogies: " + unsafeBogies);
    }

    // 🎯 Safety Rule
    private static boolean isSafe(GoodsBogie b) {
        return b.weight <= 100 && b.hazardLevel <= 5;
    }
}