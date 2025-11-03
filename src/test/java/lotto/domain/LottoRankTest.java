package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRankBonusTest {

    private WinningLotto winningLotto;

    @BeforeEach
    void setup() {
        winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
    }

    @DisplayName("5개 + 보너스 번호 일치 시 SECOND 판정")
    @Test
    void 다섯개_보너스_일치_SECOND_판정() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        LottoResult result = new LottoResult(List.of(lotto), winningLotto);
        Map<LottoRank, Integer> rankCounts = result.getRankCounts();

        assertThat(rankCounts.get(LottoRank.SECOND)).isEqualTo(1);
        assertThat(rankCounts.get(LottoRank.THIRD)).isEqualTo(0);
    }

    @DisplayName("5개만 맞고 보너스 번호 불일치 시 THIRD 판정")
    @Test
    void 다섯개만_일치_THIRD_판정() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        LottoResult result = new LottoResult(List.of(lotto), winningLotto);
        Map<LottoRank, Integer> rankCounts = result.getRankCounts();

        assertThat(rankCounts.get(LottoRank.THIRD)).isEqualTo(1);
        assertThat(rankCounts.get(LottoRank.SECOND)).isEqualTo(0);
    }
}