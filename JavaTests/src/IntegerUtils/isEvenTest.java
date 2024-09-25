package IntegerUtils;

public class isEvenTest {
    public static boolean isEven(int k) {
        return k % 2 == 0;
    }
    public static void main(String[] args) {
        boolean even = isEven(-20);
        System.out.printf(String.valueOf(even));
    }
}

