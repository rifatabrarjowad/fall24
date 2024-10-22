package dominoes;

import java.util.List;

public class DominoLowDifferenceStringImpl_Kart implements Domino {
    private final int highPipCount;
    private final int lowPipCount;

    public DominoLowDifferenceStringImpl_Kart(int lowPlus8TimesHigh) {
        this.highPipCount = lowPlus8TimesHigh / 8;
        this.lowPipCount = lowPlus8TimesHigh % 8;
        validatePipCounts(highPipCount, lowPipCount);
    }

    public DominoLowDifferenceStringImpl_Kart(List<Integer> highSum) {
        if (highSum.size() < 2) {
            throw new IllegalArgumentException("List must have at least two elements");
        }
        int temHighPip = highSum.get(0);
        int temLowPip = highSum.get(1) - temHighPip;
        validatePipCounts(temHighPip, temLowPip);
        if (temHighPip>temLowPip) {
            this.highPipCount = temHighPip;
            this.lowPipCount = temLowPip;
        }else {
            this.highPipCount = temLowPip;
            this.lowPipCount = temHighPip;
        }

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
