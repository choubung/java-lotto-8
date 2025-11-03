package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class LottoMachineTest {
    private LottoMachine machine;

    @BeforeEach
    void setUp() {
        machine = new LottoMachine();
    }

    @DisplayName("구매 금액이 1000의 배수이면 예외가 발생하지 않고 저장되는지 테스트한다.")
    @Test
    void 구매_금액_검증_로직_테스트(){
        int validAmount = 3000;

        assertThatCode(() -> machine.setTotalAmount(validAmount))
                .doesNotThrowAnyException();
        assertThat(machine.getTotalAmount()).isEqualTo(validAmount);
    }

    @DisplayName("1000의 배수가 아닌 구매 금액 입력 시 IllegalArgumentException가 발생한다.")
    @Test
    void 구매_금액이_1000의_배수가_아니면_예외가_발생한다(){
        int invalidAmount = 1500;
        assertThatThrownBy(() -> machine.setTotalAmount(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구매 금액은 1000의 배수여야 합니다.");
    }
}
