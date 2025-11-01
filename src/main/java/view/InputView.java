package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static final String PURCHASE_AMOUNT_INPUT = "구입금액을 입력해 주세요.";
    public static final String WINNING_NUMBER_INPUT = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUM_INPUT = "보너스 번호를 입력해 주세요.";

    public static String inputPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_INPUT);
        return Console.readLine();
    }

    public static String inputWinningNumbers() {
        System.out.println(WINNING_NUMBER_INPUT);
        return Console.readLine();
    }

    public static String inputBonusNumber() {
        System.out.println(BONUS_NUM_INPUT);
        return Console.readLine();
    }
}
