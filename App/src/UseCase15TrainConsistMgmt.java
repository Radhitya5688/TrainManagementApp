public class UseCase15TrainConsistMgmt {

    static class CargoSafetyException extends Exception {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    static class GoodsBogie {
        String bogieId;
        String shape;

        public GoodsBogie(String bogieId, String shape) {
            this.bogieId = bogieId;
            this.shape = shape;
        }

        public void displayDetails() {
            System.out.println("Bogie ID: " + bogieId + ", Shape: " + shape);
        }
    }

    public static void assignCargo(GoodsBogie bogie, String cargo) throws CargoSafetyException {
        System.out.println("Attempting to assign " + cargo + " cargo to " + bogie.shape + " bogie");

        if (cargo.equals("Petroleum") && bogie.shape.equals("Rectangular")) {
            throw new CargoSafetyException("Unsafe combination: Petroleum cannot be assigned to Rectangular bogie");
        }

        System.out.println("Cargo assigned successfully -> " + cargo + " to " + bogie.shape + " bogie");
    }

    public static void main(String[] args) {
        GoodsBogie cylindricalBogie = new GoodsBogie("B201", "Cylindrical");
        GoodsBogie rectangularBogie = new GoodsBogie("B202", "Rectangular");

        try {
            assignCargo(cylindricalBogie, "Petroleum");
        } catch (CargoSafetyException e) {
            System.out.println("Cargo validation failed: " + e.getMessage());
        } finally {
            System.out.println("UC15: Safe assignment cleanup for cylindrical bogie");
        }

        try {
            assignCargo(rectangularBogie, "Petroleum");
        } catch (CargoSafetyException e) {
            System.out.println("Cargo validation failed: " + e.getMessage());
        } finally {
            System.out.println("UC15: Safe assignment cleanup for rectangular bogie");
        }

        System.out.println("UC15 exception handling completed...");
    }
}