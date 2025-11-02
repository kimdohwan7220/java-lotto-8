package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.utils.ViewMessage;

public class OutputView {

    public static void printPurcahsedLottos(List<Lotto> purchasedLottos) {
        System.out.println(
                String.format(
                        ViewMessage.PURCHASE_COUNT_OUTPUT.getMessage(),
                        purchasedLottos.size()
                )
        );

        for (Lotto lotto : purchasedLottos) {
            System.out.println(lotto.getNumbers());
        }
    }



}
