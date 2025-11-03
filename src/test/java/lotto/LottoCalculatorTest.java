package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class LottoCalculatorTest {
    private LottoCalculator calculator;
    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        calculator = new LottoCalculator();

        // 당첨번호와 보너스 번호 세팅
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        winningLotto = new WinningLotto(winningNumbers, 0);
        winningLotto.setBonusNumber(7);
    }

    @Test
    void 당첨_결과_테스트(){
        Lotto lotto_1st = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto_5th = new Lotto(List.of(1, 2, 3, 10, 11, 12));

        List<Lotto> lottos = List.of(lotto_1st, lotto_5th);

        calculator.calculateResult(lottos, winningLotto);

        Map<LottoRank, Integer> rankCounts = calculator.getRankCounts();

        assertThat(rankCounts.get(LottoRank.FIRST)).isEqualTo(1);
        assertThat(rankCounts.get(LottoRank.SECOND)).isEqualTo(0);
        assertThat(rankCounts.get(LottoRank.THIRD)).isEqualTo(0);
        assertThat(rankCounts.get(LottoRank.FOURTH)).isEqualTo(0);
        assertThat(rankCounts.get(LottoRank.FIFTH)).isEqualTo(1);

    }

    @Test
    void 수익률_계산_테스트() {
        Lotto lotto_5th = new Lotto(List.of(1, 2, 3, 10, 11, 12));
        List<Lotto> lottos = List.of(lotto_5th);
        int amount = 8000;

        calculator.calculateResult(lottos, winningLotto);
        calculator.calculateProfit(amount);

        assertThat(calculator.getProfitRate()).isEqualTo(62.5);
    }
}
