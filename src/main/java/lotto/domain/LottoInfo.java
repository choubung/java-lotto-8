package lotto.domain;

import java.util.Arrays;

import static java.util.spi.ToolProvider.findFirst;

public enum LottoInfo {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int bingo;
    private final int prize;

    LottoInfo(int bingo, int prize) {
        this.bingo = bingo;
        this.prize = prize;
    }

    public static LottoInfo from(int input, boolean bonus) {
        if (input == 5 && bonus) {
            return LottoInfo.SECOND;
        }

        return Arrays.stream(values())
                .filter(lottoInfo -> lottoInfo.bingo == input)
                .findFirst()
                .orElse(MISS);
    }
}
