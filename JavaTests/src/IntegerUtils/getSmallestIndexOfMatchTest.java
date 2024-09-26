package IntegerUtils;

public class getSmallestIndexOfMatchTest {
    public static int getSmallestIndexOfMatch(int[] intArray, int target) {
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] == target) {
                return i;
            }
        }
        return -1;
    }

}
