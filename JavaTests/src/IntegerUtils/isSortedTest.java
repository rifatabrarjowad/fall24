package IntegerUtils;

public class isSortedTest {
    public static boolean isSorted(int[] intArray) {
        for (int i = 1; i < intArray.length; i++) {
            if (intArray[i] < intArray[i - 1]) {
                return false;
            }
        }
        return true;
    }
    public static void run() {
        // Test case 1: Sorted array
        int[] sortedArray = {1, 2, 3, 4, 5};
        System.out.println("Is sortedArray sorted? " + isSorted(sortedArray)); // Should return true

        // Test case 2: Unsorted array
        int[] unsortedArray = {5, 3, 4, 2, 1};
        System.out.println("Is unsortedArray sorted? " + isSorted(unsortedArray)); // Should return false

        // Test case 3: Single element array
        int[] singleElementArray = {10};
        System.out.println("Is singleElementArray sorted? " + isSorted(singleElementArray)); // Should return true

        // Test case 4: Empty array
        int[] emptyArray = {};
        System.out.println("Is emptyArray sorted? " + isSorted(emptyArray)); // Should return true

        // Test case 5: Array with duplicates
        int[] duplicateArray = {1, 2, 2, 3, 4};
        System.out.println("Is duplicateArray sorted? " + isSorted(duplicateArray)); // Should return true
    }

    public static void main(String[] args) {
        // Calling the run function to test isSorted
        run();
    }

}
