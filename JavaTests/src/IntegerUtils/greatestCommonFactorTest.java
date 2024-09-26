package IntegerUtils;

public class greatestCommonFactorTest {
    public static int greatestCommonFactor(int m, int n) {
        while (n != 0 && n != 1) {
            int temp = n;
            n = m % n;
            m = temp;
        }
        return m;
    }
    public static void main(String[] args) {
        System.out.print(greatestCommonFactor(0, 1000));
    }
}
