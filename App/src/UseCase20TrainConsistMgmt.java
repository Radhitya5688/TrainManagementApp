public class UseCase20TrainConsistMgmt {

    public static void main(String[] args) {
        System.out.println("UC20: Exception Handling During Search Operations");

        testSearch_ThrowsExceptionWhenEmpty();
        testSearch_AllowsSearchWhenDataExists();
        testSearch_BogieFoundAfterValidation();
        testSearch_BogieNotFoundAfterValidation();
        testSearch_SingleElementValidCase();

        System.out.println("UC20 execution completed...");
    }

    static boolean searchBogie(String[] bogieIds, String searchId) {
        if (bogieIds.length == 0) {
            throw new IllegalStateException("No bogies available in train. Cannot perform search.");
        }

        for (String id : bogieIds) {
            if (id.equals(searchId)) {
                return true;
            }
        }
        return false;
    }

    static void testSearch_ThrowsExceptionWhenEmpty() {
        System.out.println("\ntestSearch_ThrowsExceptionWhenEmpty()");
        String[] bogieIds = {};
        String searchId = "BG101";

        try {
            boolean found = searchBogie(bogieIds, searchId);
            System.out.println("Search result: " + found);
        } catch (IllegalStateException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }

    static void testSearch_AllowsSearchWhenDataExists() {
        System.out.println("\ntestSearch_AllowsSearchWhenDataExists()");
        String[] bogieIds = {"BG101", "BG205"};
        String searchId = "BG101";

        try {
            boolean found = searchBogie(bogieIds, searchId);
            System.out.println("Search executed successfully: " + found);
        } catch (IllegalStateException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }

    static void testSearch_BogieFoundAfterValidation() {
        System.out.println("\ntestSearch_BogieFoundAfterValidation()");
        String[] bogieIds = {"BG101", "BG205", "BG309"};
        String searchId = "BG205";

        try {
            boolean found = searchBogie(bogieIds, searchId);
            System.out.println("Bogie found: " + found);
        } catch (IllegalStateException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }

    static void testSearch_BogieNotFoundAfterValidation() {
        System.out.println("\ntestSearch_BogieNotFoundAfterValidation()");
        String[] bogieIds = {"BG101", "BG205", "BG309"};
        String searchId = "BG999";

        try {
            boolean found = searchBogie(bogieIds, searchId);
            System.out.println("Bogie found: " + found);
        } catch (IllegalStateException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }

    static void testSearch_SingleElementValidCase() {
        System.out.println("\ntestSearch_SingleElementValidCase()");
        String[] bogieIds = {"BG101"};
        String searchId = "BG101";

        try {
            boolean found = searchBogie(bogieIds, searchId);
            System.out.println("Single element search result: " + found);
        } catch (IllegalStateException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}