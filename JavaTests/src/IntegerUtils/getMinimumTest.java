package IntegerUtils;

public class getMinimumTest {
    public static int getMinimum(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }

        int min = numbers[0];
        for (int num : numbers) {
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
