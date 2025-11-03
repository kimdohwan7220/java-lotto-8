package lotto.domain;

import java.util.List;
import java.util.Map;
import lotto.utils.LottoFormatter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
    }

    @DisplayName("로또 결과가 올바르게 계산되는지 테스트")
    @Test
    void 정상_로또_결과_비교() {

        List<Lotto> purchasedLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                new Lotto(List.of(1, 2, 3, 4, 10, 11)),
                new Lotto(List.of(1, 2, 3, 10, 11, 12)),
                new Lotto(List.of(10, 11, 12, 13, 14, 15))
        );

        LottoResult lottoResult = new LottoResult(purchasedLottos, winningLotto);
        Map<LottoRank, Integer> rankCounts = lottoResult.getRankCounts();

        assertThat(rankCounts.get(LottoRank.FIRST)).isEqualTo(1);
        assertThat(rankCounts.get(LottoRank.SECOND)).isEqualTo(1);
        assertThat(rankCounts.get(LottoRank.THIRD)).isEqualTo(1);
        assertThat(rankCounts.get(LottoRank.FOURTH)).isEqualTo(1);
        assertThat(rankCounts.get(LottoRank.FIFTH)).isEqualTo(1);
        assertThat(rankCounts.get(LottoRank.NONE)).isEqualTo(1);
    }

    @DisplayName("수익률 계산이 정상적으로 되는지 테스트")
    @Test
    void 수익률_테스트() {

        List<Lotto> purchasedLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 8, 9))
        );

        LottoResult lottoResult = new LottoResult(purchasedLottos, winningLotto);

        double profitRate = lottoResult.calculateProfitRate();

        String formattedProfit = LottoFormatter.PROFIT_FORMAT.format(profitRate);

        String expectedProfitRate = "67,668,333.3";

        assertThat(formattedProfit).isEqualTo(expectedProfitRate);
    }
}
