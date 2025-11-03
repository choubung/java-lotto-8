package lotto;

import java.util.*;

public class LottoCalculator {
    private final Map<LottoRank, Integer> rankCounts = new HashMap<>();
    private final LottoRank[] ranks = new LottoRank[]{
            LottoRank.FIFTH, LottoRank.FOURTH, LottoRank.THIRD,
            LottoRank.SECOND, LottoRank.FIRST
    };
    private double profitRate;

    public LottoCalculator() {
        for (LottoRank rank : ranks) {
            rankCounts.put(rank, 0);
        }
    }

    public void calculateResult(List<Lotto> lottos, WinningLotto winningLotto) {
        for (Lotto lotto : lottos) {
            List<Integer> targetNumbers = lotto.getNumbers();
            List<Integer> winningNumbers = winningLotto.getLotto().getNumbers();

            int matchCount = (int) targetNumbers.stream().filter(winningNumbers::contains).count();
            boolean hasBonus = targetNumbers.contains(winningLotto.getBonusNumber());

            LottoRank rank = LottoRank.valueOf(matchCount, hasBonus);

            if (rankCounts.containsKey(rank)) {
                rankCounts.put(rank, rankCounts.get(rank) + 1);
            }
        }
    }

    public void calculateProfit(int totalAmount) {
        double winningAmount = 0.0;

        for (LottoRank rank : ranks) {
            winningAmount += rankCounts.get(rank) * rank.getPrizeMoney();
        }

        if (totalAmount == 0) {
            this.profitRate = 0.0;
            return;
        }

        this.profitRate = (winningAmount / totalAmount) * 100.0;
    }

    public Map<LottoRank, Integer> getRankCounts() {
        return rankCounts;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
