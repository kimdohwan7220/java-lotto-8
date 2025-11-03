package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoParserTest {

    @DisplayName("정상 입력 문자열을 라스트로 변환")
    @Test
    void 정상_입력_파싱() {
        String input = "1,2,3,4,5,6";
        List<Integer> numbers = WinningLottoParser.parseWinningNumbers(input);

        assertThat(numbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("빈 문자열 입력 시 예외 발생")
    @Test
    void 빈_문자열_예외발생() {
        String input = "";
        assertThatThrownBy(() -> WinningLottoParser.parseWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INPUT_EMPTY.getMessage());
    }

    @DisplayName("숫자 아닌 문자 입력 시 예외 발생")
    @Test
    void 숫자아닌문자_예외발생() {
        String input = "1,2,3,4,5,abc";
        assertThatThrownBy(() -> WinningLottoParser.parseWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
    }
}