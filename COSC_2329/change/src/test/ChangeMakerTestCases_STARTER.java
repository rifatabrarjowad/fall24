package test;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static org.junit.Assert.assertEquals;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import change.ChangeMaker;
import change.ChangeMakerImpl_Skeleton;

public class ChangeMakerTestCases {
    final static boolean DEBUGGING = false;
    final static int DESIRED_TIMEOUT_IN_MILLISECONDS = (3) * 1000;
    final static int TIMEOUT_USED_FOR_DEBUGGING_IN_MILLISECONDS = (10 * ((60) * 1000));
    final static int TIMEOUT_IN_MILLISECONDS = (DEBUGGING ? TIMEOUT_USED_FOR_DEBUGGING_IN_MILLISECONDS : DESIRED_TIMEOUT_IN_MILLISECONDS);

    @Rule
    public Timeout timeoutForAllTestMethods = new Timeout(TIMEOUT_IN_MILLISECONDS);

    protected static ChangeMaker changeMaker_STUDENT;
    protected static String TEST_GOAL_MESSAGE;

    @Retention(value = RUNTIME)
    @Target(value = METHOD)
    public @interface Points {
        int value();
    }

    private static Set<Integer> getUSCoinDenominationSet() {
        return getDenominationSet(new Integer[] { 1, 5, 10, 25, 100 });
    }

    private static Set<Integer> getDenominationSet(Integer[] values) {
        Set<Integer> denominationSet = new HashSet<>(Arrays.asList(values));
        assert denominationSet.size() == values.length : "The Integer array values has duplicates! : values = " + getPrettyString(values);
        return denominationSet;
    }

    private static String getPrettyString(Set<Integer> set) {
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        Collections.reverse(list);
        return list.toString();
    }

    private static String getPrettyString(Integer[] integerArray) {
        return Arrays.toString(integerArray);
    }

    private static String getPrettyString(List<Integer> list) {
        return list.toString();
    }

    protected ChangeMaker getChangeMaker(Set<Integer> denominations) {
        return new ChangeMakerImpl_Skeleton(denominations);
    }

    @Points(value = 5)
    @Test
    public void canMakeExactChange__USCoins__65() {
        Set<Integer> usCoinDenominationSet = getUSCoinDenominationSet();
        int valueInCents = 65;
        TEST_GOAL_MESSAGE = "Test " + getPrettyString(usCoinDenominationSet) + ".canMakeExactChange(" + valueInCents + ")";
        changeMaker_STUDENT = getChangeMaker(usCoinDenominationSet);

        boolean expected = true;
        boolean actual = changeMaker_STUDENT.canMakeExactChange(valueInCents);

        assertEquals("ChangeMaker should be able to make change for " + valueInCents, expected, actual);
    }

    @Points(value = 5)
    @Test
    public void getExactChange__USCoins__65() {
        Set<Integer> usCoinDenominationSet = getUSCoinDenominationSet();
        int valueInCents = 65;
        TEST_GOAL_MESSAGE = "Test " + getPrettyString(usCoinDenominationSet) + ".getExactChange(" + valueInCents + ")";
        changeMaker_STUDENT = getChangeMaker(usCoinDenominationSet);

        List<Integer> actualChangeList = changeMaker_STUDENT.getExactChange(valueInCents);
        List<Integer> expectedChangeList = Arrays.asList(0, 2, 1, 1, 0);

        assertEquals("Calculated changeList disagrees with expected!", expectedChangeList, actualChangeList);
    }

    @Points(value = 5)
    @Test
    public void canMakeExactChange__USCoins__55() {
        Set<Integer> usCoinDenominationSet = getUSCoinDenominationSet();
        int valueInCents = 55;
        TEST_GOAL_MESSAGE = "Test " + getPrettyString(usCoinDenominationSet) + ".canMakeExactChange(" + valueInCents + ")";
        changeMaker_STUDENT = getChangeMaker(usCoinDenominationSet);

        boolean expected = true;
        boolean actual = changeMaker_STUDENT.canMakeExactChange(valueInCents);

        assertEquals("ChangeMaker should be able to make change for " + valueInCents, expected, actual);
    }

    @Points(value = 5)
    @Test
    public void canMakeExactChange__USCoins__10() {
        Set<Integer> usCoinDenominationSet = getUSCoinDenominationSet();
        int valueInCents = 10;
        TEST_GOAL_MESSAGE = "Test " + getPrettyString(usCoinDenominationSet) + ".canMakeExactChange(" + valueInCents + ")";
        changeMaker_STUDENT = getChangeMaker(usCoinDenominationSet);

        boolean expected = true;
        boolean actual = changeMaker_STUDENT.canMakeExactChange(valueInCents);

        assertEquals("ChangeMaker should be able to make change for " + valueInCents, expected, actual);
    }

    @Points(value = 5)
    @Test
    public void canMakeExactChange__USCoins__11() {
        Set<Integer> usCoinDenominationSet = getUSCoinDenominationSet();
        int valueInCents = 11;
        TEST_GOAL_MESSAGE = "Test " + getPrettyString(usCoinDenominationSet) + ".canMakeExactChange(" + valueInCents + ")";
        changeMaker_STUDENT = getChangeMaker(usCoinDenominationSet);

        boolean expected = true;
        boolean actual = changeMaker_STUDENT.canMakeExactChange(valueInCents);

        assertEquals("ChangeMaker should be able to make change for " + valueInCents, expected, actual);
    }

    @Points(value = 5)
    @Test
    public void canMakeExactChange__USCoins__180004() {
        Set<Integer> usCoinDenominationSet = getUSCoinDenominationSet();
        int valueInCents = 180004;
        TEST_GOAL_MESSAGE = "Test " + getPrettyString(usCoinDenominationSet) + ".canMakeExactChange(" + valueInCents + ")";
        changeMaker_STUDENT = getChangeMaker(usCoinDenominationSet);

        boolean expected = true;
        boolean actual = changeMaker_STUDENT.canMakeExactChange(valueInCents);

        assertEquals("ChangeMaker should be able to make change for " + valueInCents, expected, actual);
    }

    @Points(value = 5)
    @Test
    public void canMakeExactChange__32_16_8_4_2_1__100() {
        Set<Integer> denominationSet = getDenominationSet(new Integer[] { 32, 16, 8, 4, 2, 1 });
        int valueInCents = 100;
        TEST_GOAL_MESSAGE = "Test " + getPrettyString(denominationSet) + ".canMakeExactChange(" + valueInCents + ")";
        changeMaker_STUDENT = getChangeMaker(denominationSet);

        boolean expected = true;
        boolean actual = changeMaker_STUDENT.canMakeExactChange(valueInCents);

        assertEquals("ChangeMaker should be able to make change for " + valueInCents, expected, actual);
    }
}
