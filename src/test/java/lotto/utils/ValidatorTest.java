package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {
    @DisplayName("유효하지 않은 구입금액 예외 처리")
    @ParameterizedTest(name = "입력값 \"{0}\" 일 때 예외 발생")
    @ValueSource(strings = {"2400", "로또", " ", "", "!", "1000j"})
    void validateAndParseCashExceptionTest(String input) {
        assertThatThrownBy(() -> {
            Validator.validateAndParseCash(input);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액 정상 입력 시 예외가 발생하지 않는다")
    @ParameterizedTest(name = "입력값 \"{0}\" 통과")
    @ValueSource(strings = {"3000", "56000"})
    void validateAndParseCashNoExceptionTest(String input) {
        assertThatCode(() -> {
            Validator.validateAndParseCash(input);
        })
                .doesNotThrowAnyException();
    }


    @DisplayName("유효하지 않은 입력 예외 처리")
    @ParameterizedTest(name = "입력값 \"{0}\" 일 때 예외 발생")
    @ValueSource(strings = {"로또", " ", "", "!", "1000j"})
    void parseToIntExceptionTest(String input) {
        assertThatThrownBy(() -> {
            Validator.parseToInt(input);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상 입력 시 예외가 발생하지 않는다")
    @ParameterizedTest(name = "입력값 \"{0}\" 통과")
    @ValueSource(strings = {"2", "34", "0"})
    void parseToIntNoExceptionTest(String input) {
        assertThatCode(() -> {
            Validator.parseToInt(input);
        })
                .doesNotThrowAnyException();
    }

}
