package IntegerUtils;
import java.util.HashSet;
import java.util.Set;
public class getCommonDecimalDigitsTest {
    public static Set<Integer> getCommonDecimalDigits(int a, int b) {
        Set<Integer> digitsA = new HashSet<>();
        Set<Integer> digitsB = new HashSet<>();

        while (a > 0) {
            digitsA.add(a % 10);
            a /= 10;
        }

        while (b > 0) {
            digitsB.add(b % 10);
            b /= 10;
        }

        digitsA.retainAll(digitsB);
        return digitsA;
    }
    public static void main(String[] args) {
        System.out.print(getCommonDecimalDigits(0,0));
    }

}
