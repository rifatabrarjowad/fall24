package dominoes;
import java.util.Iterator;
import java.util.Set;

public class DominoHighLowSetImpl_Kart implements Domino {
    private final Set<Integer> highLowSet;

    public DominoHighLowSetImpl_Kart(int highPipCount, int lowPipCount) {
        validatePipCounts(highPipCount, lowPipCount);
        if (highPipCount < lowPipCount) {
            throw new IllegalArgumentException("highPipCount cannot be less than lowPipCount");
        }
        this.highLowSet = Set.of(highPipCount, lowPipCount);
    }

    public DominoHighLowSetImpl_Kart(String sumDifferenceString) {
        String[] parts = sumDifferenceString.split(",");
        int sum = Integer.parseInt(parts[0]);
        int difference = Integer.parseInt(parts[1]);
        int high = (sum + difference) / 2;
        int low = sum - high;
        validatePipCounts(high, low);
        this.highLowSet = Set.of(high, low);
    }

    public DominoHighLowSetImpl_Kart(int lowPlus8TimesHigh) {
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
