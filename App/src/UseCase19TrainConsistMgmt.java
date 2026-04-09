import java.util.Arrays;

public class UseCase19TrainConsistMgmt {

    public static void main(String[] args) {
        String[] bogieIds = {"BC205", "BC139", "BC101", "BC585", "BC412"};

        System.out.println("UC19: Binary Search for Bogie ID");

        testBinarySearchBogieFound(bogieIds, "BC139");

        testBinarySearchBogieNotFound(bogieIds, "BC999");

        testBinarySearchFirstElement(bogieIds, "BC101");

        testBinarySearchLastElement(bogieIds, "BC585");

        testBinarySearchSingleElement();

        testBinarySearchEmptyArray();

        testBinarySearchUnsortedInput(bogieIds);

        System.out.println("UC19 completed...");
    }

    static void testBinarySearchBogieFound(String[] bogieIds, String target) {
        System.out.println("testBinarySearchBogieFound(): ");
        boolean found = binarySearch(bogieIds, target);
        System.out.println("Bogie " + target + " " + (found ? "found" : "not found") + " using Binary Search.");
        System.out.println();
    }

    static void testBinarySearchBogieNotFound(String[] bogieIds, String target) {
        System.out.println("testBinarySearchBogieNotFound(): ");
        boolean found = binarySearch(bogieIds, target);
        System.out.println("Bogie " + target + " " + (found ? "found" : "not found") + " using Binary Search.");
        System.out.println();
    }

    static void testBinarySearchFirstElement(String[] bogieIds, String target) {
        System.out.println("testBinarySearchFirstElement(): ");
        boolean found = binarySearch(bogieIds, target);
        System.out.println("First element match: " + (found ? "true" : "false"));
        System.out.println();
    }

    static void testBinarySearchLastElement(String[] bogieIds, String target) {
        System.out.println("testBinarySearchLastElement(): ");
        boolean found = binarySearch(bogieIds, target);
        System.out.println("Last element match: " + (found ? "true" : "false"));
        System.out.println();
    }

    static void testBinarySearchSingleElement() {
        String[] singleBogie = {"BC101"};
        System.out.println("testBinarySearchSingleElement(): ");
        boolean found = binarySearch(singleBogie, "BC101");
        System.out.println("Single element search: " + (found ? "true" : "false"));
        System.out.println();
    }

    static void testBinarySearchEmptyArray() {
        String[] emptyArray = {};
        System.out.println("testBinarySearchEmptyArray(): ");
        boolean found = binarySearch(emptyArray, "BC101");
        System.out.println("Empty array search: " + (found ? "true" : "false"));
        System.out.println();
    }

    static void testBinarySearchUnsortedInput(String[] bogieIds) {
        System.out.println("testBinarySearchUnsortedInput(): ");
        boolean found = binarySearch(bogieIds, "BC205");
        System.out.println("Unsorted input handled: " + (found ? "true" : "false"));
        System.out.println();
    }

    static boolean binarySearch(String[] bogieIds, String target) {
        System.out.println("Binary Search for Bogie ID: " + target);

        if (!isSorted(bogieIds)) {
            System.out.println("Input unsorted. Sorting first...");
            Arrays.sort(bogieIds);
            printArray(bogieIds);
        }

        int left = 0;
        int right = bogieIds.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Compare middle element
            int cmp = bogieIds[mid].compareTo(target);

            if (cmp == 0) {
                return true;
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    static boolean isSorted(String[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    static void printArray(String[] arr) {
        for (String id : arr) {
            System.out.print(id + " ");
        }
        System.out.println();
    }
}