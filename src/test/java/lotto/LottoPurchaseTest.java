package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoPurchase;
import lotto.utils.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPurchaseTest {
    @DisplayName("1000원 미만으로 로또 구매 시 예외가 발생한다.")
    @Test
    void 구입_금액이_1000원_미만이면_예외발생() {
        assertThatThrownBy(() -> LottoPurchase.buyLottos(500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_ENOUGH_MONEY.getMessage());
    }

    @DisplayName("1000원 단위가 아닌 금액으로 구매 시 예외가 발생한다.")
    @Test
    void 구입_금액이_1000원_단위가_아니면_예외발생() {
        assertThatThrownBy(() -> LottoPurchase.buyLottos(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_PURCHASE_AMOUNT.getMessage());
    }

    @DisplayName("정상적인 금액으로 로또를 구매하면 올바른 개수의 로또가 생성된다.")
    @Test
    void 정상금액으로_구매시_로또개수_검증() {
        List<Lotto> lottos = LottoPurchase.buyLottos(3000);
        assertThat(lottos).hasSize(3);
    }
}
