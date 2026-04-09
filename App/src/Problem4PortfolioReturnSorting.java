public class Problem4PortfolioReturnSorting {

    static class Asset {
        String name;
        double returnRate;
        double volatility;

        Asset(String name, double returnRate, double volatility) {
            this.name = name;
            this.returnRate = returnRate;
            this.volatility = volatility;
        }

        public String toString() {
            return name + "(return=" + returnRate + "%, vol=" + volatility + ")";
        }
    }

    public static Asset[] copyArray(Asset[] arr) {
        Asset[] copy = new Asset[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = new Asset(arr[i].name, arr[i].returnRate, arr[i].volatility);
        }
        return copy;
    }

    public static void mergeSort(Asset[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(Asset[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Asset[] L = new Asset[n1];
        Asset[] R = new Asset[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i].returnRate <= R[j].returnRate) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    public static void quickSort(Asset[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(Asset[] arr, int low, int high) {
        Asset pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].returnRate > pivot.returnRate ||
                    (arr[j].returnRate == pivot.returnRate && arr[j].volatility < pivot.volatility)) {
                i++;
                Asset temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        Asset temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void printArray(Asset[] arr) {
        for (Asset a : arr) System.out.println(a);
    }

    public static void main(String[] args) {
        Asset[] assets = {
                new Asset("AAPL", 12, 4.2),
                new Asset("TSLA", 8, 7.1),
                new Asset("GOOG", 15, 3.5),
                new Asset("MSFT", 15, 2.9)
        };

        Asset[] mergeArr = copyArray(assets);
        Asset[] quickArr = copyArray(assets);

        mergeSort(mergeArr, 0, mergeArr.length - 1);
        System.out.println("Merge Sort by return ascending:");
        printArray(mergeArr);

        quickSort(quickArr, 0, quickArr.length - 1);
        System.out.println("\nQuick Sort by return DESC and volatility ASC:");
        printArray(quickArr);
    }
}
