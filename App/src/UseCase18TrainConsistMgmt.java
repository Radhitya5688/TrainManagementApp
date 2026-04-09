public class UseCase18TrainConsistMgmt {

    public static void main(String[] args) {
        String[] bogieIds = {"BC101", "BC205", "BC139", "BC412", "BC585"};

        System.out.println("UC18: Linear Search for Bogie ID");

        testSearchBogieFound(bogieIds, "BC139");

        testSearchBogieNotFound(bogieIds, "BC999");

        testSearchFirstElement(bogieIds, "BC101");

        testSearchLastElement(bogieIds, "BC585");

        testSearchSingleElement();

        System.out.println("UC18 search completed...");
    }

    static void testSearchBogieFound(String[] bogieIds, String target) {
        System.out.println("testSearchBogieFound(): ");
        boolean found = linearSearch(bogieIds, target);
        if (found) {
            System.out.println("Bogie " + target + " found in train consist.");
        } else {
            System.out.println("Bogie " + target + " not found.");
        }
        System.out.println();
    }

    static void testSearchBogieNotFound(String[] bogieIds, String target) {
        System.out.println("testSearchBogieNotFound(): ");
        boolean found = linearSearch(bogieIds, target);
        if (found) {
            System.out.println("Bogie " + target + " found in train consist.");
        } else {
            System.out.println("Bogie " + target + " not found.");
        }
        System.out.println();
    }

    static void testSearchFirstElement(String[] bogieIds, String target) {
        System.out.println("testSearchFirstElement(): ");
        boolean found = linearSearch(bogieIds, target);
        System.out.println("First element match: " + (found ? "true" : "false"));
        System.out.println();
    }

    static void testSearchLastElement(String[] bogieIds, String target) {
        System.out.println("testSearchLastElement(): ");
        boolean found = linearSearch(bogieIds, target);
        System.out.println("Last element match: " + (found ? "true" : "false"));
        System.out.println();
    }

    static void testSearchSingleElement() {
        String[] singleBogie = {"BC101"};
        System.out.println("testSearchSingleElement(): ");
        boolean found = linearSearch(singleBogie, "BC101");
        System.out.println("Single element search: " + (found ? "true" : "false"));
        System.out.println();
    }

    static boolean linearSearch(String[] bogieIds, String target) {
        // Sequential traversal - check each element one by one
        for (int i = 0; i < bogieIds.length; i++) {
            if (bogieIds[i].equals(target)) {
                return true;  // Found - stop searching
            }
        }
        return false;  // Not found after checking all elements
    }
}