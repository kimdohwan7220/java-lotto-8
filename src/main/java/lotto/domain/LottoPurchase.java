package lotto.domain;

import lotto.utils.LottoConstans;

import java.util.List;
import lotto.utils.ErrorMessage;

public class LottoPurchase {

    public static List<Lotto> buyLottos(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        int lottoCount = calculateLottoCount(purchaseAmount);
        return Lotto.generateLottos(lottoCount);
    }

    private static void validatePurchaseAmount(int purchaseAmount) {
        validateEnoughPurchaseAmount(purchaseAmount);
        validateUnit(purchaseAmount);
    }

    private static void validateUnit(int purchaseAmount) {
        if (purchaseAmount % LottoConstans.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }

    private static void validateEnoughPurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < LottoConstans.LOTTO_PRICE) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ENOUGH_MONEY.getMessage());
        }
    }

    private static int calculateLottoCount(int purchaseAmount) {
        return purchaseAmount / LottoConstans.LOTTO_PRICE;
    }
}

