package lotto;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WinningLottoManager {
    private WinningLotto winningLotto;
    private double profit;
    private Map<LottoRank, Integer> rankCounts = new HashMap<LottoRank, Integer>();
    private LottoRank[] ranksToPrint = new LottoRank[]{
            LottoRank.FIFTH, LottoRank.FOURTH, LottoRank.THIRD,
            LottoRank.SECOND, LottoRank.FIRST
    };

    public void saveWinningLotto() {
        while(true) {
            try {
                String winningNumsStr = Console.readLine();
                validateWinningNumsStr(winningNumsStr);

                List<Integer> winningNumbers = Arrays.stream(winningNumsStr.split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

                System.out.println("보너스 번호를 입력해 주세요.");
                int bonus = Integer.parseInt(Console.readLine());

                winningLotto = new WinningLotto(winningNumbers, bonus);
                break;
            } catch (Exception e) {

            }
        }
    }

    private void validateWinningNumsStr(String winningNumbersStr) {
        // TODO: (입력 검증) ,로 구분된 숫자 문자열인지
    }

    public void printLottoResult(LottoMachine lottoMachine) {
        calculateResult(lottoMachine.getLottos()); // 당첨 결과 계산
        calculateProfit(lottoMachine.getTotalAmount()); // 수익률 계산
        printWinningStatistics(); // 탕첨 통계 출력
    }

    private void calculateResult(List<Lotto> lottos){
        for (Lotto lotto : lottos) {
            List<Integer> targetNumbers = lotto.getNumbers();
            List<Integer> winningNumbers = winningLotto.getLotto().getNumbers();

            int matchCount = (int) targetNumbers.stream().filter(winningNumbers::contains).count();
            boolean hasBonus = targetNumbers.contains(winningLotto.getBonusNumber());

            LottoRank rank = LottoRank.valueOf(matchCount, hasBonus);
            rankCounts.put(rank, rankCounts.getOrDefault(rank, 0) + 1);
        }
    }

    private void calculateProfit(int totalAmount) {
        double winningAmount = 0.0;
        for (LottoRank rank : ranksToPrint) {
            winningAmount += rankCounts.getOrDefault(rank, 0) * rank.getPrizeMoney();
        }
        profit = winningAmount / totalAmount * 100 ;
    }

    private void printWinningStatistics() {
        System.out.println("당첨 통계\n---");
        for (LottoRank rank : ranksToPrint) {
            int count = rankCounts.getOrDefault(rank, 0);
            System.out.println(rank.getMessage() + " - " + count + "개");
        }
        String profitRate = String.format("%.1", profit);
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }
}
