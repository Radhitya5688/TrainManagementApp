public class UseCase14TrainConsistMgmt {

    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    static class PassengerBogie {
        String bogieId;
        String bogieType;
        int capacity;

        public PassengerBogie(String bogieId, String bogieType, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Invalid bogie capacity for " + bogieId + ": " + capacity);
            }
            this.bogieId = bogieId;
            this.bogieType = bogieType;
            this.capacity = capacity;
        }

        public void displayDetails() {
            System.out.println("Bogie ID: " + bogieId + ", Type: " + bogieType + ", Capacity: " + capacity);
        }
    }

    public static void main(String[] args) {
        try {
            PassengerBogie b1 = new PassengerBogie("B101", "Sleeper", 72);
            b1.displayDetails();
        } catch (InvalidCapacityException e) {
            System.out.println(e.getMessage());
        }

        try {
            PassengerBogie b2 = new PassengerBogie("B102", "AC", 0);
            b2.displayDetails();
        } catch (InvalidCapacityException e) {
            System.out.println(e.getMessage());
        }

        try {
            PassengerBogie b3 = new PassengerBogie("B103", "First Class", -10);
            b3.displayDetails();
        } catch (InvalidCapacityException e) {
            System.out.println(e.getMessage());
        }
    }
}