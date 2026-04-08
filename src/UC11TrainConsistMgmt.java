import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;



public class UC11TrainConsistMgmt {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("===========================================");
        System.out.println("UC11 - Validate Train ID & Cargo Code");
        System.out.println("===========================================\n");

        System.out.print("Enter Train ID (Format: TRN-1234): ");
        String trainId = scanner.nextLine();

        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String cargoCode = scanner.nextLine();

        String trainRegex = "TRN-\\d{4}";
        String cargoRegex = "PET-[A-Z]{2}";

        Pattern trainPattern = Pattern.compile(trainRegex);
        Pattern cargoPattern = Pattern.compile(cargoRegex);

        Matcher trainMatcher = trainPattern.matcher(trainId);
        Matcher cargoMatcher = cargoPattern.matcher(cargoCode);

        boolean isTrainValid = trainMatcher.matches();
        boolean isCargoValid = cargoMatcher.matches();

        System.out.println("\nValidation Results:");
        System.out.println("Train ID Valid: " + isTrainValid);
        System.out.println("Cargo Code Valid: " + isCargoValid);

        if (!isTrainValid) {
            System.out.println("❌ Invalid Train ID! Expected format: TRN-1234");
        }

        if (!isCargoValid) {
            System.out.println("❌ Invalid Cargo Code! Expected format: PET-AB");
        }

        if (isTrainValid && isCargoValid) {
            System.out.println("✅ Both inputs are valid.");
        }

        System.out.println("\nUC11 validation completed...");

        scanner.close();
    }
}