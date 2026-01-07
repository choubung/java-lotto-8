package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParserTest {
    @DisplayName("유효하지 않은 로또번호 예외 처리")
    @ParameterizedTest(name = "입력값 \"{0}\" 일 때 예외 발생")
    @ValueSource(strings = {"1,2,3,4,5,6,7", "1;2;3;4;5;6", " ", "", "!", "1000j"})
    void parseExceptionTest(String input) {
        assertThatThrownBy(() -> {
            Parser.parse(input);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상 입력 시 예외가 발생하지 않는다")
    @ParameterizedTest(name = "입력값 \"{0}\" 통과")
    @ValueSource(strings = {"1,2,3,4,5,6"})
    void noExceptionTest(String input) {
        assertThatCode(() -> {
            Parser.parse(input);
        })
                .doesNotThrowAnyException();
    }
}
