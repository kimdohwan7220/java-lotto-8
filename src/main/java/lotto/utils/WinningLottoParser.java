package lotto.utils;

import static lotto.utils.LottoConstans.SPLIT_SEPARATOR;

import lotto.utils.ErrorMessage;
import lotto.utils.WinningLottoParser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLottoParser {
    public static List<Integer> parseWinningNumbers(String input) {
        validateNotBlank(input);

        try {
            return Arrays.stream(input.split(String.valueOf(SPLIT_SEPARATOR)))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    private static void validateNotBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_EMPTY.getMessage());
        }
    }
}
