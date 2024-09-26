package IntegerUtils;

public class reverseTest {
    public static int reverse(int k) {
        int reversed = 0;
        while (k != 0) {
            reversed = reversed * 10 + k % 10;
            k /= 10;
        }
        return reversed;
    }
    public static void main(String[] args) {
        System.out.print(reverse(-5));
    }
}
