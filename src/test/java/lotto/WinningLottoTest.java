package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {
    private WinningLotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 0);
    }

    @DisplayName("보너스 번호가 1~45 사이의 숫자(32)가 맞으면 보너스 번호를 저장하는지 테스트한다.")
    @Test
    void 올바른_보너스_번호_저장_테스트(){
        int validNumber = 32;
        lotto.setBonusNumber(validNumber);

        assertThat(validNumber).isEqualTo(lotto.getBonusNumber());
    }

    @DisplayName("보너스 번호가 1~45 사이의 숫자가 아니면(46) 예외를 발생시킨다.")
    @Test
    void 보너스_번호가_범위_밖이면_예외가_발생한다(){
        assertThatThrownBy(() -> lotto.setBonusNumber(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 1~45 범위의 번호여야 합니다.");
    }

    @DisplayName("보너스 번호가 당첨 번호 중 하나와라도 겹치면 예외를 발생시킨다.")
    @Test
    void 보너스_번호가_당첨_번호와_겹치면_예외가_발생한다(){
        assertThatThrownBy(() -> lotto.setBonusNumber(1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 당첨번호와 겹치지 않는 번호여야 합니다.");
    }
}
