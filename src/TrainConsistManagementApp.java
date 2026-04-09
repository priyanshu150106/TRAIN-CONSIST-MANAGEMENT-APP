import java.util.*;
import java.util.regex.Pattern;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        String trainId = "TRN-1234";

        List<String> cargoCodes = Arrays.asList(
                "CG-AX12",
                "CG-BY34",
                "INVALID1",
                "CG-1234"
        );

        // 🚆 Validate Train ID
        boolean isTrainValid = validateTrainId(trainId);
        System.out.println("Train ID Valid: " + isTrainValid);

        // 📦 Validate Cargo Codes
        List<String> validCargo = cargoCodes.stream()
                .filter(TrainConsistManagementApp::validateCargoCode)
                .toList();

        System.out.println("Valid Cargo Codes: " + validCargo);
    }

    // 🚆 Train ID Validation
    private static boolean validateTrainId(String trainId) {
        String regex = "TRN-\\d{4}";
        return Pattern.matches(regex, trainId);
    }

    // 📦 Cargo Code Validation
    private static boolean validateCargoCode(String code) {
        String regex = "CG-[A-Z]{2}\\d{2}";
        return Pattern.matches(regex, code);
    }
}