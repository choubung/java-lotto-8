package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class LottoRankTest {
    @DisplayName("일치 개수 6개면 1등(FIRST)을 반환한다.")
    @Test
    void 일치_개수_6개면_1등_반환_테스트() {
        int matchCount = 6;
        boolean hasBonus = false;

        LottoRank rank = LottoRank.valueOf(matchCount, hasBonus);

        assertThat(rank).isEqualTo(LottoRank.FIRST);
    }

    @DisplayName("일치 개수 5개에 보너스가 포함되면 2등(SECOND)을 반환한다.")
    @Test
    void 일치_개수_5개에_보너스면_2등_반환_테스트() {
        int matchCount = 5;
        boolean hasBonus = true;

        LottoRank rank = LottoRank.valueOf(matchCount, hasBonus);

        assertThat(rank).isEqualTo(LottoRank.SECOND);
    }

    @DisplayName("일치 개수 5개면(보너스 x) 3등(THIRD)을 반환한다.")
    @Test
    void 일치_개수_5개면_3등_반환_테스트() {
        int matchCount = 5;
        boolean hasBonus = false;

        LottoRank rank = LottoRank.valueOf(matchCount, hasBonus);

        assertThat(rank).isEqualTo(LottoRank.THIRD);
    }

    @DisplayName("일치 개수 4개면 4등(FOURTH)을 반환한다.")
    @Test
    void 일치_개수_4개면_4등_반환_테스트() {
        int matchCount = 4;
        boolean hasBonus = false;

        LottoRank rank = LottoRank.valueOf(matchCount, hasBonus);

        assertThat(rank).isEqualTo(LottoRank.FOURTH);
    }

    @DisplayName("일치 개수 3개면 5등(FOURTH)을 반환한다.")
    @Test
    void 일치_개수_3개면_5등_반환_테스트() {
        int matchCount = 3;
        boolean hasBonus = false;

        LottoRank rank = LottoRank.valueOf(matchCount, hasBonus);

        assertThat(rank).isEqualTo(LottoRank.FIFTH);
    }

    @DisplayName("일치 개수 2개면 꽝(LOSE)을 반환한다.")
    @Test
    void 일치_개수_2개면_LOSE_반환_테스트() {
        int matchCount = 2;
        boolean hasBonus = false;

        LottoRank rank = LottoRank.valueOf(matchCount, hasBonus);

        assertThat(rank).isEqualTo(LottoRank.LOSE);
    }
}
