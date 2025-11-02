package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.utils.ErrorMessage;
import lotto.utils.LottoConstans;

public class Lotto {
    private final List<Integer> numbers;
    private static final int MIN = LottoConstans.LOTTO_MIN_NUMBER;
    private static final int MAX = LottoConstans.LOTTO_MAX_NUMBER;
    private static final int SIZE = LottoConstans.LOTTO_NUMBER_SIZE;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    public static Lotto generateRandomNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                MIN,
                MAX,
                SIZE
        );
        return new Lotto(numbers);
    }

    public static List<Lotto> generateLottos(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> generateRandomNumber())
                .collect(Collectors.toList());
    }

    private void validate(List<Integer> numbers) {
        validateLottoNumberSize(numbers);
        validateDuplicateNumber(numbers);
        validateNumberRange(numbers);
    }

    private void validateLottoNumberSize(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_SIZE.getMessage());
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        if (hasDuplicates(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
    }

    private boolean hasDuplicates(List<Integer> numbers) {
        return numbers.size() != new HashSet<>(numbers).size();
    }

    private void validateNumberRange(List<Integer> numbers) {
        if (numbersOutOfRange(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER.getMessage());
        }
    }

    private boolean numbersOutOfRange(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(n -> n < MIN || n > MAX);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
