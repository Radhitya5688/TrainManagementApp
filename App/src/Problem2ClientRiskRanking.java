public class Problem2ClientRiskRanking {

    static class Client {
        String name;
        int riskScore;
        double accountBalance;

        Client(String name, int riskScore, double accountBalance) {
            this.name = name;
            this.riskScore = riskScore;
            this.accountBalance = accountBalance;
        }

        public String toString() {
            return name + "(risk=" + riskScore + ", balance=" + accountBalance + ")";
        }
    }

    public static Client[] copyArray(Client[] arr) {
        Client[] copy = new Client[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = new Client(arr[i].name, arr[i].riskScore, arr[i].accountBalance);
        }
        return copy;
    }

    public static void bubbleSortRiskAsc(Client[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].riskScore > arr[j + 1].riskScore) {
                    Client temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void insertionSortRiskDescBalanceAsc(Client[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Client key = arr[i];
            int j = i - 1;

            while (j >= 0 && (
                    arr[j].riskScore < key.riskScore ||
                            (arr[j].riskScore == key.riskScore && arr[j].accountBalance > key.accountBalance)
            )) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void printArray(Client[] arr) {
        for (Client c : arr) {
            System.out.println(c);
        }
    }

    public static void main(String[] args) {
        Client[] clients = {
                new Client("clientC", 80, 25000),
                new Client("clientA", 20, 50000),
                new Client("clientB", 50, 15000),
                new Client("clientD", 80, 10000)
        };

        Client[] bubble = copyArray(clients);
        Client[] insertion = copyArray(clients);

        bubbleSortRiskAsc(bubble);
        System.out.println("Bubble Sort - Risk Ascending:");
        printArray(bubble);

        insertionSortRiskDescBalanceAsc(insertion);
        System.out.println("\nInsertion Sort - Risk Desc, Balance Asc:");
        printArray(insertion);

        System.out.println("\nTop highest risk clients:");
        for (int i = 0; i < Math.min(3, insertion.length); i++) {
            System.out.println(insertion[i]);
        }
    }
}
