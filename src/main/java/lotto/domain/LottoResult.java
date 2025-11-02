package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> rankCounts = new HashMap<>();
    private final List<Lotto> purchasedLottos;

    public LottoResult(List<Lotto> purchasedLottos) {
        this.purchasedLottos = purchasedLottos;
        initRankCounts();
    }

    private void calculateResults() {
        for(Lotto lotto : purchasedLottos) {

        }
    }

    private void initRankCounts() {
        for(LottoRank rank : LottoRank.values()) {
            rankCounts.put(rank, 0);
        }
    }
}
