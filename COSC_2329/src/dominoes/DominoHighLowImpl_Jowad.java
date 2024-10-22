package dominoes;

import java.util.Set;

public class DominoHighLowImpl_Jowad implements Domino {
    private final int highPipCount;
    private final int lowPipCount;

    public DominoHighLowImpl_Jowad(int highPipCount, int lowPipCount) {
        validatePipCounts(highPipCount, lowPipCount);
        if (highPipCount < lowPipCount) {
            throw new IllegalArgumentException("highPipCount cannot be less than lowPipCount");
        }
        this.highPipCount = highPipCount;
        this.lowPipCount = lowPipCount;
    }
    public static final char HIGH_LOW_STRING_SEPARATOR = ':';
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
    public DominoHighLowImpl_Jowad(String highLowString) {
        String[] parts = highLowString.split(":");
        int high = Integer.parseInt(parts[0]);
        int low = Integer.parseInt(parts[1]);
        validatePipCounts(high, low);
        if (high < low) {
            this.highPipCount = low;
            this.lowPipCount = high;
        } else {
            this.highPipCount = high;
            this.lowPipCount = low;
        }
    }

    public DominoHighLowImpl_Jowad(int[] sumDifference) {
        int sum = sumDifference[0];
        int difference = sumDifference[1];


        if ((sum + difference) % 2 != 0) {
            throw new IllegalArgumentException("Invalid input: Sum and difference must result in integer pip counts.");
        }

        int high = (sum + difference) / 2;
        int low = sum - high;


        validatePipCounts(high, low);

        this.highPipCount = high;
        this.lowPipCount = low;
    }

    public DominoHighLowImpl_Jowad(Set<Integer> highLowSet) {

        if (highLowSet.size() < 1 || highLowSet.size() > 2) {
            throw new IllegalArgumentException("Set size must be 1 or 2.");
        }
        Integer[] pips = highLowSet.toArray(new Integer[0]);
        if (pips.length == 1) {
            this.highPipCount = pips[0];
            this.lowPipCount = pips[0];
        } else {
            this.highPipCount = Math.max(pips[0], pips[1]);
            this.lowPipCount = Math.min(pips[0], pips[1]);
        }
        validatePipCounts(highPipCount, lowPipCount);
    }

    @Override
    public int getHighPipCount() {
        return highPipCount;
    }

    @Override
    public int getLowPipCount() {
        return lowPipCount;
    }

    private void validatePipCounts(int high, int low) {
        if (high < MINIMUM_PIP_COUNT || high > MAXIMUM_PIP_COUNT ||
                low < MINIMUM_PIP_COUNT || low > MAXIMUM_PIP_COUNT) {
            throw new IllegalArgumentException("Invalid pip counts.");
        }
    }
}
