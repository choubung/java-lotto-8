package lotto.domain;

import lotto.utils.Parser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class LottoInfoTest {
    @DisplayName("번호 일치 개수와 보너스번호 일치 여부에 따른 당첨로또(LottoInfo)를 반환한다")
    @ParameterizedTest(name = "입력값 \"{0}\" 통과")
    @CsvSource({
            // "입력값, 기대값" 형태
            "6, false, FIRST",
            "5, true, SECOND",
            "5, false, THIRD",
            "4, false, FOURTH",
            "3, false, FIFTH",
            "2, false, MISS",
            "1, false, MISS",
            "0, false, MISS"
    })
    void fromTest(int input, boolean bonus, LottoInfo expected) {
        // when
        LottoInfo result = LottoInfo.from(input, bonus);

        // then
        assertThat(result).isEqualTo(expected);
    }
}
