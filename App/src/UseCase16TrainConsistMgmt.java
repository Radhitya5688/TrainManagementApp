public class UseCase16TrainConsistMgmt {

    public static void main(String[] args) {
        int[] bogieCapacities = {72, 56, 68, 40, 72};  // Test case with duplicates

        System.out.println("UC16: Manual Bubble Sorting Bogie Capacities");
        System.out.println("Original Capacities: ");
        printArray(bogieCapacities);

        // Bubble Sort algorithm
        bubbleSort(bogieCapacities);

        System.out.println("Sorted Capacities (Descending): ");
        printArray(bogieCapacities);
        System.out.println("UC16 sorting completed.");
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    // Swap if current is smaller than next
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}