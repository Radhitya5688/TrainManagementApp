import java.util.ArrayList;

public class Problem1TransactionFeeSorting {

    static class Transaction {
        String id;
        double fee;
        String timestamp;

        Transaction(String id, double fee, String timestamp) {
            this.id = id;
            this.fee = fee;
            this.timestamp = timestamp;
        }

        public String toString() {
            return id + "(fee=" + fee + ", ts=" + timestamp + ")";
        }
    }

    public static void bubbleSortByFee(ArrayList<Transaction> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).fee > list.get(j + 1).fee) {
                    Transaction temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void insertionSortByFeeAndTimestamp(ArrayList<Transaction> list) {
        for (int i = 1; i < list.size(); i++) {
            Transaction key = list.get(i);
            int j = i - 1;

            while (j >= 0 && (
                    list.get(j).fee > key.fee ||
                            (list.get(j).fee == key.fee && list.get(j).timestamp.compareTo(key.timestamp) > 0)
            )) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }

    public static void printHighFeeOutliers(ArrayList<Transaction> list) {
        System.out.println("High-fee outliers (> 50):");
        boolean found = false;
        for (Transaction t : list) {
            if (t.fee > 50) {
                System.out.println(t);
                found = true;
            }
        }
        if (!found) {
            System.out.println("None");
        }
    }

    public static ArrayList<Transaction> copyList(ArrayList<Transaction> original) {
        ArrayList<Transaction> copy = new ArrayList<>();
        for (Transaction t : original) {
            copy.add(new Transaction(t.id, t.fee, t.timestamp));
        }
        return copy;
    }

    public static void main(String[] args) {
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("id1", 10.5, "10:00"));
        transactions.add(new Transaction("id2", 25.0, "09:30"));
        transactions.add(new Transaction("id3", 5.0, "10:15"));
        transactions.add(new Transaction("id4", 25.0, "09:00"));
        transactions.add(new Transaction("id5", 60.0, "11:00"));

        ArrayList<Transaction> bubbleList = copyList(transactions);
        ArrayList<Transaction> insertionList = copyList(transactions);

        System.out.println("Original Transactions:");
        for (Transaction t : transactions) System.out.println(t);

        bubbleSortByFee(bubbleList);
        System.out.println("\nBubble Sort by fee ascending:");
        for (Transaction t : bubbleList) System.out.println(t);

        insertionSortByFeeAndTimestamp(insertionList);
        System.out.println("\nInsertion Sort by fee and timestamp:");
        for (Transaction t : insertionList) System.out.println(t);

        System.out.println();
        printHighFeeOutliers(transactions);
    }
}