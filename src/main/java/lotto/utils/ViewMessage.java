package lotto.utils;

public enum ViewMessage {
    PURCHASE_AMOUNT_INPUT("구입금액을 입력해 주세요."),
    WINNING_NUMBER_INPUT("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_INPUT("보너스 번호를 입력해 주세요."),
    RESULT_OUTPUT("당첨 통계"),
    RESULT_SEPARATOR("---"),
    PURCHASE_COUNT_OUTPUT("%d개를 구매했습니다."),
    PROFITRATE_OUTPUT("총 수익률은 %s%%입니다."),
    BONUS_MATCH(", 보너스 볼 일치"),
    MATCH_COUNT_OUTPUT("%d개 일치"),
    PRIZE_COUNT_OUTPUT(" (%s원) - %d개");


    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
