package IntegerUtils;

public class getMinimumTest {
    public static int getMinimum(int[] intArray) {
        if (intArray == null || intArray.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }

        int min = intArray[0];
        for (int num : intArray) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }
    public static void main(String[] args) {
        int[] array = {1, 17, -22, 48, 19};
        System.out.println(getMinimum(array));  // Output: -22
    }
}
