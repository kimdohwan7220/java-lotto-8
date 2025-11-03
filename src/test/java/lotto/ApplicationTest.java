package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.utils.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("통합 기능 테스트")
    void 통합_기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run(
                            "8000",            // 구매금액 입력
                            "1,2,3,4,5,6",    // 당첨번호 입력
                            "7"                // 보너스 번호 입력
                    );

                    assertThat(output()).contains(
                            "8개를 구매했습니다.",
                            "총 수익률은"
                    );
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(7, 8, 9, 10, 11, 12),
                List.of(13, 14, 15, 16, 17, 18),
                List.of(19, 20, 21, 22, 23, 24),
                List.of(25, 26, 27, 28, 29, 30),
                List.of(31, 32, 33, 34, 35, 36),
                List.of(37, 38, 39, 40, 41, 42),
                List.of(43, 44, 45, 1, 2, 3)
        );
    }

    @Test
    @DisplayName("잘못된 입력 예외 테스트")
    void 잘못된_입력_예외_테스트() {
        assertSimpleTest(() -> {

            runException(
                    "1000j\n" +
                            "1,2,3,4,5,6\n" +
                            "7\n"
            );
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("보너스 번호 중복 예외 테스트")
    void 보너스_번호_중복_예외_테스트() {
        assertSimpleTest(() -> {
            runException(
                    "1000\n" +
                            "1,2,3,4,5,6\n" +
                            "6\n"
            );
            assertThat(output()).contains(ErrorMessage.DUPLICATE_NUMBER.getMessage());
        });
    }

    @Test
    @DisplayName("로또 번호 개수 초과 예외 테스트")
    void 로또_번호_개수_초과_예외_테스트() {
        assertSimpleTest(() -> {
            runException(
                    "1000\n" +
                            "1,2,3,4,5,6,7\n" +
                            "8\n"
            );
            assertThat(output()).contains(ErrorMessage.INVALID_LOTTO_SIZE.getMessage());
        });
    }

    @Test
    @DisplayName("로또 번호 개수 미만 예외 테스트")
    void 로또_번호_개수_미만_예외_테스트() {
        assertSimpleTest(() -> {
            runException(
                    "1000\n" +
                            "1,2,3,4,5\n" +
                            "6\n"
            );
            assertThat(output()).contains(ErrorMessage.INVALID_LOTTO_SIZE.getMessage());
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
