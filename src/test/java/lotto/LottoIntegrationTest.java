package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoIntegrationTest {

    private List<Lotto> purchasedLottos;
    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        purchasedLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12)),
                new Lotto(List.of(13, 14, 15, 16, 17, 18))
        );

        winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
    }

    @Test
    void 통합_로또_시나리오_테스트() {

        LottoResult result = new LottoResult(purchasedLottos, winningLotto);

        assertThat(result.getRankCounts().get(lotto.domain.LottoRank.FIRST)).isEqualTo(1);
        assertThat(result.getRankCounts().get(lotto.domain.LottoRank.NONE)).isEqualTo(2);

        double expectedProfit = (double)(2_000_000_000) / (3 * 1000) * 100;
        assertThat(result.calculateProfitRate()).isEqualTo(expectedProfit);
    }
}
