package lotto.utils;

public enum ErrorMessage {
    INVALID_LOTTO_NUMBER("[ERROR] 로또 번호는 1부터 45 사이여야 합니다."),
    DUPLICATE_NUMBER("[ERROR] 로또 번호에 중복된 숫자가 있습니다."),
    INVALID_LOTTO_SIZE("[ERROR] 로또 번호는 6개여야 합니다."),
    NOT_ENOUGH_MONEY("[ERROR] 구입 금액이 1000원보다 적습니다."),
    INPUT_EMPTY("[ERROR] 입력 값이 비어있습니다."),
    INVALID_NUMBER_FORMAT("[ERROR] 숫자 형식이 올바르지 않습니다."),
    INVALID_PURCHASE_AMOUNT("[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
