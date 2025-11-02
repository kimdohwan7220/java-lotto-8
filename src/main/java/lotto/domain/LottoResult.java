package lotto.domain;

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
    }

    private void calculateResults() {
        for(Lotto lotto : purchasedLottos) {
            int matchCount = countMatchNumbers(lotto);
        }
    }

    private int countMatchNumbers(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(winningLotto.getWinningNumbers().getNumbers()::contains)
                .count();
    }

    private void initRankCounts() {
        for(LottoRank rank : LottoRank.values()) {
            rankCounts.put(rank, 0);
        }
    }
}
