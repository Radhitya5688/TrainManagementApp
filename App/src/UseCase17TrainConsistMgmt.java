import java.util.Arrays;

public class UseCase17TrainConsistMgmt {

    public static void main(String[] args) {
        System.out.println("UC17: Sort Bogie Names using Arrays.sort()");

        testSortBasic();

        testSortUnsorted();

        testSortAlreadySorted();

        testSortDuplicateNames();

        testSortSingleElement();

        System.out.println("UC17 sorting completed...");
    }

    static void testSortBasic() {
        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};
        System.out.println("testSortBasic(): ");
        printArray(bogieNames);

        Arrays.sort(bogieNames);
        System.out.println("Sorted: (AC Chair, First Class, General, Luxury, Sleeper)");
        printArray(bogieNames);
        System.out.println();
    }

    static void testSortUnsorted() {
        String[] bogieNames = {"Luxury", "First Class", "General", "Sleeper", "AC Chair"};
        System.out.println("testSortUnsorted(): ");
        printArray(bogieNames);

        Arrays.sort(bogieNames);
        System.out.println("Sorted: (AC Chair, First Class, General, Luxury, Sleeper)");
        printArray(bogieNames);
        System.out.println();
    }

    static void testSortAlreadySorted() {
        String[] bogieNames = {"AC Chair", "First Class", "General", "Luxury", "Sleeper"};
        System.out.println("testSortAlreadySorted(): ");
        printArray(bogieNames);

        Arrays.sort(bogieNames);
        System.out.println("Already sorted array remains unchanged");
        printArray(bogieNames);
        System.out.println();
    }

    static void testSortDuplicateNames() {
        String[] bogieNames = {"Sleeper", "General", "Sleeper"};
        System.out.println("testSortDuplicateNames(): ");
        printArray(bogieNames);

        Arrays.sort(bogieNames);
        System.out.println("Duplicates preserved in order: (General, Sleeper, Sleeper)");
        printArray(bogieNames);
        System.out.println();
    }

    static void testSortSingleElement() {
        String[] bogieNames = {"Sleeper"};
        System.out.println("testSortSingleElement(): ");
        printArray(bogieNames);

        Arrays.sort(bogieNames);
        System.out.println("Single element array does not change contents");
        printArray(bogieNames);
        System.out.println();
    }

    static void printArray(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}