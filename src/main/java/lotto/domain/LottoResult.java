package lotto.domain;

import lotto.utils.LottoConstants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> rankCounts = new HashMap<>();
    private final List<Lotto> purchasedLottos;
    private final WinningLotto winningLotto;

    public LottoResult(List<Lotto> purchasedLottos, WinningLotto winningLotto) {
        this.purchasedLottos = purchasedLottos;
        this.winningLotto = winningLotto;
        initRankCounts();
        calculateResults();
    }

    private void calculateResults() {
        for(Lotto lotto : purchasedLottos) {
            int matchCount = countMatchNumbers(lotto);
            boolean matchBonus = containsBonus(lotto);

            LottoRank rank = LottoRank.findRank(matchCount, matchBonus);
            rankCounts.put(rank, rankCounts.get(rank) + 1);
        }
    }

    private void initRankCounts() {
        for(LottoRank rank : LottoRank.values()) {
            rankCounts.put(rank, 0);
        }
    }

    private int countMatchNumbers(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(winningLotto.getWinningNumbers().getNumbers()::contains)
                .count();
    }

    private boolean containsBonus(Lotto lotto) {
        return lotto.getNumbers().contains(winningLotto.getBonusNumber());
    }

    public double calculateProfitRate() {
        long totalPrize = rankCounts.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();

        long totalSpent = purchasedLottos.size() * LottoConstants.LOTTO_PRICE;
        return ((double) totalPrize / totalSpent) * 100;
    }

    public Map<LottoRank, Integer> getRankCounts() {
        return rankCounts;
    }
}
