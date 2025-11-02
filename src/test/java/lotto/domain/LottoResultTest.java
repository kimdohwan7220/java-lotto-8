package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        // 당첨 번호: 1,2,3,4,5,6 / 보너스: 7
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
}
