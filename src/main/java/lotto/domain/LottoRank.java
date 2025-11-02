package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),   // 5개 + 보너스
    THIRD(5, 1_500_000, false),    // 5개 + 보너스 아님
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    NONE(0, 0, false);

    private final int matchCount;
    private final int prize;
    private final boolean requiresBonus;

    LottoRank(int matchCount, int prize, boolean requiresBonus) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.requiresBonus = requiresBonus;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusRank() {
        return requiresBonus;
    }
}