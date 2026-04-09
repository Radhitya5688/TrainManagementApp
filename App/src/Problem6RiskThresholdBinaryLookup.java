import java.util.Arrays;

public class Problem6RiskThresholdBinaryLookup {

    public static int linearSearch(int[] arr, int target) {
        int comparisons = 0;
        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i] == target) {
                System.out.println("Linear Search found at index " + i + " with " + comparisons + " comparisons");
                return i;
            }
        }
        System.out.println("Linear Search not found with " + comparisons + " comparisons");
        return -1;
    }

    public static int floorValue(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int floor = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) return arr[mid];
            if (arr[mid] < target) {
                floor = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return floor;
    }

    public static int ceilingValue(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ceil = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) return arr[mid];
            if (arr[mid] > target) {
                ceil = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ceil;
    }

    public static void main(String[] args) {
        int[] unsortedRisks = {50, 10, 100, 25};
        int target = 30;

        System.out.println("Unsorted risks: " + Arrays.toString(unsortedRisks));
        linearSearch(unsortedRisks, target);

        int[] sortedRisks = {10, 25, 50, 100};
        System.out.println("\nSorted risks: " + Arrays.toString(sortedRisks));
        System.out.println("Floor of " + target + ": " + floorValue(sortedRisks, target));
        System.out.println("Ceiling of " + target + ": " + ceilingValue(sortedRisks, target));
    }
}