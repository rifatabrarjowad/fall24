package dominoes;
import java.util.Iterator;
import java.util.Set;

public class DominoHighLowSetImpl_Jowad implements Domino {
    private final Set<Integer> highLowSet;

    public DominoHighLowSetImpl_Jowad(int highPipCount, int lowPipCount) {
        validatePipCounts(highPipCount, lowPipCount);
        if (highPipCount < lowPipCount) {
            throw new IllegalArgumentException("highPipCount cannot be less than lowPipCount");
        }
        this.highLowSet = Set.of(highPipCount, lowPipCount);
    }
    public static final char HIGH_LOW_STRING_SEPARATOR = ',';
    public static boolean isHighLowString(String str) {
        if (str == null) return false;
        String[] parts = str.split(String.valueOf(HIGH_LOW_STRING_SEPARATOR));
        if (parts.length != 2) return false;
        try {
            int high = Integer.parseInt(parts[0]);
            int low = Integer.parseInt(parts[1]);
            // Validate pip counts
            if (high < MINIMUM_PIP_COUNT || high > MAXIMUM_PIP_COUNT) return false;
            if (low < MINIMUM_PIP_COUNT || low > high) return false;
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public DominoHighLowSetImpl_Jowad(String sumDifferenceString) {
        String[] parts = sumDifferenceString.split(String.valueOf(HIGH_LOW_STRING_SEPARATOR));
        int sum = Integer.parseInt(parts[0]);
        int difference = Integer.parseInt(parts[1]);
        int high = (sum + difference) / 2;
        int low = sum - high;
        validatePipCounts(high, low);
        this.highLowSet = Set.of(high, low);
    }

    public DominoHighLowSetImpl_Jowad(int lowPlus8TimesHigh) {
        int high = lowPlus8TimesHigh / 8;
        int low = lowPlus8TimesHigh % 8;
        validatePipCounts(high, low);
        this.highLowSet = Set.of(high, low);
    }

    @Override
    public int getHighPipCount() {
        Iterator<Integer> iterator = highLowSet.iterator();
        int first = iterator.next();
        int second = iterator.next();

        if (first > second) {
            return first;
        } else {
            return second;
        }
    }

    @Override
    public int getLowPipCount() {
        Iterator<Integer> iterator = highLowSet.iterator();
        int first = iterator.next();
        int second = iterator.next();

        if (first < second) {
            return first;
        } else {
            return second;
        }
    }

    private void validatePipCounts(int high, int low) {
        if (high < MINIMUM_PIP_COUNT || high > MAXIMUM_PIP_COUNT ||
                low < MINIMUM_PIP_COUNT || low > MAXIMUM_PIP_COUNT) {
            throw new IllegalArgumentException("Invalid pip counts.");
        }
    }
}
