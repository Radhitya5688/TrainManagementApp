import java.util.Arrays;

public class Problem5AccountIdLookup {

    public static int linearComparisons = 0;
    public static int binaryComparisons = 0;

    public static int linearSearchFirst(String[] arr, String target) {
        linearComparisons = 0;
        for (int i = 0; i < arr.length; i++) {
            linearComparisons++;
            if (arr[i].equals(target)) return i;
        }
        return -1;
    }

    public static int linearSearchLast(String[] arr, String target) {
        int last = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(target)) last = i;
        }
        return last;
    }

    public static int binarySearch(String[] arr, String target) {
        binaryComparisons = 0;
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            binaryComparisons++;
            int mid = (low + high) / 2;
            int cmp = arr[mid].compareTo(target);

            if (cmp == 0) return mid;
            else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public static int countOccurrences(String[] arr, String target) {
        int count = 0;
        for (String s : arr) {
            if (s.equals(target)) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        String[] logs = {"accB", "accA", "accB", "accC"};

        int first = linearSearchFirst(logs, "accB");
        int last = linearSearchLast(logs, "accB");

        System.out.println("Linear Search first accB index: " + first);
        System.out.println("Linear Search last accB index: " + last);
        System.out.println("Linear comparisons: " + linearComparisons);

        Arrays.sort(logs);
        System.out.println("\nSorted logs: " + Arrays.toString(logs));

        int index = binarySearch(logs, "accB");
        int count = countOccurrences(logs, "accB");

        System.out.println("Binary Search accB index: " + index);
        System.out.println("Occurrences of accB: " + count);
        System.out.println("Binary comparisons: " + binaryComparisons);
    }
}