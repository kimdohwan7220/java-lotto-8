package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoPurchase;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import lotto.utils.ErrorMessage;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.utils.WinningLottoParser;

public class LottoController {

    public void run() {
        try {
            int amount = Integer.parseInt(InputView.inputPurchaseAmount());
            List<Lotto> purchased = LottoPurchase.buyLottos(amount);
            OutputView.printPurchasedLottos(purchased);

            List<Integer> numbers = WinningLottoParser.parseWinningNumbers(InputView.inputWinningNumbers());
            int bonus = Integer.parseInt(InputView.inputBonusNumber());
            WinningLotto winningLotto = new WinningLotto(numbers, bonus);

            LottoResult result = new LottoResult(purchased, winningLotto);
            OutputView.printStatistics(result);
        } catch (NumberFormatException e) {
            System.out.println(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}