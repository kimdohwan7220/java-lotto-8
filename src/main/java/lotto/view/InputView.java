package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.ViewMessage;

public class InputView {

    public static String inputPurchaseAmount() {
        System.out.println(ViewMessage.PURCHASE_AMOUNT_INPUT.getMessage());
        return Console.readLine();
    }

    public static String inputWinningNumbers() {
        System.out.println(ViewMessage.WINNING_NUMBER_INPUT.getMessage());
        return Console.readLine();
    }

    public static String inputBonusNumber() {
        System.out.println(ViewMessage.BONUS_NUMBER_INPUT.getMessage());
        return Console.readLine();
    }
}
