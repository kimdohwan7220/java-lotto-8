package lotto.domain;

import java.util.List;
import lotto.utils.ErrorMessage;

public class WinningLotto {
    private final Lotto winningNumbers; // 6개의 당첨 번호
    private final int bonusNumber;      // 보너스 번호

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        validate(numbers, bonusNumber);
        this.winningNumbers = new Lotto(numbers); // Lotto 객체 재사용
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> numbers, int bonusNumber) {
        validateDuplicateWithBonus(numbers, bonusNumber);
        validateBonusNumberRange(bonusNumber);
    }

    private void validateDuplicateWithBonus(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
    }

    private void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER.getMessage());
        }
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}
